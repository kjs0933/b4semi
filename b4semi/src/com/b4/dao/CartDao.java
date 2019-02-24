package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.b4.model.vo.Cart;

public class CartDao {

	private Properties prop = new Properties();
	
	public CartDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/cart/cart-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cart> selectByMember(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> list = new ArrayList<Cart>();
		Cart cart = null;
		String sql = prop.getProperty("selectByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				cart = new Cart();
				cart.setOptionAvailable(rs.getString("optionAvailable"));
				cart.setProductUnit(rs.getString("productUnit"));
				cart.setDiscountCode(rs.getString("discountCode"));
				cart.setProductCode(rs.getString("productCode"));
				cart.setProductName(rs.getString("productName"));
				cart.setDisplayListSeq(rs.getInt("displayListSeq"));
				cart.setProductCount(rs.getInt("productCount"));
				cart.setDisplayOptionPrice(rs.getInt("displayOptionPrice"));
				cart.setDiscountName(rs.getString("discountName"));
				cart.setDiscountRate(rs.getDouble("discountRate"));
				cart.setDisplayListTitle(rs.getString("displayListTitle"));
				cart.setDpListAvailable(rs.getString("dpListAvailable"));
				cart.setDiscountOptionPrice();
				cart.setImg(rs.getString("renameFile"));
				list.add(cart);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public Cart makeCart(Connection conn, String dpseq, String pcode, String amount)
	{
		
		Cart cart = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("getDataByDPOption");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(dpseq));
			pstmt.setString(2, pcode);
			int pcount = Integer.parseInt(amount);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				cart = new Cart();
				cart.setOptionAvailable(rs.getString("optionAvailable"));
				cart.setProductUnit(rs.getString("productUnit"));
				cart.setDiscountCode(rs.getString("discountCode"));
				cart.setProductCode(rs.getString("productCode"));
				cart.setProductName(rs.getString("productName"));
				cart.setDisplayListSeq(rs.getInt("displayListSeq"));
				cart.setProductCount(pcount);
				cart.setDisplayOptionPrice(rs.getInt("displayOptionPrice"));
				cart.setDiscountName(rs.getString("discountName"));
				cart.setDiscountRate(rs.getDouble("discountRate"));
				cart.setDisplayListTitle(rs.getString("displayListTitle"));
				cart.setDpListAvailable(rs.getString("dpListAvailable"));
				cart.setImg(rs.getString("renameFile"));
				cart.setDiscountOptionPrice();
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return cart;
	}
	public int insertCart(Connection conn, int memberSeq, int dpseq, String pcode, int amount) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertCart");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, pcode);
			pstmt.setInt(3, dpseq);
			pstmt.setInt(4, amount);
			result = pstmt.executeUpdate();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateCart(Connection conn, int memberSeq, int dpseq, String pcode, int amount) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateCart");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, pcode);
			pstmt.setInt(3, dpseq);
			pstmt.setInt(4, amount);
			pstmt.setInt(5, memberSeq);
			pstmt.setString(6, pcode);
			pstmt.setInt(7, dpseq);
			result = pstmt.executeUpdate();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteOne(Connection conn, int memberSeq, int dpseq, String pcode) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteOne");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, pcode);
			pstmt.setInt(3, dpseq);
			pstmt.executeUpdate();	
			result = pstmt.executeUpdate();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int getKindCount(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		String sql = prop.getProperty("getKindCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();	
			if(rs.next())
			{
				result = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public int getAmount(Connection conn, int memberSeq, int dpseq, String pcode)
	{
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		String sql = prop.getProperty("getAmount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setString(2, pcode);
			pstmt.setInt(3, dpseq);
			rs = pstmt.executeQuery();		
			if(rs.next())
			{
				
				result = rs.getInt("PRODUCTCOUNT");
				if(result<=0)
				{
					System.out.println("장바구니 수량 0이하 데이터 삭제!");
					deleteOne(conn,memberSeq,dpseq,pcode);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
}
