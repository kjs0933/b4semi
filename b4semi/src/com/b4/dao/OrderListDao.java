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

import com.b4.model.vo.OrderList;

public class OrderListDao {
	
	private Properties prop = new Properties();
	
	public OrderListDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/orderList/orderList-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public List<OrderList> selectByMemberThreeYears(Connection conn, int cPage, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderList> list = new ArrayList<>();
		String sql = prop.getProperty("selectByMemberThreeYears");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, (cPage-1)*7+1);
			pstmt.setInt(3, (cPage*7));
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				OrderList ol = new OrderList();
				ol.setOrderSeq(rs.getInt("orderSeq"));
				ol.setCouponSeq(rs.getInt("couponSeq"));
				ol.setMemberSeq(rs.getInt("memberSeq"));
				ol.setOrderStatusCode(rs.getString("orderStatusCode"));
				ol.setSpentMileage(rs.getInt("spentMileage"));
				ol.setReceiverName(rs.getString("receiverName"));
				ol.setReceiverAddress(rs.getString("receiverAddress"));
				ol.setReceiverPhone(rs.getString("receiverPhone"));
				ol.setReceiverComment(rs.getString("receiverComment"));
				ol.setShipmentNo(rs.getString("shipmentNo"));
				ol.setTotalPrice(rs.getInt("totalPrice"));
				ol.setCancelprice(rs.getInt("cancelPrice"));
				ol.setOrderTime(rs.getTimestamp("orderTime"));
				ol.setShipmentFee(rs.getInt("shipmentFee"));
				list.add(ol);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectCountByMemberThreeYears(Connection conn, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result=0;
		String sql = prop.getProperty("selectCountByMemberThreeYears");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt("CNT");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}



}
