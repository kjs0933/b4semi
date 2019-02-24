package com.b4.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b4.model.vo.Member;
import com.b4.service.CartService;
import com.b4.service.MemberService;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		Member loginMember = new MemberService().selectOne(m);
		
		if(loginMember != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			//쿠키 장바구니를 DB 장바구니로 옮기는 로직
			String cookieString=null;
			Cookie[] cookies=request.getCookies();
			
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
			if(cookieString != null && cookieString.length() >0)
			{
				String[] cartData = cookieString.split("/");
				String[][] data = new String[cartData.length][];
				int amount;
				CartService cart = new CartService();
				System.out.println("쿠키 장바구니 DB에 저장중");
				try {
					for(int i=0; i<cartData.length; i++)
					{
						data[i] = cartData[i].split("\\&");
						amount = cart.getAmount(loginMember.getMemberSeq(), Integer.parseInt(data[i][0]), data[i][1]);
						if(amount != Integer.parseInt(data[i][2]))
						{
							if(amount>0)
							{
								cart.updateCart(loginMember.getMemberSeq(),Integer.parseInt(data[i][0]),data[i][1],Integer.parseInt(data[i][2]));
							}
							else
							{
								cart.insertCart(loginMember.getMemberSeq(),Integer.parseInt(data[i][0]),data[i][1],Integer.parseInt(data[i][2]));
							}
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(loginMember.getMemberId() + " 로그인 회원 쿠키 장바구니 변환중 오류");
				}
				
				Cookie cartSave = new Cookie("cartSave","");
				cartSave.setMaxAge(0);
				response.addCookie(cartSave);
			}
		}
		
		Gson gson = new Gson();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(gson.toJson(loginMember));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
