package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public List<Cart> selectByMember(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Cart> list = new ArrayList<>();
		Cart cart = null;
		String sql = prop.getProperty("selectByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				cart = new Cart();
				cart.setMemberSeq(rs.getInt("memberSeq"));
				cart.setProductCode(rs.getString("productCode"));
				cart.setProductName(rs.getString("productName"));
				cart.setDisplayListSeq(rs.getInt("displayListSeq"));
				cart.setProductCount(rs.getInt("productCount"));
				cart.setDisplayOptionPrice(rs.getInt("displayOptionPrice"));
				cart.setDiscountName(rs.getString("discountName"));
				cart.setDiscountRate(rs.getDouble("discountRate"));
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
}
