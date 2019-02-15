package com.b4.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import java.sql.Connection;

import com.b4.dao.MemberDao;
import com.b4.model.vo.Member;

public class MemberService {
	
	MemberDao dao = new MemberDao();

	//id로 회원 찾기 메소드
	public Member selectOne(Member m)
	{
		Connection conn = getConnection();
		Member result = dao.selectOne(conn, m);
		close(conn);
		return result;
	}

}
