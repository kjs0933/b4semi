package com.b4.controller.dplist;

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
import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxCartAddServlet
 */
@WebServlet("/cartAdd.do")
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
		HttpSession session = request.getSession();
		Member m=null;
		try {
			m = (Member)session.getAttribute("loginMember");
		}
		catch(ClassCastException e)
		{
			e.printStackTrace();
		}
		
		int dpseq;
		int[] result= {0,0};
		try {
			dpseq = Integer.parseInt(request.getParameter("dpseq"));
		}
		catch(NumberFormatException e)
		{
			return;
		}
		String pcode = request.getParameter("pcode");
		if(pcode==null)
		{
			return;
		}
		int change=1;
		try {
			change = Integer.parseInt(request.getParameter("change"));
		}
		catch(NumberFormatException e)
		{}
		
		CartService cart= new CartService();
		if(m!=null) {
			
			//현재 데이터가 있으면 update, 없으면 insert
			int amount = cart.getAmount(m.getMemberSeq(),dpseq,pcode);
			int resultQuery=0;
			if(amount>0 && amount+change>0)
			{
				resultQuery = cart.updateCart(m.getMemberSeq(),dpseq,pcode,amount+change);
			}
			else if(change >0)
			{
				resultQuery = cart.insertCart(m.getMemberSeq(),dpseq,pcode,change);
			}
			else if(amount >0)
			{
				resultQuery = cart.deleteOne(m.getMemberSeq(),dpseq,pcode);
			}
			if(resultQuery==0)
			{
				System.out.println("헐 장바구니 등록 에러");
			}
			
			result[0] = cart.getKindCount(m.getMemberSeq());
			result[1] = amount+change;
		}
		else
		{
			//쿠키 가져오기
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
			if(cookieString == null || cookieString.length() ==0)
			{
				Cookie cartSave = new Cookie("cartSave", dpseq+"&"+pcode+"&"+change);
				cartSave.setMaxAge(14*24*60*60);
				response.addCookie(cartSave);
				
				result[0] = change;
				result[1] = change;
			}
			else
			{
				
				String[] cartData = cookieString.split("/");
				String[][] data = new String[cartData.length][];
				boolean added = false;
				for(int i=0; i<cartData.length; i++)
				{
					data[i] = cartData[i].split("\\&");
					if(String.valueOf(dpseq).equals(data[i][0]) && pcode.equals(data[i][1]))
					{
						result[0] = cartData.length;
						result[1] = Integer.parseInt(data[i][2])+change;
						data[i][2] = String.valueOf(result[1]); 
						added = true;
					}
				}
				
				if(added)
				{
					cookieString ="";
					for(int i=0; i<data.length; i++)
					{
						cartData[i] = String.join("&",data[i]);
					}
					cookieString = String.join("/", cartData);
					
					Cookie cartSave = new Cookie("cartSave", cookieString);
					cartSave.setMaxAge(14*24*60*60);
					response.addCookie(cartSave);
					
				}
				else
				{
					cookieString += "/"+dpseq+"&"+pcode+"&"+change;
					result[0] = cartData.length+change;
					result[1] = change;
					
					Cookie cartSave = new Cookie("cartSave", cookieString);
					cartSave.setMaxAge(14*24*60*60);
					response.addCookie(cartSave);
				}
			}
		}
		
		//카트에 담긴 수량을 전송
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
