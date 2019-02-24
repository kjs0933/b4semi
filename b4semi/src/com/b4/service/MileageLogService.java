package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.b4.dao.MileageLogDao;
import com.b4.model.vo.MileageLog;

public class MileageLogService {
	
	MileageLogDao dao = new MileageLogDao();

	public int logCountByMember(int memberSeq) {
		
		Connection conn = getConnection();
		int result = dao.logCountByMember(conn, memberSeq);
		close(conn);
		return result;
	}

	public List<MileageLog> mileageLogByMember(int cPage, int memberSeq) {
		Connection conn = getConnection();
		List<MileageLog> mlList = dao.mileageLogByMember(conn, cPage, memberSeq);
		close(conn);
		return mlList;
	}
	
	

}
