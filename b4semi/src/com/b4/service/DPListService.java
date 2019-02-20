package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.DPListDao;
import com.b4.model.vo.DPList;

public class DPListService {
	
	private DPListDao dao = new DPListDao();
	
	public int searchListCount(String type, String keyword, String category, String sortType)
	{
		Connection conn=getConnection();
		int result = dao.searchListCount(conn,type,keyword,category,sortType);
		close(conn);
		
		return result;
	}
	
	public List<DPList> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<DPList> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int insertDPList(DPList d)
	{
		Connection conn=getConnection();
		int result=dao.insertDPList(conn,d);
		if(result>0)
		{
			commit(conn);
			result=dao.displayListSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateDPList(DPList d)
	{
		Connection conn=getConnection();
		int result=dao.updateDPList(conn, d);
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteDPList(DPList d)
	{
		Connection conn=getConnection();
		int result=dao.deleteDPList(conn, d);
		
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
