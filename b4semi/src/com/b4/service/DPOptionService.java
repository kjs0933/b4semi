package com.b4.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.DPOptionDao;
import com.b4.model.vo.DPOption;


public class DPOptionService {

private DPOptionDao dao = new DPOptionDao();
	
	public List<DPOption> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<DPOption> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int insertDPOption(DPOption d)
	{
		Connection conn=getConnection();
		int result=dao.insertDPOption(conn,d);
		if(result>0)
		{
			commit(conn);
			result=dao.displayListSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateDPOption(DPOption d)
	{
		Connection conn=getConnection();
		int result=dao.updateDPOption(conn, d);
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
	
	public int deleteDPOption(DPOption d)
	{
		Connection conn=getConnection();
		int result=dao.deleteDPOption(conn, d);
		
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
