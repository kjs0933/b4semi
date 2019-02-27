package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.QueryBoard;
import com.b4.model.vo.QueryComment;
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
	
	public List<QueryBoard> selectListByMember(Connection conn, int cPage, int numPerPage, int memberSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QueryBoard> list = new ArrayList<QueryBoard>();
		String sql = prop.getProperty("selectListByMember");
		
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
				qb.setMemberId(rs.getString("memberId"));
				qb.setQuerySeq(rs.getInt("querySeq"));
				qb.setQueryTitle(rs.getString("queryTitle"));
				qb.setQueryContents(rs.getString("queryContents"));
				qb.setQueryDate(rs.getTimestamp("queryDate"));
				qb.setOrderSeq(rs.getInt("orderSeq"));
				list.add(qb);
			}	
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public List<QueryComment> selectCommentListByBoardSeq(Connection conn, int boardSeq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCommentByBoardSeq");
		List<QueryComment> cList = new ArrayList<QueryComment>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardSeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				QueryComment qc = new QueryComment();
				qc.setBoardeSeq(rs.getInt("boardSeq"));
				qc.setCommentDate(rs.getTimestamp("commentDate"));
				qc.setCommentSeq(rs.getInt("commentSeq"));
				qc.setCommentText(rs.getString("commentText"));
				qc.setMemberSeq(rs.getInt("memberSeq"));
				qc.setMemberId(rs.getString("memberId"));
				cList.add(qc);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
			close(rs);
		}
		return cList;
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
			pstmt.setInt(1, qb.getQuerySeq());
			pstmt.setInt(2, qb.getMemberSeq());
			pstmt.setString(3, qb.getQueryTitle());
			pstmt.setString(4, qb.getQueryContents());
			pstmt.setTimestamp(5, qb.getQueryDate());
			pstmt.setInt(6, qb.getOrderSeq());
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
	
	public int deleteQuery(Connection conn, int querySeq) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteQuery");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(2, querySeq);
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


	public int insertReply(Connection conn, int boardSeq, int memberSeq, String commentText) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardSeq);
			pstmt.setInt(2, memberSeq);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, commentText);
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
	
	public int updateReply(Connection conn, String commentText ,int commentSeq) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(2, commentText);
			pstmt.setInt(3, commentSeq);
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
	
	public int deleteReply(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(2, boardNo);
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
	
	public List<QueryBoard> getByDp(Connection conn, int dpseq, int qpage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QueryBoard> list = new ArrayList<QueryBoard>();
		String sql = prop.getProperty("getByDp");
		int numPerPage = 15;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dpseq);
			pstmt.setInt(2, (qpage-1)*numPerPage+1);
			pstmt.setInt(3, qpage*numPerPage);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				QueryBoard qb = new QueryBoard();
				qb.setMemberSeq(rs.getInt("memberSeq"));
				qb.setQuerySeq(rs.getInt("querySeq"));
				qb.setQueryTitle(rs.getString("queryTitle"));
				qb.setQueryContents(rs.getString("queryContents"));
				qb.setQueryDate(rs.getTimestamp("queryDate"));
				qb.setMemberId(rs.getString("memberId"));
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
	
	public int countByDP(Connection conn, int dpseq)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("countByDP");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dpseq);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getInt(1);
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
	
	public String selectRenamedFileByBoardNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectImageFilenameByBoardNo");
		String renamedFile = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next())
			{	
				renamedFile = rs.getString("renamedFile");
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
		return renamedFile;
		
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

	public QueryBoard selectByQuerySeq(Connection conn, int querySeq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QueryBoard qb = new QueryBoard();
		String sql = prop.getProperty("selectByQuerySeq");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, querySeq);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				qb.setMemberSeq(rs.getInt("memberSeq"));
				qb.setQuerySeq(rs.getInt("querySeq"));
				qb.setQueryTitle(rs.getString("queryTitle"));
				qb.setQueryContents(rs.getString("queryContents"));
				qb.setQueryDate(rs.getTimestamp("queryDate"));
				qb.setQueryDeleteDate(rs.getTimestamp("queryDeleteDate"));
				qb.setOrderSeq(rs.getInt("orderSeq"));
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

	public int selectNextVal(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("selectNextVal");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = rs.getInt(1);
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
}
