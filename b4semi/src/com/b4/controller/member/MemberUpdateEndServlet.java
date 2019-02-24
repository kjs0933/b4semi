package com.b4.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Member;
import com.b4.service.MemberService;

/**
 * Servlet implementation class MemberUpdateEndServlet
 */
@WebServlet(name="MemberUpdateEndServlet", urlPatterns="/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateEndServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null)
		{
			request.setAttribute("msg", "세션정보가 만료되었습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/view/common/msg.jsp");
		}
		
        Member m = new Member();
        m.setMemberId(request.getParameter("memberId"));
        m.setMemberPw(request.getParameter("memberPwNew"));
        m.setMemberName(request.getParameter("memberName"));
        m.setMemberEmail(request.getParameter("memberEmail"));
        m.setMemberPhone(request.getParameter("memberPhone"));
        
        int result = new MemberService().updateMember(m);
        String loc = "/memberUpdate";
        String msg = "";
        
        if(result > 0) {msg = "회원정보가 수정되었습니다.";}
        else {msg = "회원정보 수정에 실패하였습니다.";}
        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);
        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
