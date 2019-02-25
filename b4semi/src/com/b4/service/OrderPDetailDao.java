package com.b4.service;

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

import com.b4.dao.MemberDao;
import com.b4.model.vo.OrderPDetail;

public class OrderPDetailDao {
	
	Properties prop = new Properties();

	public OrderPDetailDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/orderPDetail/orderPDetail-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}

	public OrderPDetail selectOneByOrderListSeq(Connection conn, int orderSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOneByOrderListSeq");
		OrderPDetail opd = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				opd = new OrderPDetail();
				
				opd.setProductCode(rs.getString("productCode"));
				opd.setProductName(rs.getString("productName"));
				opd.setCountByOrderList(rs.getInt("RNUM"));
				opd.setOrderSeq(rs.getInt("orderSeq"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs); close(pstmt);}
		return opd;
	}

	public List<OrderPDetail> selectByOrderListSeq(Connection conn, int orderSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectByOrderListSeq");
		List<OrderPDetail> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderPDetail opd = new OrderPDetail();
				
				opd.setProductCode(rs.getString("productCode"));
				opd.setProductName(rs.getString("productName"));
				opd.setDiscountcode(rs.getString("discountCode"));
				opd.setDisplayListSeq(rs.getInt("displayListSeq"));
				opd.setDisplayOptionPrice(rs.getInt("displayOptionPrice"));
				opd.setOptionavailable(rs.getString("optionavailable"));
				opd.setOrderProductCount(rs.getInt("orderProductCount"));
				opd.setOrderSeq(rs.getInt("orderSeq"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs); close(pstmt);}
		return list;
	}

}
