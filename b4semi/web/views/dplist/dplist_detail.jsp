<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.b4.model.vo.DPDetail"%>
<%@ page import="com.b4.model.vo.DPOption"%>
<%@ page import="com.b4.model.vo.Review"%>
<%@ page import="com.b4.model.vo.QueryBoard"%>
<%@ page import="com.b4.model.vo.QueryComment"%>
<%

DPDetail detail;
try {
	detail= (DPDetail)request.getAttribute("detail");
	if(detail == null)
	{
		detail=new DPDetail();
	}
} catch (ClassCastException e) {
	detail=new DPDetail();
}

ArrayList<DPOption> option;
try {
	option= (ArrayList<DPOption>)request.getAttribute("option");
	if(option == null)
	{
		option=new ArrayList<DPOption>();
	}
} catch (ClassCastException e) {
	option=new ArrayList<DPOption>();
}

ArrayList<String> renames;
try {
	renames= (ArrayList<String>)request.getAttribute("renames");
	if(renames == null)
	{
		renames=new ArrayList<String>();
	}
} catch (ClassCastException e) {
	renames=new ArrayList<String>();
}

ArrayList<Review> review;
try {
	review= (ArrayList<Review>)request.getAttribute("review");
	if(review == null)
	{
		review=new ArrayList<Review>();
	}
} catch (ClassCastException e) {
	review=new ArrayList<Review>();
}

ArrayList<QueryBoard> qna;
try {
	qna= (ArrayList<QueryBoard>)request.getAttribute("qna");
	if(qna == null)
	{
		qna=new ArrayList<QueryBoard>();
	}
} catch (ClassCastException e) {
	qna=new ArrayList<QueryBoard>();
}

String rpageStr;
try {
	rpageStr = (String)request.getAttribute("rpageStr");
	if(rpageStr == null)
	{
		rpageStr="";
	}
} catch (ClassCastException e) {
	rpageStr="";
}

String qpageStr;
try {
	qpageStr = (String)request.getAttribute("qpageStr");
	if(qpageStr == null)
	{
		qpageStr="";
	}
} catch (ClassCastException e) {
	qpageStr="";
}

