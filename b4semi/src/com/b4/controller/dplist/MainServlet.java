package com.b4.controller.dplist;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b4.dao.MemberDao;
import com.b4.model.vo.DPList;
import com.b4.service.DPListService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DPListService service = new DPListService();
		Properties prop = new Properties();
		try {
			String fileName = MemberDao.class.getResource("/MainDisplay.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String[] eventImage = prop.getProperty("eventImage").split("/");
		String[] eventURL = prop.getProperty("eventURL").split("/");
		String[] newImage = prop.getProperty("newImage").split("/");
		String[] newURL = prop.getProperty("newURL").split("/");
		
		//평점이 높은 순서대로 4개 베스트
		ArrayList<DPList> best = service.searchDPList(1,4,"","","","REVIEWSCORE DESC");
		//가장 할인율이 높은 순서대로 6개 프로모션 상품
		ArrayList<DPList> promotion = service.searchDPList(1,6,"","","","DISCOUNTRATE DESC NULLS LAST");
		
		request.setAttribute("best", best);
		request.setAttribute("promotion", promotion);
		request.setAttribute("eventImage", eventImage);
		request.setAttribute("eventURL", eventURL);
		request.setAttribute("newImage", newImage);
		request.setAttribute("newURL", newURL);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
