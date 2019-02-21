package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.b4.dao.DPListDao;
import com.b4.model.vo.DPList;

public class DPListService {
	
	private DPListDao dao = new DPListDao();
	
	public int searchDPCount(String keyword, String category)
	{
		Connection cn=getConnection();
		int result = dao.searchDPCount(cn,keyword,category);
		close(cn);
		return result;
	}
	
	public ArrayList<DPList> searchDPList(int cPage,int numPerPage,String keyword,String category,String sortText)
	{
		Connection cn=getConnection();
		ArrayList<DPList> result = dao.searchDPList(cn, cPage, numPerPage, keyword, category, sortText);
		close(cn);
		return result;
	}

}
