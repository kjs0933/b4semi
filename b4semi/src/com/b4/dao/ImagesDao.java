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

import com.b4.model.vo.Images;


public class ImagesDao {

	Properties prop = new Properties();
	
	public ImagesDao() {	
		
		try {
			String fileName = ImagesDao.class.getResource("/sql/images/Images-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Images> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<Images> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Images d = new Images();
				d.setRenameFile(rs.getString("renameFile"));
				d.setOriginalFile(rs.getString("originalFile"));
				d.setBoardCode(rs.getString("boardCode"));
				d.setBoardNo(rs.getInt("boardNo"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return list;	
	}
	
	public int ImagesSeq(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("ImagesSeq");
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
	
	public int insertImages(Connection conn, Images d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertImages");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getRenameFile());
			pstmt.setString(2, d.getOriginalFile());
			pstmt.setString(3, d.getBoardCode());
			pstmt.setInt(4, d.getBoardNo());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	
	public int deleteImages(Connection conn, Images d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteImages");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getRenameFile());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}

	public List<Images> selectListByBoard(Connection conn, String boardCode, int querySeq) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<Images> list = new ArrayList<>();
		String sql=prop.getProperty("selectListByBoard");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "BQ");
			pstmt.setInt(2, querySeq);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Images d = new Images();
				d.setRenameFile(rs.getString("renameFile"));
				d.setOriginalFile(rs.getString("originalFile"));
				d.setBoardCode(rs.getString("boardCode"));
				d.setBoardNo(rs.getInt("boardNo"));
				list.add(d);
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return list;
	}

	public int updateImages(Connection conn, String oldFile, Images img) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateImages");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, img.getRenameFile());
			pstmt.setString(2, img.getOriginalFile());
			pstmt.setString(3, oldFile);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
}
