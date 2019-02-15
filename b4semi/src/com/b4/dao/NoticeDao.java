package com.b4.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.Notice;

public class NoticeDao {
	
	Properties prop = new Properties();
	
	public List<Notice> NoticeList(Connection conn, int cPage, int numPerPage)//시작페이지
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList();
		String sql = prop.getProperty("selectList");
		System.out.println(sql);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Notice n = new Notice();
				n.setNoticeSeq(rs.getInt("noticeseq"));
				n.setMemberSeq(rs.getInt("memberseq"));
				n.setNoticeTitle(rs.getString("noticetitle"));
				n.setNoticeContents(rs.getString("noticecontents"));
				n.setNoticeDate(rs.getTimestamp("noticedate"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int selectCount(Connection conn)//조회수
	{
		PreparedStatement pstmt=null;
		int result=0;
		ResultSet rs=null;
		String sql=prop.getProperty("selectCount");
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return result;
	}
	
	public int insertNotice(Connection conn, Notice n)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertnotice");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, n.getNoticeSeq());
			pstmt.setInt(2, n.getMemberSeq());
			pstmt.setString(3, n.getNoticeTitle());
			pstmt.setString(4, n.getNoticeContents());
			pstmt.setString(5, n.getNoticeOriginalFilename());
			pstmt.setString(6, n.getNoticeRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateNotice(Connection conn, Notice n)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updatenotice");
		try {
			pstmt=conn.prepareStatement(sql);
			
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteNotice(Connection conn, Notice n)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deletenotice");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, n.getNoticeSeq());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}

}
