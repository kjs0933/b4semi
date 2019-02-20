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

import com.b4.model.vo.DPOption;

public class DPOptionDao {

Properties prop = new Properties();

	public DPOptionDao() {
		try {
			String fileName = MemberDao.class.getResource("/sql/DPOption/DPOption-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}
	
	public List<DPOption> selectList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<DPOption> list = new ArrayList<>();
		String sql=prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				DPOption d = new DPOption();
				d.setProductCode(rs.getString("productCode"));
				d.setDisplayListSeq(rs.getInt("displayListSeq"));
				d.setDiscountCode(rs.getString("discountCode"));
				d.setDisplayOptionPrice(rs.getInt("displayOptionPrice"));
				d.setOptionAvailable(rs.getString("OptionAvailable"));
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
	
	public int insertDPOption(Connection conn, DPOption d)//입력
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertDPOption");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getProductCode());
			pstmt.setInt(2, d.getDisplayListSeq());
			pstmt.setString(3, d.getDiscountCode());
			pstmt.setInt(4, d.getDisplayOptionPrice());
			pstmt.setString(5, d.getOptionAvailable());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int updateDPOption(Connection conn, DPOption d)//수정
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateDPOption");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,d.getProductCode());
			pstmt.setInt(2, d.getDisplayListSeq());
			pstmt.setString(3, d.getDiscountCode());
			pstmt.setInt(4, d.getDisplayOptionPrice());
			pstmt.setString(5, d.getOptionAvailable());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}
	
	public int deleteDPOption(Connection conn, DPOption d)//삭제
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteDPOption");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, d.getProductCode());
			pstmt.setInt(2, d.getDisplayListSeq());
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally {close(pstmt);}
		return result;
	}

}
