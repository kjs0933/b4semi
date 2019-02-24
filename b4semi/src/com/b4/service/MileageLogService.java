package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.MileageLogDao;
import com.b4.model.vo.MileageLog;

public class MileageLogService {
	
	private MileageLogDao dao = new MileageLogDao();
	
	//회원별 마일리지 로그 조회
	public List<MileageLog> selectMileageLogList(int cPage, int numPerPage, int memberSeq)
	{
		Connection conn = getConnection();
		List<MileageLog> list = dao.selectMileageLogList(conn, cPage, numPerPage, memberSeq);
		close(conn);
		return list;
	}
	
	//회원별 마일리지 로그 총 개수
	public int selectMileageLogCount(int memberSeq)
	{
		Connection conn = getConnection();
		int result = dao.selectMileageLogCount(conn, memberSeq);
		close(conn);
		return result;
	}
	
	//회원별 마일리지 로그 총 리스트 조회
	public List<MileageLog> selectAllMileageLogList(int memberSeq)
	{
		Connection conn = getConnection();
		List<MileageLog> result = dao.selectAllMileageLogList(conn, memberSeq);
		close(conn);
		return result;
	}

}
