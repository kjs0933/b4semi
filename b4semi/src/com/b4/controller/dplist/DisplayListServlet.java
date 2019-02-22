package com.b4.controller.dplist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.model.vo.Category;
import com.b4.model.vo.DPList;
import com.b4.service.DPListService;

/**
 * Servlet implementation class DisplayListServlet
 */
@WebServlet("/dplist")
public class DisplayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String sub = request.getParameter("sub");
		String major = request.getParameter("major");
		String sort = request.getParameter("sort");
		int cPage; //현재 페이지 수
		
		if(keyword==null || "null".equals(keyword))
		{
			keyword="";
		}
		if(sub==null || "null".equals(sub))
		{
			sub="";
		}
		if(major==null || "null".equals(major))
		{
			major="";
		}
		if(sort==null || "null".equals(sort))
		{
			sort=""; // 타입이 없을때는 리뷰평점 내림차순?
		}
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage=1;
		}
		
		String sortText;
		switch(sort)
		{
		case "number" : sortText="DISPLAYLISTSEQ DESC"; break; //번호순
		case "title" : sortText="DISPLAYLISTTITLE ASC"; break; //가나다순
		case "score" : sortText="REVIEWSCORE DESC"; break;
		case "new" : sortText="DISPLAYDATE DESC"; break;
		case "popularity" : sortText="POPULARITY DESC"; break;
		case "priceAsc" : sortText="MINPRICE ASC"; break;
		case "priceDesc" : sortText="MINPRICE DESC"; break;
		default : sortText="DISPLAYLISTSEQ DESC";
		}
		
		if(major.length()==0 && sub.length()>0)
		{
			System.out.println("[주의] 어딘가에서 major코드 없이 sub코드로만 요청을 했습니다!");
			sub = "";
		}
		
		
		int numPerPage=15; //페이지당 자료 수
		
		DPListService service = new DPListService();

		ArrayList<DPList> dplist = service.searchDPList(cPage,numPerPage,keyword,sub,major,sortText);
		
		
		String subText; 
		ArrayList<Category> subTextAll;
		Category majorText;
		
		if(major.length() == 0)
		{
			subText = "";
			subTextAll = service.getMajorTextAll();
			majorText = new Category("","","전체 검색");
		}
		else if(sub.length() == 0 && keyword.length() > 0)
		{
			subText = service.getMajorText(major).getCategoryName();
			subTextAll = service.getMajorTextAll();
			majorText = new Category("","","전체 검색");
		}
		else
		{
			subText = service.getSubText(sub);
			subTextAll = service.getSubTextAll(major);
			majorText = service.getMajorText(major);
		}

		
		
		//페이징 처리를 위한 값!!!
		int totalCount = service.searchDPCount(keyword,sub,major); //총 자료의 갯수
		int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
		int pageBarSize = 5; //bar의 출력할 페이지 수!
		int pageStart= ((cPage-1)/pageBarSize)*pageBarSize+1;//시작지점
		int pageEnd= Math.min(pageStart+pageBarSize-1,totalPage); //끝지점
		
		// 쿼리스트링이 많은 특수한 경우이므로 페이징 템플릿을 이용하지 않습니다

		String pageBar="<div class='pagebar'>";
		if(pageStart==1) {
			pageBar+="<div><img src='"+request.getContextPath()+"/images/board-arrow-left.png'></div>";
		}
		else {
			pageBar +="<div><a href='"+ request.getContextPath() +"/dplist?cPage="+(pageStart-1)+
					"&keyword="+keyword+"&sub="+sub+"&major="+major+"&sort="+sort+"'><img src='"+
					request.getContextPath()+"/images/board-arrow-left.png'></a></div>";
		}
		for(int i=pageStart; i<=pageEnd; i++)
		{
			if(cPage==i)
			{
				pageBar+="<div><b>"+cPage+"</b></div>";
			}
			else
			{
				pageBar +="<div><a href='"+ request.getContextPath() +"/dplist?cPage="+i+
						"&keyword="+keyword+"&sub="+sub+"&major="+major+"&sort="+sort+"'>"+i+"</a></div>";
			}
		}
		if(pageEnd>=totalPage)
		{
			pageBar+="<div><img src='"+request.getContextPath()+"/images/board-arrow-right.png'></div>";
		}
		else
		{
			pageBar +="<div><a href='"+ request.getContextPath() +"/dplist?cPage="+(pageEnd+1)+
					"&keyword="+keyword+"&sub="+sub+"&major="+major+"&sort="+sort+"'><img src='"+
					request.getContextPath()+"/images/board-arrow-right.png'></a></div>";
		}
		pageBar+="</div>";
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("subText", subText);
		request.setAttribute("subTextAll", subTextAll);
		request.setAttribute("majorText", majorText);
		request.setAttribute("dplist", dplist);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/dplist/dplist.jsp?cPage="+cPage+"&keyword="+keyword+"&sub="+sub+"&major="+major+"&sort="+sort).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
