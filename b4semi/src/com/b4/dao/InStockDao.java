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

import com.b4.model.vo.InStock;

public class InStockDao {

	Properties prop = new Properties();

	public InStockDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/InStock/InStock-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<InStock> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<InStock> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				InStock d = new InStock();
				d.setInstockSeq(rs.getInt("instockSeq"));
				d.setProductCode(rs.getString("productCode"));
				d.setInStockDate(rs.getTimestamp("inStockDate"));
				d.setInStockCount(rs.getInt("inStockCount"));
				d.setInStockPrice(rs.getInt("inStockPrice"));
				d.setExpiryDate(rs.getTimestamp("expiryDate"));
				d.setRemainStockCount(rs.getInt("remainStockCount"));
				d.setExpiredStockCount(rs.getInt("expiredStockCount"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs);close(pstmt);}
		return list;	
	}
	
	public int instockSeq(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("instockSeq");
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
	
	public int insertInStock(Connection conn, InStock d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertInStock");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getInstockSeq());
			pstmt.setString(2, d.getProductCode());
			pstmt.setTimestamp(3, d.getInStockDate());
			pstmt.setInt(4, d.getInStockCount());
			pstmt.setInt(5, d.getInStockPrice());
			pstmt.setTimestamp(6, d.getExpiryDate());
			pstmt.setInt(7, d.getRemainStockCount());
			pstmt.setInt(8, d.getExpiredStockCount());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateInStock(Connection conn, InStock d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateInStock");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getInstockSeq());
			pstmt.setString(2, d.getProductCode());
			pstmt.setTimestamp(3, d.getInStockDate());
			pstmt.setInt(4, d.getInStockCount());
			pstmt.setInt(5, d.getInStockPrice());
			pstmt.setTimestamp(6, d.getExpiryDate());
			pstmt.setInt(7, d.getRemainStockCount());
			pstmt.setInt(8, d.getExpiredStockCount());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteInStock(Connection conn, InStock d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteInStock");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, d.getInstockSeq());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public InStock selectOne(Connection conn, int no)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		InStock i=null;
		String sql=prop.getProperty("selectOne");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				i=new InStock();
				i.setInstockSeq(rs.getInt("InStockseq"));
				i.setProductCode(rs.getString("productCode"));
				i.setInStockDate(rs.getTimestamp("InStockDate"));
				i.setInStockCount(rs.getInt("InStockCount"));
				i.setInStockPrice(rs.getInt("inStockPrice"));
				i.setExpiryDate(rs.getTimestamp("expiryDate"));
				i.setRemainStockCount(rs.getInt("remainStockCount"));
				i.setExpiredStockCount(rs.getInt("expiredStockCount"));
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
		return i;

	}
}
