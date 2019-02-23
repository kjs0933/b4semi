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
            align-items: center;
            justify-content: center;
        }

        .coupon-table{border-bottom: 1px solid #ccc;}

        .coupon-table-cols > div:nth-of-type(1){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(2){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(3){flex: 1 1 0;}
        .coupon-table-cols > div:nth-of-type(4){flex: 1 1 0;}
    
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
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_mileage.jsp">적립금</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_coupon.jsp">쿠폰</a></div>
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
                        <span>사용가능쿠폰: 0 장</span>
                    </div>
                    <div class="coupon-table">
                        <div class="coupon-table-header">
                            <div>쿠폰명</div>
                            <div>기능</div>
                            <div>사용가능기간</div>
                            <div>사용가능여부</div>
                        </div>
                        <div class="coupon-table-cols">
                            <div>생일쿠폰</div>
                            <div>10%할인</div>
                            <div>2019-02-01 ~ 2019-02-28</div>
                            <div>가능</div>
                        </div>
                    </div>
                    <div class="pagebar">
                        <div><img src="images/board-arrow-left.png"></div>
                        <div>1</div>
                        <div>2</div>
                        <div>3</div>
                        <div>4</div>
                        <div>5</div>
                        <div><img src="images/board-arrow-right.png"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>