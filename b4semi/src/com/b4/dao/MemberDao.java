package com.b4.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.b4.model.vo.Member;
import static common.JDBCTemplate.close;

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
				m.setMemberEnrollDate(rs.getDate("memberEnrollDate"));
				m.setMemberQuitDate(rs.getDate("memberQuitDate"));
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
	


}
