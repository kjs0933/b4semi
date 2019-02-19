package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.b4.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean checkId(Connection conn, String memberId)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("checkId");
		boolean result = false;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
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
	
	public Member selectOne(Connection conn, Member m)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOne");
		Member result = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = new Member();
				result.setMemberSeq(rs.getInt("memberSeq"));
				result.setMemberId(rs.getString("memberId"));
				result.setMemberGradeName(rs.getString("memberGradeName"));
				result.setMemberPw(rs.getString("memberPw"));
				result.setMemberName(rs.getString("memberName"));
				result.setMemberEmail(rs.getString("memberEmail"));
				result.setMemberPhone(rs.getString("memberPhone"));
				result.setMemberComment(rs.getString("memberComment"));
				result.setMemberEnrollDate(rs.getTimestamp("memberEnrollDate"));
				result.setMemberQuitDate(rs.getTimestamp("memberQuitDate"));
				result.setMemberMileage(rs.getInt("memberMileage"));
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
	
	public int insertOne(Connection conn, Member m)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertOne");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, arg1);
			pstmt.setString(2, arg1);
			pstmt.setString(3, arg1);
			pstmt.setString(4, arg1);
			pstmt.setString(5, arg1);
		}
	}
	
	
	public int updateMember(Connection conn, Member m)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getMemberPw());
			pstmt.setString(2,m.getMemberName());
			pstmt.setString(3,m.getMemberEmail() );
			pstmt.setString(4,m.getMemberPhone() );
			pstmt.setString(5,m.getMemberId() );
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
	
	public int quitMember(Connection conn, Member m)
	{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("quitMember");
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, m.getMemberQuitDate());
			pstmt.setString(2, m.getMemberId());
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


}
