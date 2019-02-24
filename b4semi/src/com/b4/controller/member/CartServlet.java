package com.b4.controller.member;

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
import com.b4.service.CartService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CartService cart = new CartService();
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginMember");
		if(session.getAttribute("loginMember")!=null) {
			ArrayList<Cart> list = cart.selectByMember(m.getMemberSeq());
			request.setAttribute("cartList", list);
		}
		else
		{
			//비로그인 데이터 전송 로직
			String cookieString=null;
			Cookie[] cookies=request.getCookies();
			ArrayList<Cart> list;
			
			if(cookies != null)
			{
				for(Cookie c : cookies)
				{
					if("cartSave".equals(c.getName()))
					{
						cookieString = c.getValue();
					}
				}
			}
			if(cookieString != null && cookieString.length() > 0)
			{
				String[] cartData = cookieString.split("/");
				String[][] data = new String[cartData.length][];
				for(int i=0; i<cartData.length; i++)
				{
					data[i] = cartData[i].split("\\&");
				}
				list = cart.getListByCookie(data);
			}
			else
			{
				list = new ArrayList<Cart>();
			}
			
			request.setAttribute("cartList", list);
		}
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