%>
    <style>
        .dp-detail-wrapper
        {
            width: 1024px;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            font-family: 'Noto Sans KR';
            font-size: 14px;
            margin-top: 100px;
        }

        .dp-detail-wrapper select
        {
            font-family: 'Noto Sans KR';
            height: 30px;
            
        }

        .dp-detail-wrapper input
        {
            font-family: 'Noto Sans KR';
        }

        .dp-detail-wrapper input:focus
        {
            outline: none;
        }

        .dp-detail-top-wrapper
        {
            width: 100%;
            display: flex;
        }

        .dp-detail-top-wrapper > div 
        {
            display: flex; 
            flex-flow: column nowrap;
            justify-content: space-between;
        }

        .prod-image
        {
            flex: 5 1 0;
            height: 550px;
        }

        .prod-image > img
        {
            width: 100%;
            height: 100%;
        }

        .prod-description
        {
            flex: 6 1 0;
            margin-left: 55px;
        }

        .prod-description > div
        {
            display: flex;
        }

        .prod-description > div > div:nth-of-type(1){flex:2 1 0;}
        .prod-description > div > div:nth-of-type(2){flex:4 1 0;}


        .prod-name
        {
            font-size: 21px;
            font-weight: bold;
        }

        .prod-price
        {
            padding: 40px 0;
        }

        .prod-unit
        {
            border-top: 1px solid #eee;
            padding: 40px 0;
        }

        .quantity
        {
            border-top: 1px solid #eee;
            padding: 40px 0;
        }

        .prod-origin
        {
            border-top: 1px solid #eee;
            padding: 40px 0;
        }

        .purchase-option
        {
            border-top: 1px solid #eee;
            padding: 40px 0;
        }
        .option-total
        {
            font-size: 21px;
            margin-bottom: 15px;
            font-weight: bold;
        }

        .prod-descr-conclude{flex-flow: column nowrap;}

        .add-to-cart
        {
            position: relative;
            display: flex;
            justify-content: space-between;
        }

        .add-to-cart img {cursor: pointer;}

        #cart-icon
        {
            position: absolute;
            left: 55px; 
            top: 10px;
            width: 25px;
            height: 25px;
        }

        #bell-icon
        {
            position: absolute;
            width: 35px;
            height: 35px;
            left: 330px;
            top: 5px;
        }

        .add-to-cart > input
        {
            width: 50%;
            height: 45px;
            border-radius: 2px;
            background-color: rgb(42, 71, 114);
            border: none;
            color: white;
            cursor: pointer;
        }

        .add-to-cart > input:last-of-type
        {
            background-color: white;
            border: 1px solid #bbb;
            color: black;
            margin-left: 20px;
        }

        .selected-options-display
        {
            width: 100%;
            height: auto;
            background-color: whitesmoke;
            box-sizing: border-box;
            margin-bottom: 15px;
        }

        .selected-option
        {
            display: flex;
            justify-content: space-between;
            padding: 10px;
        }

        .selected-option > div
        {
            display: flex;
            align-items: center;
            justify-content: flex-start;
        }

        .selected-option > div:nth-of-type(1){flex: 8 1 0;}
        .selected-option > div:nth-of-type(2){flex: 2 1 0;}
        .selected-option > div:nth-of-type(3){flex: 2 1 0;justify-content: flex-end;}
        .selected-option > div:nth-of-type(4){width: 20px; margin-left: 10px;justify-content: center;}



        .dp-detail-body-wrapper
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
        }

        .dp-detail-tab
        {
            display: flex;
            margin-top: 50px;
        }

        .dp-detail-tab > div
        {
            width: 181px;
            height: 47px;
            border: 1px solid #ccc;
            border-right: none;
            background-color: #eee;
            display: flex;
            align-items: center;
            justify-content: center;
            box-sizing: border-box;
        }

        .dp-detail-tab > div:last-of-type
        {
            border: none;
            border-bottom: 1px solid #ccc;
            border-left: 1px solid #ccc;
            background-color: white;
        }


        /*옵션 상품 수량 컨트롤 박스*/
        .option-quantity-controller
        {
            width: 78px;
            height: 26px;
            display: flex;
        }

        .option-quantity-controller > input
        {
            width: 26px;
            height: 26px;
            border: none;
            box-sizing: border-box;
            text-align: center;
            font-weight: bold;
            background-color: #eee;
            color: black;
            border-top: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
        }

        .option-quantity-controller > input:focus
        {
            outline: none;
        }

        .option-quantity-controller> div
        {
            width: 26px;
            height: 26px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: white;
        }

        .option-quantity-controller > div > img
        {
            width: 90%;
            height: 90%;
            cursor: pointer;
        }
        

        /*단일 상품 수량 컨트롤 박스*/
        .quantity-controller
        {
            width: 78px;
            height: 26px;
            display: flex;
        }

        .quantity-controller > input
        {
            width: 26px;
            height: 26px;
            border: none;
            box-sizing: border-box;
            text-align: center;
            font-weight: bold;
            background-color: #eee;
            color: black;
            border-top: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
        }

        .quantity-controller > input:focus
        {
            outline: none;
        }

        .quantity-controller > div
        {
            width: 26px;
            height: 26px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .quantity-controller > div > img
        {
            width: 90%;
            height: 90%;
            cursor: pointer;
        }

        .current-tab
        {
            background-color: white !important;
            border-bottom: none !important;
        }

        .delete-selection img {cursor: pointer;}
        
        
        
        
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
    <div class="dp-detail-wrapper">
        <div class="dp-detail-top-wrapper">
            <div class="prod-image">
                <img src="<%=request.getContextPath()%>/upload/product/<%=detail.getImg()%>" onError="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';">
            </div>
            <div class="prod-description">
            	<div><%=detail.getMajorCategoryName()%>&nbsp;&nbsp;>&nbsp;&nbsp;<%=detail.getSubCategoryName()%></div>
                <div class="prod-name">
                    <%=detail.getDisplayListTitle()%>
                </div>
<%--            <div class="discount">
                	<div>할인</div>
                	<div><%=detail.getDiscountName()%></div>
                </div> --%>
                <div class="prod-price">
                    <div>판매가</div>
                    <div>
                    <%if(detail.getDiscountRate()>0){%>
                    <del><%=detail.getMinPrice() %> 원</del>
                    <br>할인가 : <%=detail.getDiscountMinPrice()%> 원 (<%=detail.getDiscountName()%>)
                    <%}else{%>
                    <%=detail.getMinPrice() %> 원
                    <%}%>
                    </div>
                    <%for(int i=0; i<option.size(); i++){%>
                        <input type="hidden" id="op-data-<%=i+1%>" data-dpseq="<%=detail.getDisplayListSeq()%>" data-pcode="<%=option.get(i).getProductCode()%>" data-pname="<%=option.get(i).getProductName()%>" data-price="<%=option.get(i).getDiscountOptionPrice()%>" data-count="0">
                    <%}%>
                </div>
                <div class="prod-unit">
                    <div>판매단위</div>
                    <div><%=detail.getProductUnit()%></div>
                </div>
                <div class="prod-origin">
                    <div>원산지</div>
                    <div><%=detail.getOriginCountry()%></div>
                </div>

<%if(option.size()>1){ %>
                <!-- 단일 상품일시 출력 X {-->
                <div class="purchase-option">
                    <div>구매옵션선택</div>
                    <div>
                        <select>
                        	<option value="0">=== 상품 옵션을 선택해주세요 ===</option>
                        <%for(int i=0; i<option.size(); i++){%>
                            <option value="<%=i+1%>"><%=option.get(i).getProductName()%> <%=option.get(i).getDiscountOptionPrice()%>원 (+<%=option.get(i).getDiscountOptionPrice() - detail.getDiscountMinPrice()%> 원 추가)</option>
                        <%}%>
                        </select>
                    </div>
                </div>
                <!--} 단일 상품일시 출력 X -->
<%}else{ %>

                <!-- 옵션 상품일시 출력 X {-->
                <div class="quantity">
                    <div>구매수량</div>
                    <div class="quantity-controller">
                        <div><img src="images/arrow_left_black.png"></div>
                        <input type="text" name="quantity" id="quantity" value="1" readonly>
                        <div><img src="images/arrow_right_black.png"></div>
                    </div>
                </div>
                <!--} 옵션 상품일시 출력 X -->
<%} %>

                <div class="prod-descr-conclude">
                    
                    <div class="selected-options-display">
                        
                        <!-- 옵션태그 선택시 append되는 부분{ -->


                         <!-- }옵션태그 선택시 append되는 부분 -->

                    </div>
                    <div class="option-total">
                        총 상품금액: <span class="option-total-price"><%=option.size()>1?"0원":option.get(0).getDiscountOptionPrice()+"원"%></span>
                    </div>
                    <div class="add-to-cart">
                        <input type="button" value="장바구니 담기" onclick="fn_cart_all()">
                        <input type="button" value="재입고 알림" onclick="fn_stock_inform()">
                        <img id="cart-icon" src="images/add_to_cart.png">
                        <img id="bell-icon" src="images/bell.png">
                    </div>
                </div>
            </div>
        </div>
        <div id="dp-detail-body-wrapper">
            <div class="dp-detail-tab">
                <div class="current-tab">상품설명</div>
                <div>상품이미지</div>
                <div>상세정보</div>
                <div>고객후기(<%=detail.getReviewCount()%>)</div>
                <div>상품문의(<%=detail.getQnaCount()%>)</div>
                <div></div>
            </div>
            <div><%=detail.getDisplayListContents()%></div>
        </div>
        <div id="dp-detail-body-wrapper">
            <div class="dp-detail-tab">
                <div>상품설명</div>
                <div class="current-tab">상품이미지</div>
                <div>상세정보</div>
                <div>고객후기(<%=detail.getReviewCount()%>)</div>
                <div>상품문의(<%=detail.getQnaCount()%>)</div>
                <div></div>
            </div>
            <%for(int i=0; i<renames.size();i++){ %>
            <div><img src="<%=request.getContextPath()%>/upload/product/<%=renames.get(i)%>"></div>
            <%} %>
        </div>
        <div id="dp-detail-body-wrapper">
            <div class="dp-detail-tab">
                <div>상품설명</div>
                <div>상품이미지</div>
                <div class="current-tab">상세정보</div>
                <div>고객후기(<%=detail.getReviewCount()%>)</div>
                <div>상품문의(<%=detail.getQnaCount()%>)</div>
                <div></div>
            </div>
            <div>
            	제조사<div><%=detail.getSupplierName()%></div>
            	연락처<div><%=detail.getSupplierPhone()%></div>
            	주소<div><%=detail.getSupplierAddress()%></div>
            	이메일<div><%=detail.getSupplierEmail()%></div>
            </div>
        </div>
        <div id="dp-detail-body-wrapper">
            <div class="dp-detail-tab">
                <div>상품설명</div>
                <div>상품이미지</div>
                <div>상세정보</div>
                <div class="current-tab">고객후기(<%=detail.getReviewCount()%>)</div>
                <div>상품문의(<%=detail.getQnaCount()%>)</div>
                <div></div>
            </div>
            <div>평점:<%=detail.getReviewScore()%>/5.00</div>
            <%for(int i=0; i<review.size();i++){%>
            <div><%=review.get(i).getMemberId()%></div><div><%=review.get(i).getReviewScore()%>점 <%=review.get(i).getReviewTitle()%></div><div><%=review.get(i).getReviewContents()%></div>
            <%}%>
            <div><%=rpageStr%></div>
        </div>
        <div id="dp-detail-body-wrapper">
            <div class="dp-detail-tab">
                <div>상품설명</div>
                <div>상품이미지</div>
                <div>상세정보</div>
                <div>고객후기(<%=detail.getReviewCount()%>)</div>
                <div class="current-tab">상품문의(<%=detail.getQnaCount()%>)</div>
                <div></div>
            </div>
            <%for(int i=0; i<qna.size();i++){%>
            <div><%=qna.get(i).getMemberId()%></div><div><%=qna.get(i).getQueryTitle()%></div><div><%=qna.get(i).getQueryContents()%></div>
            	<div>
<%--            <%for(int j=0; j<qna.get(i).getList().size();j++){%>
            		<div><%=qna.get(i).getList().get(j).getMemberId()%></div><div><%=qna.get(i).getList().get(j).getCommentText()%></div>
            	<%}%> --%>
            	</div>
            <%}%>
            <div><%=qpageStr%></div>
        </div>
    </div>
</section>

<script>

    //셀렉트 태그 옵션 선택시 화면에 추가
    const optionSelectEle = $('.purchase-option');
    const selectedOptionsDisplay = $('.selected-options-display');    
    
    $(() => {
    	if(<%=option.size()%>==1){$("#op-data-1").data("count",1)}
    	
        optionSelectEle.on('change', (e) => {
            const optionIndex = $(e.target).val();
            if(optionIndex == 0)
            {
            	return;
            }

            //해당 인덱스의 옵션이 이미 추가되어 있으면 메시지 출력 후 리턴
            if($('.selected-option').hasClass($(e.target).val()))
            {
                alert('이미 선택된 상품입니다.');
                $(e.target).val("0").prop("selected", true);
                return;
            }
            const selectedOption = $('.selected-option'); // 화면에 추가된 옵션들 선택
            const selectedData = $("#op-data-"+optionIndex); // 선택한 옵션의 데이터들을 저장했던 input태그
            
            const newTag 
            = '<div class="selected-option '+optionIndex+'">'
            +   '<div>'+selectedData.data("pname")+'</div>'
            +   '<div class="option-quantity-controller">'
            +       '<div><img src="images/arrow_left_black.png"></div>'
            +       '<input type="text" name="op-quantity-'+optionIndex+'" id="op-quantity-'+optionIndex+'" value="1" data-index='+optionIndex+' readonly>'
            +       '<div><img src="images/arrow_right_black.png"></div>'
            +   '</div>'
            +   '<div id="op-price"'+optionIndex+'>'+selectedData.data("price")+'원</div>'
            +   '<div class="delete-selection" data-delindex='+optionIndex+'><img src="images/btn_close_black.png"></div>'
            + '</div>';
            
            selectedOptionsDisplay.append(newTag);
            
            $("#op-data-"+optionIndex).data("count",1);

            
            //수량 조정 로직
            //옵션 상품의 경우 옵션 추가시마다
            //매번 버튼 요소 배열을 재정의 해줘야 함

            const opLeftBtn = $('.option-quantity-controller > input').prev().children();
            const opRightBtn = $('.option-quantity-controller > input').next().children();

            opLeftBtn.off('click');
            opLeftBtn.on('click', (e) => {
                const target = $(e.target).parent().next()
                if(target.val() == 1){alert('최수 수량은 1개입니다.'); return;}
                target.val(parseInt(target.val())-1);
                target.parent().next().text($("#op-data-"+target.data("index")).data("price")*parseInt(target.val())+"원");
                $("#op-data-"+target.data("index")).data("count",target.val());
                detail_cal_Total();
            });

            opRightBtn.off('click');
            opRightBtn.on('click', (e) => {
                const target = $(e.target).parent().prev();
                target.val(parseInt(target.val())+1);
                target.parent().next().text($("#op-data-"+target.data("index")).data("price")*parseInt(target.val())+"원");
                $("#op-data-"+target.data("index")).data("count",target.val());
                detail_cal_Total();
            });

            //버튼 클릭시 해당 옵션 화면에서 삭제
            const deleteBtn = $('.delete-selection');
            deleteBtn.off('click');
            deleteBtn.on('click', (e) =>{
            	$("#op-data-"+$(e.target).parent().data("delindex")).data("count",0);
                $(e.target).parents('.selected-option').remove();
                detail_cal_Total();
            });
            
            detail_cal_Total();
            $(e.target).val("0").prop("selected", true);
        });

        //단일 상품 수량 조정 로직
        const leftBtn = $('.quantity-controller > input').prev().children();
        const rightBtn = $('.quantity-controller > input').next().children();
        $(() => {
            leftBtn.on('click', (e) => {
                const target = leftBtn.parent().next()
                if(target.val() <= 1){ alert('최수 수량은 1개입니다.'); return; }
                target.val(parseInt(target.val())-1);
                $("#op-data-1").data("count",target.val());
                detail_cal_Total();
            });

            rightBtn.on('click', (e) => {
                const target = rightBtn.parent().prev();
                target.val(parseInt(target.val())+1);
                $("#op-data-1").data("count",target.val());
                detail_cal_Total();
            });
        });

    });
    
    function detail_cal_Total() {
    	var totalPrice = 0;
    	for(var i=0; i<<%=option.size()%>;i++)
    	{
    		totalPrice += $("#op-data-"+(i+1)).data("price")*$("#op-data-"+(i+1)).data("count");
    	}
    	$(".option-total-price").text(totalPrice+"원");
    }
    
    function fn_cart_all() {
		var c=0;
		var dpseqs="";
		var pcodes="";
		var changes="";
		
    	for(var i=0;i<<%=option.size()%>;i++)
    	{
    		if($("#op-data-"+(i+1)).data("count")>0)
    		{
				dpseqs+=$("#op-data-"+(i+1)).data("dpseq")+",";
				pcodes+=$("#op-data-"+(i+1)).data("pcode")+",";
				changes+=$("#op-data-"+(i+1)).data("count")+",";
    			$("#op-data-"+(i+1)).data("count",0);
				c++;
    		}
    	}
    	if(c>0)
    	{
    		$('.selected-option').remove();
    		$('#quantity').val(0);
			$.ajax({
				url:"<%=request.getContextPath()%>/cartAdd.do",
				type:"post",
				data:{"multi":"yes","dpseqs":dpseqs,"pcodes":pcodes,"changes":changes},
				success:function(data){
					alert("성공적으로 장바구니에 담았습니다.");
				}
			});
			detail_cal_Total();
    	}
    	else
    	{
    		alert("먼저 상품을 선택해주세요");
    	}
    }
    
    function fn_stock_inform() {
    	alert("딸랑딸랑~ 현재 재고가 충분히 있습니당");
    }
    
    
</script>

<%@ include file="/views/common/footer.jsp" %>