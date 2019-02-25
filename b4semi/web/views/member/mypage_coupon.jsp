<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="com.b4.model.vo.MypageHeader" %>
<%@ page import="com.b4.model.vo.IssuedCoupon" %>
<%@ page import="static common.DateFormatTemplate.getTillDate" %>

<%
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
	
	List<IssuedCoupon> list = (List<IssuedCoupon>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int cPage = (int)request.getAttribute("cPage");
	
	int countAvailable=0;
	for(IssuedCoupon ic : list)
	{
		if(ic.getExpiryDate().getTime() > System.currentTimeMillis() && ic.getIsUsed().equals("N"))
		{
			countAvailable++;
		}
	}
	
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

        .mypage-tab-current{border-bottom: 2px solid rgb(42, 71, 114) !important;}



        .mypage-coupon-wrapper
        {
            width: 1024px;
            display: flex;
            flex-flow: column nowrap;
            font-family: 'Noto Sans KR';
        }
        
        .coupon-title
        {
            font-size: 25px;
            margin: 30px 0;
        }
        

        .coupon-table-caption
        {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            font-size: 13px;
        }

        .coupon-table-caption > ul
        {
            list-style: square;
            margin: 0;
            padding-left: 7px;
        }

        .coupon-table
        {
            display: flex;
            flex-flow: column nowrap;
        }

        .coupon-table-header
        {
            display: flex;
            padding: 17px 0;
            border-top: 2px solid rgb(38, 85, 139);
        }

        .coupon-table-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .coupon-table-header > div:nth-of-type(1){flex: 1 1 0;}
        .coupon-table-header > div:nth-of-type(2){flex: 1 1 0;}
        .coupon-table-header > div:nth-of-type(3){flex: 1 1 0;}
        .coupon-table-header > div:nth-of-type(4){flex: 1 1 0;}

        .coupon-table-cols
        {
            display: flex;
            padding: 17px 0;
            border-top: 1px solid #ccc;
        }

        .coupon-table-cols > div
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            justify-content: center;
        }

        .coupon-table{border-bottom: 1px solid #ccc;}

        .coupon-table-cols > div:nth-of-type(1){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(2){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(3){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(4){flex: 1 1 0;}
        
        .coupon-table-cols > div > div:nth-of-type(2){font-size: 13px;}
        
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

    </style>
    <section>
        <div class="mypage-wrapper">
            <div class="mypage-header">
                <div class="mypage-title">마이페이지</div>
                <div class="my-account-info">
                    <div>
                        <img src="images/<%=mh.getMemberGradeCode()%>.png">
                        <p><%=mh.getMemberGradeName()%></p>
                    </div>
                    <span></span>
                    <div>
                        <p><span><%=mh.getMemberName()%></span> 님</p>
                        <p><%=mh.getGradeRate()*100%>% 적립</p>
                        <p>무료배송</p>
                    </div>
                    <span></span>
                    <div>
                        <p>적립금</p>
                        <a href="<%=request.getContextPath()%>/memberMileage"><%=mh.getMemberMileage()%> 원</a>
                    </div>
                    <span></span>
                    <div>
                        <p>쿠폰</p>
                        <a href="<%=request.getContextPath() %>/memberCoupon"><%=mh.getCouponCount()%> 개</a>
                    </div>
                </div>
            </div>
            <div class="mypage-tab">
                <div><a href="<%=request.getContextPath() %>/memberOrderlist">주문내역</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-coupon-wrapper">
                	<div class="coupon-title">
                                     쿠폰
                    </div>
                    <div class="coupon-table-caption">
                        <ul>
                            <li>쿠폰은 적용 가능한 상품이 따로 적용되어 있는 경우 해당 상품 구매 시에만 사용이 가능합니다.</li>
                        </ul>
                        <span>사용가능쿠폰: <%=String.valueOf(countAvailable)%> 장</span>
                    </div>
                    <div class="coupon-table">
                        <div class="coupon-table-header">
                            <div>쿠폰명</div>
                            <div>기능</div>
                            <div>유효기간</div>
                            <div>가용여부</div>
                        </div>
                        <%if(list.size() != 0){
                        	for(IssuedCoupon ic : list)
                        	{ %>
                        <div class="coupon-table-cols">
                            <div>
                                <div><%=ic.getCouponName()%></div>
                                <div><%=ic.getMinPrice() != 0 ? ic.getMinPrice()+" 원 이상" : "" %></div>
                            </div>
                            <div><%=ic.getDiscountRate() != 0 ? (ic.getDiscountRate() != 1 ? (int)(ic.getDiscountRate()*100)+"% 할인" : ic.getMaxDisPrice()+"원 할인") : "배송료 무료" %></div>
                            <div><%=getTillDate(ic.getIssueDate())%> ~ <%=getTillDate(ic.getExpiryDate())%></div>
                            <div><%=ic.getExpiryDate().getTime() > System.currentTimeMillis() ? (ic.getIsUsed().equals("Y") ? "사용후" : "사용전" ) : "만료"%></div>
                        </div>	
                          <%}
                        } %>
                    </div>
					<%=pageBar %>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>