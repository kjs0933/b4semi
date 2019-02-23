package com.b4.controller.supplier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.Supplier;
import com.b4.service.SupplierService;

/**
 * Servlet implementation class SupplierEnrollEndServlet
 */
@WebServlet("/SupplierEnrollEndServlet")
public class SupplierEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierEnrollEndServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		String supplierCode=request.getParameter("supplierCode");
		String supplierName=request.getParameter("supplierName");
		String supplierPhone=request.getParameter("supplierPhone");
		String supplierAddress=request.getParameter("supplierAddress");
		String supplierEmail=request.getParameter("supplierEmail");
		
		
		
		Supplier i=new Supplier();
		i.setSupplierCode(supplierCode);
		i.setSupplierName(supplierName);
		i.setSupplierPhone(supplierAddress);
		i.setSupplierAddress(supplierAddress);
		i.setSupplierEmail(supplierEmail);
		

		int result = new SupplierService().insertSupplier(i);
		
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
			loc="/views/supplier/supplierEnroll.jsp";
			
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
