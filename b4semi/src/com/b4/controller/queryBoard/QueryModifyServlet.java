package com.b4.controller.queryBoard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Images;
import com.b4.model.vo.Member;
import com.b4.model.vo.QueryBoard;
import com.b4.service.ImagesService;
import com.b4.service.QueryBoardService;

/**
 * Servlet implementation class QueryModifyServlet
 */
@WebServlet("/queryModify")
public class QueryModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = (Member)request.getSession().getAttribute("loginMember");
		if(m == null)
		{
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
			
		int querySeq = Integer.parseInt(request.getParameter("querySeq"));
		QueryBoard qb = new QueryBoardService().selectByQuerySeq(querySeq);
		List<Images> imgList = new ArrayList<>();
		imgList = new ImagesService().selectListByBoard("BQ",querySeq);
		
		request.setAttribute("imgList", imgList);
		request.setAttribute("queryBoard", qb);		
		request.getRequestDispatcher("/views/support/support_query_modify.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
