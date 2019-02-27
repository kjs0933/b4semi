package com.b4.controller.notice;

import java.io.IOException;

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
@WebServlet("/support/support_notice_View")
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

		request.setCharacterEncoding("UTF-8");
		try {int no=Integer.parseInt(request.getParameter("noticeone"));			}
		catch(NumberFormatException e) {e.printStackTrace();}
		Notice n=new NoticeService().NoticeOne(0);
		
		try {String IM=request.getParameter("selectOne");}
		catch(Exception e) {e.printStackTrace();}
		
		//Images m=new ImagesService().selectOne(IM);
		
		
		
		request.setAttribute("notice", n);
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
