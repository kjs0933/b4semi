package com.b4.service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.b4.dao.ReviewDao;
import com.b4.model.vo.Review;

public class ReviewService {

	ReviewDao dao = new ReviewDao();
	
	public int selectCount()
	{
		Connection conn = getConnection();
		int result = dao.selectCount(conn);
	}
	
	
	//후기작성
	public int insertReview(Review r)
	{
		Connection conn = getConnection();
		int result = dao.insertReview(conn, r);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
}
