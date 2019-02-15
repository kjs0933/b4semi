<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
    <style>

        #mypage
        {
            width: 1024px;
        }

        #user-info
        {
            display: flex;
            flex-flow: row nowrap;
            width: 100%;
            height: 200px;
        }

        #user-info > div
        {
            border: 1.5px solid rgb(182, 181, 181);
            border-left: 0;
        }

        #user-info > div:first-child
        {
            border-left:1.5px solid rgb(182, 181, 181);
        }

        #user-info > div:nth-of-type(1)
        {
            flex-grow: 2
        }
        #user-info > div:nth-of-type(2)
        {
            flex-grow: 1
        }
        #user-info > div:nth-of-type(3)
        {
            flex-grow: 1
        }

        #content-container
        {
            display: flex;
            flex-flow: row nowrap;
            width:100%;
        }

        #user-menu
        {
            display: flex;
            flex-flow: column nowrap;
            width: 220px;
        }

        #user-menu div
        {
            width: 100%;
            height: 50px;
            border: 1px solid gray;
            border-bottom: none; 
            display: flex;
            align-items: center;
            justify-content: center;
        }

        #user-menu div:last-of-type
        {
            border-bottom: 1px solid gray;
        }

        #user-menu > p
        {
            font-size: 25px;
            align-self: center;
        }

        #user-content
        {
            width:804px; 
            padding:10px 20px;
            border:1px solid lightblue;
        }

        #user-content > p
        {
            font-size: 20px;
        }

    </style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
    <section id="mypage">
        <div id="user-info">
            <div></div>
            <div></div>
            <div></div>
        </div>
        <div id="content-container">
            <div id="user-menu">
                <p>마이푸드포럼</p>
                <div id='orderlist' onclick="test">주문 내역<p>></p></div>
                <div id='review'>상품 후기</div>
                <div id='mileage'>적립금</div>
                <div id='coupon'>쿠폰</div>
                <div id='user-update'>개인 정보 수정</div>
            </div>
            <div id='user-content'></div>
        </div>
<script>
	$(function(){
		$('#orderlist').click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/mypage_orderlist.do",
				type:"post",
				data:{"usermenu":$('#user-menu>div').text()},
				success:function(data){
					console.log(data);
				}
			})
		});
	});
</script>
    </section>
</body>
</html>