<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.b4.model.vo.Cart"%>
<%@ page import="com.b4.model.vo.Member"%>
<%@ page import="com.b4.model.vo.MemberGrade"%>
<%@ page import="com.b4.model.vo.AddressList"%>
<%@ page import="com.b4.model.vo.IssuedCoupon"%>

<%
	ArrayList<Cart> clist;
	try {
		clist = (ArrayList<Cart>)request.getAttribute("clist");
		if(clist == null)
		{
			clist=new ArrayList<Cart>();
		}
	} catch (ClassCastException e) {
		clist=new ArrayList<Cart>();
	}
	ArrayList<AddressList> alist;
	try {
		alist = (ArrayList<AddressList>)request.getAttribute("alist");
		if(alist == null)
		{
			alist=new ArrayList<AddressList>();
		}
	} catch (ClassCastException e) {
		alist=new ArrayList<AddressList>();
	}
	ArrayList<IssuedCoupon> ilist;
	try {
		ilist = (ArrayList<IssuedCoupon>)request.getAttribute("ilist");
		if(ilist == null)
		{
			ilist=new ArrayList<IssuedCoupon>();
		}
	} catch (ClassCastException e) {
		ilist=new ArrayList<IssuedCoupon>();
	}
	Member m; 
	try {
		m = (Member)session.getAttribute("loginMember");
		if(m == null)
		{
			m=new Member();
		}
	} catch (ClassCastException e) {
		m=new Member();
	}
	MemberGrade grade; 
	try {
		grade = (MemberGrade)request.getAttribute("grade");
		if(grade == null)
		{
			grade=new MemberGrade();
		}
	} catch (ClassCastException e) {
		grade=new MemberGrade();
	}
	int totalPrice=0;
	int totalDiscount=0;
	int ship;
	for(int i=0; i< clist.size();i++)
	{
		Cart cart = clist.get(i);
		totalPrice+=cart.getProductCount()*cart.getDisplayOptionPrice();
		totalDiscount+=cart.getProductCount()*(cart.getDisplayOptionPrice()-cart.getDiscountOptionPrice());
	}
	if(totalPrice-totalDiscount < 30000)
	{
		ship = 2500;
	}
	else
	{
		ship = 0;
	}
	int couponCount=0;
	for(int i=0;i<ilist.size();i++)
	{
		if(totalPrice - totalDiscount >= ilist.get(i).getMinPrice())
		{
			couponCount++;
		}
	}
			
