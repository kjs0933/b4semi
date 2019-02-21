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

import com.b4.model.vo.CouponMaster;
import com.b4.model.vo.IssuedCoupon;

public class CouponDao {
	
private Properties prop = new Properties();
	
	public CouponDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/coupon/coupon-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public int insertCouponMaster(Connection conn, CouponMaster cm) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCouponMaster");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getCouponCode());
			pstmt.setString(2, cm.getCouponName());
			pstmt.setDouble(3, cm.getDiscountRate());
			pstmt.setInt(4, cm.getMinPrice());
			pstmt.setInt(5, cm.getMaxDisPrice());
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		return result;
	}

	public int updateCouponMaster(Connection conn, CouponMaster cm) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCouponMaster");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getCouponName());
			pstmt.setDouble(2, cm.getDiscountRate());
			pstmt.setInt(3, cm.getMinPrice());
			pstmt.setInt(4, cm.getMaxDisPrice());
			pstmt.setString(5, cm.getCouponCode());
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		return result;
	}

	public int deleteCouponMaster(Connection conn, CouponMaster cm) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCouponMaster");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getCouponCode());
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		return result;
	}

	public List<IssuedCoupon> selectCouponByMember(Connection conn, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<IssuedCoupon> list = new ArrayList<>();
		String sql = prop.getProperty("selectCouponByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				IssuedCoupon ic = new IssuedCoupon();
				//sql : couponName은 couponMaster에서 join해서 가져올 것
				ic.setCouponName(rs.getString("couponName"));
				ic.setUsed(rs.getBoolean("isUsed"));
				ic.setIssueDate(rs.getTimestamp("issuedDate"));
				ic.setExpiryDate(rs.getTimestamp("expiryDate"));
				list.add(ic);
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
