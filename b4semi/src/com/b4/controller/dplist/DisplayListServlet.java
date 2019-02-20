package com.b4.controller.dplist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.service.DPListService;

/**
 * Servlet implementation class DisplayListServlet
 */
@WebServlet(name="MemberEnrollServlet", urlPatterns="/dpList")
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
		/*	String id = (String)request.getSession().getAttribute("id");*/
		
		String type = request.getParameter("searchType");
		String keyword = request.getParameter("searchKeyword");
		String category = request.getParameter("searchCategory");
		String sortType = request.getParameter("searchSortType");
		

		if(type==null || type.length()==0)
		{
			type="";// 타입이 없을때는 where 절 like문에 아무 컬럼명이나 넣자!
		}
		if(keyword==null || keyword.length()==0)
		{
			keyword="";
		}
		if(category==null || type.length()==0)
		{
			category="";
		}
		if(sortType==null || keyword.length()==0)
		{
			sortType=""; // 타입이 없을때는 신상품순 내림차순!
		}
		
		//페이징 처리를 위한 값!!!
		int cPage; //현재 페이지 수
		int numPerPage=15; //페이지당 자료 수
		int totalContent= new DPListService().searchListCount(type,keyword,category,sortType); //총 자료의 갯수

		System.out.println("검색상품수:"+totalContent);
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage=1;
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
