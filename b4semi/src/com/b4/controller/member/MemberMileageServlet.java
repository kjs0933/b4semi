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
import com.b4.model.vo.MypageHeader;
import com.b4.service.MemberService;
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
		
		//각 mypage 위에 멤버 기본정보 가져오는 트랜잭션
		MypageHeader mh = new MemberService().selectMypageHeader(loginMember);
		request.setAttribute("mh", mh);
		
		//마일리지 누적 사용양
		List<MileageLog> allList = new MileageLogService().selectAllMileageLogList(loginMember.getMemberSeq());
		int mileageSpentSum = 0;
		for(MileageLog ml : allList)
		{
			if(ml.getNextMileage()-ml.getPreMileage() < 0)
			{
				mileageSpentSum += (ml.getPreMileage()-ml.getNextMileage());
			}
		}
		
		//페이징 시작
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e)
		{
			numPerPage = 10;
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
		
		request.setAttribute("list", list);
		request.setAttribute("cPage", cPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("mileageSpentSum", mileageSpentSum);
		
		request.getRequestDispatcher("/views/member/mypage_mileage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
