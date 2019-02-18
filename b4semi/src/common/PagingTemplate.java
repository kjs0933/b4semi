package common;

public class PagingTemplate {
	
	public static String pageBar(String href, int cPage, int totalContent)
	{
		int pageBarSize = 5;
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String pageBar = "";
		int numPerPage = 15;
		int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
		
		if(pageNo==1)
		{
			pageBar += "<span>[이전]</span>";
		}
		else
		{
			pageBar += "<a href='"+ href+"?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage))
		{
			if(pageNo==cPage)
			{
				pageBar += "<span>"+pageNo+"</span>";
			}
			else
			{
				pageBar += "<a href='"+href+"?cPage="+pageNo+ "'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage)
		{
			pageBar+="<span>[다음]</span>";
		}
		else
		{
			pageBar+="<a href='"+ href+"?cPage="+pageNo+"'>[다음]</a>";
		}
		return pageBar;
	}

}
