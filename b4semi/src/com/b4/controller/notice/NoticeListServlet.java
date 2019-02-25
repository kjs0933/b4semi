package com.b4.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Notice;
import com.b4.service.NoticeService;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/support/support_notice")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage=1;
		}
		int numPerPage=5;
		//전체자료수 호출
		int totalContent=new NoticeService().NoticeCount();
		//전체 페이지수
		int totalPage=(int)Math.ceil((double)totalContent/numPerPage);	
		
		
		//DB에서 데이터를 불러옴!
		//servlet -> service(Connection) -> Dao
		List<Notice> list = new NoticeService().selectList(cPage,numPerPage);
		//page구현하는 pageBar
		String pageBar="";
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		//pageBar채우기
		if(pageNo==1)
		{
			pageBar+="<span>[이전]</span>";
		}
		else
		{
			pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		//번호구현
		while(!(pageNo>pageEnd||pageNo>totalPage))
		{
			if(cPage==pageNo)
			{
				pageBar+="<span class='cPage'>"+pageNo+"</span>";
			}
			else
			{
				pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage)
		{
			pageBar+="<span>[다음]</span>	";
		}
		else
		{
			pageBar+="<a href='"+request.getContextPath()+"/notice/noticeList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		//응답view선택 데이터 응답view에 전송
		request.setAttribute("list", list);
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageBar", pageBar);
		
		
		
		request.getRequestDispatcher("/views/support/support_notice.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
