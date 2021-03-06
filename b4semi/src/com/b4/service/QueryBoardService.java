package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.b4.dao.QueryBoardDao;
import com.b4.model.vo.QueryBoard;

public class QueryBoardService {
	//1대1문의 게시판 및 댓글 테이블에 대한 메소드정의.
	
	
	QueryBoardDao dao = new QueryBoardDao();

	//1대1문의 게시판 회원별 count
	public int selectCountByMember(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectCountByMember(conn, memberSeq);
		close(conn);
		return result;
	}
	
	public List<QueryBoard> selectListByMember(int cPage, int numPerPage, int memberSeq)
	{
		Connection conn = getConnection();
		List<QueryBoard> result = dao.selectListByMember(conn, cPage, numPerPage, memberSeq);
		
		for(QueryBoard qb : result)
		{
			qb.setList(dao.selectCommentListByBoardSeq(conn, qb.getQuerySeq()));
			qb.setRenamedFile(dao.selectRenamedFileByBoardNo(conn, qb.getQuerySeq()));
		}
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
	public int deleteQuery(int querySeq)
	{
		Connection conn = getConnection();
		int result = dao.deleteQuery(conn, querySeq);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//QueryBoard에 관련된
	//Reply 메소드
	
	//댓글 입력
	public int[] insertReply(int boardSeq, int memberSeq, String commentText, Timestamp commentDate)
	{
		Connection conn = getConnection();
		int result[] = new int[2];
		result[0] = dao.insertReply(conn, boardSeq, memberSeq, commentText, commentDate);
		result[1] = dao.selectReplyCurrval(conn);
		if(result[0] > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//댓글 수정
	public int updateReply(String commentText, int commentSeq)
	{
		Connection conn = getConnection();
		int result = dao.updateReply(conn, commentText, commentSeq);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//댓글삭제 - 프런트에서 deleteDate있을 경우 삭제된 것으로 처리
	public int deleteReply(int commentSeq)
	{
		Connection conn = getConnection();
		int result = dao.deleteReply(conn, commentSeq);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//상품상세페이지에서 보여줄 주문번호 관련 문의 모두 가져오기
	public List<QueryBoard> getByDp(int dpseq, int qpage)
	{
		Connection conn = getConnection();
		List<QueryBoard> list = dao.getByDp(conn, dpseq, qpage);
		//각 객체에 댓글 객체를 넣어주는 과정
		for(int i=0; i<list.size();i++)
		{
			list.get(i).setList(dao.selectCommentListByBoardSeq(conn, list.get(i).getQuerySeq()));
			//list.get(i).setImg(dao.);
		}
		close(conn);
		return list;
	}
	
	 public int countByDP(int dpseq)
	 {
		Connection conn = getConnection();
		int result = dao.countByDP(conn, dpseq);
		close(conn);
		return result;
	 }

	public QueryBoard selectRecentQuery() {
		Connection conn = getConnection();
		QueryBoard qb = dao.selectRecentQuery(conn);
		close(conn);
		return qb;
	}

	public QueryBoard selectByQuerySeq(int querySeq) {
		Connection conn = getConnection();
		QueryBoard qb = dao.selectByQuerySeq(conn, querySeq);
		close(conn);
		return qb;
	}

	public int selectNextVal() {
		Connection conn = getConnection();
		int querySeq = dao.selectNextVal(conn);
		close(conn);
		return querySeq;
	}



}
