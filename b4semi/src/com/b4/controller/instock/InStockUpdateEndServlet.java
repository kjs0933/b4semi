package com.b4.controller.instock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.b4.model.vo.InStock;
import com.b4.service.InStockService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InStockUpdateEndServlet
 */
@WebServlet("/InStockUpdateEndServlet")
public class InStockUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InStockUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request))
		{
			request.setAttribute("msg", "공지사항오류![Error:code(001):form enctype 관리자에게 문의하세요]");
			request.setAttribute("loc", "/InStock/InStockList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String root=getServletContext().getRealPath("/");
		
		String filePath=root+File.separator+"upload"+File.separator+"InStock";
		
		int maxSize=1024*1024*100;
		
		MultipartRequest mr=new MultipartRequest(request, filePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		InStock i = new InStock();
		i.setInstockSeq(Integer.parseInt(mr.getParameter("instockSeq")));
		i.setProductCode(mr.getParameter("productCode"));
		i.setInStockCount(Integer.parseInt(mr.getParameter("inStockCount")));
		i.setInStockPrice(Integer.parseInt(mr.getParameter("inStockPrice")));
		i.setRemainStockCount(Integer.parseInt(mr.getParameter("remainStockCount")));
		i.setExpiredStockCount(Integer.parseInt(mr.getParameter("expiredStockCount")));
		String fileName=mr.getFilesystemName("up_file");
		
		File f= mr.getFile("up_file");//새로운 파일이 있는지 비교
		
		Enumeration e=mr.getFileNames();
		List<String> fileNames=new ArrayList();
		while(e.hasMoreElements())
		{
			fileNames.add(mr.getFilesystemName((String)e.nextElement()));
		}
		
		if(f!=null&&f.length()>0)
		{
			File deleFile=new File(filePath+"/"+mr.getParameter("old_file"));
			boolean resul=deleFile.delete();
			
		}
		else
		{
			fileName=mr.getParameter("old_file");
		}
		
		
		int result=new InStockService().updateInStock(i);
		
		String msg="";
		String loc="/inStock/inStockView?InStockno="+mr.getParameter("no");
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="입고정보 수정성공";
		}
		else
		{
			msg="입고정보 수정실패";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
