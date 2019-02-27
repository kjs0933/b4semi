package com.b4.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Cart;
import com.b4.model.vo.Member;
import com.b4.model.vo.MypageHeader;
import com.b4.model.vo.OrderList;
import com.b4.model.vo.OrderPDetail;
import com.b4.service.CartService;
import com.b4.service.MemberService;
import com.b4.service.OrderListService;
import com.b4.service.OrderPDetailService;

/**
 * Servlet implementation class MemberOrderlistDetailServlet
 */
@WebServlet("/memberOrderlistDetail")
public class MemberOrderlistDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberOrderlistDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null)
		{
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		//각 mypage 위에 멤버 기본정보 가져오는 트랜잭션
		MypageHeader mh = new MemberService().selectMypageHeader(loginMember);
		request.setAttribute("mh", mh);
		
		int orderSeq = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("orderSeq", orderSeq);
		
		List<OrderPDetail> opdList = new OrderPDetailService().selectByOrderListSeq(orderSeq);
		request.setAttribute("opdList", opdList);
		
		List<Cart> cartList = new CartService().selectByOrderSeq(orderSeq);
		request.setAttribute("cartList", cartList);
		
		OrderList orderList = new OrderListService().selectByOrderListSeq(orderSeq); 
		request.setAttribute("orderList", orderList);
		
		request.getRequestDispatcher("/views/member/mypage_orderlist_detail.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
