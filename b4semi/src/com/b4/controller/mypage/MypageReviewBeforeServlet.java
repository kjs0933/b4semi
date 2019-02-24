package com.b4.controller.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.b4.model.vo.Member;
import com.b4.service.CouponService;

/**
 * Servlet implementation class ReviewBeforeServlet
 */
@WebServlet("/mypage/mypage_reviewb")
public class MypageReviewBeforeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageReviewBeforeServlet() {
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
/*			int couponCount = new CouponService().couponCountByMember(loginMember.getMemberId());
			request.setAttribute("couponCount", couponCount);
			request.setAttribute("loginMember", loginMember);
			request.getRequestDispatcher("/views/member/mypage_review_before.jsp").forward(request, response);*/
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
