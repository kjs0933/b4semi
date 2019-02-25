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
	
	//판매게시별 리뷰 count 검색
	public int selectCountByDP(int displayListSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectCountByDP(conn, displayListSeq);
		close(conn);
		return result;
	}
	
	//판매게시별 리뷰리스트 검색
	public List<Review> selectAllByDP(int displayListSeq, int cPage)
	{
		Connection conn = getConnection();
		List<Review> list = dao.selectAllByDP(conn, displayListSeq, cPage);
		//각각 리뷰 객체에 이미지 담기
		for(int i=0; i<list.size();i++)
		{
			list.get(i).setRenameFiles(dao.getRenameFiles(conn, list.get(i).getReviewSeq()));
		}
		close(conn);
		return list;
	}
	
	//개인별 리뷰 count 검색
	public int selectCountByMember(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectCountByMember(conn, memberSeq);
		close(conn);
		return result;
	}
	
	//개인별 리뷰리스트 검색
	public List<Review> selectAllByMember(int memberSeq, int cPage)
	{
		Connection conn = getConnection();
		List<Review> list = dao.selectAllByMember(conn, memberSeq, cPage);
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
	
	//판매게시별 평점 평균 구하기
	public double avgReviewScore(int displayListSeq)
	{
		Connection conn = getConnection();
		double avg = dao.avgReviewScore(conn, displayListSeq);
		close(conn);
		return avg;
	}
}
