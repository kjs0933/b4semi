package com.b4.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.b4.model.vo.OrderPDetail;

public class OrderPDetailService {

	OrderPDetailDao dao = new OrderPDetailDao();
	
	public OrderPDetail selectOneByOrderListSeq(int orderSeq) {
		Connection conn = getConnection();
		OrderPDetail opd = dao.selectOneByOrderListSeq(conn, orderSeq);
		close(conn);
		return opd;
	}

	public List<OrderPDetail> selectByOrderListSeq(int orderSeq) {
		Connection conn = getConnection();
		List<OrderPDetail> list = dao.selectByOrderListSeq(conn, orderSeq);
		close(conn);
		return list;
	}
}