%>
<style>
    .orderlist-pre-wrapper input {
        padding: 0 5px;
        font-size: 13px;
        font-family: 'Noto Sans KR';


    }

    .orderlist-pre-wrapper input[type="button"] {
        cursor: pointer;
    }

    .orderlist-pre-wrapper {
        width: 1024px;
        display: flex;
        flex-flow: column;
        align-items: center;
        font-family: 'Noto Sans KR';
    }


    .orderlist-pre-header {
        display: flex;
        flex-flow: column nowrap;
        align-items: center;
        color: rgb(38, 85, 139);
    }

    .orderlist-pre-header>h1 {
        font-size: 35px;
        margin: 25px 0;
    }

    .orderlist-pre-header>span {
        font-size: 15px;
        color: black;
    }



    .products-info-title {
        align-self: flex-start;
        font-size: 21px;
        margin: 25px 0;
    }

    .products-info-table {
        width: 1024px;
        display: flex;
        flex-flow: column nowrap;
        border-top: 2px solid rgb(38, 85, 139);
        border-bottom: 1px solid #ccc;

    }

    .products-info-header {
        display: flex;
        font-size: 15px;
    }

    .products-info-header>div {
        display: flex;
        justify-content: center;
        padding: 15px 0;
    }

    .products-info-header>div:nth-of-type(1) {
        width: 76px;
    }

    .products-info-header>div:nth-of-type(2) {
        flex: 4 1 0;
        padding-left: 10px;
    }

    .products-info-header>div:nth-of-type(3) {
        flex: 1 1 0;
        justify-content: flex-start
    }

    .products-info-cols {
        display: flex;
        height: 130px;
    }

    .products-info-cols>div {
        display: flex;
        flex-flow: column nowrap;
        align-items: flex-start;
        justify-content: center;
        padding: 15px;
        border-top: 1px solid #ccc;
    }

    .products-info-cols>div>span {
        font-size: 13px;
    }

    .products-info-cols img {
        width: 100%;
        height: 100%;
    }

    .products-info-cols>div:nth-of-type(1) {
        width: 76px;
    }

    .products-info-cols>div:nth-of-type(2) {
        flex: 4 1 0;
        justify-content: space-evenly;
    }

    .products-info-cols>div:nth-of-type(3) {
        flex: 1 1 0;
    }

    .buyer-info-title {
        align-self: flex-start;
        font-size: 21px;
        margin: 25px 0;
    }

    .buyer-info-table {
        width: 100%;
        border-top: 2px solid rgb(38, 85, 139);
        border-bottom: 1px solid #ccc;
        font-size: 15px;
        padding: 10px 0;
    }

    .buyer-info-cols {
        display: flex;
    }

    .buyer-info-cols>div {
        display: flex;
        padding: 15px;
    }

    .buyer-info-cols>div:nth-of-type(1) {
        flex: 2 1 0;
    }

    .buyer-info-cols>div:nth-of-type(2) {
        flex: 6 1 0;
    }


    .shipment-info-title {
        font-size: 21px;
        margin: 25px 0;
        align-self: flex-start;
    }

    .select-ship-destination {
        width: 100%;
        padding: 15px 0;
        border-top: 2px solid rgb(38, 85, 139);
        display: flex;
        align-items: center;
    }

    .select-ship-destination>div {
        padding: 10px;
        display: flex;
    }

    .select-ship-destination>div:nth-of-type(1) {
        flex: 1 1 0;
    }

    .select-ship-destination>div:nth-of-type(2) {
        flex: 5 1 0;
    }

    .select-ship-destination>div input {
        width: 150px;
        height: 40px;
        background-color: white;
        border: 1px solid rgb(38, 85, 139);
    }

    .select-ship-destination input {
        margin: 0 10px 0 1px;
    }


    .shipment-info-table {
        width: 100%;
        border-top: 2px solid rgb(38, 85, 139);
        border-bottom: 1px solid #ccc;
        padding: 10px 0;
        font-size: 15px;
    }

    .shipment-info-table input {
        height: 25px;
    }


    .shipment-info-cols {
        display: flex;

    }

    .shipment-info-cols>div {
        padding: 15px 10px;
        display: flex;
        justify-content: center;
    }

    .shipment-info-cols:nth-of-type(1) input {
        width: 176px;
    }

    .shipment-info-cols:nth-of-type(2) input {
        width: 535px;
        margin: 10px 0;
    }

    .shipment-info-cols:nth-of-type(3) input {
        width: 176px;
    }



    .phone-info-container input {
        width: 175px;
    }

    .shipment-info-cols textarea {
        max-width: 550px;
        resize: none;
        font-family: 'Noto Sans KR';
        padding: 5px;
    }


    .shipment-info-cols>div {
        display: flex;
        flex-flow: column nowrap;
    }

    .shipment-info-cols>div:nth-of-type(1) {
        flex: 1 1 0;
    }

    .shipment-info-cols>div:nth-of-type(2) {
        flex: 5 1 0;
        justify-self: flex-start;
    }

    .coupon-mileage-price-wrapper {
        width: 100%;
        height: 400px;
        display: flex;
        font-size: 15px;
    }

    .coupon-mileage-price-wrapper>div:nth-of-type(1) {
        flex: 9 1 0;
    }

    .coupon-mileage-price-wrapper>div:nth-of-type(2) {
        flex: 3 1 0;
    }


    .coupon-mileage-wrapper {
        display: flex;
        flex-flow: column nowrap;
    }

    .coupon-mileage-title {
        font-size: 21px;
        margin: 25px 0;
    }

    .coupon-mileage-table {
        border-top: 2px solid rgb(38, 85, 139);

    }

    .coupon-mileage-cols {
        display: flex;
        border-bottom: 1px solid #ccc;
    }

    .coupon-mileage-cols:nth-of-type(1) {
        height: 211px;
    }

    .coupon-mileage-cols:nth-of-type(2) {
        height: 104px;
    }

    .coupon-mileage-cols>div {
        display: flex;
        padding: 25px 10px;
    }

    .coupon-mileage-cols>div:nth-of-type(1) {
        flex: 2 1 0;
    }

    .coupon-mileage-cols>div:nth-of-type(2) {
        flex: 5 1 0;
        display: flex;
        flex-flow: column nowrap
    }

    .coupon-mileage-cols>div:nth-of-type(2)>select {
        width: 50%;
        height: 35px;
        border: 1px solid #ccc;
        font-family: 'Noto Sans KR';
    }

    .coupon-mileage-cols>div:nth-of-type(2)>input {
        width: 50%;
        height: 35px;
        border: 1px solid #ccc;
    }

    .coupon-mileage-cols>div:nth-of-type(2)>input:focus {
        outline: none;
    }

    .coupon-mileage-cols>div:nth-of-type(2)>span {
        font-size: 13px;
        margin: 5px 0;
    }

    .final-price-wrapper {
        margin-left: 25px;
        border-bottom: 1px solid #ccc;
        font-size: 15px;
    }

    .final-price-title {
        font-size: 21px;
        margin: 25px 0;
    }

    .final-price-table {
        border-top: 2px solid rgb(38, 85, 139);
        position: relative;
    }

    .final-price-cols {
        display: flex;
        justify-content: space-between;
        padding: 5px 10px;
    }

    .final-price-cols>div {
        display: flex;
        align-items: center;
    }

    .final-price-cols:first-of-type {
        border-bottom: 1px solid #ccc;
        padding: 20px 10px;
        margin-bottom: 10px;
    }

    .final-price-cols:nth-of-type(6) {
        border-top: 1px solid #ccc;
        padding: 20px 10px;
        margin-top: 10px;
    }

    .final-price-cols:last-of-type {
        position: absolute;
        right: 0;
        padding: 0 10px 0 0;
        font-size: 12px;
        margin-top: -5px
    }

    #final-price {
        font-size: 21px;
        color: rgb(38, 85, 139);
    }

    .payment-method-title {
        width: 100%;
        align-self: flex-start;
        font-size: 21px;
        margin: 25px 0;
    }

    .payment-method-table {
        width: 100%;
        border-top: 2px solid rgb(38, 85, 139);
        border-bottom: 1px solid #ccc;
        display: flex;
        flex-flow: column nowrap;
        padding: 10px 0;
        font-size: 15px;
    }

    .payment-method-cols {
        display: flex;
    }

    .payment-method-cols>div {
        display: flex;
        padding: 15px 10px;
    }

    .payment-method-cols>div:nth-of-type(1) {
        flex: 2 1 0;
    }

    .payment-method-cols>div:nth-of-type(2) {
        flex: 7 1 0;
    }

    .payment-method-cols label {
        margin: 0 10px;
    }


    .orderlist-pre-wrapper>input {
        width: 180px;
        height: 50px;
        background-color: rgb(38, 85, 139);
        border: none;
        color: white;
        margin: 80px 0 50px 0;
    }


    /* 배송지 목록 CSS */

    .search-address {
        position: fixed;
        top: 20%;
        left: 50%;
        transform: translateX(-50%);
        display: none;

        width: 850px;
        height: 550px;
        border: 1px solid black;
        font-size: 12px;
        background-color: white;

        font-family: 'Noto Sans KR';
    }

    .search-address-content {
        display: flex;
        flex-flow: column nowrap;
        justify-content: center;
    }

    .content-comment {
        font-size: 15px;
        display: flex;
        padding: 20px 0;
    }

    .search-address-header {
        width: 100%;
        height: 50px;
        background-color: rgb(49, 49, 49);
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        position: relative;
    }

    .close {
        position: absolute;
        top: 0;
        right: 0;
        font-size: 2.5rem;
        font-weight: lighter;
        line-height: 1;
        color: white;
        text-shadow: 0 1px 0 #fff;
        opacity: .6;
        width: 50px;
        height: 50px;
    }

    .close:focus,
    .close:hover {
        color: white;
        text-decoration: none;
        cursor: pointer;
        opacity: .9;
        outline: none;
    }

    button.close {
        padding: 0;
        cursor: pointer;
        background: transparent;
        border: 0;
        -webkit-appearance: none;
    }

    .search-address-content {
        margin: 20px;
    }

    .address-unit {
        display: flex;
        flex-flow: column nowrap;
    }

    .address-header {
        display: flex;
        border-top: 1px solid black;
        border-bottom: 1px solid black;
    }

    .address-header>div {
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 15px;
    }

    .address-header>div:nth-of-type(1) {
        flex: 2 1 0;
    }

    .address-header>div:nth-of-type(2) {
        flex: 14 1 0;
    }

    .address-header>div:nth-of-type(3) {
        flex: 2 1 0;
    }

    .address-header>div:nth-of-type(4) {
        flex: 3 1 0;
    }

    .address-header>div:nth-of-type(5) {
        flex: 1 1 0;
    }

    .address-cols {
        display: flex;
    }

    .address-cols>div {
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 12px 15px;
        border-bottom: 1px solid #eee;
    }

    .address-cols>div:nth-of-type(1) {
        flex: 2 1 0;
    }

    .address-cols>div:nth-of-type(2) {
        flex: 14 1 0;
    }

    .address-cols>div:nth-of-type(3) {
        flex: 2 1 0;
    }

    .address-cols>div:nth-of-type(4) {
        flex: 3 1 0;
    }

    .address-cols>div:nth-of-type(5) {
        flex: 1 1 0;
    }

    .pagebar img {
        width: 40%;
        height: 40%;
    }

    .pagebar {
        display: flex;
        align-self: center;
        margin: 40px;
        font-size: 12px;
    }

    .pagebar div {
        width: 33px;
        height: 33px;
        border: 1px solid rgb(220, 220, 220);
        border-left: none;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
    }

    .pagebar div:first-of-type {
        border-left: 1px solid rgb(220, 220, 220);
    }

    .pagebar a {
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
    <form action="#" method="post" id="payment-frm" autocomplete="off">
        <div class="orderlist-pre-wrapper">
        	<div>
        			<input type="hidden" name="totalPrice" value="<%=totalPrice-totalDiscount%>" >
        			<input type="hidden" name="shipmentFee" value="<%=ship%>" >
        			<input type="hidden" name="CouponSeq" value="" >
        		<%for(int i=0;i<ilist.size();i++){ %>
                    <input type="hidden" id="ilist<%=i+1%>" value="<%=i+1%>" data-cseq="<%=ilist.get(i).getCouponSeq()%>" data-cmin"<%=ilist.get(i).getMinPrice()%>" data-cmax"<%=ilist.get(i).getMaxDisPrice()%>" data-crate="<%=ilist.get(i).getDiscountRate()%>"
                     data-discount="<%=(totalPrice- totalDiscount >= ilist.get(i).getMinPrice())?(int)(Math.min(ilist.get(i).getMaxDisPrice(),(totalPrice-totalDiscount)*ilist.get(i).getDiscountRate())/10)*10 : 0%>">
                <%}%>
        	</div>
            <div class="orderlist-pre-header">
                <h1>주문서</h1>
                <span>주문하실 상품명 및 수량을 정확하게 확인해 주세요</span>
            </div>
            <div class="products-info-title">
                상품 정보
            </div>
            <div class="products-info-table">
                <div class="products-info-header">
                    <div></div>
                    <div>상품 정보</div>
                    <div>상품 금액</div>
                </div>
                <%for(int i=0; i<clist.size(); i++){%>
                <div class="products-info-cols">
                    <div><img src="<%=request.getContextPath()%>/upload/product/<%=clist.get(i).getImg()%>"></div>
                    <div>
                        <div><b><%=clist.get(i).getDisplayListTitle()%></b> (옵션 - <%=clist.get(i).getProductName()%>)<%=clist.get(i).getDiscountName()==null?"":" : "+clist.get(i).getDiscountName()+" 적용"%></div>
                        <span><%=clist.get(i).getProductCount()%>개 / <%=clist.get(i).getProductUnit()%>당  <%=clist.get(i).getDiscountOptionPrice()%>원</span>
                    </div>
                    <%if(clist.get(i).getDiscountRate()>0){%>
                    <div><del><%=clist.get(i).getProductCount()*clist.get(i).getDisplayOptionPrice()%> 원</del> → <%=clist.get(i).getProductCount()*clist.get(i).getDiscountOptionPrice()%> 원</div>
                    <% }else{%>
                    <div><%=clist.get(i).getProductCount()*clist.get(i).getDiscountOptionPrice()%> 원</div>
                    <%} %>
                </div>
                <%}%>
            </div>

            <div class="buyer-info-title">
                주문자 정보
            </div>
            <div class="buyer-info-table">
                <div class="buyer-info-cols">
                    <div>보내는 분</div>
                    <div><%=m.getMemberName()%></div>
                </div>
                <div class="buyer-info-cols">
                    <div>휴대폰</div>
                    <div><%=m.getMemberPhone()%></div>
                </div>
                <div class="buyer-info-cols">
                    <div>이메일</div>
                    <div><%=m.getMemberEmail()%></div>
                </div>
            </div>


            <div class="shipment-info-title">
                배송 정보
            </div>
            <div class="select-ship-destination">
                <div>배송지 선택</div>
                <div>
                    <input id="address-api-open-btn" type="button" value="주소 검색">
                    <input id="search-address-open-btn" type="button" value="배송지 목록">
                    <input id="add-address-open-btn" type="button" value="배송지 추가">
                </div>
            </div>
            <div class="shipment-info-table">
                <div class="shipment-info-cols">
                    <div>배송지</div>
                    <div><input type="text" id="address-tag"></div>
                </div>
                <div class="shipment-info-cols">
                    <div>주소</div>
                    <div>
                        <input type="text" name="receiverAddress" id="address">
                    </div>
                </div>
                <div class="shipment-info-cols">
                    <div>수령인</div>
                    <div><input type="text" name="receiverName" id="receiver-name"></div>
                </div>
                <div class="shipment-info-cols">
                    <div>휴대전화</div>
                    <div class="phone-info-container">
                        <input type="text" name="receiverPhone" id="address-phone">
                    </div>
                </div>
                <div class="shipment-info-cols">
                    <div>배송 요청사항</div>
                    <div>
                        <textarea name="receiverComment" rows="4"></textarea>
                    </div>
                </div>
            </div>

            <div class="coupon-mileage-price-wrapper">
                <div class="coupon-mileage-wrapper">
                    <div class="coupon-mileage-title">
                        쿠폰 / 적립금
                    </div>
                    <div class="coupon-mileage-table">
                        <div class="coupon-mileage-cols">
                            <div>쿠폰 사용</div>
                            <div>
                                <select id="coupon">
                                <option value="0">=== 사용 쿠폰을 선택해주세요 ===</option>
                                <%for(int i=0;i<ilist.size();i++){ %>
                                    <option value="<%=i+1%>"><%=ilist.get(i).getCouponName()%><%=(totalPrice- totalDiscount >= ilist.get(i).getMinPrice())? " ("+(int)(Math.min(ilist.get(i).getMaxDisPrice(),(totalPrice-totalDiscount)*ilist.get(i).getDiscountRate())/10)*10+"원 할인가능)" : " (최소금액 미달)"%></option>
                                <%}%>
                                </select>
                                <span id="coupon-min">사용 가능 쿠폰 : <%=couponCount%>개</span>
                                <div id="coupon-rate">최대 10% 할인</div>
                                <div id="coupon-max">할인 적용 상한 : 3000원</div>
                            </div>
                        </div>
                        <div class="coupon-mileage-cols">
                            <div>적립금 사용</div>
                            <div>
                                <input type="text" name="spentMileage" id="spentMileage" value="0" data-memberMileage="<%=m.getMemberMileage()%>">
                                <span>가용 적립금: <%=m.getMemberMileage()%></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="final-price-wrapper">
                    <div class="final-price-title">
                        결제 금액
                    </div>
                    <div class="final-price-table">
                        <div class="final-price-cols">
                            <div>상품 금액</div>
                            <div><%=totalPrice%> 원</div>
                        </div>
                        <div class="final-price-cols">
                            <div>상품 할인 금액</div>
                            <div><%=totalDiscount*(-1)%> 원</div>
                        </div>
                        <div class="final-price-cols">
                            <div>배송비</div>
                            <div>+<%=ship%> 원</div>
                        </div>
                        <div class="final-price-cols">
                            <div>쿠폰 사용</div>
                            <div id="result-coupon">0 원</div>
                        </div>
                        <div class="final-price-cols">
                            <div>적립금 사용</div>
                            <div id="result-mileage">0 원</div>
                        </div>
                        <div class="final-price-cols">
                            <div>최종결제금액</div>
                            <div id="result-final"><%=totalPrice-totalDiscount+ship%> 원</div>
                        </div>
                        <div class="final-price-cols">구매 시 <%=(int)((totalPrice-totalDiscount)*grade.getGradeRate())%> 원(<%=grade.getGradeRate()*100%>%) 적립 예정</div>
                    </div>
                </div>
            </div>
            <div class="payment-method-title">
                결제 수단
            </div>
            <div class="payment-method-table">
                <div class="payment-method-cols payment-method-selection">
                    <div>
                        일반결제
                    </div>
                    <div>
                        <label><input type="radio" name="paymentMethod" id="payment-method-credit"
                                value="creidt">신용카드</label>
                        <label><input type="radio" name="paymentMethod" id="payment-method-phone"
                                value="phone">휴대전화</label>
                    </div>
                </div>
                <div class="payment-method-cols payment-method-refund-method">
                    <div>
                        미출고 시 조치 방법
                    </div>
                    <div>
                        <label><input type="radio" name="refundMethod" id="refund-method-same" value="same">결제수단으로
                            환불</label>
                        <label><input type="radio" name="refundMethod" id="refund-method-wait-instock"
                                value="waitInstock">상품 입고시 배송</label>
                    </div>
                </div>
            </div>
            <input type="button" value="결제하기">
        </div>
    </form>


    <!-- 배송지 목록 클릭시 출력되는 되는 부분 -->

    <div class="search-address">
        <div class="search-address-header">
            <div>배송지 조회</div>
            <button id="search-address-close-btn" type="button" class="close" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="search-address-content">
            <span class="content-comment">· 배송지를 선택하세요.</span>
            <div class="address-header">
                <div>배송지</div>
                <div>주소</div>
                <div>수령인</div>
                <div>연락처</div>
                <div>선택</div>
            </div>
            <%for(int i=0; i<alist.size(); i++){%>
            <div class="address-cols">
                <div class="address-tag">
             <%=alist.get(i).getAddressTag()%>
                </div>
                <div class="address">
             <%=alist.get(i).getAddress()%>
                </div>
                <div class="receiver-name">
             <%=alist.get(i).getReceiverName()%>
                </div>
                <div class="address-phone">
             <%=alist.get(i).getAddressPhone()%>
                </div>
                <div class="address-radio">
                    <input
                        data-address='{"addressTag":"<%=alist.get(i).getAddressTag()%>", "address":"<%=alist.get(i).getAddress()%>", "receiver": "<%=alist.get(i).getReceiverName()%>", "addressPhone": "<%=alist.get(i).getAddressPhone()%>"}'
                        type="radio" name="address" class="address-pick">
                </div>
            </div>
            <%} %>

 <!--            <div class="pagebar">
                <div><a href="#"><img src="images/board-arrow-left.png"></a></div>
                <div><a href="#">1</a></div>
                <div><a href="#">2</a></div>
                <div><a href="#">3</a></div>
                <div><a href="#">4</a></div>
                <div><a href="#">5</a></div>
                <div><a href="#"><img src="images/board-arrow-right.png"></a></div>
            </div> -->
        </div>
        <div>
        </div>
    </div>

    <!-- 배송지 목록 클릭시 출력되는 되는 부분 -->
</section>

<script>

    //배송지 목록 버튼 로직
    const searchAddressBtn = $('#search-address-open-btn');
    const searchAddressWindow = $('.search-address');
    const searchAddressClose = $('#search-address-close-btn');
    $(() => {
        searchAddressBtn.on('click', e => { searchAddressWindow.fadeToggle(150); });
        searchAddressClose.on('click', e => { searchAddressWindow.fadeToggle(150); });
    });

    //배송지 선택시 정보입력

    //본문 내(배송지 조회창 X) 인풋 태그 선택
    const addressTag = $('#address-tag');
    const address = $('#address');
    const receiverName = $('#receiver-name');
    const addressPhone = $('#address-phone');

    const radioEl = $('.address-pick');
    $(() => {
        radioEl.on('click', (e) => {
            addressTag.val($(e.target).data("address").addressTag);
            address.val($(e.target).data("address").address);
            receiverName.val($(e.target).data("address").receiver);
            addressPhone.val($(e.target).data("address").addressPhone)
            searchAddressClose.trigger('click');
        });
    });

</script>

<%@ include file="/views/common/footer.jsp" %>