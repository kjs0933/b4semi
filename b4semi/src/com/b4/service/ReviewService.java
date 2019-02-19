package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.ReviewDao;
import com.b4.model.vo.Review;

public class ReviewService {

	ReviewDao dao = new ReviewDao();
	
	//리뷰테이블 페이징처리를 위한 판매게시별 리뷰수
	public int selectCountByDP(Review r)
	{
		Connection conn = getConnection();
		int result = dao.selectCountByDP(conn,r);
		close(conn);
		return result;
	}
	
	//판매게시별 리뷰리스트 검색
	public List<Review> selectAllByDP(Review r, int cPage)
	{
		Connection conn = getConnection();
		List<Review> list = dao.selectAllByDP(conn, r, cPage);
		close(conn);
		return list;
	}
	
	//개인별 리뷰리스트 검색
	public List<Review> selectAllByMember(Review r, int cPage)
	{
		Connection conn = getConnection();
		List<Review> list = dao.selectAllByMember(conn, r, cPage);
		close(conn);
		return list;
	}
	
	//후기작성
	public int insertReview(Review r)
	{
		Connection conn = getConnection();
		int result = dao.insertReview(conn, r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//리뷰수정. reviewseq로 접근해서 title,contents, date, score 만 변경
	public int updateReview(Review r)
	{
		Connection conn = getConnection();
		int result = dao.updateReview(conn, r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//리뷰삭제일시추가. reviewseq로 접근해서 reviewdeletedate 변경.
	public int deleteReview(Review r)
	{
		Connection conn = getConnection();
		int result = dao.deleteReview(conn, r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
