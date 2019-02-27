package common;

public class PagingTemplate {
	
	public static String pageBar(String href, int cPage, int numPerPage, int totalContent)
	{
		
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		if(pageNo==1)
		{
			pageBar += "<div class=\"pagebar\"><div><img src=\"images/board-arrow-left.png\"></div>";
		}
		else
		{
			pageBar += "<div class=\"pagebar\"><div><a href="+href+"?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"><img src=\"images/board-arrow-left.png\"></a></div>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage))
		{
			if(pageNo==cPage)
			{
				pageBar += "<div>"+pageNo+"</div>";
			}
			else
			{
				pageBar += "<div><a href=\""+href+"?cPage="+pageNo+"&numPerPage="+numPerPage+"\">"+pageNo+"</a></div>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage)
		{
			pageBar+="<div><img src=\"images/board-arrow-right.png\"></div></div>";
		}
		else
		{
			pageBar+="<div><a href=\""+href+"?cPage="+pageNo+"&numPerPage="+numPerPage+"\"><img src=\"images/board-arrow-right.png\"></a></div></div>";
		}
		return pageBar;
	}
	
	
	
	
	public static String pageBar2(String href, int cPage, int totalContent)
	{
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "<div class='pagebar'>";
		int numPerPage = 7;
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		if(pageNo==1)
		{
			pageBar += "<div><img src='/b4semi/images/board-arrow-left.png'></div>";
		}
		else
		{
			pageBar += "<div><a href='"+ href+"?cPage="+(pageNo-1)+"'><img src='/b4semi/images/board-arrow-left.png'></a></div>";
		}
		for(int i=pageNo; i<=pageEnd; i++)
		{
			if(cPage==i)
			{
				pageBar+="<div><b>"+cPage+"</b></div>";
			}
			else
			{
				pageBar +="<div><a href='"+href+"?cPage="+i+"'/>"+i+"</a></div>";
			}
		}
		if(pageEnd>=totalPage)
		{
			pageBar+="<div><img src='/b4semi/images/board-arrow-right.png'></div>";
		}
		else
		{
			pageBar +="<div><a href='"+href+"?cPage="+(pageEnd+1)+"'><img src='/b4semi/images/board-arrow-right.png'></a></div>";
		}
		pageBar+="</div>";
		return pageBar;
	}
	
	//DisplayDetailServlet에서 사용중
	public static String pageBar3(String href, int cPage, int totalContent, String pageName, String root)
	{
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "<div class='pagebar'>";
		int numPerPage = 15;
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		if(pageNo==1)
		{
			pageBar += "<div><img src='"+root+"/images/board-arrow-left.png'></div>";
		}
		else
		{
			pageBar += "<div><a href='"+ href+pageName+"="+(pageNo-1)+"'><img src='"+root+"/images/board-arrow-left.png'></a></div>";
		}
		for(int i=pageNo; i<=Math.min(pageEnd,totalPage); i++)
		{
			if(cPage==i)
			{
				pageBar+="<div><b>"+cPage+"</b></div>";
			}
			else
			{
				pageBar +="<div><a href='"+href+pageName+"="+i+"'/>"+i+"</a></div>";
			}
		}
		if(pageEnd>=totalPage)
		{
			pageBar+="<div><img src='"+root+"/images/board-arrow-right.png'></div>";
		}
		else
		{
			pageBar +="<div><a href='"+href+pageName+"="+(pageEnd+1)+"'><img src='"+root+"/images/board-arrow-right.png'></a></div>";
		}
		pageBar+="</div>";
		return pageBar;
	}
	
	public static String pageBar4(String href, int cPage, int totalContent, String pageName, String root)
	{
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "<div class='pagebar'>";
		int numPerPage = 15;
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		if(pageNo==1)
		{
			pageBar += "<div><img src='"+root+"/images/board-arrow-left.png'></div>";
		}
		else
		{
			pageBar += "<div><a href='"+ href+pageName+"="+(pageNo-1)+"'><img src='"+root+"/images/board-arrow-left.png'></a></div>";
		}
		for(int i=pageNo; i<=Math.min(pageEnd,totalPage); i++)
		{
			if(cPage==i)
			{
				pageBar+="<div><b>"+cPage+"</b></div>";
			}
			else
			{
				pageBar +="<div><a href='"+href+pageName+"="+i+"'/>"+i+"</a></div>";
			}
		}
		if(pageEnd>=totalPage)
		{
			pageBar+="<div><img src='"+root+"/images/board-arrow-right.png'></div>";
		}
		else
		{
			pageBar +="<div><a href='"+href+pageName+"="+(pageEnd+1)+"'><img src='"+root+"/images/board-arrow-right.png'></a></div>";
		}
		pageBar+="</div>";
		return pageBar;
	}
}
