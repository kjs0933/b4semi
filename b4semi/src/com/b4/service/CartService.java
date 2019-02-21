package com.b4.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.List;

import com.b4.dao.CartDao;
import com.b4.model.vo.Cart;

public class CartService {
	
	CartDao dao = new CartDao();
	
	public List<Cart> selectByMember(int memberSeq)
	{
		Connection conn = getConnection();
		List<Cart> list = dao.selectByMember(conn, memberSeq);
		close(conn);
		return list;
	}

}
