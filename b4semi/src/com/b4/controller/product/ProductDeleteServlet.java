package com.b4.controller.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Product;
import com.b4.service.ProductService;

/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String deleteNo=request.getParameter("deleteNo");
		String deleteFile=request.getParameter("deleteFile");
		
		Product p = new Product();
		p.setProductCode(deleteNo);
		
		String dir=getServletContext().getRealPath("/");
		String filePath=dir+File.separator+"upload"+File.separator+"notice";
		
		int result=new ProductService().deleteProduct(p);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			File deleteFile2=new File(filePath+"/"+deleteFile);
			deleteFile2.delete();
			msg="상품 삭제완료.";
			loc="/product/productList";
		}
		else {
			msg="상품 삭제실패";
			loc="/product/productView?productcode="+deleteNo;
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
