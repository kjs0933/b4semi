package com.b4.controller.member;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.model.vo.MileageLog;
import com.b4.service.CouponService;
import com.b4.service.MemberService;
import com.b4.service.MileageLogService;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet(name="MemberEnrollServlet", urlPatterns="/memberEnroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		m.setMemberName(memberName);
		m.setMemberEmail(memberEmail);
		m.setMemberPhone(memberPhone);
		
		int result = new MemberService().insertOne(m);
		
		String msg = "";
		if(result > 0)
		{
			msg = "회원가입이 완료되었습니다.";
			//회원번호 가져오기!
			int seq = new MemberService().selectOne(m).getMemberSeq();
			CouponService service = new CouponService();
			service.issueCoupon(seq, "NEW-20K-0.1-5000");
			service.issueCoupon(seq, "FREE-5K");
			service.issueCoupon(seq, "LCP-30K-1-3000");
			service.issueCoupon(seq, "FCP-0-0.07-7000");
			service.issueCoupon(seq, "GCP-500K-0.15-100000");
			//마일리지 등록
			MileageLog mlog = new MileageLog();
			mlog.setMileageLogType("MPN");
			mlog.setMemberSeq(seq);
			mlog.setLogDate(new Timestamp(System.currentTimeMillis()));
			mlog.setPreMileage(0);
			mlog.setNextMileage(1000);
			new MileageLogService().createLog(mlog);
			
		}
		else
		{
			msg = "회원가입에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
