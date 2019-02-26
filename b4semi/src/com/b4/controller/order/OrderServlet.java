package com.b4.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.AddressList;
import com.b4.model.vo.Cart;
import com.b4.model.vo.IssuedCoupon;
import com.b4.model.vo.Member;
import com.b4.service.AddressListService;
import com.b4.service.CartService;
import com.b4.service.CouponService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
    	
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
		}
		List<Cart> clist = new CartService().selectByMember(m.getMemberSeq());
		List<AddressList> alist = new AddressListService().selectByMember(m);
		List<IssuedCoupon> iclist = new CouponService().selectCouponListByMember(1, 999, m.getMemberSeq());
		
		request.setAttribute("clist", clist);
		request.setAttribute("alist", alist);
		request.setAttribute("iclist", iclist);
		request.getRequestDispatcher("/views/payment/payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
