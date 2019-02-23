package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

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
	
	public int getAmount(int memberSeq, int dpseq, String pcode)
	{
		Connection conn = getConnection();
		int result = dao.getAmount(conn, memberSeq, dpseq, pcode);
		close(conn);
		return result;
	}
	

	public int insertCart(int memberSeq, int dpseq, String pcode, int amount) {
		Connection conn = getConnection();
		int result = dao.insertCart(conn, memberSeq, dpseq, pcode, amount);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int updateCart(int memberSeq, int dpseq, String pcode, int amount) {
		Connection conn = getConnection();
		int result = dao.updateCart(conn, memberSeq, dpseq, pcode, amount);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int getKindCount(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.getKindCount(conn, memberSeq);
		close(conn);
		return result;
	}

}
