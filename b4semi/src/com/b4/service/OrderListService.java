package com.b4.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.List;

import com.b4.dao.OrderListDao;
import com.b4.model.vo.OrderList;


public class OrderListService {
	
	OrderListDao dao = new OrderListDao();
	
	public List<OrderList> selectByMemberThreeYears(int cPage, int memberSeq)
	{
		Connection conn = getConnection();
		List<OrderList> list = dao.selectByMemberThreeYears(conn, cPage, memberSeq);
		close(conn);
		return list;
	}

	public int selectCountByMemberThreeYears(int memberSeq) {
		Connection conn = getConnection();
		int result = dao.selectCountByMemberThreeYears(conn, memberSeq);
		close(conn);
		return result;
	}

}
