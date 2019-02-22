package com.b4.controller.instock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.InStock;
import com.b4.model.vo.Member;
import com.b4.model.vo.Product;
import com.b4.service.InStockService;
import com.b4.service.ProductService;

/**
 * Servlet implementation class InStockViewServlet
 */
@WebServlet("/InStockViewServlet")
public class InStockViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InStockViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member loginMember=(Member)request.getSession().getAttribute("loginMember");
		
		if(loginMember==null||!"admin".equals(loginMember.getMemberId()))
		{
			request.setAttribute("msg", "잘못된 경로로 이동하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		int no=Integer.parseInt(request.getParameter("instockseq"));
		
		InStock p=new InStockService().selectOne(no);
		
		
		request.setAttribute("instock", p);
		request.getRequestDispatcher("/views/instock/instockView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
