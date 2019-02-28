<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.MypageHeader, java.util.*, com.b4.model.vo.OrderPDetail, com.b4.model.vo.Cart, com.b4.model.vo.OrderList, static common.DateFormatTemplate.getTillSec" %>

<%
	
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
	
	List<OrderPDetail> opdList = (List<OrderPDetail>)request.getAttribute("opdList");
	List<Cart> cartList = (List<Cart>)request.getAttribute("cartList");

	OrderList orderlist = (OrderList)request.getAttribute("orderList");
	String orderStatus="";
	switch(orderlist.getOrderStatusCode()){
    case "OS01" : orderStatus="결제완료"; break;
    case "OS02" : orderStatus="출고대기"; break;
    case "OS03" : orderStatus="배송중"; break;
    case "OS04" : orderStatus="배송완료"; break;
    case "OS05" : orderStatus="구매확정"; break;
    default : orderStatus="구매확정"; break;
    }
	
	int discountPriceTotal = 0;
	for(int i=0; i<cartList.size(); i++){
		if(cartList.get(i).getDiscountName()!=null){
			discountPriceTotal = (cartList.get(i).getDisplayOptionPrice()-cartList.get(i).getDiscountOptionPrice())*(cartList.get(i).getProductCount());
		}
	}	
	String phone = orderlist.getReceiverPhone().substring(0, 3)+"-"+orderlist.getReceiverPhone().substring(3, 7)+"-"+orderlist.getReceiverPhone().substring(7, 11);
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
        .order-table-cols > div:nth-of-type(4){flex: 1 1 0;}
        .order-table-cols > div:nth-of-type(5){flex: 1 1 0;align-items: center; justify-content: space-between;}


