package com.b4.controller.queryBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.QueryBoardService;

/**
 * Servlet implementation class QueryCommentDeleteServlet
 */
@WebServlet("/queryCommentDelete")
public class QueryCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCommentDeleteServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentSeq = Integer.parseInt(request.getParameter("commentSeq"));
		
		int result = new QueryBoardService().deleteReply(commentSeq);
				
		if(result > 0)
		{
			response.getWriter().println("1");
		}
		else
		{
			response.getWriter().println("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
