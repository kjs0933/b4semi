package com.b4.controller.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Notice;
import com.b4.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/notice/noticeDelete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deleteNo=Integer.parseInt(request.getParameter("deleteNo"));
		String deleteFile=request.getParameter("deleteFile");
		
		Notice n = new Notice();
		n.setNoticeSeq(deleteNo);
		
		String dir=getServletContext().getRealPath("/");
		String filePath=dir+File.separator+"upload"+File.separator+"notice";
		
		int result=new NoticeService().deleteNotice(n);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			File deleteFile2=new File(filePath+"/"+deleteFile);
			deleteFile2.delete();
			msg="공지사항 삭제완료.";
			loc="/notice/noticeList";
		}
		else {
			msg="공지사항 삭제실패";
			loc="/notice/noticeview?noticeno="+deleteNo;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
