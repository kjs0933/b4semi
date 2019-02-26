<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.b4.model.vo.Cart"%>
<%@ include file="/views/common/header.jsp" %>
<%
	ArrayList<Cart> cartList;
	try {
		cartList = (ArrayList<Cart>)request.getAttribute("cartList");
		if(cartList == null)
		{
			cartList=new ArrayList<Cart>();
		}
	} catch (ClassCastException e) {
		cartList=new ArrayList<Cart>();
	}
	
%>    
	<style>
	
		.cart-wrapper
		{
			width: 1024px;
			margin-top: 60px;
			display: flex;
			flex-flow: column nowrap;
			align-items: center;
		}
	
        #cart-frm
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
        }

        #cart-frm > p
        {
            font-size: 40px;
            color: rgb(38, 85, 139);
            font-weight: bold;
            margin: 70px;

        }

        .cart-rows
        {
            width: 1024px;
            display: flex;
            flex-flow: column nowrap;
            font-family: 'Noto Sans KR';
            /* border-bottom: 1px solid rgb(38, 85, 139); */
        }

        .cart-header
        {
            width: 1024px;
            display: flex;
            flex-flow: row nowrap;
            border-bottom: 1px solid #ccc;
            border-top: 2px solid rgb(38, 85, 139);
            font-family: 'Noto Sans KR';
            box-sizing: border-box;
            font-weight: bold;
            padding: 5px 0;
        }

        .cart-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 10px;
        }


        .cart-header > div:nth-of-type(1){flex:1 1 0;}
        .cart-header > div:nth-of-type(2){width: 110px;justify-content: flex-start;}
        .cart-header > div:nth-of-type(3){flex:20 1 0;}
        .cart-header > div:nth-of-type(4){flex:4 1 0;}
        .cart-header > div:nth-of-type(5){flex:3 1 0;}
        .cart-header > div:nth-of-type(6){flex:2 1 0;}

        .cart-col, #emptycart
        {
            width: 1024px;
            display: flex;
            flex-flow: row nowrap;
            border-bottom: 1px solid #ccc;
        }
        
        #emptycart
        {
        	height:120px;
        	align-items: center;        	
        }

        .cart-col > div:nth-of-type(2) > img{width: 80px;height: auto;}
        .cart-col > div:nth-of-type(6) > img{cursor: pointer;}

        .cart-col > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 10px;
        }

        .cart-col > div:nth-of-type(1){flex:1 1 0;}
        .cart-col > div:nth-of-type(2){width: 110px;}
        .cart-col > div:nth-of-type(3){flex:20 1 0; justify-content: flex-start;}
        .cart-col > div:nth-of-type(4){flex:4 1 0;}
        .cart-col > div:nth-of-type(5){flex:3 1 0;}
        .cart-col > div:nth-of-type(6){flex:2 1 0;}
        
        .cart-col > div p
        {
            margin: 0;
            font-size: 15px;
        }

        .cart-col > div p:first-of-type{font-weight: bold;}
        .cart-col > div p:last-of-type{font-size: 13px;}


        .quantity-box
        {
            width: 78px;
            height: 26px;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .quantity-box > input
        {
            width: 26px;
            height: 26px;
            border: none;
            box-sizing: border-box;
            text-align: center;
            font-weight: bold;
            background-color: rgb(38, 85, 139);
            color: white;
        }

        .quantity-box > input:focus
        {
            outline: none;
        }

        .quantity-box > div
        {
            width: 26px;
            height: 26px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .quantity-box > div > img
        {
            width: 90%;
            height: 90%;
        }

        .checkbox-control
        {
            width: 100%;
            height: auto;
            align-self: flex-start;
            padding: 25px 0 0 0;
        }

        .checkbox-control > input
        {
            width: 100px;
            height: 50px;
            border: 1px solid #ccc;
            color: black;
            background-color: transparent;
            margin-right: 4px;
            cursor: pointer;
        }

        .checkbox-control > input:focus
        {
            outline: none;
        }


        .total-info
        {
            display: flex;
            flex-flow: row nowrap;
            width: 1024px;
            height: 130px;
            font-family: 'Noto Sans KR';
            box-sizing: border-box;
            align-items: center;
        }

        .total-info > p
        {
            margin: 0;
            font-size: 30px;
        }

        .total-info > div
        {
            margin: 25px;
            flex: 1 1 0;
            border: 1px solid #ccc;
            display: flex;
            align-items: center;
            justify-content: space-around;
            padding: 10px;
            box-sizing: border-box;
        }

        .total-info > div:first-of-type{margin-left: 0;}
        .total-info > div:last-of-type{margin-right: 0;}

        .total-info > div > p
        {
            margin-left: 5px;
        }

        .total-info input
        {
            background-color: none;
            width: 60px;
            text-align: center;
            padding-top: 6px;
            height: 16px;
            border: none;
            font-size: 16px;
            font-weight: bold;
        }

        .total-info input:focus
        {
            outline: none;
        }

        #checkout
        {
            width: 200px;
            height: 50px;
            background-color: rgb(38, 85, 139);
            border: none;
            color: white;
            cursor: pointer;

            margin: 20px 0;
        }

        #checkout:focus
        {
            outline: none;
        }

        input[type="checkbox"]
        {
            display: none;
        }

        input[type="checkbox"] + label
        {
            position: relative;
            width: 17px;
            height: 17px;
            background-color: rgb(38, 85, 139);
            cursor: pointer;
            border-radius: 1px;
        }

        input[type="checkbox"] + label span
        {
            position: absolute;
            display: none;
            left: 5px;
            top: 1px;
            width: 4px;
            height: 10px;
            border-right: 2px solid white;
            border-bottom: 2px solid white;
            transform: rotateZ(40deg);
        }

        input[type="checkbox"] + label:hover
        {
            background-color: rgb(47, 105, 172);
        }

        input[type="checkbox"]:checked + label span
        {
            display: inline-block;
        }
	</style>
	
    <section>
    <div class="cart-wrapper">
        <form action="#" method="post" id="cart-frm">
            <p>장바구니</p>
            <div class="cart-rows">
                <div class="cart-header">
                    <div><input type="checkbox" name="selectAllProd" id="selectAll" class="selectAll"><label for="selectAll"><span></span></label></div>
                    <div>전체선택</div>
                    <div>상품정보</div>
                    <div>수량</div>
                    <div>금액</div>
                    <div>취소</div>
                </div>
             	<%
             		if(cartList.size()==0){%>
            		<div id='emptycart'>장바구니에 담긴 상품이 없습니다.</div>
             		<%}else{
             			for(int i=0; i<cartList.size(); i++){
             	%>
                <div class="cart-col">
                    <div><input type="checkbox" name="products" id="product<%=i+1 %>" class="products"><label for="product<%=i+1 %>"><span></span></label></div>
                    <div><img src="<%=request.getContextPath() %>/upload/product/<%=cartList.get(i).getImg()%>" onError="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';"></div>
                    <div>
                    <div>
                    <p><a href="<%=request.getContextPath()%>/dpdetail?dpseq=<%=cartList.get(i).getDisplayListSeq()%>" style="text-decoration: none;"><%=cartList.get(i).getDisplayListTitle()%></a> (옵션 - <%=cartList.get(i).getProductName()%>)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;단위:<%=cartList.get(i).getProductUnit()%></p><br>
                    <%=cartList.get(i).getDiscountName()==null?"":cartList.get(i).getDiscountName()%>
                    <% if(cartList.get(i).getDiscountRate()>0){%>
                    <p><del><%=cartList.get(i).getDisplayOptionPrice()%>원</del> → <b><%=cartList.get(i).getDiscountOptionPrice()%>원<%="Y".equals(cartList.get(i).getOptionAvailable())?"":" <품절>"%></b></p>
                    <%}else{ %>
                    <p><%=cartList.get(i).getDisplayOptionPrice()%>원<%="Y".equals(cartList.get(i).getOptionAvailable())?"":" <품절>"%></p>
                    <%}%>
                    </div>
                    </div>
                    <div>
                        <div class="quantity-box">
                            <div><img src="<%=request.getContextPath() %>/images/arrow_left_black.png"></div>
                            <input type="text" name="quantity<%=i+1%>" id="quantity<%=i+1%>" value="<%=cartList.get(i).getProductCount()%>" readonly/>
                            <div><img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></div>
                        </div>
                    </div>
                    <input type="hidden" value="<%=i+1%>">
                    <div id="totalPrice<%=i+1%>"><%=cartList.get(i).getDiscountOptionPrice()*cartList.get(i).getProductCount()%>원</div>
                    <div><img src="<%=request.getContextPath() %>/images/btn_close.png" onclick="fn_cart_close()"></div>
                    <input type="hidden" id="price<%=i+1%>" value="<%=cartList.get(i).getDisplayOptionPrice()%>">
                    <input type="hidden" id="discount<%=i+1%>" value="<%=cartList.get(i).getDisplayOptionPrice()-cartList.get(i).getDiscountOptionPrice()%>">
                    <input type="hidden" id="dpseq<%=i+1%>" value="<%=cartList.get(i).getDisplayListSeq()%>">
                    <input type="hidden" id="pcode<%=i+1%>" value="<%=cartList.get(i).getProductCode()%>">
                    <input type="hidden" id="available<%=i+1%>" value="<%=cartList.get(i).getOptionAvailable()%>">
                </div>
                <%}}%>
            </div>
            <div class="checkbox-control">
                <input type="button" value="선택 삭제" onclick="fn_selected_delete()"/>
                <input type="button" value="품절 삭제" onclick="fn_soldout_delete()"/>
            </div>
            <div class="total-info">
                <div><p>상품금액</p><input type="text" name="preTotal" id="preTotal" value="" readonly></div>
                <p>-</p>
                <div><p>할인금액</p><input type="text" name="discount" id="discount" value="" readonly></div>
                <p>+</p>
                <div><p>배송료</p><input type="text" name="shipFee" id="shipFee" value="" readonly></div>
                <p>=</p>
                <div><p>결제예정금액</p><input type="text" name="totalPrice" id="totalPrice" readonly></div>
            </div>
            <input id="checkout" type="button" value="주문하기" onclick="fn_order()">
        </form>
    </div>
    </section>
    
    <script>
        //하단 total 출력
        const preTotal = $('#preTotal');
        const discount = $('#discount');
        const shipFee = $('#shipFee');
        const totalPrice = $('#totalPrice');
        
    	const cartSize = $(".cart-col").length;

        function cart_total_calculate(){
        	var preTotalPriceTotal = 0;
        	var discountPriceTotal = 0;
        	for(var i=0;i<cartSize;i++)
        	{
        		const preTotalPrice = parseInt($("#quantity"+(i+1)).val())*parseInt($("#price"+(i+1)).val());
        		const discountPrice = parseInt($("#quantity"+(i+1)).val())*parseInt($("#discount"+(i+1)).val());
        		if($.isNumeric(preTotalPrice) && $.isNumeric(discountPrice))
        		{
            		preTotalPriceTotal += preTotalPrice;
            		discountPriceTotal += discountPrice;
        		}

        	}
        	preTotal.val(preTotalPriceTotal);
        	discount.val(discountPriceTotal);
        	if(preTotalPriceTotal-discountPriceTotal>=30000 || preTotalPriceTotal == 0)
        	{
        		shipFee.val(0);
        	}
        	else
        	{
        		shipFee.val(2500);
        	}
            const execTotalPrice = parseInt(preTotal.val()) - parseInt(discount.val()) + parseInt(shipFee.val());
            totalPrice.val(execTotalPrice);
        }
        
        $(cart_total_calculate());

        // 체크박스 전체선택
        const selectAll = $('#selectAll');
        $(() => {
            selectAll.on('change', checkboxsToggle)
        })

        const checkboxsToggle = () => {
            if(selectAll.is(':checked'))
            {
                $('.products').each( (index, el) => {
                    el.checked = true;
                });
            }
            else
            {
                $('.products').each( (index, el) => {
                    el.checked = false;
                });
            }
        }
        
        
        const leftArrow = $('.quantity-box > input').prev().children();
        const rightArrow = $('.quantity-box > input').next().children();

		$(function(){
			leftArrow.on ('click', (e) => {
				var cartIndex = $(e.target).parent().parent().parent().next().val();
				var decre = $(e.target).parent().next().val();
				var denum = parseInt(decre);
				denum--;
				if(denum>0){
					$(e.target).parent().next().val(denum);
					$("#totalPrice"+cartIndex).html((parseInt($("#price"+cartIndex).val())-parseInt($("#discount"+cartIndex).val()))*denum+"원");
					$.ajax({
						url:"<%=request.getContextPath()%>/cartAdd.do",
						type:"post",
						data:{"dpseq":$("#dpseq"+cartIndex).val(),"pcode":$("#pcode"+cartIndex).val(),"change":-1},
						success:function(data){}
					});
	    			cart_total_calculate();
				}
			});
			rightArrow.on('click', (e) => {
				var cartIndex = $(e.target).parent().parent().parent().next().val();
				var incre = $(e.target).parent().prev().val();
				var innum = parseInt(incre);
				innum++;
				$(e.target).parent().prev().val(innum);
				$("#totalPrice"+cartIndex).html((parseInt($("#price"+cartIndex).val())-parseInt($("#discount"+cartIndex).val()))*innum+"원");
				$.ajax({
					url:"<%=request.getContextPath()%>/cartAdd.do",
					type:"post",
					data:{"dpseq":$("#dpseq"+cartIndex).val(),"pcode":$("#pcode"+cartIndex).val(),"change":1},
					success:function(data){}
				});
				cart_total_calculate();
			});
		});
              
		function fn_cart_close() {
			var cartIndex = $(event.target).parent().prev().prev().val();
			$.ajax({
				url:"<%=request.getContextPath()%>/cartAdd.do",
				type:"post",
				data:{"dpseq":$("#dpseq"+cartIndex).val(),"pcode":$("#pcode"+cartIndex).val(),"change":-99999999},
				success:function(data){}
			});
			$(event.target).parent().parent().remove();
			cart_total_calculate();
		}
		
		function fn_selected_delete() {
			var c=0;
			var dpseqs="";
			var pcodes="";
			var changes="";
			
        	for(var i=0;i<cartSize;i++)
        	{
        		if($("#product"+(i+1)).prop("checked"))
        		{
					dpseqs+=$("#dpseq"+(i+1)).val()+",";
					pcodes+=$("#pcode"+(i+1)).val()+",";
					changes+="-99999999,"
        			$("#product"+(i+1)).parent().parent().remove();
					c++;
        		}
        	}
        	if(c>0)
        	{
    			$.ajax({
    				url:"<%=request.getContextPath()%>/cartAdd.do",
    				type:"post",
    				data:{"multi":"yes","dpseqs":dpseqs,"pcodes":pcodes,"changes":changes},
    				success:function(data){}
    			});
    			cart_total_calculate();
        	}
        	else
        	{
        		alert("먼저 체크박스에 체크해주세요");
        	}
        	
		}
		function fn_soldout_delete() {
			var c=0;
			var dpseqs="";
			var pcodes="";
			var changes="";
			
        	for(var i=0;i<cartSize;i++)
        	{
        		if($("#available"+(i+1)).val() != "Y")
        		{
					dpseqs+=$("#dpseq"+(i+1)).val()+",";
					pcodes+=$("#pcode"+(i+1)).val()+",";
					changes+="-99999999,"
        			$("#product"+(i+1)).parent().parent().remove();
					c++;
        		}
        	}
        	if(c>0)
        	{
    			$.ajax({
    				url:"<%=request.getContextPath()%>/cartAdd.do",
    				type:"post",
    				data:{"multi":"yes","dpseqs":dpseqs,"pcodes":pcodes,"changes":changes},
    				success:function(data){}
    			});
    			cart_total_calculate();
        	}
        	else
        	{
        		alert("품절 상품이 없습니다");
        	}
        	
		}
		
		
		function fn_order(){
		var session = '<%=session.getAttribute("loginMember") == null?"logoff":"logon"%>';
			if(session=="logon")
			{
				if($("#preTotal").val()>0)
				{
					location.href='<%=request.getContextPath()%>/order';
				}
				else
				{
					alert("먼저 장바구니에 상품을 담아주세요");
				}
			}
			else
			{
				alert("로그인 후 이용해주세요");
			}
		}
    </script>
<%@ include file="/views/common/footer.jsp" %>