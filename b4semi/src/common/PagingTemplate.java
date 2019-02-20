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
			pageBar += "<div><img src=\"images/board-arrow-left.png\"></div>";
		}
		else
		{
			pageBar += "<div href='"+ href+"?cPage="+(pageNo-1)+"'><img src=\"images/board-arrow-left.png\"></div>";
		}
		
		while(!(pageNo>pageEnd || pageNo>totalPage))
		{
			if(pageNo==cPage)
			{
				pageBar += "<div>"+"<img src=images/board-arrow-right.png>"+"</div>";
			}
			else
			{
				pageBar += "<div href='"+href+"?cPage="+pageNo+ "'>"+pageNo+"</div>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage)
		{
			pageBar+="<div><img src=\"images/board-arrow-right.png\"></div>";
		}
		else
		{
			pageBar+="<div href='"+ href+"?cPage="+pageNo+"'><img src=\"images/board-arrow-right.png\"></div>";
		}
		return pageBar;
	}

}


/*<div class="pagebar">
<div><img src="images/board-arrow-left.png"></div>
<div>1</div>
<div>2</div>
<div>3</div>
<div>4</div>
<div>5</div>
<div><img src="images/board-arrow-right.png"></div>
</div>*/
