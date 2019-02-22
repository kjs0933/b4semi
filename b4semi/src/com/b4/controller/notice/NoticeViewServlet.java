package com.b4.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.Notice;
import com.b4.service.NoticeService;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/NoticeViewServlet")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member logginMember=(Member)request.getSession(false).getAttribute("logginMember");
		if(logginMember==null||!"admin".equals(logginMember.getMemberId()))
		{
			request.setAttribute("msg", "잘못된 경로로 이동하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		int no=Integer.parseInt(request.getParameter("noticeno"));
		
		Notice n=new NoticeService().NoticeOne(no);
		
		request.setAttribute("notice", n);
		request.getRequestDispatcher("/views/notice/noticeView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
