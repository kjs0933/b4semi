package com.b4.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Product;
import com.b4.service.MemberService;
import com.b4.service.ProductService;

/**
 * Servlet implementation class ProductUpdateEndServlet
 */
@WebServlet("/ProductUpdateEndServlet")
public class ProductUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCode=request.getParameter("productCode");
		String sCode=request.getParameter("supplierCode");
		String pName=request.getParameter("productName");
		String oc=request.getParameter("originCountry");
		String scc=request.getParameter("subcategoryCode");
		String pUnit=request.getParameter("productUnit");
		
		
		Product p=new Product();
		p.setProductCode(pCode);
		p.setSupplierCode(sCode);
		p.setProductName(pName);
		p.setProductName(oc);
		p.setSubCategoryCode(scc);
		p.setProductUnit(pUnit);
		
		int result = new ProductService().updateProduct(p);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="정보수정을 성공하였습니다.";
			
		}
		else
		{
			msg="정보수정을 실패하였습니다.";
			loc="/updateProduct?pCode="+pCode;
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
