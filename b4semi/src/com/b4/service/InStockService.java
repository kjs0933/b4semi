package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.InStockDao;
import com.b4.model.vo.InStock;

public class InStockService {

private InStockDao dao = new InStockDao();
	
	public List<InStock> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<InStock> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int insertInStock(InStock d)
	{
		Connection conn=getConnection();
		int result=dao.insertInStock(conn,d);
		if(result>0)
		{
			commit(conn);
			result=dao.instockSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateInStock(InStock d)
	{
		Connection conn=getConnection();
		int result=dao.updateInStock(conn, d);
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
	
	public int deleteInStock(InStock d)
	{
		Connection conn=getConnection();
		int result=dao.deleteInStock(conn, d);
		
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
