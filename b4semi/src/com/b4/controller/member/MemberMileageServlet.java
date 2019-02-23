package com.b4.controller.member;

import static common.PagingTemplate.pageBar;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.MileageLog;
import com.b4.service.MileageLogService;

/**
 * Servlet implementation class MemberMileageServlet
 */
@WebServlet("/memberMileage")
public class MemberMileageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMileageServlet() {
        super();

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
		
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e)
		{
			numPerPage = 15;
		}
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));			
		}catch(NumberFormatException e)
		{
			cPage = 1;
		}
		
		int totalCount = new MileageLogService().selectMileageLogCount(loginMember.getMemberSeq());
		List<MileageLog> list = new MileageLogService().selectMileageLogList(cPage, numPerPage, loginMember.getMemberSeq());
		String pageBar = pageBar(request.getContextPath()+"/memberMileage", cPage, numPerPage, totalCount);
		
		System.out.println(list.size());
		System.out.println(pageBar);
		System.out.println(cPage);
		
		request.setAttribute("list", list);
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/member/mypage_mileage.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
