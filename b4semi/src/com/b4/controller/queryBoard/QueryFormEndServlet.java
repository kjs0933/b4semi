package com.b4.controller.queryBoard;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.model.vo.Images;
import com.b4.model.vo.Member;
import com.b4.model.vo.QueryBoard;
import com.b4.service.ImagesService;
import com.b4.service.QueryBoardService;
import com.oreilly.servlet.MultipartRequest;

import common.rename.QueryFileRenamePolicy;

/**
 * Servlet implementation class QueryFormEndServlet
 */
@WebServlet("/queryFormEnd")
public class QueryFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFormEndServlet() {
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
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		if(!ServletFileUpload.isMultipartContent(request))
		{
			//response.sendRedirect("/index.jsp");
		}
		
		String dir=getServletContext().getRealPath("/upload/queryBoard");
		int maxSize=1024*1024*1024;
		MultipartRequest mr= new MultipartRequest(request,dir,maxSize,"UTF-8",new QueryFileRenamePolicy());
		//DB 로직 구성
		
		String orderSeq = mr.getParameter("orderSeq");
		String queryTitle = mr.getParameter("queryTitle");
		String queryContents = mr.getParameter("queryContents");
		
		//현재 시간 받아오기 : new Timestamp(System.currentTimeMillis())
		QueryBoard qb = new QueryBoard();
		qb.setMemberSeq(loginMember.getMemberSeq());
		if(!orderSeq.isEmpty() || !orderSeq.equals("")) {
			//orderSeq=""인 경우에는 null, 아닌경우 int로 파싱해서 db로 저장
			qb.setOrderSeq(Integer.parseInt(orderSeq));
		}
		qb.setQueryTitle(queryTitle);
		qb.setQueryContents(queryContents);
		qb.setQueryDate(new Timestamp(System.currentTimeMillis()));
		
		int resultQuery = new QueryBoardService().insertQuery(qb);
		if(resultQuery>0) {
			System.out.println("등록완료");
		}
		
		QueryBoard fileQb = new QueryBoardService().selectRecentQuery();

		//File uploadFile = mr.getFile("originalFile");
		String originalFile = mr.getOriginalFileName("originalFile");
		String renameFile = mr.getFilesystemName("originalFile");
		
//		List<Images> imgList = new ArrayList<Images>();
		Images img = new Images();
		img.setBoardCode("BQ");
		img.setBoardNo(fileQb.getQuerySeq());
		img.setOriginalFile(originalFile);
		img.setRenameFile(renameFile);
//		imgList.add(img);
		
		int resultFile = new ImagesService().insertImages(img);
		if(resultFile>0) {
			System.out.println("파일명 DB저장");
		}
		
		
		/*Enumeration e=mr.getFileNames();
		List<String> fileNames=new ArrayList<>();
		while(e.hasMoreElements())
		{
			fileNames.add(mr.getFilesystemName((String)e.nextElement()));
		}*/
		System.out.println();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
