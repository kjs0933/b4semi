<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.b4.model.vo.*, java.text.SimpleDateFormat, java.sql.Timestamp" %>
<%@ include file="/views/common/header.jsp"%>
<%
	int cPage;
	try {
		cPage = Integer.parseInt(request.getParameter("cPage"));
	} catch (NumberFormatException e) {
		cPage = 1;
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


	List<OrderList> orderList = (List<OrderList>)request.getAttribute("orderList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd [HH시 mm분]");
	List<OrderPDetail> orderPList = (List<OrderPDetail>)request.getAttribute("orderProductList");
	
	String gradeCode = "";
	double gradeRate = 0;
	switch(loginMember.getMemberGradeName()){
	case "일반" : gradeCode="new"; gradeRate=0.5; break;
	case "브론즈" : gradeCode="bronze"; gradeRate=1; break;
	case "실버" : gradeCode="silver"; gradeRate=3;break;
	case "골드" : gradeCode="gold"; gradeRate=5;break;
	case "플래티넘" : gradeCode="platinum"; gradeRate=7;break;
	case "다이아" : gradeCode="diamond"; gradeRate=7;break;
	default : gradeCode="new"; gradeRate=0.5;break;
	};
	int couponCount = (Integer)request.getAttribute("couponCount");
%>
    <style>
        .mypage-wrapper
        {
            width: 1024px;
            height: auto;
            font-family: 'Noto Sans KR';
            display: flex;
            flex-flow: column nowrap;
            margin-top: 100px;
        }

        .mypage-header
        {
            height: 150px;

            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 40px;
        }

        .mypage-title
        {
            font-size: 40px;
            margin-bottom: 3px;
            font-weight: bold;
            color: rgb(38, 85, 139);
        }

        .my-account-info
        {
            height: 100%;
            width: 613px;
            display: flex;
            align-items: center;
            border: 1px solid #ccc;
        }

        .my-account-info > span
        {
            width: 1px;
            height: 70%;
            background-color: #eee;
        }

        .my-account-info > div
        {
            flex: 1 1 0;
            display: flex;
            flex-flow: column;
            align-items: center;
            justify-content: center;   
        }

        .my-account-info > div:nth-of-type(1) > p
        {
            font-size: 18px;
            margin: 0;
        }

        .my-account-info > div:nth-of-type(2) > p
        {
            margin: 2px 0;
        }

        .my-account-info > div > p
        {
            font-size: 15px;
            margin: 0;
        }

        .my-account-info > div span
        {
            font-size: 20px;
            font-weight: bold;
        }

        .my-account-info > div > a
        {
            font-size: 20px;
            text-decoration: none;
            color: rgb(47, 131, 208);
        }

        .my-account-info > div > img
        {
            width: 55%;
            height: 55%;
        }

        .mypage-tab
        {
            width: 100%;
            height: 45px;
            display: flex;
            position: relative;
        }

        .mypage-tab > div
        {
            flex: 1 1 0;
            border: 1px solid #ccc;
            border-right: none;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .mypage-tab > div:last-of-type
        {
            border-right: 1px solid #ccc;
        }

        .mypage-tab > span
        {
            position: absolute;
            bottom: 0;
            display: block;
            width: 20%;
            height: 2px;
            background-color: rgb(38, 85, 139);
        }

        .mypage-tab > div > a
        {
            text-decoration: none;
            color: black;
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }



        /*주문 내역*/
        .client-orderlist
        {
            display: flex;
            flex-flow: column nowrap;
        }

        .client-orderlist-title
        {
            margin: 10px 0 0 0;
        }

        .client-orderlist-title span
        {
            font-size: 25px;
            margin-right: 10px;
        }

        .order-date
        {
            font-size: 17px;
            color: rgb(38, 85, 139);
            margin: 8px 27px;
        }

        .order > div
        {
            border: 1px solid #ccc;
            display: flex;
            flex-flow: column nowrap;
        }

        .order-title
        {
            padding: 15px 25px 15px 25px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .order-title > a
        {
            font-size: 17px;
            font-weight: bold;
            text-decoration: none;
            color: rgb(38, 85, 139);
        }

        .order-title > img
        {
            transform: translateY(3px);
            height: 30px;
            width: 30px;
        }

        .order > div > span
        {
            align-self: center;
            width: 95%;
            margin-left: -1px;
            height: 1px;
            background-color: #ccc;
        }

        .order-body
        {
            position: relative;
            display: flex;
            height: 120px;
            padding: 5px 20px 10px 15px;
        }

        .order-body > div
        {
            display: flex;
            flex-flow: column;
            align-items: flex-start;
            justify-content: space-between;
            padding: 10px;
            font-size: 14px;
        }

        .order-body > div:nth-of-type(1){width: 78px;}
        .order-body > div:nth-of-type(2){flex: 1 1 0;}
        .order-body > div:nth-of-type(3){font-weight: bold;flex: 1 1 0;}
        .order-body > div:nth-of-type(4){flex: 10 1 0;align-items:flex-end;justify-content: space-between;}

        .order-body > div > input
        {
            width: 100px;
            height: 45%;
            border: 1px solid #ccc;
            background-color: transparent;
            font-family: 'Noto Sans KR';
            font-size: 14px;
            cursor: pointer;
            padding: 0;
        }

        .order-body > div > input:first-of-type{background-color: rgb(38, 85, 139); color: white; border: none;}

        input:focus
        {
            outline: none;
        }

        .order-body > div > img
        {
            width: 100%;
            height: 100%;
        }


        .mypage-orderlist-wrapper
        {
            width: 1024px;
            display: flex;
            flex-flow: column nowrap;

            font-family: 'Noto Sans KR';
        }

        .mypage-orderlist-title
        {
            margin: 10px 0 0 0;
            border-bottom: 2px solid rgb(38, 85, 139);
            padding: 10px 0;
            margin-bottom: 15px;
        }

        .mypage-orderlist-title p
        {
            font-size: 14px;
        }

        .mypage-orderlist-title span
        {
            font-size: 25px;
            margin-right: 10px;
        }

        .order-date
        {
            font-size: 16px;
            color: #444;
            font-weight: bold;
            margin: 20px 0 8px 0;
        }

        .order > div
        {
            border: 1px solid #ccc;
            display: flex;
            flex-flow: column nowrap;
        }

        .order-title
        {
            padding: 15px 25px 15px 25px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .order-title > a
        {
            font-size: 17px;
            font-weight: bold;
            text-decoration: none;
            color: rgb(38, 85, 139);
        }

        .order-title > img
        {
            transform: translateY(3px);
            height: 30px;
            width: 30px;
        }

        .order > div > span
        {
            align-self: center;
            width: 95%;
            margin-left: -1px;
            height: 1px;
            background-color: #ccc;
        }

        .order-body
        {
            position: relative;
            display: flex;
            height: 120px;
            padding: 5px 20px 10px 15px;
        }

        .order-body > div
        {
            display: flex;
            flex-flow: column;
            align-items: flex-start;
            justify-content: space-between;
            padding: 10px;
            font-size: 14px;
        }

        .order-body > div:nth-of-type(1){width: 78px;}
        .order-body > div:nth-of-type(2){flex: 1 1 0;}
        .order-body > div:nth-of-type(3){font-weight: bold;flex: 1 1 0;}
        .order-body > div:nth-of-type(4){flex: 10 1 0;align-items:flex-end;justify-content: space-between;}

        .order-body > div > input
        {
            width: 100px;
            height: 45%;
            border: 1px solid #ccc;
            background-color: transparent;
            font-family: 'Noto Sans KR';
            font-size: 15px;
            cursor: pointer;
            padding: 0;
        }

        .order-body > div > input:first-of-type{background-color: rgb(38, 85, 139); color: white; border: none;}


        input:focus
        {
            outline: none;
        }

        .order-body > div > img
        {
            width: 100%;
            height: 100%;
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

        .mypage-tab-current{border-bottom: 2px solid rgb(42, 71, 114) !important;}

    </style>
    <section>
        <div class="mypage-wrapper">
            <div class="mypage-header">
                <div class="mypage-title">마이페이지</div>
                <div class="my-account-info">
                    <div>
                        <img src="<%=request.getContextPath() %>/images/member_grade_<%=gradeCode %>.png">
                        <p><%=loginMember.getMemberGradeName()%></p>
                    </div>
                    <span></span>
                    <div>
                        <p><span><%=loginMember.getMemberName() %></span> 님</p>
                        <p>적립 <%=gradeRate%>%</p>
                       	<%if(loginMember.getMemberGradeName().equals("다이아")) {%>
                       	<p>무료배송</p>
                       	<%} %>
                    </div>
                    <span></span>
                    <div>
                        <p>적립금</p>
                        <a href="#"><%=loginMember.getMemberMileage() %> 원</a>
                    </div>
                    <span></span>
                    <div>
                        <p>쿠폰</p>
                        <a href="#"><%=couponCount %> 개</a>
                    </div>
                </div>
            </div>
            <div class="mypage-tab">
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/mypage/mypage_orderlist">주문내역</a></div>
                <div><a href="<%=request.getContextPath() %>/mypage/mypage_reviewb">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/mypage/mypage_mileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/mypage/mypage_coupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-orderlist-wrapper">
                    <div class="mypage-orderlist-title">
                        <p><span>주문내역</span>지난 3년간의 주문 내역 조회가 가능합니다.</p>
                        <div class="search-period">

                        </div>
                    </div>
                    <%for(int i=0;i<orderList.size();i++) {%>
                    <div class="order">
                        <p class="order-date"><%=sdf.format(new Date(orderList.get(i).getOrderTime().getTime()))%></p>
                        <div>
                            <div>
                                <div class="order-title"><a href="#"><%=orderPList.get(i).getProductName() %> 외 <%=(orderPList.get(i).getCountByOrderList())-1 %>건</a><img
                                        src="images/arrow_right_black.png" alt=""></div>
                            </div>
                            <span></span>
                            <div class="order-body">
                                <div><img src="<%=request.getContextPath() %>/upload/product/<%=orderPList.get(i).getProductName() %>.jpg"></div>
                                <div>
                                    <div>주문번호</div>
                                    <div>결제금액</div>
                                    <div>주문상태</div>
                                </div>
                                <div>
                                    <div><%=orderList.get(i).getOrderSeq() %></div>
                                    <div><%=(orderList.get(i).getTotalPrice())+(orderList.get(i).getShipmentFee())%> 원</div>
                                    <div>배송완료</div>
                                </div>
                                <div>
                                    <input type="button" value="후기 작성">
                                    <input type="button" value="1:1 문의">
                                </div>
                            </div>
                        </div>
                    </div>
                    <%} %>
					<%=pageBar %>
<!--                     <div class="pagebar">
                        <div><img src="images/board-arrow-left.png"></div>
                        <div>1</div>
                        <div>2</div>
                        <div>3</div>
                        <div>4</div>
                        <div>5</div>
                        <div><img src="images/board-arrow-right.png"></div>
                    </div> -->
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>