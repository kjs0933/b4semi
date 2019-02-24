package com.b4.controller.mypage;

import java.io.IOException;
import static common.PagingTemplate.pageBar2;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b4.model.vo.Member;
import com.b4.model.vo.MileageLog;
import com.b4.service.CouponService;
import com.b4.service.MileageLogService;

/**
 * Servlet implementation class MileageServlet
 */
@WebServlet("/mypage/mypage_mileage")
public class MypageMileageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMileageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		if(loginMember == null)
		{
			request.setAttribute("msg", "세션이 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		else
		{
			int couponCount = new CouponService().couponCountByMember(loginMember.getMemberId());
			int logCount = new MileageLogService().logCountByMember(loginMember.getMemberSeq());
			
			
			int cPage;
			try {
				cPage=Integer.parseInt(request.getParameter("cPage"));
			}
			catch(NumberFormatException e)
			{
				cPage=1;
			}
			String pageBar = pageBar2(request.getContextPath()+"/mypage/mypage_mileage",cPage,logCount);
			List<MileageLog> mlList = new MileageLogService().mileageLogByMember(cPage,loginMember.getMemberSeq());
			
		
			request.setAttribute("pageBar", pageBar);
			request.setAttribute("logCount", logCount);
			request.setAttribute("mlList", mlList);
			request.setAttribute("couponCount", couponCount);
			request.setAttribute("loginMember", loginMember);
			request.getRequestDispatcher("/views/member/mypage_mileage.jsp?cPage="+cPage).forward(request, response);
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
