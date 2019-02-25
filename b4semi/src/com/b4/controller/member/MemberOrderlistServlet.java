package com.b4.controller.member;

import static common.PagingTemplate.pageBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.MypageHeader;
import com.b4.model.vo.OrderList;
import com.b4.model.vo.OrderPDetail;
import com.b4.service.MemberService;
import com.b4.service.OrderListService;
import com.b4.service.OrderPDetailService;

/**
 * Servlet implementation class MemberOrderlistServlet
 */
@WebServlet("/memberOrderlist")
public class MemberOrderlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberOrderlistServlet() {
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
		
		
		
		//페이징 시작
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e)
		{
			numPerPage = 5;
		}
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));			
		}catch(NumberFormatException e)
		{
			cPage = 1;
		}
		
		int totalCount = new OrderListService().selectCountByMemberThreeYears(loginMember.getMemberSeq());
		List<OrderList> orderlist = new OrderListService().selectByMemberThreeYears(cPage, numPerPage, loginMember.getMemberSeq());
		List<OrderPDetail> orderProductList = new ArrayList<>();
		for(int i=0; i<orderlist.size(); i++) 
		{
			OrderPDetail opd = new OrderPDetail();
			opd = new OrderPDetailService().selectOneByOrderListSeq(orderlist.get(i).getOrderSeq());
			orderProductList.add(opd);
		}
		
		String pageBar = pageBar(request.getContextPath()+"/memberOrderlist", cPage, numPerPage, totalCount);
		
		request.setAttribute("orderProductList", orderProductList);
		request.setAttribute("orderlist", orderlist);
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageBar", pageBar);
		
		
		request.getRequestDispatcher("/views/member/mypage_orderlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
