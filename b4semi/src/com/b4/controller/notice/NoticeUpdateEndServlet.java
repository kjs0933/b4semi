package com.b4.controller.notice;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/NoticeUpdateEndServlet")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request))
		{
			request.setAttribute("msg", "공지사항오류![Error:code(001):form enctype 관리자에게 문의하세요]");
			request.setAttribute("loc", "/notice/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String root=getServletContext().getRealPath("/");
		
		String filePath=root+File.separator+"upload"+File.separator+"notice";
		
		int maxSize=1024*1024*100;
		
		MultipartRequest mr=new MultipartRequest(request, filePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Notice n = new Notice();
		n.setNoticeTitle(mr.getParameter("noticetitle"));
		n.setNoticeContents(mr.getParameter("contents"));
		n.setNoticeReadCount(Integer.parseInt(mr.getParameter("noticeReadCount")));
		String fileName=mr.getFilesystemName("up_file");
		
		File f= mr.getFile("up_file");//새로운 파일이 있는지 비교
		
		Enumeration e=mr.getFileNames();
		List<String> fileNames=new ArrayList();
		while(e.hasMoreElements())
		{
			fileNames.add(mr.getFilesystemName((String)e.nextElement()));
		}
		
		if(f!=null&&f.length()>0)
		{
			File deleFile=new File(filePath+"/"+mr.getParameter("old_file"));
			boolean resul=deleFile.delete();
			
		}
		else
		{
			fileName=mr.getParameter("old_file");
		}
		
		
		int result=new NoticeService().updateNotice(n);
		
		String msg="";
		String loc="/notice/noticeView?noticeseq="+mr.getParameter("no");
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="공지사항수정성공";
		}
		else
		{
			msg="공지사항수정실패";
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
