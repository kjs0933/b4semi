package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.CartDao;
import com.b4.model.vo.Cart;
import com.b4.model.vo.Product;

public class CartService {
	
	CartDao dao = new CartDao();
	
	public List<Cart> selectByMember(int memberSeq)
	{
		Connection conn = getConnection();
		List<Cart> list = dao.selectByMember(conn, memberSeq);
		close(conn);
		return list;
	}

	public int insertCart(int memberSeq, int dpseq, Product p) {
		Connection conn = getConnection();
		int result = dao.insertCart(conn, memberSeq, dpseq, p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
