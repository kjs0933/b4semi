package com.b4.controller.supplier;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Supplier;
import com.b4.service.SupplierService;

/**
 * Servlet implementation class SupplierDeleteServlet
 */
@WebServlet("/SupplierDeleteServlet")
public class SupplierDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteNo=request.getParameter("deleteNo");
		String deleteFile=request.getParameter("deleteFile");
		
		Supplier s = new Supplier();
		s.setSupplierCode(deleteNo);
		
		String dir=getServletContext().getRealPath("/");
		String filePath=dir+File.separator+"upload"+File.separator+"notice";
		
		int result=new SupplierService().deleteSupplier(s);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			File deleteFile2=new File(filePath+"/"+deleteFile);
			deleteFile2.delete();
			msg="공급사 정보 삭제완료.";
			loc="/supplier/supplierList";
		}
		else {
			msg="공급사 정보 삭제실패";
			loc="/supplier/supplierView?supplierseq="+deleteNo;
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
