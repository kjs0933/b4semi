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

import com.b4.model.vo.Category;
import com.b4.model.vo.DPList;
import com.b4.model.vo.DPOption;

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
			ps.setString(2, "%"+keyword+"%");
			ps.setString(3, "%"+keyword+"%");
			ps.setString(4, "%"+sub+"%");
			ps.setString(5, "%"+major+"%");
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
				result=rs.getString("SUBCATEGORYNAME");
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
	public ArrayList<Category> getSubTextAll(Connection cn, String major)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getSubTextAll");
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, major);
			rs=ps.executeQuery();
			while(rs.next())
			{
				result.add(new Category(rs.getString("MAJORCATEGORYCODE"),rs.getString("SUBCATEGORYCODE"),rs.getString("SUBCATEGORYNAME")));
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
	
	public Category getMajorText(Connection cn, String major)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getMajorText");
		Category result=null;
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, major);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=new Category(rs.getString("MAJORCATEGORYCODE"),"",rs.getString("MAJORCATEGORYNAME"));
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
	public ArrayList<Category> getMajorTextAll(Connection cn)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql=prop.getProperty("getMajorTextAll");
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				result.add(new Category(rs.getString("MAJORCATEGORYCODE"),"",rs.getString("MAJORCATEGORYNAME")));
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
			ps.setString(2, "%"+keyword+"%");
			ps.setString(3, "%"+keyword+"%");
			ps.setString(4, "%"+sub+"%");
			ps.setString(5, "%"+major+"%");
			ps.setInt(6, (cPage)*numPerPage); //최대값이 먼저 와야 한다
			ps.setInt(7, (cPage-1)*numPerPage+1);
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
				dplist.setOptionCount(rs.getInt("OPTIONCOUNT"));
				dplist.setProductUnit(rs.getString("PRODUCTUNIT"));
				dplist.setProductCode(rs.getString("PRODUCTCODE"));
				dplist.setDiscountMinPrice();
				dplist.setReviewCount(rs.getInt("POPULARITY"));
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
	
	public ArrayList<DPOption> searchDPOption(Connection cn, int dpSeq)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<DPOption> result = new ArrayList<DPOption>();
		DPOption dpoption;
		String sql=prop.getProperty("searchDPOption");
		try {
			ps=cn.prepareStatement(sql);
			ps.setInt(1, dpSeq);
			rs=ps.executeQuery();
			while(rs.next())
			{
				dpoption = new DPOption();
				dpoption.setProductCode(rs.getString("PRODUCTCODE"));
				dpoption.setProductName(rs.getString("PRODUCTNAME"));
				dpoption.setDisplayListSeq(rs.getInt("DISPLAYLISTSEQ"));
				dpoption.setDisplayOptionPrice(rs.getInt("DISPLAYOPTIONPRICE"));
				dpoption.setOptionAvailable(rs.getString("OPTIONAVAILABLE"));
				dpoption.setDiscountRate(rs.getDouble("DISCOUNTRATE"));
				dpoption.setDiscountCode(rs.getString("DISCOUNTCODE"));
				dpoption.setDiscountOptionPrice();
				dpoption.setOriginCountry(rs.getString("ORIGINCOUNTRY"));
				result.add(dpoption);
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
