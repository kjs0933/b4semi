package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.CouponDao;
import com.b4.model.vo.CouponMaster;
import com.b4.model.vo.IssuedCoupon;

public class CouponService {
	
	CouponDao dao = new CouponDao();
	
	//관리자 - 쿠폰마스터 등록
	public int insertCouponMaster(CouponMaster cm)
	{
		Connection conn = getConnection();
		int result = dao.insertCouponMaster(conn, cm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;		
	}

	//쿠폰 마스터 수정 및 삭제는 거의 사용할 일 없다고 생각됩니다.
	//관리자 - 쿠폰코드로 접근, 쿠폰마스터 수정
	public int updateCouponMaster(CouponMaster cm)
	{
		Connection conn = getConnection();
		int result = dao.updateCouponMaster(conn, cm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);	
		return result;
	}

	//관리자 - 쿠폰마스터 삭제. db에서 삭제하는 메소드
	public int deleteCouponMaster(CouponMaster cm)
	{
		Connection conn = getConnection();
		int result = dao.deleteCouponMaster(conn, cm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;		
	}
	
	
	
	
	//회원 접근 쿠폰 메소드
	//회원 기준 쿠폰 조회 - 페이징처리는 보류
	public List<IssuedCoupon> selectCouponListByMember(int cPage, int numPerPage, int memberSeq)
	{
		Connection conn = getConnection();
		List<IssuedCoupon> list = dao.selectCouponListByMember(conn, cPage, numPerPage, memberSeq);
		close(conn);
		return list;
	}
	
	public List<IssuedCoupon> selectCouponUseAble(int memberSeq)
	{
		Connection conn = getConnection();
		List<IssuedCoupon> list = dao.selectCouponUseAble(conn, memberSeq);
		close(conn);
		return list;
	}
	
	public int selectCouponCountByMember(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectCouponCountByMember(conn, memberSeq);
		close(conn);
		return result;
	}
	
	public int issueCoupon(int memberSeq, String code)
	{
		Connection conn = getConnection();
		int result = dao.issueCoupon(conn, memberSeq, code);
		close(conn);
		return result;
	}

/*	public int couponCountByMember(String id) {
		Connection conn = getConnection();
		int couponCount = dao.couponCountByMember(conn, id);
		close(conn);
		return couponCount;
	}*/
	
}
