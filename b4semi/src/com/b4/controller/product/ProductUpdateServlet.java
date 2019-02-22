package com.b4.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Product;
import com.b4.service.ProductService;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//상품코드를 가져와서 그 정보를 출력해주는 view화면을 선택
		String pCode = request.getParameter("productCode");
		
		Product p=new Product();
		p.setProductCode(pCode);
		//비즈니스 로직
		Product result=new ProductService().selectOne(p);
		
		//view 선택
		String msg="";
		String loc="";
		String view="";
		if(result==null)
		{
			msg="해당상품이 존재하지 않습니다.";
			view="/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		else
		{
			view="/views/product/productView.jsp";
			request.setAttribute("member", result);			
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
