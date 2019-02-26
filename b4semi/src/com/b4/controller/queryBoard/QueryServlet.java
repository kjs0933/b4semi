package com.b4.controller.queryBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.QueryBoard;
import com.b4.model.vo.QueryComment;
import com.b4.service.QueryBoardService;
import static common.PagingTemplate.pageBar;

/**
 * Servlet implementation class QueryListServlet
 */
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null)
		{
			request.setAttribute("msg", "로그인 회원만 이용 가능합니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage = 1;
		}
		
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		catch(NumberFormatException e)
		{
			numPerPage = 15;
		}
		
		int totalCount = new QueryBoardService().selectCountByMember(loginMember.getMemberSeq());
		List<QueryBoard> list = new QueryBoardService().selectListByMember(cPage, numPerPage, loginMember.getMemberSeq());
		String pageBar = pageBar(request.getContextPath(), cPage, numPerPage, totalCount);
		
		request.setAttribute("loginMember", loginMember);
		request.setAttribute("list", list);
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/support/support_query.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
