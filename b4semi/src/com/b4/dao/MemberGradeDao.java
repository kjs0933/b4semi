package com.b4.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.b4.model.vo.MemberGrade;
import com.b4.model.vo.Notice;

public class MemberGradeDao {
	
private Properties prop = new Properties();
	
	public MemberGradeDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/grade/grade-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public MemberGrade selectOne(Connection conn,int no)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberGrade m=null;
		String sql=prop.getProperty("selectOne");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				m=new MemberGrade();
				m.setMemberGradeCode(rs.getString("memberGradeCode"));
				m.setMemberGradeName(rs.getString("memberGradeName"));
				m.setGradeRate(rs.getInt("gradeRate"));
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return m;
	}
		
		
		

}
