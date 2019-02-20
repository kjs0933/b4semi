<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>    
	<style>
	
		.cart-wrapper
		{
			width: 1024px;
			margin-top: 60px;
			display: flex;
			flex-flow: column nowrap;
			aling-items: center;
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

        .cart-col
        {
            width: 1024px;
            display: flex;
            flex-flow: row nowrap;
            border-bottom: 1px solid #ccc;
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
                <div class="cart-col">
                    <div><input type="checkbox" name="products" id="product1" class="products"><label for="product1"><span></span></label></div>
                    <div><img src="<%=request.getContextPath() %>/images/tit_md_goods_3.jpg"></div>
                    <div><div><p>맛없는 음식</p><br><p>3000 원</p></div></div>
                    <div>
                        <div class="quantity-box">
                            <div><img src="<%=request.getContextPath() %>/images/arrow_left_black.png"></div>
                            <input type="text" name="quantity1" id="quantity1" value="1"/>
                            <div><img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></div>
                        </div>
                    </div>
                    <div></div>
                    <div><img src="<%=request.getContextPath() %>/images/btn_close.png"></div>
                </div>
                <div class="cart-col">
                    <div><input type="checkbox" name="products" id="product2" class="products"><label for="product2"><span></span></label></div>
                    <div><img src="<%=request.getContextPath() %>/images/tit_md_goods_3.jpg"></div>
                    <div><div><p>맛있는 음식</p><br><p>3000 원</p></div></div>
                    <div>
                        <div class="quantity-box">
                            <div><img src="<%=request.getContextPath() %>/images/arrow_left_black.png"></div>
                            <input type="text" name="quantity2" id="quantity2" value="1"/>
                            <div><img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></div>
                        </div>
                    </div>
                    <div></div>
                    <div><img src="<%=request.getContextPath() %>/images/btn_close.png"></div>
                </div>
            </div>
            <div class="checkbox-control">
                <input type="button" value="선택 삭제"/>
                <input type="button" value="품절 삭제"/>
            </div>
            <div class="total-info">
                <div><p>상품금액</p><input type="text" name="preTotal" id="preTotal" value="10000"></div>
                <p>-</p>
                <div><p>할인금액</p><input type="text" name="discount" id="discount" value="2000"></div>
                <p>+</p>
                <div><p>배송료</p><input type="text" name="shipFee" id="shipFee" value="2500"></div>
                <p>=</p>
                <div><p>결제예정금액</p><input type="text" name="totalPrice" id="totalPrice"></div>
            </div>
            <input id="checkout" type="submit" value="주문하기">
        </form>
    </div>
    </section>
    
    <script>
        //하단 total 출력
        const preTotal = $('#preTotal');
        const discount = $('#discount');
        const shipFee = $('#shipFee');
        const totalPrice = $('#totalPrice');

        $(() => {
            const execTotalPrice = parseInt(preTotal.val()) - parseInt(discount.val()) + parseInt(shipFee.val());
            totalPrice.val(execTotalPrice);
        })

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
    </script>
<%@ include file="/views/common/footer.jsp" %>