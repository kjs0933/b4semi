package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.b4.dao.MemberGradeDao;
import com.b4.model.vo.MemberGrade;


public class MemberGradeService {
	
	
	private MemberGradeDao dao = new MemberGradeDao();
	
	
	
	public MemberGrade selectOne(int no)
	{
		Connection conn=getConnection();
		MemberGrade m=dao.selectOne(conn,no);
		close(conn);
		return m;
	}

}