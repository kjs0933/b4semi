package com.b4.controller.dplist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b4.model.vo.Cart;
import com.b4.model.vo.Member;
import com.b4.model.vo.Product;
import com.b4.service.CartService;
import com.b4.service.ProductService;

/**
 * Servlet implementation class AjaxCartAddServlet
 */
@WebServlet("/js/cartAdd.do")
public class AjaxCartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dpseq = Integer.parseInt(request.getParameter("dpseq"));
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginMember");
		if(session.getAttribute("loginMember")!=null) {
			Product p = new ProductService().selectByDpListSeq(dpseq);
			int result = new CartService().insertCart(m.getMemberSeq(),dpseq,p);
			if(result==0) {
				String msg = "장바구니에 추가 실패~!";
				request.setAttribute("msg",msg);			
			}else {
				System.out.println("장바구니 추가");
			}
		}
		else
		{
			String cartString = new ArrayList<Cart>().toString();
			Cookie cartCookie = new Cookie("cartCookie", cartString);
			cartCookie.setMaxAge(14*24*60*60);
			response.addCookie(cartCookie);
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
