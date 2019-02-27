package com.b4.controller.queryBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.QueryBoardService;

/**
 * Servlet implementation class QueryCommentModifyServlet
 */
@WebServlet("/queryCommentModify")
public class QueryCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCommentModifyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentText = request.getParameter("commentText");
		int commentSeq = Integer.parseInt(request.getParameter("commentSeq"));
		
		int result = new QueryBoardService().updateReply(commentText, commentSeq);
		
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
		doGet(request, response);
	}

}
