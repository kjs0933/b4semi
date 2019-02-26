package com.b4.controller.queryBoard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.OrderList;
import com.b4.model.vo.OrderPDetail;
import com.b4.service.OrderListService;
import com.b4.service.OrderPDetailService;

/**
 * Servlet implementation class QueryFormServlet
 */
@WebServlet("/queryForm")
public class QueryFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFormServlet() {
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
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
			
		String orderSeq = request.getParameter("orderSeq");
		if(orderSeq.isEmpty() || orderSeq.equals("")){
			orderSeq = "";
		}
		request.setAttribute("orderSeq", orderSeq);
		
		List<OrderList> orderlist = new OrderListService().selectByMemberRecent5(m.getMemberSeq());
		List<OrderPDetail> orderProductList = new ArrayList<>();
		for(int i=0; i<orderlist.size(); i++) 
		{
			OrderPDetail opd = new OrderPDetail();
			opd = new OrderPDetailService().selectOneByOrderListSeq(orderlist.get(i).getOrderSeq());
			orderProductList.add(opd);
		}
		
		request.setAttribute("orderProductList", orderProductList);
		request.setAttribute("orderlist", orderlist);
		request.getRequestDispatcher("/views/support/support_query_form.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
