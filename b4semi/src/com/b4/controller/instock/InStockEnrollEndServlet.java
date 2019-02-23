package com.b4.controller.instock;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.InStock;
import com.b4.service.InStockService;

/**
 * Servlet implementation class InStockEnrollEndServlet
 */
@WebServlet("/InStockEnrollEndServlet")
public class InStockEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InStockEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		int instockseq=Integer.parseInt(request.getParameter("instockSeq"));
		String productcode=request.getParameter("productcode");
		Timestamp iDate=new Timestamp(System.currentTimeMillis());
		int inStockCount=Integer.parseInt(request.getParameter("inStockCount"));
		int inStockPrice=Integer.parseInt(request.getParameter("inStockPrice"));
		//String email=request.getParameter("email");//유통기한
		int remainStockCount=Integer.parseInt(request.getParameter("remainStockCount"));
		int expriedStockCount=Integer.parseInt(request.getParameter("expiredStockCount"));
		
		
		InStock i=new InStock();
		i.setInstockSeq(instockseq);
		i.setProductCode(productcode);
		i.setInStockDate(iDate);
		i.setInStockCount(inStockCount);
		i.setInStockPrice(inStockPrice);
		//i.setAge(age);//유통기한
		i.setRemainStockCount(remainStockCount);
		i.setExpiredStockCount(expriedStockCount);
		
		int result = new InStockService().insertInStock(i);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="입고등록을 성공하였습니다.";
			loc="/";
		}
		else
		{
			msg="입고등록을 실패하였습니다.";
			loc="/views/product/productEnroll.jsp";
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
