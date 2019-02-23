<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.b4.model.vo.Member"%>    

<% Member loginMember = (Member)session.getAttribute("loginMember");%>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Marcellus+SC" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
       
	<style>
	
		/* 헤더 */
		
        body
        {
            margin: 0;
            width: 100%;
        }

        .whole-wrapper
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            min-width: 1024px;

            background-color: white;
            
            font-familt: 'Noto Sans KR';
        }

        header
        {
            position: relative;
            height: 60px;
            width: 100%;
            min-width: 1024px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Noto Sans KR';
            font-size: 13px;
            background-color: white;
            position: fixed;
            z-index: 3;
            
            border-bottom: 1px solid #ccc;
        }

        .header-anim
        {
            animation: headerFade 200ms linear forwards;
        }

        #logo
        {
            font-family: 'Marcellus SC';
            font-size: 25px;
        }

        /* 네비게이션 */

        .nav
        {
            width: 1024px;
            height: 100%;
            padding: 0 1px;
            display: fixed;
            box-sizing: border-box;
        }

        .nav > ul
        {
            height: 100%;
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 1024px;
            position: relative;
        }

        .nav > ul > li
        {
            display: flex;
            height: 100%;
            align-items: center;
            padding: 0 10px;
            margin: 0;
            cursor: pointer;
        }
        
        .nav > ul > li > div
        {
        	display: flex;
        	flex-flow: column;
        	justify-content: center;
        }

        .nav > ul > li a
        { 
            text-decoration: none;
            color: black;
        }

        .nav ul li:nth-of-type(1){flex: 1 1 0;}
        .nav ul li:nth-of-type(2){flex: 1 1 0;}
        .nav ul li:nth-of-type(3){flex: 1 1 0;}
        .nav ul li:nth-of-type(4){flex: 5 1 0;}
        .nav ul li:nth-of-type(5){flex: 3 1 0;}
        .nav ul li:nth-of-type(6){flex: 1 1 0;}
        .nav ul li:nth-of-type(7){flex: 1 1 0;}
        .nav ul li:nth-of-type(8){flex: 1 1 0;}
		.nav ul li:nth-of-type(9){flex: 1 1 0; justify-content: flex-end;}
		
        .nav svg
        {
            width: 25px;
            height: 25px;
            fill: rgb(80, 80, 90);
            margin-bottom: -5px;
        }

        
       	/*헤더 검색창*/
       	
       	
        .search-box > input
        {
            box-sizing: border-box;
            width: 200px;
            height: 35px;
            width: 160px;
            border: none;
            border-bottom: 1px solid #aaa;
        }
        
        .search-box > input::placeholder
        {
            font-family: 'Noto Sans KR';
            font-size: 13px;
        }

        .search-box > input:focus
        {
            outline: none;
        }

        .search-box
        {
            position: relative;
        }
        
        
