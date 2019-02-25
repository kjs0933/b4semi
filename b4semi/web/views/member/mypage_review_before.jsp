<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.MypageHeader" %>

<%
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
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

        .mypage-review-wrapper
        {
            width: 1024px;
            font-family: 'Noto Sans KR';
        }

        .mypage-review-title > ul
        {
            list-style: square;
            margin: 0;
            padding-left: 19px;
            font-size: 13px;
        }
        
        .mypage-review-title > p
        {
        	font-size: 25px;
        	margin: 30px 0;
        }
        
        .review-tab
        {
            position: relative;
            display: flex;
            margin-top: 30px;
            cursor: pointer;
        	width: 100%;
        	height: 100%;
        }
        
        .review-tab a
        {
        	width: 100%;
        	height: 100%;
        	text-decoration: none;
        	color: rgb(38, 85, 139);
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 16px;
        }

        .review-tab > div
        {
            flex: 1 1 0;
            display: flex;
            align-items: center;
            justify-content: center;
            border: 1px solid #ccc;
        }

        .review-tab > div:last-of-type{border-left: none;}

        .review-tab > span
        {
            display: block;
            position: absolute;
            bottom: 0;
            width: 50%;
            height: 2px;
            background-color: rgb(38, 85, 139);
        }

        .review-content-before
        {
            display: flex;
            flex-flow: column;
            width: 100%;
        }
        
        .review-unit
        {
            margin-top: 25px;
            display: flex;
            flex-flow: column;
        }

        .review-product-unit
        {
            display: flex;
            border: 1px solid #ccc;
            margin: 5px 0;
        }

        .review-product-unit img
        {
            width: 80px;
        }

        .review-product-unit input
        {
            width: 80px;
            height: 40px;
            border: none;
            background-color: rgb(38, 85, 139);
            color: white;
        }

        .review-product-unit > div
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: flex-start;
            justify-content: space-evenly;
            padding: 15px;
        }

        .review-product-unit > div:nth-of-type(1){flex: 1 1 0;}
        .review-product-unit > div:nth-of-type(2){flex: 4 1 0;}
        .review-product-unit > div:nth-of-type(3){flex: 1 1 0;}
        .review-product-unit > div:nth-of-type(4){flex: 1 1 0;}
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
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-review-wrapper">
                    <div class="mypage-review-title">
                        <p>상품후기</p>  
                        <ul>
                            <li>포토 리뷰는 <b>100원</b> 텍스트 리뷰는 <b>50원</b>을 적립해 드립니다.</li>
                            <li>플래티넘·다이아몬드는 <b>2배</b> 적립 (사진 200원, 글 100원)</li>
                            <li>주간 베스트 후기로 선정 시 <b>5,000원</b> 추가 적립</li>
                            <li>후기 작성은 배송 완료일로부터 <b>30일</b> 이내 가능합니다.</li>
                        </ul>
                    </div>
                    <div class="review-tab">
                        <div class="review-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">작성가능 후기 [1]</a></div>
                        <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_after.jsp">작성완료 후기 [0]</a></div>
                        <span></span>
                    </div>
                    <div class="review-content-before">
                        
                        <div class="review-unit">
                            <span class="order-seq">주문번호 1550500008708</span>
                            
                            <div class="review-product-unit">
                                <div><img src="images/order_sample_4.jpg"></div>
                                <div>
                                    <div>[몽상클레르] 팡아라 크렘 파티세리</div>
                                    <div>1개 구매</div>
                                </div>
                                <div>2월20일 배송완료</div>
                                <div><input type="button" value="후기쓰기"></div>
                            </div>
                            
                            <div class="review-product-unit">
                                <div><img src="images/order_sample_4.jpg"></div>
                                <div>
                                    <div>[몽상클레르] 팡오 쇼콜라 크렘</div>
                                    <div>1개 구매</div>
                                </div>
                                <div>2월20일 배송완료</div>
                                <div><input type="button" value="후기쓰기"></div>
                            </div>
                            
                            <div class="review-product-unit">
                                <div><img src="images/order_sample_5.jpg"></div>
                                <div>
                                    <div>[테라오카] 계란에 뿌려먹는 간장</div>
                                    <div>1개 구매</div>
                                </div>
                                <div>2월20일 배송완료</div>
                                <div><input type="button" value="후기쓰기"></div>
                            </div>
                        </div>

                        <div class="review-unit">
                            <span class="order-seq">주문번호 1550328316414</span>
                            <div class="review-product-unit">
                                <div><img src="images/order_sample_2.jpg"></div>
                                <div>
                                    <div>멕시코 생 라임</div>
                                    <div>1개 구매</div>
                                </div>
                                <div>2월18일 배송완료</div>
                                <div><input type="button" value="후기쓰기"></div>
                            </div>
                            <div class="review-product-unit">
                                <div><img src="images/order_sample_3.jpg"></div>
                                <div>
                                    <div>[우드앤브릭] 빵콩플레</div>
                                    <div>1개 구매</div>
                                </div>
                                <div>2월18일 배송완료</div>
                                <div><input type="button" value="후기쓰기"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>