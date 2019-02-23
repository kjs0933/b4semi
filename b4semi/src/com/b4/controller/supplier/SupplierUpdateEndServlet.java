package com.b4.controller.supplier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.model.vo.Supplier;
import com.b4.service.SupplierService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class SupplierUpdateEndServlet
 */
@WebServlet("/SupplierUpdateEndServlet")
public class SupplierUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(!ServletFileUpload.isMultipartContent(request))
		{
			request.setAttribute("msg", "공지사항오류![Error:code(001):form enctype 관리자에게 문의하세요]");
			request.setAttribute("loc", "/supplier/supplierList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String root=getServletContext().getRealPath("/");
		
		String filePath=root+File.separator+"upload"+File.separator+"Supplier";
		
		int maxSize=1024*1024*100;
		
		MultipartRequest mr=new MultipartRequest(request, filePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Supplier s = new Supplier();
		
		s.setSupplierCode(mr.getParameter("supplierCode"));
		s.setSupplierName(mr.getParameter("supplierName"));
		s.setSupplierPhone(mr.getParameter("supplierPhone"));
		s.setSupplierAddress(mr.getParameter("supplierAddress"));
		s.setSupplierEmail(mr.getParameter("supplierEmail"));
		
		
		
		int result=new SupplierService().updateSupplier(s);
		
		String msg="";
		String loc="/Supplier/SupplierView?Supplierno="+mr.getParameter("no");
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="공급사정보 수정성공";
		}
		else
		{
			msg="공급사정보 수정실패";
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
