package com.b4.controller.instock;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.InStock;
import com.b4.service.InStockService;

/**
 * Servlet implementation class InStockDeleteServlet
 */
@WebServlet("/InStockDeleteServlet")
public class InStockDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InStockDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int deleteNo=Integer.parseInt(request.getParameter("deleteNo"));
		String deleteFile=request.getParameter("deleteFile");
		
		InStock i = new InStock();
		i.setInstockSeq(deleteNo);
		
		String dir=getServletContext().getRealPath("/");
		String filePath=dir+File.separator+"upload"+File.separator+"notice";
		
		int result=new InStockService().deleteInStock(i);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			File deleteFile2=new File(filePath+"/"+deleteFile);
			deleteFile2.delete();
			msg="입고상품 삭제완료.";
			loc="/instock/productList";
		}
		else {
			msg="입고상품 삭제실패";
			loc="/instock/instockView?instockseq="+deleteNo;
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
