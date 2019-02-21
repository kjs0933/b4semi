package com.b4.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.model.vo.Member;
import com.b4.model.vo.Product;
import com.b4.service.ProductService;

/**
 * Servlet implementation class ProductEnrollEndServlet
 */
@WebServlet("/ProductEnrollEndServlet")
public class ProductEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member logginMember=(Member)request.getSession(false).getAttribute("logginMember");
		if(logginMember==null||!"admin".equals(logginMember.getMemberId()))
		{
			request.setAttribute("msg", "잘못된 경로로 이동하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		
		if(!ServletFileUpload.isMultipartContent(request))
		{
			response.sendRedirect("/index.jsp");
			return;
		}
		
		String dir=getServletContext().getRealPath("/upload/ajax");
		int maxSize=1024*1024*100;
		
		
		request.setCharacterEncoding("UTF-8");
		String productCode=request.getParameter("productCode");
		String supplierCode=request.getParameter("supplierCode");
		String productName=request.getParameter("productName");
		String originCountry=request.getParameter("originCountry");
		String subCategoryCode=request.getParameter("subCategoryCode");
		String productUnit=request.getParameter("productUnit");
		String originalFilename=request.getParameter("originalFileName");
		
		Product p=new Product();
		p.setProductCode(productCode);
		p.setSupplierCode(supplierCode);
		p.setProductName(productName);
		p.setOriginCountry(originCountry);
		p.setSubCategoryCode(subCategoryCode);
		p.setProductUnit(productUnit);

		
		int result = new ProductService().insertProduct(p);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="물품등록을 성공하였습니다.";
			loc="/";
		}
		else
		{
			msg="물품등록을 실패하였습니다.";
			loc="/views/product/productEnroll.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/notice/noticeForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
