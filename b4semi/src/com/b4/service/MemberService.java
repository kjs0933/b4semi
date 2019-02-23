package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.b4.dao.MemberDao;
import com.b4.model.vo.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao();

	//ID 존재 여부 체크
	public boolean checkId(String memberId)
	{
		Connection conn = getConnection();
		boolean result = dao.checkId(conn, memberId);
		close(conn);
		return result;
	}
	
	//ID로 회원 정보 객체 리턴
	public Member selectOne(Member m)
	{
		Connection conn = getConnection();
		Member result = dao.selectOne(conn, m);
		close(conn);
		return result;
	}
	
	//회원정보수정
	public int updateMember(Member m)
	{
		Connection conn = getConnection();
		int result = dao.updateMember(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//회원추가
	public int insertOne(Member m)
	{
		Connection conn = getConnection();
		int result = dao.insertOne(conn, m);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//회원탈퇴(memberQuitDate입력)
	public int quitMember(Member m)
	{
		Connection conn = getConnection();
		int result = dao.quitMember(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}

}
