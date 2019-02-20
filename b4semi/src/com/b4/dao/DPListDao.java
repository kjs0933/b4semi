package com.b4.dao;


import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.b4.model.vo.DPList;

public class DPListDao {
	
	Properties prop = new Properties();
	
	public List<DPList> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<DPList> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				DPList d = new DPList();
				d.setDisplayListSeq(rs.getInt("diplayListSeq"));
				d.setDisplayListTitle(rs.getString("diplayListTitle"));
				d.setDisplayListContents(rs.getString("displayListContents"));
				d.setDPListAvailable(rs.getString("DPListAvailable"));
				d.setDisplayDate(rs.getTimestamp("displayDate"));
				d.setDPListOriginalFileName(rs.getString("dplistoriginalfilename"));
				d.setDPListRenameFilename(rs.getString("DPListRenameFilename"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return list;	
	}
	
	public int displayListSeq(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("displayListSeq");
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {close(rs);close(pstmt);}
		return result;
	}
	
	public int insertDPList(Connection conn, DPList d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDisplayListSeq());
			pstmt.setString(2, d.getDisplayListTitle());
			pstmt.setString(3, d.getDisplayListContents());
			pstmt.setString(4, d.getDPListAvailable());
			pstmt.setTimestamp(5, d.getDisplayDate());
			pstmt.setString(6, d.getDPListOriginalFileName());
			pstmt.setString(7, d.getDPListRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateDPList(Connection conn, DPList d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,d.getDisplayListSeq());
			pstmt.setString(2, d.getDisplayListTitle());
			pstmt.setString(3, d.getDisplayListContents());
			pstmt.setString(4, d.getDPListAvailable());
			pstmt.setTimestamp(5, d.getDisplayDate());
			pstmt.setString(6, d.getDPListOriginalFileName());
			pstmt.setString(7, d.getDPListRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteDPList(Connection conn, DPList d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteDPList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDisplayListSeq());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}

}
