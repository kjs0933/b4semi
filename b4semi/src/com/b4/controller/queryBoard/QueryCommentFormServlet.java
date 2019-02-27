package com.b4.controller.queryBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.QueryBoardService;

/**
 * Servlet implementation class QueryCommentFormServlet
 */
@WebServlet("/queryCommentForm")
public class QueryCommentFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCommentFormServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
		String commentText = request.getParameter("commentText");
		
		System.out.println(memberSeq);
		System.out.println(boardSeq);
		System.out.println(commentText);
		
		
		int result = new QueryBoardService().insertReply(boardSeq, memberSeq, commentText);
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
