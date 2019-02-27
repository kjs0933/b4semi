package com.b4.controller.order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.dao.CartDao;
import com.b4.dao.OrderListDao;
import com.b4.model.vo.Cart;
import com.b4.model.vo.Member;
import com.b4.model.vo.OrderList;

import common.JDBCTemplate;

/**
 * Servlet implementation class OrderEndServlet
 */
@WebServlet("/orderEnd")
public class OrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = (Member)request.getSession().getAttribute("loginMember");
		if(m == null)
		{
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/cart");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		//내용 가져오는 것
		OrderList order = new OrderList();
		try {
			order.setCouponSeq(Integer.parseInt(request.getParameter("couponSeq")));
			order.setMemberSeq(m.getMemberSeq());
			order.setSpentMileage(Integer.parseInt(request.getParameter("spentMileage")));
			order.setReceiverName(request.getParameter("receiverName"));
			order.setReceiverAddress(request.getParameter("receiverAddress"));
			order.setReceiverPhone(request.getParameter("receiverPhone"));
			order.setReceiverComment(request.getParameter("receiverComment"));
			order.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
			order.setOrderTime(new Timestamp(System.currentTimeMillis()));
			order.setShipmentFee(Integer.parseInt(request.getParameter("shipmentFee")));
		} catch(NumberFormatException e) {
			request.setAttribute("msg", "전송 데이터 오류");
			request.setAttribute("loc", "/order");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		//DB로직 수행 - 커넥션 생성!!!
		Connection cn = JDBCTemplate.getConnection();
		OrderListDao dao = new OrderListDao();
		CartDao cart = new CartDao();
		order.setOrderSeq(dao.getOrderSeq(cn));

		//주문서 처리
		int result = dao.newOrder(cn,order);
		if(result<=0)
		{
			JDBCTemplate.rollback(cn);
			JDBCTemplate.close(cn);
			request.setAttribute("msg", "주문서 DB등록 오류");
			request.setAttribute("loc", "/order");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		ArrayList<Cart> cartlist = cart.selectByMember(cn, m.getMemberSeq());
		//주문서 세부내용 처리
		result = dao.newOrderP(cn,cartlist,order.getOrderSeq());
		if(result != cartlist.size())
		{
			System.out.println("장바구니 수 : "+cartlist.size() + "\nDB입력 수 : "+ result);
			JDBCTemplate.rollback(cn);
			JDBCTemplate.close(cn);
			request.setAttribute("msg", "주문서 세부내용 DB등록 오류");
			request.setAttribute("loc", "/order");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		//장바구니 비우기
	/*	result = cart.deleteAll(cn,m.getMemberSeq());*/
		//발행된 쿠폰 처리
		//쿠폰 로그 처리
		//마일리지(회원) 처리
		//마일리지 로그 처리
		
		
		
		JDBCTemplate.commit(cn);
		JDBCTemplate.close(cn);
		System.out.println("주문서 등록 성공!!");
		request.setAttribute("msg", "주문을 완료하였습니다.");
/*		request.setAttribute("loc", "/memberOrderlist");*/
		request.setAttribute("loc", "/memberOrderlistDetail?no="+order.getOrderSeq());
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
