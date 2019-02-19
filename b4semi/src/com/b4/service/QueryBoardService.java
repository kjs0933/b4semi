package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.QueryBoardDao;
import com.b4.model.vo.QueryBoard;
import com.b4.model.vo.Reply;

public class QueryBoardService {
	
	QueryBoardDao dao = new QueryBoardDao();

	//1대1문의 게시판 회원별 count
	public int selectCountByMember(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectCountByMember(conn, memberSeq);
		close(conn);
		return result;
	}
	
	//1대1문의 게시판 회원별 리스트
	public List<QueryBoard> selectAllByMember(int memberSeq, int cPage)
	{
		Connection conn = getConnection();
		List<QueryBoard> list = dao.selectAllByMember(conn, memberSeq, cPage);
		close(conn);
		return list;
	}
	
	//1대1문의 입력
	public int insertQuery(QueryBoard qb)
	{
		Connection conn = getConnection();
		int result = dao.insertQuery(conn, qb);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//1대1문의 수정(querySeq로 접근, title, contents, date, 참조orderSeq만 변경
	public int updateQuery(QueryBoard qb)
	{
		Connection conn = getConnection();
		int result = dao.updateQuery(conn, qb);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	

	//1대1문의 삭제(deleteDate수정)
	public int deleteQuery(QueryBoard qb)
	{
		Connection conn = getConnection();
		int result = dao.deleteQuery(conn, qb);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//QueryBoard에 관련된
	//Reply 메소드
	
	//댓글 입력
	public int insertReply(Reply re)
	{
		Connection conn = getConnection();
		int result = dao.insertReply(conn, re);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
