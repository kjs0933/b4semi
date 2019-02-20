package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.SupplierDao;
import com.b4.model.vo.Supplier;

public class SupplierService {

	private SupplierDao dao = new SupplierDao();
	
	public List<Supplier> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Supplier> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int insertSupplier(Supplier d)
	{
		Connection conn=getConnection();
		int result=dao.insertSupplier(conn,d);
		if(result>0)
		{
			commit(conn);
			result=dao.displayListSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateSupplier(Supplier d)
	{
		Connection conn=getConnection();
		int result=dao.updateSupplier(conn, d);
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
	
	public int deleteSupplier(Supplier d)
	{
		Connection conn=getConnection();
		int result=dao.deleteSupplier(conn, d);
		
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
