package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.b4.dao.CartDao;
import com.b4.model.vo.Cart;

public class CartService {
	
	CartDao dao = new CartDao();
	
	public ArrayList<Cart> selectByMember(int memberSeq)
	{
		Connection conn = getConnection();
		ArrayList<Cart> list = dao.selectByMember(conn, memberSeq);
		close(conn);
		return list;
	}
	
	public ArrayList<Cart> getListByCookie(String[][] data)
	{
		Connection conn = getConnection();
		ArrayList<Cart> list = new ArrayList<Cart>();
		Cart cart;
		for(int i=0; i<data.length; i++)
		{
			if(data[i].length<3)
			{
				continue;
			}
			cart = dao.makeCart(conn,data[i][0],data[i][1],data[i][2]);
			if(cart != null)
			{
				list.add(cart);
			}
		}
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
	
	public int deleteOne(int memberSeq, int dpseq, String pcode) {
		Connection conn = getConnection();
		int result = dao.deleteOne(conn, memberSeq, dpseq, pcode);
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

	public List<Cart> selectByOrderSeq(int orderSeq) {
		Connection conn = getConnection();
		ArrayList<Cart> list = dao.selectByOrderSeq(conn, orderSeq);
		close(conn);
		return list;
	}

}
