package com.b4.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Images;
import com.b4.model.vo.Notice;
import com.b4.service.ImagesService;
import com.b4.service.NoticeService;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/notice/noticeview")
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
		int no=0;
		try {
			no=Integer.parseInt(request.getParameter("noticeseq"));
		}
		catch(NumberFormatException e)
		{
			request.setAttribute("msg", "게시글이 없습니다");
			request.setAttribute("loc", "/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		Notice n=new NoticeService().selectOne(no);
		request.setAttribute("notice", n);
		
		if(n== null)
		{
			request.setAttribute("msg", "게시글이 없습니다");
			request.setAttribute("loc", "/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/views/support/support_notice_view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
