<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.DPList"%>
<%@ page import="java.util.ArrayList"%>

<%
	int cPage;
	try {
		cPage = Integer.parseInt(request.getParameter("cPage"));
	} catch (NumberFormatException e) {
		cPage = 1;
	}
/* 	String keyword= request.getParameter("keyword");
	if(keyword == null)
	{
		keyword ="";
	} 헤더에 있어야 하므로 일단 주석 */
	String sort= request.getParameter("sort");
	if(sort == null)
	{
		sort="";
	}
	String subText;
	try {
		subText= (String)request.getAttribute("subText");
		if(subText == null)
		{
			subText="";
		}
	} catch (ClassCastException e) {
		subText="";
	}
	ArrayList<String> subTextAll;
	try {
		subTextAll= (ArrayList<String>)request.getAttribute("subTextAll");
		if(subTextAll == null)
		{
			subTextAll=new ArrayList<String>();
		}
	} catch (ClassCastException e) {
		subTextAll=new ArrayList<String>();
	}
	
	String majorText;
	try {
		majorText = (String)request.getAttribute("majorText");
		if(majorText == null)
		{
			majorText="";
		}
	} catch (ClassCastException e) {
		majorText="";
	}
	String totalCount;
	try {
		totalCount = String.valueOf((int)request.getAttribute("totalCount"));
		if(totalCount == null)
		{
			totalCount="0";
		}
	} catch (Exception e) {
		totalCount="0";
	}
	
	String pageBar;
	try {
		pageBar = (String)request.getAttribute("pageBar");
		if(pageBar == null)
		{
			pageBar ="";
		}
	} catch (ClassCastException e) {
		pageBar ="";
	}
	
	ArrayList<DPList> dplist;
	try {
		dplist = (ArrayList<DPList>)request.getAttribute("dpList");
		if(dplist == null)
		{
			dplist = new ArrayList<DPList>();
		}
	} catch (ClassCastException e) {
		dplist = new ArrayList<DPList>();
	}

%>
    <style>
        .dp-list-wrapper
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            width: 1024px;
            font-family: 'Noto Sans KR';
            margin-top: 60px;
        }

        .plist-board
        {
            width: 100%;
            display: flex;
            flex-flow: row wrap;
            justify-content: space-around;
        }

        .plist-board > div
        {
            position: relative;
            width: 305px;
            margin-top: 20px;
            margin-bottom: 70px;
        }

        .plist-board  > div > div 
        {
            position: absolute;
            right: 5%;
            top: 73%;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background-color: rgba(0, 0, 0, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .plist-board  > div > div > img
        {
            margin-top: 2px;
            margin-left: 2px;
            width: 65%;
        }

        .plist-board  > div > div > svg
        {
            width: 65%;
            fill: rgba(255, 255, 255, 0.9);
        }

        .plist-board  > div > img
        {
            width: 100%;
        }

        .plist-board  p
        {
            margin: 0;
        }

        .plist-board  > div p:first-of-type
        {
            font-size: 20px;
            color: #222;
        }

        .plist-board  > div p:last-of-type
        {
            font-size: 16px;
            color: rgb(38, 85, 139);
        }

        .major-category
        {
            font-size: 35px;
            margin: 15px 0px 5px 27px;
            font-family: 'Noto Sans KR';
            color: rgb(38, 85, 139);
            align-self: flex-start;
        }

        .sub-category
        {
            margin: 10px 28px;
            font-family: 'Noto Sans KR';
            font-size: 15px;
        }

       	.sub-category > ul
        {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }

        .sub-category > ul > li
        {
            color: #666;
        }

        .sub-category > ul > li a
        {
            text-decoration: none;
            color: inherit;
            padding: 0px 10px;
        }
        
        .sub-category > ul > li > a:hover
        {
            color: royalblue;
        }

        .sub-category > ul > li > span
        {
            position: relative;
            display: block;
            width: 100%;
            height: 1px;
        }

        .current-sub-category
        {
            border-bottom: 1px solid royalblue;
            color: royalblue !important;
        }

        .sub-category-wrapper
        {
            width: 1024px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-sizing: border-box;
            padding-right: 27px;
        }

        #orderby
        {
            width: 100px;
        }

        #orderby select
        {
            background-color: none;
            border: none;
            height: 25px;
        }

        #orderby select:focus
        {
            outline: none;
        }

        .pagebar img
        {
            width: 40%;
            height: 40%;
        }



        .pagebar
        {
            display: flex;
            align-self: center;
            margin: 40px;
            font-size: 12px;
        }

        .pagebar > div
        {
            width: 33px;
            height: 33px;
            border: 1px solid rgb(220, 220, 220);
            border-left: none;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .pagebar > div:first-of-type
        {
            border-left: 1px solid rgb(220, 220, 220);
        }
        
       
        .search-result
        {
            display: flex;
            justify-content: space-between;
            width: 1024px;
            font-size: 13px;
            border-bottom: 1px solid #ccc;
            margin-top: 50px;

        }

</style>
<section>
    <div class="dp-list-wrapper">
	    <div class="search-result">
	        <div class="search-result-msg">
	           	총 <%=totalCount%>개 상품
	        </div>
	        <div id="orderby">
	            <select>
	                <option value="descRate">평점순</option>
	                <option value="descDate">신상품순</option>
	                <option value="descPopular">인기상품순</option>
	                <option value="ascPrice">낮은가격순</option>
	                <option value="descPrice">높은가격순</option>
	            </select>
	        </div>
	    </div>
    
        <div class="major-category"><%=majorText%></div>
        <div class="sub-category-wrapper">
            <div class="sub-category">
                <ul>
                	<%for(int i=0; i<subTextAll.size(); i++){
                	if(subTextAll.get(i).equals(subText))
                	{%>
                		<li class="current-sub-category"><a href="#"><%=subTextAll.get(i)%></a><span></span></li>
                	<%}
                	else
                	{%>
                		<li><a href="<%=request.getContextPath()%>/dplist?sub="><%=subTextAll.get(i)%></a><span></span></li>
                	<%}
                	}%>
                </ul>
            </div>
        </div>

        
        <div class="plist-board">
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
            <div>
                <img src="<%=request.getContextPath()%>/images/dp_sample.jpg" alt="">
                <div><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <p>농약 팍팍 독버섯</p>
                <p>10,000 원</p>
            </div>
        </div>
        <div class="pagebar">
            <div><img src="<%=request.getContextPath()%>/images/board-arrow-left.png"></div>
            <div>1</div>
            <div>2</div>
            <div>3</div>
            <div>4</div>
            <div>5</div>
            <div><img src="<%=request.getContextPath()%>/images/board-arrow-right.png"></div>
        </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>