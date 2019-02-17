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
				m.setMemberSeq(rs.getInt("memberSeq"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberGradeName(rs.getString("memberGradeName"));
				m.setMemberPw(rs.getString("memberPw"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberComment(rs.getString("memberComment"));
				m.setMemberEnrollDate(rs.getTimestamp("memberEnrollDate"));
				m.setMemberQuitDate(rs.getTimestamp("memberQuitDate"));
				m.setMemberMileage(rs.getInt("memberMileage"));
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
