package com.b4.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Notice;
import com.b4.service.NoticeService;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/NoticeUpdateServlet")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		Notice notice = new NoticeService().NoticeOne(no);
		String view="";
		String msg="";
		if(notice!=null)
		{
			request.setAttribute("notice", notice);
			view="/views/notice/noticeUpdate.jsp";
		}
		else
		{
			msg="조회한 공지사항이 없습니다.";
			view="/views/common/msg.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/notice/noticeList");
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
