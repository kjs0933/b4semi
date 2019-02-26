package com.b4.controller.queryBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.QueryBoardService;

/**
 * Servlet implementation class QueryDeleteServlet
 */
@WebServlet("/queryDelete")
public class QueryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int querySeq = Integer.parseInt(request.getParameter("querySeq"));
		
		int result = new QueryBoardService().deleteQuery(querySeq);
		
		String msg = "";
		String loc = "/";
		if(result > 0){msg = "1:1 문의가 삭제되었습니다."; loc="/query";}
		else {msg = "1:1 문의 삭제에 실패하였습니다."; loc="/view/support/support_query";}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
