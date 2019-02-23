package com.b4.controller.instock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.InStock;
import com.b4.model.vo.Member;
import com.b4.service.InStockService;

/**
 * Servlet implementation class InStockUpdateServlet
 */
@WebServlet("/InStockUpdateServlet")
public class InStockUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InStockUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginMember=(Member)request.getSession(false).getAttribute("loginMember");
		if(loginMember==null||!"admin".equals(loginMember.getMemberId()))
		{
			request.setAttribute("msg", "잘못된 경로로 이동하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		InStock instock = new InStockService().selectOne(no);
		String view="";
		String msg="";
		if(instock!=null)
		{
			request.setAttribute("instock", instock);
			view="/views/instock/instockUpdate.jsp";
		}
		else
		{
			msg="조회한 공지사항이 없습니다.";
			view="/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/instock/instockList");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
