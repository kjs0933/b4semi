package com.b4.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import com.b4.model.vo.Review;
import static common.JDBCTemplate.close;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/review/review-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int insertReview(Connection conn, Review r)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMemberSeq());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setString(3, r.getReviewContent());
			pstmt.setTimestamp(4, r.getReviewDate());
			pstmt.setInt(5, r.getReviewScore());
			pstmt.setString(6, r.getProductCode());
			pstmt.setInt(7, r.getDisplayListSeq());
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
	
	public int updateReview(Connection conn, Review r)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReview");
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setTimestamp(3, r.getReviewDate());
			pstmt.setInt(4, r.getReviewScore());
			pstmt.setInt(5, r.getReviewSeq());
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
	
	public int deleteReview(Connection conn, Review r)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getReviewSeq());
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

}
