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

import com.b4.model.vo.Supplier;

public class SupplierDao {
	
	Properties prop = new Properties();

	public SupplierDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/Supplier/Supplier-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}
	
	public List<Supplier> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<Supplier> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Supplier d = new Supplier();
				d.setSupplierCode(rs.getString("supplierCode"));
				d.setSupplierName(rs.getString("supplierName"));
				d.setSupplierPhone(rs.getString("supplierPhone"));
				d.setSupplierAddress(rs.getString("supplierAddress"));
				d.setSupplierEmail(rs.getString("supplierEmail"));
				
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
	
	public int insertSupplier(Connection conn, Supplier d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertSupplier");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getSupplierCode());
			pstmt.setString(2, d.getSupplierName());
			pstmt.setString(3, d.getSupplierPhone());
			pstmt.setString(4, d.getSupplierAddress());
			pstmt.setString(5, d.getSupplierEmail());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateSupplier(Connection conn, Supplier d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateSupplier");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getSupplierCode());
			pstmt.setString(2, d.getSupplierName());
			pstmt.setString(3, d.getSupplierPhone());
			pstmt.setString(4, d.getSupplierAddress());
			pstmt.setString(5, d.getSupplierEmail());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteSupplier(Connection conn, Supplier d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteSupplier");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getSupplierCode());

			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public Supplier selectOne(Connection conn, String no)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Supplier s=null;
		String sql=prop.getProperty("selectOne");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				s=new Supplier();
				s.setSupplierCode(rs.getString("supplierCode"));
				s.setSupplierName(rs.getString("supplierName"));
				s.setSupplierPhone(rs.getString("supplierPhone"));
				s.setSupplierAddress(rs.getString("supplierAddress"));
				s.setSupplierEmail(rs.getString("supplierEmail"));
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
		return s;

	}


}
