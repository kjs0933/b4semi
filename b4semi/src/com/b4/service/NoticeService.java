package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.NoticeDao;
import com.b4.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao dao = new NoticeDao();
	
	//public List<Notice> selectList(int cPage,int numPerPage)
	{
		Connection conn=getConnection();
		//List<Notice> list = dao.selectList(conn,cPage,numPerPage);
		close(conn);
		//return list;
	}
	
	public int selectCount()
	{
		Connection conn=getConnection();
		int result=dao.selectCount(conn);
		close(conn);
		return result;
	}
	
	/*public Notice selectOne(int no)
	{
		Connection conn=getConnection();
		Notice n=dao.selectOne(conn,no);
		close(conn);
		return n;
	}*/
	
	public int insertNotice(Notice n)//
	{
		Connection conn=getConnection();//
		//noticeSeq.nextVal을 가져오는 메소드 작성
		
		//가져온 리턴값을 n.setNoticeSeq(가져온값)
		int result=dao.insertNotice(conn, n);
		//가져온 번호로 넘겨줌=>preaparedStatement로 ?로 넘겨줌
		if(result>0)
		{
			//커밋하기 전에 가져온 이미지를 db에 저장하는 메소드를 작성
			commit(conn);
			//result=dao.selectSeq(conn);
		}
		else {rollback(conn);}
		close(conn);
		return result;
	}
	
	public int updateNotice(Notice n)
	{
		Connection conn=getConnection();
		int result=dao.updateNotice(conn, n);
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
	
	public int deleteNotice(Notice n)
	{
		Connection conn=getConnection();
		int result=dao.deleteNotice(conn, n);
		
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
