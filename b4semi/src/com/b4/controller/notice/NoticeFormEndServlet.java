package com.b4.controller.notice;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.model.vo.Notice;
import com.b4.service.NoticeService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeFormEndServlet
 */
@WebServlet("/NoticeFormEndServlet")
public class NoticeFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request))
		{
			request.setAttribute("msg", "공지사항오류![Error:code(001):form enctype 관리자에게 문의하세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String dir=getServletContext().getRealPath("/");
		dir+="upload/notice";
		
		
		int maxSize=1024*1024*100;
		

		MultipartRequest mr=new MultipartRequest(request,dir,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		String title=mr.getParameter("noticeTitle");
		String contents=mr.getParameter("noticeContents");
		Timestamp date=new Timestamp(System.currentTimeMillis());
		int readCount=Integer.parseInt(mr.getFilesystemName("noticeReadCount"));
		
		//ajax파일 다중 업로드
		Enumeration e=mr.getFileNames();
		List<String> fileNames=new ArrayList();
		while(e.hasMoreElements())
		{
			fileNames.add(mr.getFilesystemName((String)e.nextElement()));
		}
		
		Notice n=new Notice();
		n.setNoticeTitle(title);
		n.setNoticeContents(contents);
		n.setNoticeDate(date);
		n.setNoticeReadCount(readCount);
		
		int result = new NoticeService().insertNotice(n);
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="공지사항등록성공";
			loc="/notice/noticeView?noticeno="+result;
		}
		else
		{
			msg="공지사항등록실패";
			loc="/notice/noticeForm";
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
