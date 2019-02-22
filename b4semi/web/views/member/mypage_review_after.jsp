<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
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
            font-size: 14px;
            margin-top: 100px;
        }

        .mypage-review-wrapper input
        {
            cursor: pointer;
        }

        .mypage-review-title > ul
        {
            list-style: square;
            margin: 0;
            padding-left: 19px;
            font-size: 13px;
        }
        
        .review-tab
        {
            position: relative;
            display: flex;
            margin-top: 30px;
            cursor: pointer;
        }

        .review-tab > div
        {
            flex: 1 1 0;
            display: flex;
            align-items: center;
            justify-content: center;
            border: 1px solid #ccc;
            padding: 16px;
        }

        .review-tab > div:last-of-type{border-left: none;}

        .review-tab > span
        {
            display: block;
            position: absolute;
            left: 50%;
            bottom: 0;
            width: 50%;
            height: 2px;
            background-color: rgb(38, 85, 139);
        }


        .written-review-unit
        {
            width: 100%;
            display: flex;
            flex-flow: column;
            border-bottom: 1px solid #ccc;
        }
        
        .written-review-header
        {
            display: flex;
            justify-content: space-between;
            border-top: 1px solid #ccc;   
        }

        .written-review-header > div{padding: 20px 25px;}

        .review-product-name{padding: 20px 25px; font-weight: bold;}

        .written-review-content{padding: 20px 25px;}

        .written-review-footer{display: flex;justify-content:flex-end; padding: 0 20px 20px 20px;}

        .written-review-footer input
        {
            background-color: white;
            border: 1px solid #ccc;
            width: 70px;
            height: 40px;
            font-family: 'Noto Sans KR';
            margin: 5px;
        }

        .written-review-date
        {
            color: gray;
            font-size: 13px;
        }

    </style>
    <section>
        <div class="mypage-wrapper">
            <div class="mypage-header">
                <div class="mypage-title">마이페이지</div>
                <div class="my-account-info">
                    <div>
                        <img src="images/member_grade_diamond.png">
                        <p>다이아</p>
                    </div>
                    <span></span>
                    <div>
                        <p><span>정우진</span> 님</p>
                        <p>적립 9%</p>
                        <p>무료배송</p>
                    </div>
                    <span></span>
                    <div>
                        <p>적립금</p>
                        <a href="#">0 원</a>
                    </div>
                    <span></span>
                    <div>
                        <p>쿠폰</p>
                        <a href="#">0 개</a>
                    </div>
                </div>
            </div>
            <div class="mypage-tab">
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_orderlist.jsp">주문내역</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_mileage.jsp">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_coupon.jsp">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-review-wrapper">
                    <div class="mypage-review-title">
                        <h2>상품후기</h2>    
                        <ul>
                            <li>포토 리뷰는 <b>100원</b> 텍스트 리뷰는 <b>50원</b>을 적립해 드립니다.</li>
                            <li>플래티넘·다이아몬드는 <b>2배</b> 적립 (사진 200원, 글 100원)</li>
                            <li>주간 베스트 후기로 선정 시 <b>5,000원</b> 추가 적립</li>
                            <li>후기 작성은 배송 완료일로부터 <b>30일</b> 이내 가능합니다.</li>
                        </ul>
                    </div>
                    <div class="review-tab">
                        <div class="review-tab-current">작성가능 후기 [1]</div>
                        <div>작성완료 후기 [0]</div>
                        <span></span>
                    </div>
                    <div class="review-content-after">
                        <div class="written-review-unit">
                            <div class="review-product-name">
                                [몽상클레르] 팡오 쇼콜라 크렘
                            </div>
                            <div class="written-review-header">
                                <div class="written-review-title">
                                    <b>잘 먹었습니다.</b>
                                </div>
                                <div class="written-review-date">19.02.21 작성</div>
                            </div>
                            <div class="written-review-content">
                               	 먹을 만 합니다. 진하네요.
                            </div>
                            <div class="written-review-footer">
                                <input type="button" value="삭제">
                                <input type="button" value="수정">
                            </div>
                        </div>
                    </div>
                    <div class="review-content-after">
                        <div class="written-review-unit">
                            <div class="review-product-name">
                                [갈바니나] 자몽소다수355ml
                            </div>
                            <div class="written-review-header">
                                <div class="written-review-title">
                                    <b>맛있습니다.</b>
                                </div>
                                <div class="written-review-date">
                                    19.02.18 작성
                                </div>
                            </div>
                            <div class="written-review-content">
                                	많이 달지 않고 신맛이 꽤 납니다.
                            </div>
                            <div class="written-review-footer">
                                <input type="button" value="삭제">
                                <input type="button" value="수정">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>