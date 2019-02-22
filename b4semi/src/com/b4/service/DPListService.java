package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.b4.dao.DPListDao;
import com.b4.model.vo.Category;
import com.b4.model.vo.DPList;

public class DPListService {
	
	private DPListDao dao = new DPListDao();
	
	public int searchDPCount(String keyword, String sub, String major)
	{
		Connection cn=getConnection();
		int result = dao.searchDPCount(cn,keyword,sub,major);
		close(cn);
		return result;
	}
	
	public ArrayList<DPList> searchDPList(int cPage,int numPerPage,String keyword,String sub, String major, String sortText)
	{
		Connection cn=getConnection();
		ArrayList<DPList> result = dao.searchDPList(cn, cPage, numPerPage, keyword, sub, major, sortText);
		close(cn);
		return result;
	}
	
	public String getSubText(String sub)
	{
		Connection cn=getConnection();
		String result = dao.getSubText(cn,sub);
		close(cn);
		return result;
	}
	public Category getMajorText(String major)
	{
		Connection cn=getConnection();
		Category result = dao.getMajorText(cn,major);
		close(cn);
		return result;
	}
	public ArrayList<Category> getSubTextAll(String major)
	{
		Connection cn=getConnection();
		ArrayList<Category> result = dao.getSubTextAll(cn,major);
		close(cn);
		return result;
	}
	
	public ArrayList<Category> getMajorTextAll()
	{
		Connection cn=getConnection();
		ArrayList<Category> result = dao.getMajorTextAll(cn);
		close(cn);
		return result;
	}
}
