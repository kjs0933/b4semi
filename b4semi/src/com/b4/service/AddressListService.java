package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import java.sql.Connection;
import java.util.List;
import com.b4.dao.AddressListDao;
import com.b4.model.vo.AddressList;
import com.b4.model.vo.Member;

public class AddressListService {
	
	AddressListDao dao = new AddressListDao();
	
	//회원별 addressList조회
	public List<AddressList> selectByMember(Member m)
	{
		Connection conn = getConnection();
		List<AddressList> list = dao.selectByMember(conn, m);
		close(conn);
		return list;
	}
	
	//addressList추가 메소드
	public int insertAddressList(AddressList al)
	{
		Connection conn = getConnection();
		int result = dao.insertAddressList(conn, al);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;	
	}
	
	//addressList변경 메소드
	public int updateAddressList(AddressList al)
	{
		Connection conn = getConnection();
		int result = dao.updateAddressList(conn, al);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//addressList삭제 메소드
	public int deleteAddressList(AddressList al)
	{
		Connection conn = getConnection();
		int result = dao.updateAddressList(conn, al);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}

}
