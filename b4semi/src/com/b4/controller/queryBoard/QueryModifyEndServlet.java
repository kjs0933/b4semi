package com.b4.controller.queryBoard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.dao.QueryBoardDao;
import com.b4.model.vo.Images;
import com.b4.model.vo.Member;
import com.b4.model.vo.QueryBoard;
import com.b4.service.ImagesService;
import com.oreilly.servlet.MultipartRequest;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;
import common.rename.QueryFileRenamePolicy;

/**
 * Servlet implementation class QueryModifyEndServlet
 */
@WebServlet("/queryModifyEnd")
public class QueryModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryModifyEndServlet() {
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
		System.out.println(request.getParameter("querySeq"));
		int querySeq = Integer.parseInt(request.getParameter("querySeq"));
		String dir=getServletContext().getRealPath("/upload/queryBoard");
		int maxSize=1024*1024*1024;
		MultipartRequest mr= new MultipartRequest(request,dir,maxSize,"UTF-8",new QueryFileRenamePolicy());
		
		String orderSeq = mr.getParameter("orderSeq");
		String queryTitle = mr.getParameter("queryTitle");
		String queryContents = mr.getParameter("queryContents");
		
		QueryBoard qb = new QueryBoard();
		qb.setQuerySeq(querySeq);
		qb.setMemberSeq(loginMember.getMemberSeq());
		if(!orderSeq.isEmpty() || !orderSeq.equals("")) {
			//orderSeq=""인 경우에는 null, 아닌경우 int로 파싱해서 db로 저장
			qb.setOrderSeq(Integer.parseInt(orderSeq));
		}
		qb.setQueryTitle(queryTitle);
		qb.setQueryContents(queryContents);
		qb.setQueryDate(new Timestamp(System.currentTimeMillis()));
		
		
		String oldFile = mr.getParameter("oldFile");		
		String upFile = mr.getOriginalFileName("upFile");
		String renameUpFile = mr.getFilesystemName("upFile");

		Images img = new Images();
		img.setBoardCode("BQ");
		img.setBoardNo(qb.getQuerySeq());
		img.setOriginalFile(upFile);
		img.setRenameFile(renameUpFile);
		
		Connection conn = getConnection();
		int resultQuery = new QueryBoardDao().updateQuery(conn, qb);
		if(resultQuery>0) 
		{
			if(!img.getOriginalFile().isEmpty())
			{
				int resultFile = new ImagesService().updateImages(oldFile,img);
				if(resultFile>0) {
					commit(conn);
					close(conn);
					request.setAttribute("msg", "1대1 문의가 수정되었습니다");
					request.setAttribute("loc", "/query");
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				}
				else 
				{
					rollback(conn);close(conn);
					request.setAttribute("msg", "1대1 문의 수정이 실패하였습니다.");
					request.setAttribute("loc", "/queryForm");
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				}
			}
			else 
			{
				commit(conn);close(conn);
				request.setAttribute("msg", "1대1 문의가 수정되었습니다");
				request.setAttribute("loc", "/query");
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			}
		}
		else
		{
			rollback(conn);close(conn);
			request.setAttribute("msg", "1대1 문의 수정이 실패하였습니다.");
			request.setAttribute("loc", "/queryForm");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
