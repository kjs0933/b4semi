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

import com.b4.model.vo.Member;
import com.b4.model.vo.Product;

public class ProductDao {

	Properties prop = new Properties();

	public ProductDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/product/product-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}
	
	public List<Product> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<Product> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Product d = new Product();
				d.setProductCode(rs.getString("productCode"));
				d.setSupplierCode(rs.getString("supplierCode"));
				d.setProductName(rs.getString("productName"));
				d.setOriginCountry(rs.getString("originCountry"));
				d.setSubCategoryCode(rs.getString("subCategoryCode"));
				d.setProductUnit(rs.getString("productUnit"));
				d.setProductOriginalFileName(rs.getString("productOriginalFileName"));
				d.setProductRenameFilename(rs.getString("productRenameFilename"));
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
	
	public int insertProduct(Connection conn, Product d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertProduct");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getProductCode());
			pstmt.setString(2, d.getSupplierCode());
			pstmt.setString(3, d.getProductName());
			pstmt.setString(4, d.getOriginCountry());
			pstmt.setString(5, d.getSubCategoryCode());
			pstmt.setString(6, d.getProductUnit());
			pstmt.setString(7, d.getProductOriginalFileName());
			pstmt.setString(8, d.getProductRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateProduct(Connection conn, Product d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateProduct");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,d.getProductCode());
			pstmt.setString(2, d.getSupplierCode());
			pstmt.setString(3, d.getProductName());
			pstmt.setString(4, d.getOriginCountry());
			pstmt.setString(5, d.getSubCategoryCode());
			pstmt.setString(6, d.getProductUnit());
			pstmt.setString(7, d.getProductOriginalFileName());
			pstmt.setString(8, d.getProductRenameFilename());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteProduct(Connection conn, Product d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteProduct");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getProductCode());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public Product selectOne(Connection conn, Product p)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOne");
		Product result = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getProductCode());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = new Product();
				result.setProductCode(rs.getString("productCode"));
				result.setSupplierCode(rs.getString("supplierCode"));
				result.setProductName(rs.getString("productName"));
				result.setOriginCountry(rs.getString("originCountry"));
				result.setSubCategoryCode(rs.getString("subCategoryCode"));
				result.setProductUnit(rs.getString("productUnit"));
				result.setProductOriginalFileName(rs.getString("productOriginaFileName"));
				result.setProductRenameFilename(rs.getString("productRenameFilename"));
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

	public Product selectByDpListSeq(Connection conn, int dpseq) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectByDpListSeq");
		Product p = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dpseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				p = new Product();
				p.setProductName(rs.getString("productName"));
				p.setProductCode(rs.getString("productCode"));
			}
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(rs); close(pstmt);}
		return p;
	}

}
