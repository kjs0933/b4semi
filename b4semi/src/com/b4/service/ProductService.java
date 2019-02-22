package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.ProductDao;
import com.b4.model.vo.Member;
import com.b4.model.vo.Product;

public class ProductService {

private ProductDao dao = new ProductDao();
	
	public List<Product> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Product> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public int insertProduct(Product d)
	{
		Connection conn=getConnection();
		int result=dao.insertProduct(conn,d);
		if(result>0)
		{
			commit(conn);
			result=dao.displayListSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateProduct(Product d)
	{
		Connection conn=getConnection();
		int result=dao.updateProduct(conn, d);
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
	
	public int deleteProduct(Product d)
	{
		Connection conn=getConnection();
		int result=dao.deleteProduct(conn, d);
		
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
	
	public Product selectOne(Product p)
	{
		Connection conn = getConnection();
		Product result = dao.selectOne(conn, p);
		close(conn);
		return result;
	}

	public Product selectByDpListSeq(int dpseq)
	{
		Connection conn = getConnection();
		Product p = dao.selectByDpListSeq(conn, dpseq);
		close(conn);
		return p;
	}
	

}