/*         .order-table-cols > div:nth-of-type(2) > div:last-of-type{font-size: 13px;}
       	.order-table-cols > div:nth-of-type(2) > div span{font-size: 16px; font-weight: bold;} */ 

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

 		.product-info
        {
            display: flex;
            flex-flow: column nowrap;
            justify-content: space-between !important;
            align-items: flex-start !important;
        }

        .pd-title{color: gray; font-size: 12px; border-bottom: 1px solid #ccc;}
		.pd-option{font-size: 18px; font-weight: bold;}
        .pd-price {font-size: 16px; color: rgb(42, 71, 114);}

        .pd-option a {text-decoration: none; color: black;}
        .pd-unit {margin-left: 10px; color: gray; font-size: 15px; font-weight: normal;}
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
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_orderlist.jsp">주문내역</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="mypage-orderlist-detail-wrapper">
                    <div class="mypage-orderlist-detail-title">
                        주문 내역 상세
                    </div>
                    <div class="order-seq">
                        <p>주문번호 <%=orderlist.getOrderSeq() %></p>
                        <span>배송또는 상품에 문제가 있나요? <a href="<%=request.getContextPath() %>/queryForm?orderSeq=<%=orderlist.getOrderSeq()%>">1대1 문의</a></span>
                    </div>
                    <div class="order-table">
                        <%if(cartList!=null){
                        	for(int i=0;i<cartList.size();i++){
                        %>
                    <div class="order-table-cols">
                    <div><a href="<%=request.getContextPath()%>/dpdetail?dpseq=<%=cartList.get(i).getDisplayListSeq()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=cartList.get(i).getImg()%>"alt="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';"></a></div>
                    <div class="product-info">     
                    	<div class="pd-title">
                    		<%=cartList.get(i).getDisplayListTitle()%>
                    	</div>
                    	<div class="pd-option">
                    		<a href="<%=request.getContextPath()%>/dpdetail?dpseq=<%=cartList.get(i).getDisplayListSeq()%>"><%=cartList.get(i).getProductName()%></a><span class="pd-unit">수량 : <%=cartList.get(i).getProductCount()%><%=cartList.get(i).getProductUnit()%></span>
                    	</div>
                    	<div class="pd-price">
			            	<%-- <%=cartList.get(i).getDiscountName()==null?"":cartList.get(i).getDiscountName()%> --%>
			            	<% if(cartList.get(i).getDiscountRate()>0){%>     
                    		<del><%=cartList.get(i).getDisplayOptionPrice()%>원</del> → <b><%=cartList.get(i).getDiscountOptionPrice()%>원<%="Y".equals(cartList.get(i).getOptionAvailable())?"":" <품절>"%></b>
                    		<%}else{ %>
			                <%=cartList.get(i).getDisplayOptionPrice()%>원<%="Y".equals(cartList.get(i).getOptionAvailable())?"":" <품절>"%>
			                <%}%>
                    	</div>                    	                   
                    </div>
                    <div><%=(cartList.get(i).getDiscountOptionPrice())*(cartList.get(i).getProductCount()) %>원</div>
                    <div><%=orderStatus%></div>
                            <div>
                                <input type="button" value="후기 작성">
                                <input type="button" onclick="fn_cart_add()" value="장바구니 담기" data-dpseq="<%=cartList.get(i).getDisplayListSeq()%>" data-pcode="<%=cartList.get(i).getProductCode()%>">
                            </div>
                        </div>
                        <%}} %>
	                        <!-- <div class="order-table-cols">
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
                        </div> -->
                    </div>
                    
                    <div class="payment-info">
                        <div class="payment-info-header">
                            	결제 정보
                        </div>
                        <div class="payment-info-table">
                            <div class="payment-info-cols">
                                <span>총 주문 금액</span>
                                <span><%=orderlist.getTotalPrice() %> 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>상품할인</span>
                                <span>-<%=discountPriceTotal %> 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>쿠폰할인</span>
                                <span>0 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>적립금 사용</span>
                                <span><%=orderlist.getSpentMileage() %> 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>배송비</span>
                                <span><%=orderlist.getShipmentFee() %> 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>결제금액</span>
                                <span><%=orderlist.getTotalPrice()-discountPriceTotal+orderlist.getShipmentFee() %> 원</span>
                            </div>
                            <div class="payment-info-cols">
                                <span>적립금액</span>
                                <span><%=(int)((orderlist.getTotalPrice()-discountPriceTotal)*mh.getGradeRate()) %> 원</span>
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
                                <span><%=orderlist.getOrderSeq() %></span>
                            </div>
                            <div class="order-info-cols">
                                <span>주문자 명</span>
                                <span><%=loginMember.getMemberName() %></span>
                            </div>
                            <div class="order-info-cols">
                                <span>보내는 분</span>
                                <span><%=loginMember.getMemberName() %></span>
                            </div>
                            <div class="order-info-cols">
                                <span>결제 시간</span>
                                <span><%=getTillSec(orderlist.getOrderTime()) %></span>
                            </div>
                            <div class="order-info-cols">
                                <span>주문 처리 상태</span>
                                <span><%=orderStatus %></span>
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
                                <span><%=orderlist.getReceiverName() %></span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>받는 분 핸드폰</span>
                                <span><%=phone %></span>
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
                                <span><%=orderlist.getReceiverAddress() %></span>
                            </div>
                            <div class="shipment-info-cols">
                                <span>배송 요청사항</span>
                                <span><%=orderlist.getReceiverComment() %></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<script>
	function fn_cart_add() {
		var dpseq = ($(event.target).data("dpseq"));
		var pcode = ($(event.target).data("pcode"));
		$.ajax({
			url:"<%=request.getContextPath()%>/cartAdd.do",
			type:"post",
			data:{"dpseq":dpseq,"pcode":pcode},
			success:function(data){
					alert("상품을 장바구니에 담았습니다. 해당상품 "+data[1]+"개, 총 " + data[0] +" 종류");
			}
		});
		
	}
	
	</script>
<%@ include file="/views/common/footer.jsp" %>