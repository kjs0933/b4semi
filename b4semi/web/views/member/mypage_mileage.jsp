<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.MileageLog"%>
<%@ page import="com.b4.model.vo.MypageHeader"%>
<%@ page import="static common.DateFormatTemplate.getTillMinKorLoc"%>
<%@ page import="java.util.*" %>

<%
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
	
	int mileageSpentSum = (int)request.getAttribute("mileageSpentSum");
	List<MileageLog> list = (List<MileageLog>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int cPage = (int)request.getAttribute("cPage");
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




        .mypage-mileage-wrapper
        {
            width: 1024px;
            font-family: 'Noto Sans KR';
            display: flex;
            flex-flow: column;
        }

        .mypage-mileage-title
        {
            margin: 30px 0;
        }

        .mypage-mileage-title span
        {
            font-size: 25px;
            margin-right: 10px;   
        }

        .mypage-mileage-info
        {
            width: 100%;
            height: 100px;
            display: flex;
        }

        .mypage-mileage-info > div
        {
            flex: 1 1 0;
            display: flex;
            align-items: center;
            justify-content: space-around;
            border: 1px solid #ccc;
        }

        .mypage-mileage-info > div:last-of-type{border-left: none;}

        .mypage-mileage-info > div > span
        {
            font-size: 21px;
            color: rgb(38, 85, 139);
        }

        .mypage-mileage-log
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
            margin-top: 40px;
            border-top: 2px solid rgb(38, 85, 139);
        }
        .mypage-mileage-header
        {
            display: flex;
            padding: 17px 0;
        }

        .mypage-mileage-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .mypage-mileage-header > div:nth-of-type(1){flex: 2 1 0;}
        .mypage-mileage-header > div:nth-of-type(2){flex: 1 1 0;}
        .mypage-mileage-header > div:nth-of-type(3){flex: 1 1 0;}
        .mypage-mileage-header > div:nth-of-type(4){flex: 1 1 0;}
        .mypage-mileage-header > div:nth-of-type(5){flex: 1 1 0;}

        .mypage-mileage-cols
        {
            padding: 15px 0;
            display: flex;
            border-top: 1px solid #ccc;
        }

        .mypage-mileage-cols > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .mypage-mileage-log{border-bottom: 1px solid #ccc;}

        .mypage-mileage-cols > div:nth-of-type(1){flex: 2 1 0;}
        .mypage-mileage-cols > div:nth-of-type(2){flex: 1 1 0;}
        .mypage-mileage-cols > div:nth-of-type(3){flex: 1 1 0;}
        .mypage-mileage-cols > div:nth-of-type(4){flex: 1 1 0;}
        .mypage-mileage-cols > div:nth-of-type(5){flex: 1 1 0;}

		
		.no-mileage-log-msg{padding: 50px; display:flex; justify-content: center;}
		

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
                        <a href="#"><%=mh.getMemberMileage()%> 원</a>
                    </div>
                    <span></span>
                    <div>
                        <p>쿠폰</p>
                        <a href="#"><%=mh.getCouponCount()%> 개</a>
                    </div>
                </div>
            </div>
            <div class="mypage-tab">
                <div><a href="<%=request.getContextPath() %>/memberOrderlist">주문내역</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-mileage-wrapper">
                    <div class="mypage-mileage-title">
                        <p><span>적립금</span>보유하고 계신 적립금의 내역을 한 눈에 확인 하실수 있습니다.</p>
                    </div>
                    <div class="mypage-mileage-info">
                    <div><p>현재적립금</p><span><%=mh.getMemberMileage()%> 원</span></div>
                    <div><p>누적사용금액</p><span><%=mileageSpentSum%>원</span></div> 
                    </div>
                    
                    <div class="mypage-mileage-log">
                        <div class="mypage-mileage-header">
                            <div>시간</div>
                            <div>내용</div>
                            <div>금액</div>
                            <div>이전</div>
                            <div>이후</div>
                        </div>
                        
                    <%if(list.isEmpty()){ %>
                   		<div class="no-mileage-log-msg">사용내역이 없습니다.</div>
                    <%} else {
               		for (MileageLog ml : list) {%>
                        <div class="mypage-mileage-cols">
                            <div><%=getTillMinKorLoc(ml.getLogDate())%></div>
                            <div><%=ml.getLogTypeName()%></div>
                            <div><%=ml.getNextMileage()-ml.getPreMileage()%> 원</div>
                            <div><%=ml.getPreMileage()%> 원</div>
                            <div><%=ml.getNextMileage()%> 원</div>
                        </div>
                    <%} %>
                    <%} %>
                    </div>
                    
                    <%=pageBar %>

                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>