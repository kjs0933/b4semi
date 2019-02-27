package com.b4.controller.dplist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.DPDetail;
import com.b4.model.vo.DPOption;
import com.b4.model.vo.QueryBoard;
import com.b4.model.vo.Review;
import com.b4.service.DPListService;
import com.b4.service.QueryBoardService;
import com.b4.service.ReviewService;

import common.PagingTemplate;

/**
 * Servlet implementation class DisplayDetailServlet
 */
@WebServlet("/dpdetail")
public class DisplayDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rpage;
		try {
			rpage = Integer.parseInt(request.getParameter("rpage"));
		}
		catch(NumberFormatException e)
		{
			rpage=1;
		}
		int qpage;
		try {
			qpage = Integer.parseInt(request.getParameter("qpage"));
		}
		catch(NumberFormatException e)
		{
			qpage=1;
		}
		int dpseq=0;
		try {
			dpseq = Integer.parseInt(request.getParameter("dpseq"));
		}
		catch(NumberFormatException e)
		{
			request.setAttribute("msg", "상품 페이지를 찾을 수 없습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		//스크롤 앵커//
		String scrollAnchor = request.getParameter("scrollAnchor");
		if(scrollAnchor == null) {scrollAnchor = "page-top";}
		
		DPListService service = new DPListService();
		DPDetail detail = service.getDetail(dpseq);
		if(detail ==null)
		{
			request.setAttribute("msg", "상품 페이지를 찾을 수 없습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		detail.setQnaCount(new QueryBoardService().countByDP(dpseq));
		ArrayList<DPOption> option = service.getOption(dpseq);
		ArrayList<String> renames = service.getRenames(dpseq);
		
		List<Review> review = new ReviewService().selectAllByDP(dpseq, rpage);
		List<QueryBoard> qna = new QueryBoardService().getByDp(dpseq, qpage);
		
		String rpageStr = PagingTemplate.pageBar3(request.getContextPath()+"/dpdetail?dpseq="+dpseq+"&qpage="+qpage+"&scrollAnchor=review-tab&", rpage, detail.getReviewCount(), "rpage", request.getContextPath());
		String qpageStr = PagingTemplate.pageBar4(request.getContextPath()+"/dpdetail?dpseq="+dpseq+"&rpage="+rpage+"&scrollAnchor=qna-tab&", qpage, detail.getQnaCount(), "qpage",request.getContextPath());
		
		request.setAttribute("detail", detail);
		request.setAttribute("option", option);
		request.setAttribute("renames", renames);
		request.setAttribute("review", review);
		request.setAttribute("qna", qna);
		request.setAttribute("rpageStr", rpageStr);
		request.setAttribute("qpageStr", qpageStr);
		//스크롤 앵커//
		request.setAttribute("scrollAnchor", scrollAnchor);
		request.getRequestDispatcher("/views/dplist/dplist_detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
