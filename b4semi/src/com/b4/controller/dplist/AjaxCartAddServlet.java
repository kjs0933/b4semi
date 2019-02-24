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
		CartService cart= new CartService();
		Member m=null;
		try {
			m = (Member)session.getAttribute("loginMember");
		}
		catch(ClassCastException e)
		{
			e.printStackTrace();
		}

		boolean multi = false;
		int multiSize = 0;
		int dpseq=0;
		String pcode=null;
		String[] dpseqs=null;
		String[] pcodes=null;
		String[] changes=null;
		int[] result= {0,0};
		if(request.getParameter("multi") == null || request.getParameter("multi").length() ==0)
		{
			multi=false;
		}
		else
		{
			multi=true;
		}

		int change=1;
		try {
			change = Integer.parseInt(request.getParameter("change"));
		}
		catch(NumberFormatException e)
		{}


		if(multi)
		{
			try {
				dpseqs = request.getParameter("dpseqs").split(",");
				pcodes = request.getParameter("pcodes").split(",");
				changes = request.getParameter("changes").split(",");
				multiSize = Math.min(dpseqs.length, pcodes.length);
			}
			catch(Exception e)
			{
				return;
			}
			if(multiSize<=0)
			{
				return;
			}

		}
		else
		{
			try {
				dpseq = Integer.parseInt(request.getParameter("dpseq"));
			}
			catch(NumberFormatException e)
			{
				return;
			}
			pcode = request.getParameter("pcode");
			if(pcode==null)
			{
				return;
			}
		}

		if(m!=null) {

			for(int n=0; n< Math.max(multiSize,1); n++)
			{

				if(multi)
				{	
					try {
						dpseq = Integer.parseInt(dpseqs[n]);
					}
					catch(NumberFormatException e)
					{
						continue;
					}
					pcode = pcodes[n];
					if(pcode==null)
					{
						continue;
					}
					try {
						change = Integer.parseInt(changes[n]);
					}
					catch(Exception e)
					{}
				}


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
		}
		else
		{
			//쿠키 가져오기
			String cookieString="";
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
			
			//여기서부터 반복문
			for(int n=0; n< Math.max(multiSize,1); n++)
			{

				if(multi)
				{	
					try {
						dpseq = Integer.parseInt(dpseqs[n]);
					}
					catch(NumberFormatException e)
					{
						continue;
					}
					pcode = pcodes[n];
					if(pcode==null)
					{
						continue;
					}
					try {
						change = Integer.parseInt(changes[n]);
					}
					catch(Exception e)
					{}
				}
			
				if(cookieString.length() == 0)
				{
					if(change>0)
					{
						cookieString = dpseq+"&"+pcode+"&"+change;
						if(!multi)
						{
							result[0] = change;
							result[1] = change;
						}
					}
				}
				else
				{
					String[] cartData = cookieString.split("/");
					String[][] data = new String[cartData.length][];
					boolean added = false;
					int count=0;
					for(int i=0; i<cartData.length; i++)
					{
						data[i] = cartData[i].split("\\&");
						if(String.valueOf(dpseq).equals(data[i][0]) && pcode.equals(data[i][1]))
						{
							result[0] = cartData.length;
							count = Integer.parseInt(data[i][2])+change;
							if(count >= 0)
							{
								result[1] = count;
								data[i][2] = String.valueOf(result[1]); 
							}
							else
							{
								result[1] = 0;
								data[i][2] = String.valueOf(result[1]);
							}
							added = true;
						}
					}
	
					if(added)
					{
						cookieString ="";
						for(int i=0; i<data.length; i++)
						{
							if(Integer.parseInt(data[i][2])>0)
							{
								cookieString += data[i][0] + "&" + data[i][1] + "&" + data[i][2];
								if(i<data.length-1)
								{
									cookieString +="/";
								}
							}
						}
					}
					else
					{
						if(change>0)
						{
							cookieString += "/"+dpseq+"&"+pcode+"&"+change;
							result[0] = cartData.length+change;
							result[1] = change;
						}
					}
				}
			}
			
			Cookie cartSave = new Cookie("cartSave", cookieString);
			cartSave.setMaxAge(14*24*60*60);
			response.addCookie(cartSave);
		}


		if(!multi)
		{
			//카트에 담긴 수량을 전송
			response.setContentType("application/json;charset=UTF-8");
			new Gson().toJson(result, response.getWriter());
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
