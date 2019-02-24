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

	public List<IssuedCoupon> selectCouponListByMember(Connection conn, int cPage, int numPerPage, int memberSeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<IssuedCoupon> list = new ArrayList<>();
		String sql = prop.getProperty("selectCouponListByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				IssuedCoupon ic = new IssuedCoupon();
				ic.setCouponCode(rs.getString("couponCode"));
				ic.setCouponSeq(rs.getInt("couponSeq"));
				ic.setMemberSeq(rs.getInt("memberSeq"));
				ic.setIsUsed(rs.getString("isUsed"));
				ic.setIssueDate(rs.getTimestamp("issueDate"));
				ic.setExpiryDate(rs.getTimestamp("expiryDate"));
				ic.setCouponName(rs.getString("couponName"));
				ic.setDiscountRate(rs.getDouble("discountRate"));
				ic.setMinPrice(rs.getInt("minPrice"));
				ic.setMaxDisPrice(rs.getInt("maxDisPrice"));
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
	
	public int selectCouponCountByMember(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("selectCouponCountByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("CN");
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
