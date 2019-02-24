package com.b4.service;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.b4.dao.MemberDao;
import com.b4.model.vo.OrderPDetail;
import com.b4.model.vo.Product;

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
	
}
