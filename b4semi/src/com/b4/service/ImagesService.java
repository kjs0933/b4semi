package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.ImagesDao;
import com.b4.model.vo.Images;
import com.b4.model.vo.Notice;

public class ImagesService {
	
	private ImagesDao dao = new ImagesDao();
	
	public List<Images> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Images> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public Images selectOne(int no)
	{
		Connection conn=getConnection();
		Images i=dao.selectOne(conn,no);
		close(conn);
		return i;
	}
	
	public int insertImages(Images d)
	{
		Connection conn=getConnection();
		int result=dao.insertImages(conn,d);
		if(result>0)
		{
			commit(conn);
			//result=dao.ImagesSeq(conn);
		}
		else{rollback(conn);}
		close(conn);
		return result;
	}
	
	
	public int deleteImages(Images d)
	{
		Connection conn=getConnection();
		int result=dao.deleteImages(conn, d);
		
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
