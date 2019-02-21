package com.b4.dao;


import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.b4.model.vo.DPList;

public class DPListDao {
	
	Properties prop = new Properties();
	
	public DPListDao () {
		try {
			String fileName = MemberDao.class.getResource("/sql/DPList/DPList-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int searchDPCount(Connection cn, String keyword, String sub, String major)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("searchDPCount");
		int result = 0;
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			ps.setString(2, "%"+sub+"%");
			ps.setString(3, "%"+major+"%");
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(ps);
		}
		return result;
	}
	
	public String getSubText(Connection cn, String sub)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getSubText");
		String result = "";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, sub);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(ps);
		}
		return result;
	}
	public ArrayList<String> getSubTextAll(Connection cn, String major)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getSubTextAll");
		ArrayList<String> result = new ArrayList<String>();
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, major);
			rs=ps.executeQuery();
			while(rs.next())
			{
				result.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(ps);
		}
		return result;
	}
	
	public String getMajorText(Connection cn, String major)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getMajorText");
		String result = "";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, major);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getString(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(ps);
		}
		return result;
	}
	
	public ArrayList<DPList> searchDPList(Connection cn, int cPage, int numPerPage, String keyword, String sub, String major, String sortText)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<DPList> result = new ArrayList<DPList>();
		DPList dplist;
		String sql=prop.getProperty("searchDPList1") +" "+ sortText + prop.getProperty("searchDPList2");
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			ps.setString(2, "%"+sub+"%");
			ps.setString(3, "%"+major+"%");
			ps.setInt(4, (cPage)*numPerPage); //최대값이 먼저 와야 한다
			ps.setInt(5, (cPage-1)*numPerPage+1);
			rs=ps.executeQuery();
			while(rs.next())
			{
				dplist = new DPList();
				dplist.setDisplayListSeq(rs.getInt("DISPLAYLISTSEQ"));
				dplist.setDisplayListTitle(rs.getString("DISPLAYLISTTITLE"));
				dplist.setDpListAvailable(rs.getString("DPLISTAVAILABLE"));
				dplist.setDisplayDate(rs.getTimestamp("DISPLAYDATE"));
				dplist.setMinPrice(rs.getInt("MINPRICE"));
				dplist.setDiscountRate(rs.getDouble("DISCOUNTRATE"));
				dplist.setReviewScore(rs.getString("REVIEWSCORE"));
				dplist.setImg(rs.getString("IMG"));
				result.add(dplist);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(ps);
		}
		return result;
	}
	

}
