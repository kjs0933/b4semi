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

import com.b4.model.vo.QueryBoard;
import com.b4.model.vo.Reply;

public class QueryBoardDao {

	private Properties prop = new Properties();
	
	public QueryBoardDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/queryBoard/queryBoard-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int selectCountByMember(Connection conn, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("selectCountByMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("cnt");
			}
		}catch(SQLException e)
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
	
	public List<QueryBoard> selectAllByMember(Connection conn, int memberSeq, int cPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QueryBoard> list = new ArrayList<>();
		String sql = prop.getProperty("selectAllByMember");
		int numPerPage = 15;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				QueryBoard qb = new QueryBoard();
				qb.setMemberSeq(rs.getInt("memberSeq"));
				qb.setQuerySeq(rs.getInt("querySeq"));
				qb.setQueryTitle(rs.getString("queryTitle"));
				qb.setQueryContents(rs.getString("queryContents"));
				qb.setQueryDate(rs.getTimestamp("queryDate"));
				qb.setQueryDeleteDate(rs.getTimestamp("queryDeleteDate"));
				list.add(qb);
			}
		}catch(SQLException e)
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


	public int insertQuery(Connection conn, QueryBoard qb) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQuery");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qb.getMemberSeq());
			pstmt.setString(2, qb.getQueryTitle());
			pstmt.setString(3, qb.getQueryContents());
			pstmt.setTimestamp(4, qb.getQueryDate());
			pstmt.setInt(5, qb.getOrderSeq());
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
	
	public int updateQuery(Connection conn, QueryBoard qb) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQuery");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qb.getQueryTitle());
			pstmt.setString(2, qb.getQueryContents());
			pstmt.setTimestamp(3, qb.getQueryDate());
			pstmt.setInt(4, qb.getOrderSeq());
			pstmt.setInt(5, qb.getQuerySeq());
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
	
	public int deleteQuery(Connection conn, QueryBoard qb) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQuery");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, qb.getQueryDeleteDate());
			pstmt.setInt(2, qb.getQuerySeq());
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


	public int insertReply(Connection conn, Reply re) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re.getBoardSeq());
			pstmt.setInt(2, re.getMemberSeq());
			pstmt.setInt(3, re.getCommentRef());
			pstmt.setTimestamp(4, re.getCommentDate());
			pstmt.setString(5, re.getCommentText());
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
	
	public int updateReply(Connection conn, Reply re) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, re.getCommentDate());
			pstmt.setString(2, re.getCommentText());
			pstmt.setInt(3, re.getCommentSeq());
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
	
	public int deleteReply(Connection conn, Reply re) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, re.getCommentDeleteDate());
			pstmt.setInt(2, re.getCommentSeq());
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


	public QueryBoard selectRecentQuery(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QueryBoard qb = new QueryBoard();
		String sql = prop.getProperty("selectRecentQuery");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				qb.setMemberSeq(rs.getInt("memberSeq"));
				qb.setQuerySeq(rs.getInt("querySeq"));
				qb.setQueryTitle(rs.getString("queryTitle"));
				qb.setQueryContents(rs.getString("queryContents"));
				qb.setQueryDate(rs.getTimestamp("queryDate"));
				qb.setQueryDeleteDate(rs.getTimestamp("queryDeleteDate"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return qb;
	}
}
