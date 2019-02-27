package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.Cart;
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

	public List<OrderList> selectByMemberThreeYears(Connection conn, int cPage, int numPerPage, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderList> list = new ArrayList<>();
		String sql = prop.getProperty("selectByMemberThreeYears");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
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

	public OrderList selectByOrderListSeq(Connection conn, int orderSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderList ol = new OrderList();
		String sql = prop.getProperty("selectByOrderListSeq");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
		return ol;
	}

	public List<OrderList> selectByMemberRecent5(Connection conn, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderList> list = new ArrayList<>();
		String sql = prop.getProperty("selectByMemberRecent5");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
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

	public int getOrderSeq(Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result=0;
		String sql = prop.getProperty("getOrderSeq");
		try {
			pstmt = conn.prepareStatement(sql);
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
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
		
	}

	public int newOrder(Connection conn, OrderList order)
	{
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("newOrder");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,order.getOrderSeq());
			if(order.getCouponSeq()==0)
			{
				pstmt.setNull(2,Types.INTEGER);
			}
			else
			{
				pstmt.setInt(2,order.getCouponSeq());
			}
			pstmt.setInt(3,order.getMemberSeq());
			pstmt.setInt(4,order.getSpentMileage());
			pstmt.setString(5, order.getReceiverName());
			pstmt.setString(6, order.getReceiverAddress());
			pstmt.setString(7, order.getReceiverPhone());
			pstmt.setString(8, order.getReceiverComment());
			pstmt.setInt(9, order.getTotalPrice());
			pstmt.setTimestamp(10, order.getOrderTime());
			pstmt.setInt(11, order.getShipmentFee());
			
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public int newOrderP(Connection conn, ArrayList<Cart> cartlist, int orderSeq)
	{
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("newOrderP");
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<cartlist.size();i++)
			{
				pstmt.setInt(1, orderSeq);
				pstmt.setString(2, cartlist.get(i).getProductCode());
				pstmt.setInt(3, cartlist.get(i).getDisplayListSeq());
				pstmt.setInt(4, cartlist.get(i).getProductCount());
				result += pstmt.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}
