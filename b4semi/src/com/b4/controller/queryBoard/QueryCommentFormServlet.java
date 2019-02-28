package com.b4.controller.queryBoard;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.QueryBoardService;
import com.google.gson.JsonObject;

import static common.DateFormatTemplate.getTillMin;

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
		
		Timestamp commentDate = new Timestamp(System.currentTimeMillis());
		
		int result[] = new QueryBoardService().insertReply(boardSeq, memberSeq, commentText, commentDate);
		
		JsonObject json = new JsonObject();
		
		if(result[0] > 0)
		{
			json.addProperty("result", 1);
			json.addProperty("commentDate", getTillMin(commentDate));
			json.addProperty("currval", result[1]);
			json.addProperty("commentText", commentText);
			response.getWriter().println(json);
		}
		else
		{
			json.addProperty("result", 0);
			response.getWriter().println(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
