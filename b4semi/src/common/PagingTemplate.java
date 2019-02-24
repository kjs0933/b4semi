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
			pageBar+="<div><a href=\""+href+"?cPage="+pageNo+"&numPerPage="+numPerPage+"><img src=\"images/board-arrow-right.png\"></a></div></div>";
		}
		return pageBar;
	}

}
