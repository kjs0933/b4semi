package com.b4.controller.mypage;

import static common.PagingTemplate.pageBar2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b4.model.vo.Member;
import com.b4.model.vo.MileageLog;
import com.b4.model.vo.OrderList;
import com.b4.model.vo.OrderPDetail;
import com.b4.model.vo.Product;
import com.b4.service.CouponService;
import com.b4.service.MileageLogService;
import com.b4.service.OrderListService;
import com.b4.service.OrderPDetailService;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/mypage/mypage_orderlist")
public class MypageOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null)
		{
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		else
		{
			int cPage;
			try {
				cPage=Integer.parseInt(request.getParameter("cPage"));
			}
			catch(NumberFormatException e)
			{
				cPage=1;
			}
			
			int orderCount = new OrderListService().selectCountByMemberThreeYears(loginMember.getMemberSeq());
			String pageBar = pageBar2(request.getContextPath()+"/mypage/mypage_orderlist",cPage,orderCount);
			
			List<OrderList> orderList = new OrderListService().selectByMemberThreeYears(cPage, loginMember.getMemberSeq());
			List<OrderPDetail> orderProductList = new ArrayList<>();
			for(int i=0; i<orderList.size(); i++) 
			{
				OrderPDetail opd = new OrderPDetail();
				opd = new OrderPDetailService().selectOneByOrderListSeq(orderList.get(i).getOrderSeq());
				orderProductList.add(opd);
			}
/*			int couponCount = new CouponService().couponCountByMember(loginMember.getMemberId());
			
			request.setAttribute("pageBar", pageBar);
			request.setAttribute("orderList", orderList);
			request.setAttribute("orderProductList", orderProductList);
			request.setAttribute("couponCount", couponCount);
			request.setAttribute("loginMember", loginMember);
			request.getRequestDispatcher("/views/member/mypage_orderlist.jsp?cPage="+cPage).forward(request, response);*/
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
