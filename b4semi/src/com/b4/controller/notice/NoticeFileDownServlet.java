package com.b4.controller.notice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownServlet
 */
@WebServlet("/NoticeFileDownServlet")
public class NoticeFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
	
		
		
		String dir=request.getServletContext().getRealPath("/upload/notice");
		

		File downFile=new File(dir+"/"+fname);
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(downFile));
		
		ServletOutputStream sos=response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);

		
		
		String resFileName="";
		boolean isMSIE=request.getHeader("user-agent").indexOf("MSIE")!=-1||request.getHeader("user-agent").indexOf("Trident")!=-1;
		if(isMSIE)
		{
			resFileName=URLEncoder.encode(fname,"UTF-8").replaceAll("\\", "%20");//익스플로러일때
		}
		else
		{
			resFileName=new String(fname.getBytes("UTF-8"),"ISO-8859-1");//한글파일 깨짐방지
		}
		
		//4.헤더 세팅
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFileName);
		response.setHeader("Content-Disposition", "inline;filename="+resFileName);//IE에서 사용가능
		
		//5.파일 보내주기
		int read=-1;
		while((read=bis.read())!=-1)
		{
			bos.write(read);
		}
		
		bis.close();
		bos.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
