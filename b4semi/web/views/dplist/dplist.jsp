<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.DPList"%>
<%@ page import="com.b4.model.vo.Category"%>
<%@ page import="java.util.ArrayList"%>

<%
	int cPage;
	try {
		cPage = Integer.parseInt(request.getParameter("cPage"));
	} catch (NumberFormatException e) {
		cPage = 1;
	}
 	String keyword= request.getParameter("keyword");
	if(keyword == null)
	{
		keyword ="";
	}
 	String sub= request.getParameter("sub");
	if(sub == null)
	{
		sub ="";
	}
 	String major= request.getParameter("major");
	if(major == null)
	{
		major ="";
	}
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
	ArrayList<Category> subTextAll;
	try {
		subTextAll= (ArrayList<Category>)request.getAttribute("subTextAll");
		if(subTextAll == null)
		{
			subTextAll=new ArrayList<Category>();
		}
	} catch (ClassCastException e) {
		subTextAll=new ArrayList<Category>();
	}
	
	Category majorText;
	try {
		majorText = (Category)request.getAttribute("majorText");
		if(majorText == null)
		{
			majorText=new Category("","","전체 검색");
		}
	} catch (ClassCastException e) {
		majorText=new Category("","","전체 검색");
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
		dplist = (ArrayList<DPList>)request.getAttribute("dplist");
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
            justify-content: flex-start;
        }

        .plist-board > div
        {
            position: relative;
            width: 310px;
            margin: 15px;
            margin-top: 20px;
            margin-bottom: 70px;
        }

        .add-to-cart
        {
            position: absolute;
            right: 5%;
            top: 74%;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background-color: rgba(0, 0, 0, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }
        
        .plist-title
        {
        	font-size: 18px;
            color: #222;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        
        .rating-holder {
            display: inline-block;
            box-sizing: border-box;
            display: flex;
            align-items: flex-end;
        	position: absolute;
        	top: 0;
        	right: 0;
        	margin-right: 2px;
        }
        
        .c-rating
        {
        	display: flex;
        }

        .c-rating button {
            display: inline-block;
            width: 25px;
            height: 25px;
            border: 0;
            text-indent: -9999px;
            outline: none;
            background: url("data:image/svg+xml;utf8,%3Csvg%20version%3D%221.1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20width%3D%22512%22%20height%3D%22512%22%20viewBox%3D%220%200%20512%20512%22%3E%3Cpath%20fill%3D%22%23ddd%22%20d%3D%22M457.888 210.672l-139.504-20.272-62.384-126.4-62.384 126.4-139.504 20.272 100.944 98.384-23.84 138.928 124.768-65.6 124.768 65.6-23.84-138.928c0 0 100.944-98.384 100.944-98.384z%22%3E%3C%2Fpath%3E%3C%2Fsvg%3E") center/cover no-repeat;
        }
        
        .plist-price-box
        {
        	display: flex;
        	justify-content: space-between;
        }
                
        .plist-price
        {
            font-size: 15px;
            color: rgb(38, 85, 139);
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
            cursor: pointer;
        }

        .plist-board  p
        {
            margin: 0;
        }


        

        .major-category
        {
            font-size: 35px;
            margin: 15px 0px 5px 14px;
            font-family: 'Noto Sans KR';
            color: rgb(38, 85, 139);
            align-self: flex-start;
        }
        
        .major-category a
        {
        	font-size: 35px;
        	color: rgb(42, 71, 114);
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

        .pagebar div
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

        .pagebar div:first-of-type
        {
            border-left: 1px solid rgb(220, 220, 220);
        }
        
        .pagebar a
        {
        	display: flex;
        	width: 100%;
        	height: 100%;
        	align-items: center;
        	justify-content: center;
        	text-decoration: none;
        	color: black;
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
        

</style>
<section>
    <div class="dp-list-wrapper">
	    <div class="search-result">
	        <div class="search-result-msg">
	           	총 <%=totalCount%>개 상품
	        </div>
	        <div id="orderby">
	            <select onchange='fn_dplist_sort();'>
	                <option value="score" <%="score".equals(sort)?"selected":""%>>평점순</option>
	                <option value="new" <%="new".equals(sort)?"selected":""%>>신상품순</option>
	                <option value="popularity" <%="popularity".equals(sort)?"selected":""%>>인기상품순</option>
	                <option value="priceAsc" <%="priceAsc".equals(sort)?"selected":""%>>낮은가격순</option>
	                <option value="priceDesc" <%="priceDesc".equals(sort)?"selected":""%>>높은가격순</option>
	            </select>
	        </div>
	    </div>
	    <script>
	    	function fn_dplist_sort(){
	    		location.href="<%=request.getContextPath()%>/dplist?keyword=<%=keyword%>&sub=<%=sub%>&major=<%=major%>&sort="+event.target.options[event.target.selectedIndex].value;
	    	}
	    	$("#header-keyword").val("<%=keyword%>");
	    </script>
    
        <div class="major-category"><a href="<%=request.getContextPath()%>/dplist?keyword=<%=keyword%>&sub=<%=majorText.getSubCode()%>&major=<%=majorText.getMajorCode()%>&sort=<%=sort%>" style="text-decoration: none;"><%=majorText.getCategoryName()%></a></div>
        <div class="sub-category-wrapper">
            <div class="sub-category">
                <ul>
                	<%for(int i=0; i<subTextAll.size(); i++){
                	if(subTextAll.get(i).getCategoryName().equals(subText))
                	{%>
                		<li class="current-sub-category"><a href="<%=request.getContextPath()%>/dplist?keyword=<%=keyword%>&sub=<%=subTextAll.get(i).getSubCode()%>&major=<%=subTextAll.get(i).getMajorCode()%>&sort=<%=sort%>"><%=subTextAll.get(i).getCategoryName()%></a><span></span></li>
                	<%}
                	else
                	{%>
                		<li><a href="<%=request.getContextPath()%>/dplist?keyword=<%=keyword%>&sub=<%=subTextAll.get(i).getSubCode()%>&major=<%=subTextAll.get(i).getMajorCode()%>&sort=<%=sort%>"><%=subTextAll.get(i).getCategoryName()%></a><span></span></li>
                	<%}
                	}%>
                </ul>
            </div>
        </div>
        
       
        
        
        <div class="plist-board">
        
        <%for(int i=0; i< dplist.size();i++) {%>
            
            <%
            	double standardizedRate = 0;
            	int integer = (int)(Double.parseDouble(dplist.get(i).getReviewScore()));
            	double decimal = Double.parseDouble(dplist.get(i).getReviewScore()) - integer;
            	if(decimal >= 0.75) {standardizedRate = (double)integer + 0.75;}
            	else if(decimal >= 0.5) {standardizedRate = (double)integer + 0.5;}
            	else if(decimal >= 0.25) {standardizedRate = (double)integer + 0.25;}
            	else if(decimal < 0.25) {standardizedRate = (double)integer;}
            %>

            <div>
                <img src="<%=request.getContextPath()%>/upload/product/<%=dplist.get(i).getImg()%>" onError="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';">
                <input type='hidden' name='plist-index' value="<%=dplist.get(i).getOptionCount()==1?dplist.get(i).getProductCode():""%>"/>
                <input type='hidden' name='plist-index' value="<%=dplist.get(i).getDisplayListSeq()%>"/>
                <div class="add-to-cart"><img src="<%=request.getContextPath()%>/images/add_to_cart.png"></div>
                <div class="plist-title">
                	<%=dplist.get(i).getDisplayListTitle()%>
                </div>
                 <%if(dplist.get(i).getDiscountRate()>0){%>
                <div class="plist-price-box">
                  	<div class="plist-price"><del><%=dplist.get(i).getMinPrice()%>원</del> → <b><%=dplist.get(i).getDiscountMinPrice()%>원</b>&nbsp;&nbsp;(단위:<%=dplist.get(i).getProductUnit()%>)</div>
                </div>
                  <%}else{ %>
                <div class="plist-price-box">
                  	<div class="plist-price"><%=dplist.get(i).getMinPrice()%>원&nbsp;&nbsp;(단위:<%=dplist.get(i).getProductUnit()%>)</div>
                </div>
                  <%}%>
            	<div class="rating-holder">
					<div class="c-rating" data-rating-value="<%=standardizedRate%>">
					    <button>1</button>
					    <button>2</button>
					    <button>3</button>
					    <button>4</button>
					    <button>5</button>
					</div>
    			</div>
            </div>
        <%} %>
        </div>
        <%=pageBar%>
    </div>
    

    
</section>


<script>
	
	const cartMsgWrapper = $('.cart-msg-wrapper');
	const addedProdImage = $('.added-prod-image').children();
	const addedProdName = $('.added-prod-name');
	const addedProdAmount = $('.added-prod-amount');
	const cartCount = $('#cart-count');
	const addCart = $('.plist-board > div > div').children();
	
	
	$(function(){
		//이미지 클릭시 링크 이벤트
		$(".plist-board>div>img").click(function(){
			location.href="<%=request.getContextPath()%>/dpdetail?dpseq="+$(event.target).next().next().val();
			});
		
		addCart.on('click',(e) => {
			if(cartMsgWrapper.is(':animated')||cartMsgWrapper.is(':visible')) return;
			
			//displayListSeq받아옴.
			var dpseq = $(e.target).parents().prev().val();
			var pcode = $(e.target).parents().prev().prev().val();
			//카트 아이콘에 장바구니에 추가되었습니다 문구 넣어주세요
			//if문으로 dpseq가 optionList의 displayListSeq중에 해당될 경우 옵션창을 띄워 보여줌.
			if(pcode != "")
			{
				$.ajax({
					url:"<%=request.getContextPath()%>/cartAdd.do",
					type:"post",
					data:{"dpseq":dpseq,"pcode":pcode},
					success:function(data){
// 						alert("상품을 장바구니에 담았습니다. 해당상품 "+data[1]+"개, 총 " + data[0] +" 종류");

						addedProdImage.prop('src', $(e.target).parent().siblings().first().prop('src'));
						addedProdName.text($(e.target).parent().next().text());
						addedProdAmount.text(data[1]+'개');
						if(data[1] == 1) {cartCount.text(parseInt(cartCount.text())+1);}
						cartMsgWrapper.fadeIn(600);
						setTimeout(()=>{cartMsgWrapper.fadeOut(600)}, 2000);
					}
				});
			}
			else
			{
				//상품 종류가 많을 때 옵션창 로직
				location.href="<%=request.getContextPath()%>/dpdetail?dpseq="+dpseq;
			}
				
		});
	});
</script>

<%@ include file="/views/common/footer.jsp" %>