/*      마이 어카운트 토글 박스 */

        
        .my-account-wrapper
        {
        	position: relative;
        }
        
		#my-account-btn > span
		{
			font-size: 15px;
			font-weight: bold;
		}
		
   		.my-account-box
        {
            display: none;
            position: absolute;
            width: 85px;
            height: auto;
            border: 1px solid #ccc;
            font-size: 13px;
            left: -74px;
            top : 30px;
            background-color: white;
        }
        

        .my-account-box > ul
        {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .my-account-box > ul > li
        {
            width: 100%;
            height: 100%;
            padding: 5px 10px;

            box-sizing: border-box;
        }

        .my-account-box > ul > li:hover
        {
            background-color: #eee;
        }

        .my-account-box > ul > li > a
        {
            text-decoration: none;
            color: black;
            display: block;
            width: 100%;
            height: 100%;
            
            text-align: center;
        }

        #my-account-btn
        {
            position: relative;
            cursor: pointer;
        }
        
/*         고객지원 토글 박스        */
		
		
		.header-support-wrapper
        {
            position: relative;

        }

        .support-box
        {
            display: none;
            width: 75px;
            height: auto;
            border: 1px solid #ccc;
            font-size: 13px;
            position: absolute;
            left: -17px;
            top: 39px;
            
            background-color: white;
        }

        .support-box > ul
        {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .support-box > ul > li
        {
            width: 100%;
            height: 100%;
            padding: 5px 10px;

            box-sizing: border-box;
        }

        .support-box > ul > li:hover
        {
            background-color: #eee;
        }

        .support-box > ul > li > a
        {
            display: block;
            text-decoration: none;
            color: black;
            width: 100%;
            height: 100%;
            text-align: center;
        }

        #support-btn
        {
            position: relative;
            cursor: pointer;
        }


/* 		카테고리 메뉴 토글 버튼 */

        #category-toggle-btn
        {
            width: auto;
            height: 100%;
            cursor: pointer;
            box-sizing: border-box;
        }

        #category-toggle-btn span
        {
            display: block;
            width: 25px;
            height: 4px;
            background-color: black;
        }

        #category-toggle-btn span:not(:first-of-type)
        {
            margin-top: 3px;
        }
        
        
        /* 카테고리 메뉴 */


        .category-menu
        {
            position: absolute;
            width: 1024px;
            height: 600px;
            top: 100%;
            background-color: white;
            font-family: 'Noto Sans KR';
            border: 1px solid #ccc;

            z-index: 5;
            display: none;
            flex-flow: row wrap;
            justify-content: center;
        }
        
        .category-menu a
        {
        	color: #333;
        }

        .category-menu.active
        {
            display: flex;
        }

        .category-menu > div
        {
            width: 176px;
            margin: 0 10px;
        }

        .category-menu p
        {
            font-size: 14px;
            margin: 14px 0 0 0;
            color: #666;
            font-weight: bold;
            width: 100%;
            padding: 10px;
            box-sizing: border-box;

            transition: 250ms linear;
        }

        .category-menu > div > span
        {
            display: block;
            width: 100%;
            height: 1px;
            background-color: #bbb;
            margin-bottom: 13px;
            transition: 250ms linear;
        }

        .category-menu div:hover span
        {
            background-color: black;
        }

        .category-menu div:hover p
        {
            color: black;
        }

        .category-menu ul
        {
            list-style: none;
            margin: 0;
            padding: 0 10px;
            box-sizing: border-box;
        }

        .category-menu ul > li > a
        {
            font-size: 13px;
            text-decoration: none;
            color: #888;
        }

        .category-menu ul > li > a:hover
        {
            color: black;
        }

        .section-wrapper
        {
            width: 100%;
            height: auto;

            display: flex;
            flex-flow: column;
            align-items: center;

            background-color: white;
            margin-top: 60px;
        }

/* 		footer */

        footer
        {
            width: 100%;
            margin: 30px 0;
            font-family: 'Noto Sans KR';
            display: flex;
            flex-flow: column;
            align-items: center;
            
            border-top: 1px solid #ccc;
        }
        
       	.footer-wrapper
       	{
       		width: 1024px;
       	}

        .footer > h2
        {
            margin: 5px 8px;
        }

        .footer > div
        {
            margin: 15px 8px;
        }

        .ask-wrapper
        {
            display: flex;
            justify-content: space-between;
        }

        .ask-wrapper p
        {
            font-size: 0.8em;
        }

        .ask-wrapper span
        {
            font-size: 1.2em;
            font-weight: bold;
            color: royalblue;
        }

        hr
        {
            position: absolute;
            left: 0;
            width: 100%;
            transform: translateY(5px);
            border: none;
            height: 1px;
            background-color: #ccc;
        }

        .footer-info-wrapper
        {
            margin: 20px 0;
            padding: 20px 0;
        }

        .footer-info-wrapper > ul
        {
            display: flex;
            flex-flow: row nowrap;
            list-style: none;
            justify-content: space-between;
            padding: 0;
            margin: 0;
        }

        .footer-info-wrapper > ul > li
        {
            padding: 0;
            margin: 0;

            flex-grow: 1;
        }

        .footer-info-wrapper > ul > li:last-of-type
        {
            flex-grow: 3;
        }

        .footer-info-wrapper img
        {
            float: right;
        }

        .footer-info-wrapper > ul > li > a
        {
            text-decoration: none;
            color: royalblue;
            font-weight: bold;
            font-size: 0.8em;
        }

        .footer-info-wrapper img
        {
            margin: 0 3px;
            margin-top: -5px;
        }

        .business-info
        {
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-between;
        }
        
        .business-info p
        {
            font-size: 0.7em;
            color: #888;
            line-height: 1.7em;
        }


        .main-form-wrapper
        {
            position: fixed;
            left: 50vw;
            top: 50vh;
            transform: translateX(-50%) translateY(-50%);
            width: 400px;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            padding: 20px 50px;
            box-sizing: border-box;
            background-color: white;
            border-radius: 2px;
            box-shadow: 0 2px 15px 1px rgba(0, 0, 0, 0.2);

            display: none;
            z-index: 3;
            font-family: 'Noto Sans KR';
        }

        .main-form-wrapper input::placeholder
        {
            font-family: 'Noto Sans KR';
            font-size: 13px;
            color: #bbb;
        }
        
        .main-form-wrapper input{font-family: 'Noto Sans KR';}

        .main-form-wrapper.active{display: flex;}

        .main-frm-anim{animation: mainFrmPop 150ms linear forwards;}

        .login-frm-title
        {
            color: rgb(38, 85, 139);
            font-size: 2em;
            text-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
            display: flex;
            justify-content: space-between;
            width: 250px;
        }

        .login-frm-title > p{cursor: pointer;}

        .signin-frm
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            margin-top: 30px;
            width: 250px;
        }

        .signin-frm input
        {
            width: 250px;
            height: 35px;
            margin: 0 0 10px 0;
            border: none;
            font-size: 16px; 
        }

        .signin-frm input[type="submit"]
        {
            margin: 40px 0 20px 0;
            height: 45px;
            background-color: rgb(38, 85, 139);
            color: white;
            border-radius: 1px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }

        .signin-frm label
        {
            font-size: 14px;
            color: #666;
        }

        .signin-frm label input
        {
            border-bottom: 1px solid #ccc;
        }

        .signin-frm input:focus
        {
            outline: none;
        }

        .signin-frm > label > span
        {
            display: block;
            color: black;
        }

        .signin-frm #saveId
        {
            display: none;
        }

        #saveId + label
        {
            position: relative;
            align-self: flex-start;
            width: 17px;
            height: 17px;
            background-color: rgb(38, 85, 139);
            cursor: pointer;
            border-radius: 1px;
        }
        

        #saveId + label span
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

        #saveId + label:hover
        {
            background-color: rgb(47, 105, 172);
        }

        #saveId:checked + label span
        {
            display: inline-block;
        }
        
        #saveId + label span:last-of-type
        {
        	position: absolute !important;
        }

        .signin-frm > p
        {
            font-size: 14px;
            color: gray;
            cursor: pointer;
        }

        .signin-frm > p:first-of-type
        {
            margin-top: -19px;
            margin-left: -110px;
            color: gray;
        }

        .frm-invalid-anim
        {
            animation: invalid 150ms ease forwards;
        }

        .body-inactive
        {
            background-color: black;
        }

        .whole-wrapper-inactive
        {
            opacity: 0.3;
        }
        
        
-
        @keyframes invalid
        {
            0%
            {
                transform: translateY(-50%) translateX(-50%) scale(0.95);
            }

            100%
            {
                transform: translateY(-50%) translateX(-50%) scale(1);
            }
        }

        @keyframes mainFrmClose
        {
            0%
            {
                transform: translateY(-50%) translateX(-50%) scale(1);
                opacity: 1;
            }

            100%
            {
                transform: translateY(-50%) translateX(-50%) scale(0.7);
                opacity: 0;
            }
        }

        @keyframes mainFrmPop
        {
            0%
            {
                opacity: 0.3;
                transform: translateY(-60%) translateX(-50%);
            }

            100%
            {
                opacity: 1;
                transform: translateY(-50%) translateX(-50%);
            }
        }
</style>

</head>
<body>
<div class="whole-wrapper">
    <header class="header">
        <nav class="nav">
            <ul>
                <li>
                    <div id="category-toggle-btn">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </li>
                <li><a href="<%=request.getContextPath()%>/dplist?sort=score">베스트</a></li>
                <li><a href="<%=request.getContextPath()%>/dplist?sort=event">할인</a></li>
                <li><div id="logo"><a href="<%=request.getContextPath()%>">The Food Forum</a></div></li>
                <li>
                	<div class="search-box">
                        <input type="text" name="keyword" id="header-keyword" placeholder="상품검색">
                    </div>
                </li>
                <% if(loginMember == null) { %>
                <li id="login-btn">로그인</li>
                <% } else { %>
        		<li id="my-account-btn"><span><%=loginMember.getMemberName()%></span>님
			        <div class="my-account-wrapper">
			        	<div class="my-account-box">
				           	<ul>
				               	<li><a href="<%=request.getContextPath() %>/views/member/mypage_orderlist.jsp">주문내역</a></li>
				               	<li><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품리뷰</a></li>
				               	<li><a href="<%=request.getContextPath() %>/views/member/mypage_mileage.jsp">적립금</a></li>
				               	<li><a href="<%=request.getContextPath() %>/views/member/mypage_coupon.jsp">쿠폰</a></li>
				               	<li><a href="<%=request.getContextPath() %>/memberUpdate">계정정보</a></li>
				               	<li><a href="<%=request.getContextPath()%>/logout">로그아웃</a></li>
				           	</ul>
			        	</div>
			        </div>
			    </li>
               	<% } %>
                <%if(loginMember == null){%>
               	<li>
                	<a href="<%=request.getContextPath()%>/views/member/signup.jsp">회원가입</a>
                </li>
                <%} %>
          
                <li>
                	<div class="header-support-wrapper">
        				<span id="support-btn">고객센터</span>
	        			<div class="support-box">
		            		<ul>
		                		<li><a href="<%=request.getContextPath()%>/views/support/support_notice.jsp">공지사항</a></li>
		                		<li><a href="<%=request.getContextPath()%>/views/support/support_query.jsp">1:1문의</a></li>
		                		<li><a href="#">상품제안</a></li>
		            		</ul>
	        			</div>
    				</div>
    			</li>
                <% if(loginMember != null && "admin".equals(loginMember.getMemberId())) {%>
                <li><a href="<%=request.getContextPath()%>/adminMain"><svg width="48" height="48" viewBox="0 0 48 48">
    			<path d="M0 0h48v48H0z" fill="none"/>
    			<path fill="#50505A" d="M38.86 25.95c.08-.64.14-1.29.14-1.95s-.06-1.31-.14-1.95l4.23-3.31c.38-.3.49-.84.24-1.28l-4-6.93c-.25-.43-.77-.61-1.22-.43l-4.98 2.01c-1.03-.79-2.16-1.46-3.38-1.97L29 4.84c-.09-.47-.5-.84-1-.84h-8c-.5 0-.91.37-.99.84l-.75 5.3c-1.22.51-2.35 1.17-3.38 1.97L9.9 10.1c-.45-.17-.97 0-1.22.43l-4 6.93c-.25.43-.14.97.24 1.28l4.22 3.31C9.06 22.69 9 23.34 9 24s.06 1.31.14 1.95l-4.22 3.31c-.38.3-.49.84-.24 1.28l4 6.93c.25.43.77.61 1.22.43l4.98-2.01c1.03.79 2.16 1.46 3.38 1.97l.75 5.3c.08.47.49.84.99.84h8c.5 0 .91-.37.99-.84l.75-5.3c1.22-.51 2.35-1.17 3.38-1.97l4.98 2.01c.45.17.97 0 1.22-.43l4-6.93c.25-.43.14-.97-.24-1.28l-4.22-3.31zM24 31c-3.87 0-7-3.13-7-7s3.13-7 7-7 7 3.13 7 7-3.13 7-7 7z"/>
				</svg></a></li>
                <%} else { %>    	
                <li><a href="<%=request.getContextPath()%>/cart"><?xml version="1.0" ?><svg enable-background="new 0 0 26 26" version="1.1" id="cart" viewBox="0 0 26 26" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M24.25,2.5898438h-2.8359375c-0.0267944,0-0.0495605,0.0125122-0.0756226,0.0152588  c-0.0543823,0.0055542-0.1052246,0.0145874-0.156189,0.0315552c-0.0426636,0.0140991-0.0811768,0.0314941-0.1200562,0.0526123  c-0.0447388,0.024353-0.085083,0.0507813-0.1240845,0.0836792c-0.0358887,0.0301514-0.0663452,0.0622559-0.0960083,0.0984497  c-0.0305786,0.0372925-0.0567017,0.0752563-0.079895,0.1184692c-0.0239868,0.0443726-0.0408325,0.0899048-0.055542,0.1390991  c-0.0079956,0.0266724-0.0252686,0.0480957-0.0303955,0.0761108l-0.4295044,2.3473511L1.8930664,6.625  C1.8227539,6.6201172,1.7607422,6.6303711,1.6821289,6.6376953C1.2744141,6.6748047,0.9716797,7.0322266,1.0019531,7.4404297  c0.0024414,0.0307617,0.0063477,0.0605469,0.012207,0.0898438l1.2788086,6.9746094  c0.2924805,1.081543,1.1933594,2.1733398,2.5483398,2.1733398h13.3695679l-0.2862549,1.5644531H6.6748047  c-1.4243164,0-2.5834961,1.1591797-2.5834961,2.5834961c0,1.4248047,1.1591797,2.5839844,2.5834961,2.5839844  s2.5834961-1.1591797,2.5834961-2.5839844c0-0.3881226-0.0922241-0.7528687-0.2462769-1.0834961h6.9080811  c-0.1540527,0.3306274-0.2462769,0.6953735-0.2462769,1.0834961c0,1.4248047,1.1591797,2.5839844,2.5834961,2.5839844  s2.5834961-1.1591797,2.5834961-2.5839844c0-1.0127563-0.5914307-1.8825073-1.4421387-2.3057861l2.640564-14.430542H24.25  c0.4140625,0,0.75-0.3359375,0.75-0.75S24.6640625,2.5898438,24.25,2.5898438z M19.0220947,12.244812l-3.1782227,0.0499268  l0.1730957-1.8419189l3.3514404-0.1004639L19.0220947,12.244812z M3.1442871,10.8387451l3.1759644-0.0952148l0.2077637,1.6974487  l-3.081543,0.0484009L3.1442871,10.8387451z M7.3235474,10.7134399l3.4909058-0.1046143v1.7648315l-3.281311,0.0515747  L7.3235474,10.7134399z M10.8144531,9.6079102L7.2014771,9.7162476l-0.230835-1.885376l3.843811-0.2247314V9.6079102z   M11.8144531,7.5476685l3.4902344-0.2041016l-0.2006836,2.1357422l-3.2895508,0.0986328V7.5476685z M10.8144531,13.3739014  v1.8043213H7.8701782l-0.2148438-1.7546997L10.8144531,13.3739014z M11.8144531,13.3582153l2.9293823-0.0459595l-0.175354,1.8659668  h-2.7540283V13.3582153z M11.8144531,12.3579712v-1.7791138l3.1952515-0.0958252l-0.1717529,1.8274536L11.8144531,12.3579712z   M19.5525513,9.3459473l-3.4412842,0.1031494l0.2033691-2.1645508l3.6542358-0.2136841L19.5525513,9.3459473z M5.9707642,7.8893433  l0.227356,1.8569336l-3.236145,0.0970459C2.8256226,9.102478,2.717041,8.5267334,2.6245117,8.0849609L5.9707642,7.8893433z   M3.7548828,14.1743164l-0.1258545-0.687561l3.0212402-0.0474243l0.2128906,1.7388916H4.8413086  C4.1987305,15.1782227,3.8408203,14.4819336,3.7548828,14.1743164z M15.572937,15.1782227l0.1768188-1.8817749l3.0888062-0.0485229  l-0.3532104,1.9302979H15.572937z M7.7583008,20.8261719c0,0.5976563-0.4858398,1.0839844-1.0834961,1.0839844  s-1.0834961-0.4863281-1.0834961-1.0839844s0.4858398-1.0834961,1.0834961-1.0834961S7.7583008,20.2285156,7.7583008,20.8261719z   M18.2573242,21.9101563c-0.5976563,0-1.0834961-0.4863281-1.0834961-1.0839844s0.4858398-1.0834961,1.0834961-1.0834961  s1.0834961,0.4858398,1.0834961,1.0834961S18.8549805,21.9101563,18.2573242,21.9101563z"/></svg></a></li>
                <% } %>
            </ul>
        </nav>
        <div class="category-menu">
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=01" style="text-decoration: none;">채소</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V01">잎채소</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V02">마늘·파·양파</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V03">뿌리채소</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V04">고추·호박·오이·가지</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V05">나물</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V06">버섯</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=01&sub=V07">기타</a></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=02" style="text-decoration: none;">과일</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=02&sub=F01">생과일</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=02&sub=F02">냉동과일</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=02&sub=F03">건과일</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=02&sub=F04">잼·주스·통조림</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=03" style="text-decoration: none;">견과·곡류</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=03&sub=G01">쌀</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=03&sub=G02">잡곡</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=03&sub=G03">견과</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=04" style="text-decoration: none;">수산</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S01">생선류</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S02">조개류</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S03">해조류</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S04">건어물</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S05">오징어·낙지·문어</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=04&sub=S06">새우·게·랍스터</a></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=05" style="text-decoration: none;">정육·계란</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=05&sub=M01">돼지고기</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=05&sub=M02">소고기</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=05&sub=M03">닭고기·오리고기</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=05&sub=M04">계란</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=05&sub=M05">양념육</a></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=06" style="text-decoration: none;">유제품</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=06&sub=D01">우유</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=06&sub=D02">치즈</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=06&sub=D03">버터</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=06&sub=D04">요거트</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=07" style="text-decoration: none;">반찬</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=07&sub=C01">젓갈</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=07&sub=C02">국·탕·찌개</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=07&sub=C03">햄·소세지</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=07&sub=C04">두부·어묵</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=07&sub=C05">통조림</a></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=08" style="text-decoration: none;">소스·장류</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=08&sub=P01">액젓</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=08&sub=P02">장류</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=08&sub=P03">양념·소스</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=09" style="text-decoration: none;">오일·식초·면</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=09&sub=I01">오일</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=09&sub=I02">식초</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=09&sub=I03">면</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p><a href="<%=request.getContextPath()%>/dplist?major=10" style="text-decoration: none;">향신료·조미료</a></p>
                <span></span>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=10&sub=H01">소금</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=10&sub=H02">허브</a></li>
                    <li><a href="<%=request.getContextPath()%>/dplist?major=10&sub=H03">시즈닝·스탁</a></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
    </header>