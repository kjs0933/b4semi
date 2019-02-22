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


        .mypage-orderlist-detail-wrapper
        {
            font-family: 'Noto Sans KR';
            width:1024px;
        }

        .mypage-orderlist-detail-title
        {
            font-size: 25px;
            margin: 25px 0;
            font-weight: bold;
        }

        .order-seq
        {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding-bottom: 10px;
        }

        .order-seq > p
        {
            margin: 0;
            font-size: 20px;
            font-weight: bold;
        }

        .order-seq > span{font-size: 14px;}

        .order-seq a
        {
            text-decoration: none;
            color: rgb(47, 131, 208);
        }

        .order-table
        {
            display: flex;
            flex-flow: column nowrap;
            border-top: 2px solid rgb(38, 85, 139);
        }

        .order-table-cols
        {
            display: flex;
            height: 130px;
        }

        .order-table-cols img
        {
            width: 100%;
            height: 100%;
        }

        .order-table-cols > div
        {
            display: flex;
            flex-flow: column;
            align-items: flex-start;
            justify-content: space-evenly;
            padding: 15px 15px;
            border-bottom: 1px solid #ccc;
        }

        .order-table-cols > div:nth-of-type(1){width: 78px;}
        .order-table-cols > div:nth-of-type(2){flex: 4 1 0;}
        .order-table-cols > div:nth-of-type(3){flex: 1 1 0;}
        .order-table-cols > div:nth-of-type(4){flex: 1 1 0;align-items: center; justify-content: space-between;}


        .order-table-cols > div:nth-of-type(2) > div:last-of-type{font-size: 13px;}
        .order-table-cols > div:nth-of-type(2) > div span{font-size: 16px; font-weight: bold;}

        .order-table-cols input
        {
            border: none;
            width: 100px;
            height: 40%;
            text-align: center;
            font-family: 'Noto Sans KR';
            background-color: rgb(38, 85, 139);
            color: white;
        }

        .order-table-cols input:last-of-type
        {
            border: 1px solid #ccc;
            background-color: transparent;
            color: black;
        }


        .payment-info-header
        {
            font-size: 20px;
            margin: 25px 0;
            font-weight: bold;
        }

        .payment-info-table
        {
            border-top: 2px solid rgb(38, 85, 139);
            padding: 10px 0;
            font-size: 14px;
            border-bottom: 1px solid #ccc;
        
        }

        .payment-info-cols
        {
            display: flex;
        }


        .payment-info-cols > span
        {
            padding: 15px 10px;
        }

        .payment-info-cols > span:nth-of-type(1){flex: 1 1 0;}
        .payment-info-cols > span:nth-of-type(2){flex: 4 1 0;}
        

        .order-info
        {
            display: flex;
            flex-flow: column nowrap;
        }

        .order-info-header
        {
            font-size: 20px;
            font-weight: bold;
            padding: 20px 0;
        }

        .order-info-table
        {
            border-top: 2px solid rgb(38, 85, 139);
            font-size: 14px;
            padding: 10px 0;
            border-bottom: 1px solid #ccc;
        }

        .order-info-cols
        {
            display: flex;
        }

        .order-info-cols > span:nth-of-type(1){flex: 1 1 0;}
        .order-info-cols > span:nth-of-type(2){flex: 4 1 0;}


        .order-info-cols > span
        {
            padding: 15px 10px;
        }

        .shipment-info
        {
            display: flex;
            flex-flow: column nowrap;
        }

        .shipment-info-header
        {
            font-size: 20px;
            font-weight: bold;
            padding: 20px 0;
        }

        .shipment-info-table
        {
            border-top: 2px solid rgb(38, 85, 139);
            font-size: 14px;
            padding: 10px 0;

            border-bottom: 1px solid #ccc;
        }

        .shipment-info-cols
        {
            display: flex;
        }

        .shipment-info-cols > span:nth-of-type(1){flex: 1 1 0;}
        .shipment-info-cols > span:nth-of-type(2){flex: 4 1 0;}


        .shipment-info-cols > span
        {
            padding: 15px 10px;
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
                <div><a href="mypage_orderlist.html">주문내역</a></div>
                <div class="mypage-tab-current"><a href="mypage_review_before.html">상품후기</a></div>
                <div><a href="mypage_mileage.html">적립금</a></div>
                <div><a href="mypage_coupon.html">쿠폰</a></div>
                <div><a href="mypage_memberupdate.html">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-orderlist-detail-wrapper">
                    <div class="mypage-orderlist-detail-title">
                        주문 내역 상세
                    </div>
                    <div class="order-seq">
                        <p>주문번호 1550328316414</p>
                        <span>배송또는 상품에 문제가 있나요? <a href="#">1대1 문의</a></span>
                    </div>
                    <div class="order-table">
                        <div class="order-table-cols">
                            <div><img src="images/order_sample_1.jpg"></div>
                            <div>
                                <div><b>[갈바니나] 자몽소다수 355ml</b></div>
                                <div><span>3,800 원</span> 1개</div>
                            </div>
                            <div>배송완료</div>
                            <div>
                                <input type="text" value="후기 작성">
                                <input type="text" value="장바구니 담기">
                            </div>
                        </div>
                        <div class="order-table-cols">
                            <div><img src="images/order_sample_2.jpg"></div>
                            <div>
                                <div><b>멕시코 생 라임</b></div>
                                <div><span>1,300 원</span> 1개</div>
                            </div>
                            <div>배송완료</div>
                            <div>
                                <input type="text" value="후기 작성">
                                <input type="text" value="장바구니 담기">
                            </div>
                        </div>
                        <div class="order-table-cols">
                            <div><img src="images/order_sample_3.jpg"></div>
                            <div>
                                <div><b>[우드앤브릭] 빵콩플레</b></div>
                                <div><span>4,500원</span> 1개</div>
                            </div>
                            <div>배송완료</div>
                            <div>
                                <input type="text" value="후기 작성">
                                <input type="text" value="장바구니 담기">
                            </div>
                        </div>
                    </div>
                    
                    <div class="payment-info">
                        <div class="payment-info-header">
                            	결제 정보
                        </div>
                        <div class="payment-info-table">
                            <div class="payment-info-cols">
                                <span>총 주문 금액</span>
                                <span>9,600 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>상품할인</span>
                                <span>-570 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>쿠폰할인</span>
                                <span>0 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>적립금 사용</span>
                                <span>0 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>배송비</span>
                                <span>0 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>결제금액</span>
                                <span>9,030 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>적립금액</span>
                                <span>452 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>결제수단</span>
                                <span>신용카드</span>
                            </div>
                        </div>
                    </div>

                    <div class="order-info">
                        <div class="order-info-header">
                            	주문 정보
                        </div>
                        <div class="order-info-table">
                            <div class="order-info-cols">
                                <span>주문 번호</span>
                                <span>1550328316414</span>
                            </div>
                            <div class="order-info-cols">
                                <span>주문자 명</span>
                                <span>정우진</span>
                            </div>
                            <div class="order-info-cols">
                                <span>보내는 분</span>
                                <span>정우진</span>
                            </div>
                            <div class="order-info-cols">
                                <span>결제 시간</span>
                                <span>2019-02-17 00:17:15</span>
                            </div>
                            <div class="order-info-cols">
                                <span>주문 처리 상태</span>
                                <span>배송완료</span>
                            </div>
                        </div>
                    </div>

                    <div class="shipment-info">
                        <div class="shipment-info-header">
                            	배송 정보
                        </div>
                        <div class="shipment-info-table">
                            <div class="shipment-info-cols">
                                <span>받는분</span>
                                <span>정우진</span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>받는 분 핸드폰</span>
                                <span>010-5069-4404</span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>우편번호</span>
                                <span>16235 (442-819)</span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>배송방법</span>
                                <span>샛별 배송</span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>주소</span>
                                <span>경기 수원시 팔달구</span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>배송 요청사항</span>
                                <span>문앞에 놓고 가주세요.</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp" %>