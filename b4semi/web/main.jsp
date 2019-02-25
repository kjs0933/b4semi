<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="views/common/header.jsp" %>
<%@ page import="com.b4.model.vo.DPList"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<DPList> best;
ArrayList<DPList> promotion;
try {
	best = (ArrayList<DPList>)request.getAttribute("best");
	if(best == null)
	{
		best = new ArrayList<DPList>();
	}
} catch (ClassCastException e) {
	best = new ArrayList<DPList>();
}
try {
	promotion = (ArrayList<DPList>)request.getAttribute("promotion");
	if(promotion == null)
	{
		promotion = new ArrayList<DPList>();
	}
} catch (ClassCastException e) {
	promotion = new ArrayList<DPList>();
}

String[] eventImage;
String[] eventURL;
String[] newImage;
String[] newURL;
try {
	eventImage= (String[])request.getAttribute("eventImage");
	if(eventImage == null)
	{
		eventImage=new String[0];
	}
} catch (ClassCastException e) {
	eventImage=new String[0];
}
try {
	eventURL= (String[])request.getAttribute("eventURL");
	if(eventURL == null)
	{
		eventURL=new String[0];
	}
} catch (ClassCastException e) {
	eventURL=new String[0];
}
try {
	newImage= (String[])request.getAttribute("newImage");
	if(newImage == null)
	{
		newImage=new String[0];
	}
} catch (ClassCastException e) {
	newImage=new String[0];
}
try {
	newURL= (String[])request.getAttribute("newURL");
	if(newURL == null)
	{
		newURL=new String[0];
	}
} catch (ClassCastException e) {
	newURL=new String[0];
}



%>
    <style>
        /*메인 슬라이드*/

        .main-slide-container
        {
            position: relative;
            width: 100%;
            height: 650px;
            overflow: hidden;
        }

        .main-image-track
        {
            position: relative;
            width: 100%;
            height: 100%;
            white-space: nowrap;
            left: -100%;
        }

        .main-image-track img
        {
            position: relative;
            object-fit: cover;
            width: 100%;
            height: 100%;
        }
        
        .main-slide-btn
        {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            opacity: 0;
            cursor: pointer;

            transition: 200ms linear;

        }
        
        .main-slide-btn--left
        {
            left: 0%;
            z-index: 1;
        }

        .main-slide-btn--right
        {
            right: 0%;
        }

        .main-slide-container:hover .main-slide-btn
        {
            opacity: 1;
        }

        .main-slide-navbar ul
        {
            list-style: none;
            display: flex;
            justify-content: center;
        }

        .main-slide-navbar li
        {
            position: relative;
            top: -50px;
            left: -19px;
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background-color: white;
            display: inline-block;
            margin: 0 7px;
            cursor: pointer;

            opacity: 0.7;
        }

        .main-slide-navbar li:hover
        {
            transform: scale(1.3);
        }

        .main-slide-navbar li.main-current-dot
        {
            opacity: 1;
        }


        /*베스트 상품*/


        .best-products
        {
            width: 100%;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
        }


        .best-products > p
        {
            margin: 40px 0 22px 0;
            font-size: 25px;
            font-weight: bold;
            
        }

        .best-products-box
        {
            position: relative;
            width: 1024px;
            height: auto;
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-around;
        }

        .best-products-box > div
        {
            font-size: 0.9em;
            border: 1px solid #ccc;
        }

        .best-products-box > div > div
        {
            height: 308px;
            width: 240px;
            background-color: black;
        }

        .best-products-box > div > div img
        {
            width: 100%;
            height: 100%;
            object-fit: fill;
        }

        .best-products-box > div > div img:hover
        {
            opacity: 0.8;
        }

        .best-products-box p
        {
            margin: 15px 20px 20px 20px;
            line-height: 1.6em;
            
        }

        /*이벤트, 새로운 상품 슬라이드*/

        .event-and-new
        {
            position: relative;
            width: 1024px;
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-around;
        }

        .event-box > p, .news-box > p
        {
            margin: 22px;
            font-size: 25px;
            font-weight: bold;
        }
        .news-box, .event-box
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
        }

        .event-and-new > div
        {
            position: relative;
            width: 500px;
            height: auto;
        }

        .event-slide-container, .new-slide-container
        {
            position: relative;
            width: 100%;
            height: auto;

            overflow: hidden;
        }

        .event-image-track, .new-image-track
        {
            position: relative;
            width: 100%;
            height: auto;
            white-space: nowrap;
            left: -100%;
        }

        .event-image-track img, .new-image-track img
        {
            position: relative;
            width: 500px;
            height: auto;
            object-fit: cover;
        }

        .event-slide-btn, .new-slide-btn
        {
            position: absolute;
            width: 70px;
            height: 70px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            opacity: 0;

            transition: 200ms linear;
        }

        .event-slide-container:hover .event-slide-btn, .new-slide-container:hover .new-slide-btn
        {
            opacity: 0.8;
        }

        .event-slide-btn--left, .new-slide-btn--left
        {
            left: 0;
            z-index: 1;
        }

        .event-slide-btn--right, .new-slide-btn--right
        {
            right: 0;
        }


        /* 프로모션 상품 */


        .promotion-products
        {
            position: relative;
            display: flex;
            width: 100%;
            flex-flow: column nowrap;
            align-items: center;
            padding-bottom: 42px;
        }

        .promotion-products > p
        {
            margin: 20px;
            font-size: 30px;
            font-weight: bold;
        }

        .promotion-products-container
        {
            position: relative;
            width: 1019px;
            height: auto;
            padding-left: 6px;
            overflow: hidden;
        }

        .promotion-products-image-track
        {
            position: relative;
            width: auto;
            height: auto;
            white-space: nowrap;

            left: -340px;
        }

        .promotion-products-image-box
        {
            position: relative;
            display: inline-block;
            width: 332px;
            margin: 0 8px 0 0;
            border: 1px solid #ccc;
            box-sizing: border-box;
            background-color: white;
        }

        .promotion-products-image-box > div
        {
            width: 330px;
            height: 424px;
            background-color: black;
        }
        
        .promotion-products-image-box > div img
        {
            width: 330px;
            height: auto;
        }

        .promotion-products-image-box > div img:hover
        {
            opacity: 0.8;
        }


        .promotion-products-image-box p
        {
            font-size: 0.8em;
            margin: 20px;
        }

        .promotion-products-slide-btn
        {
            position: absolute;
            float: left;
            width: 70px;
            height: 70px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            opacity: 0;
            transition: 200ms linear;
        }

        .promotion-products-container:hover .promotion-products-slide-btn
        {
            opacity: 0.8;
        }

        .promotion-products-slide-btn--left
        {
            left: 0;
            z-index: 1;
        }

        .promotion-products-slide-btn--right
        {
            right: 0;
        }
        
        
        .rating-holder {
            display: inline-block;
            background-color: #fff;
            box-sizing: border-box;
            display: flex;
            align-items: flex-end;
        }
        
        .c-rating
        {
        	display: flex;
        }

        .c-rating button {
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 0;
            text-indent: -9999px;
            outline: none;
            background: url("data:image/svg+xml;utf8,%3Csvg%20version%3D%221.1%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20width%3D%22512%22%20height%3D%22512%22%20viewBox%3D%220%200%20512%20512%22%3E%3Cpath%20fill%3D%22%23ddd%22%20d%3D%22M457.888 210.672l-139.504-20.272-62.384-126.4-62.384 126.4-139.504 20.272 100.944 98.384-23.84 138.928 124.768-65.6 124.768 65.6-23.84-138.928c0 0 100.944-98.384 100.944-98.384z%22%3E%3C%2Fpath%3E%3C%2Fsvg%3E") center/cover no-repeat;
        }
        
        
        
    </style>

    <div class="section-wrapper">
        <section class="main-slide">
            <div class="main-slide-container">
                <img src="images/arrow-left-white.png" alt="" width="120" height="120" class="main-slide-btn main-slide-btn--left">
                <div class="main-image-track"
                    ><img src="images/main_slide_01.jpg" alt="" class="main-current-slide"
                    ><img src="images/main_slide_03.jpg" alt=""
                    ><img src="images/main_slide_04.jpg" alt=""
                    ><img src="images/main_slide_05.jpg" alt=""
                    ><img src="images/main_slide_06.jpg" alt=""
                ></div>
                <img src="images/arrow-right-white.png" alt="" width="120" height="120" class="main-slide-btn main-slide-btn--right">
                <div class="main-slide-navbar">
                    <ul>
                        <li class="main-current-dot"></li
                        ><li></li
                        ><li></li
                        ><li></li
                        ><li></li>
                    </ul>
                </div>
            </div>
        </section>
        <section class="best-products">
            <p>베스트 상품</p>
            <div class="best-products-box">
            <%for(int i=0;i<best.size();i++) {%>
                <div><div><a href="#"><img src="<%=request.getContextPath()%>/upload/product/<%=best.get(i).getImg()%>" onError="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';"></a></div><p><b><%=best.get(i).getDisplayListTitle()%></b>
                  <%if(best.get(i).getDiscountRate()>0){%>
                  <br><del><%=best.get(i).getMinPrice()%>원</del> → <b><%=best.get(i).getDiscountMinPrice()%>원</b>
                  <%}else{ %>
                  <br><%=best.get(i).getMinPrice()%>원
                  <%}%>
                </p></div>
             <%}%>
            </div>
        </section>
        <br>
        <section class="event-and-new">
            <div class="event-box">
                <p>이벤트 상품</p>
                <div class="event-slide-container">
                    <img src="images/arrow-left-white-bold.png" alt="" class="event-slide-btn event-slide-btn--left">
                    <div class="event-image-track"
                    	<%for(int i=0; i<Math.min(eventURL.length,eventImage.length);i++){ 
                    	if(i==0){%>
                        ><a href="<%=request.getContextPath()%>/<%=eventURL[i]%>"><img src="<%=request.getContextPath()%>/images/<%=eventImage[i]%>" alt="" class="event-current-slide"></a
                        <%}else{%>
                        ><a href="<%=request.getContextPath()%>/<%=eventURL[i]%>"><img src="<%=request.getContextPath()%>/images/<%=eventImage[i]%>" alt=""></a
                        <%} }%>></div>
                    <img src="images/arrow-right-white-bold.png" alt="" class="event-slide-btn event-slide-btn--right">
                </div>
            </div>
            <div class="news-box">
                <p>신상품</p>
                <div class="new-slide-container">
                    <img src="images/arrow-left-white-bold.png" alt="" class="new-slide-btn new-slide-btn--left">
                    <div class="new-image-track"
                        <%for(int i=0; i<Math.min(newURL.length,newImage.length);i++){ 
                    	if(i==0){%>
                        ><a href="<%=request.getContextPath()%>/<%=newURL[i]%>"><img src="<%=request.getContextPath()%>/images/<%=newImage[i]%>" alt="" class="new-current-slide"></a
                        <%}else{%>
                        ><a href="<%=request.getContextPath()%>/<%=newURL[i]%>"><img src="<%=request.getContextPath()%>/images/<%=newImage[i]%>" alt=""></a
                        <%} }%>></div>
                    <img src="images/arrow-right-white-bold.png" alt="" class="new-slide-btn new-slide-btn--right">
                </div>
            </div>
        </section>
        <section class="promotion-products">
            <p>프로모션 상품</p>
            <div class="promotion-products-container">
                <div class="promotion-products-image-track"
                <%for(int i=0; i< promotion.size();i++){%>
                ><div class="promotion-products-image-box"><div><a href="#"><img src="<%=request.getContextPath()%>/upload/product/<%=promotion.get(i).getImg()%>" onError="this.src='<%=request.getContextPath()%>/images/dp_sample.jpg';"></a></div><p><b>★<%=promotion.get(i).getReviewScore()%> <%=promotion.get(i).getDisplayListTitle()%></b>
                <%if(promotion.get(i).getDiscountRate()>0){%>
                  <br><del><%=promotion.get(i).getMinPrice()%>원</del> → <b><%=promotion.get(i).getDiscountMinPrice()%>원</b>&nbsp;&nbsp;(단위:<%=promotion.get(i).getProductUnit()%>)
                  <%}else{ %>
                  <br><%=promotion.get(i).getMinPrice()%>원&nbsp;&nbsp;(단위:<%=promotion.get(i).getProductUnit()%>)
                  
                  <%}%>
                	</p></div
               	<%}%>></div>
                <img src="images/arrow-left-white-bold.png" class="promotion-products-slide-btn promotion-products-slide-btn--left">
                <img src="images/arrow-right-white-bold.png" class="promotion-products-slide-btn promotion-products-slide-btn--right">
            </div>
        </section>
    </div>
    
    <script>
    //메인 슬라이드

    const mainImageTrack = $('.main-image-track');
    const navBar = $('.main-slide-navbar ul');
    const mainLeftBtn = $('.main-slide-btn--left');
    const mainRightBtn = $('.main-slide-btn--right');
    const dots = navBar.children();

    //버튼과 네비게이션 점에 이벤트 설정
    $(() => {
        mainLeftBtn.on('click', prevSlide);
        mainRightBtn.on('click', nextSlide);
        dots.on('click', navBarClicked);
    });

    //슬라이드 앞으로 이동 함수
    const nextSlide = (e, isDot) => {
        const currentSlide = mainImageTrack.children().first();
        const targetSlide = currentSlide.next();

        //점 클릭이면 애니메이션 미적용
        if (isDot) {
            mainImageTrack.append(currentSlide);
            moveDot('next');
        }
        //버튼 클릭이면 애니메이션 적용
        else {
            //이전 애니메이션이 작동중이면 함수 정지
            if (mainImageTrack.is(':animated')) return;

            mainImageTrack.append(currentSlide);
            mainImageTrack.css('left', '0');
            mainImageTrack.animate({ left: '-100%', }, 200);
            moveDot('next');
        }
    }

    //슬라이드 뒤로 이동 함수
    const prevSlide = (e, isDot) => {
        const currentSlide = mainImageTrack.children().first();
        const targetSlide = mainImageTrack.children().last();
        //점 클릭이면 애니메이션 미적용
        if (isDot) {
            mainImageTrack.prepend(targetSlide);
            moveDot('prev');
        }
        //버튼 클릭이면 애니메이션 적용
        else {
            //이전 애니메이션이 작동중이면 함수 정지
            if (mainImageTrack.is(':animated')) return;

            mainImageTrack.prepend(targetSlide);
            mainImageTrack.css('left', '-200%');
            mainImageTrack.animate({ left: '-100%' }, 200);
            moveDot('prev');
        }
    }

    //네비게이션 점 이동 함수
    const moveDot = (direction) => {
        const firstDot = navBar.children().first();
        const lastDot = navBar.children().last();

        //점 이동 방향을 매개변수로 구분해 분기
        switch (direction) {
            case 'prev': navBar.append(firstDot); break;
            case 'next': navBar.prepend(lastDot); break;
        }
    }

    //네비게이션 점 클릭시 슬라이드 이동 함수
    const navBarClicked = (e) => {
        if (!e.target.closest('li')) return;
        //클릭 시점의 네비게이션 점 요소들 배열
        const dots = navBar.children();
        //current-dot 클래스가 적용된(흰색)점의 인덱스
        const currentDotIndex = dots.index($('.main-current-dot'));
        //클릭한 점의 인덱스
        const clickedDotIndex = dots.index($(e.target));
        //현재 인덱스와 클릭한 인덱스 간의 간격
        const DotsDistance = currentDotIndex - clickedDotIndex;

        //점 클릭으로 인한 함수 요청인지 알려주기 위한 불린 상수
        const isDot = true;

        //인덱스 간격을 기준으로한 슬라이드 이동 로직
        if (DotsDistance > 0) {
            for (let i = 0; i < DotsDistance; i++) {
                prevSlide(e, isDot);
            }
        }
        else {
            for (let i = 0; i < Math.abs(DotsDistance); i++) {
                nextSlide(e, isDot);
            }
        }
    }

    setInterval(nextSlide, 5000);

    //이벤트 슬라이드

    const eventImageTrack = $('.event-image-track');
    const eventLeftBtn = $('.event-slide-btn--left');
    const eventRightBtn = $('.event-slide-btn--right');

    //버튼과 네비게이션 점에 이벤트 설정
    $(() => {
        eventLeftBtn.on('click', eventPrevSlide);
        eventRightBtn.on('click', eventNextSlide);
    });

    //슬라이드 앞으로 이동 함수
    const eventNextSlide = () => {
        const currentSlide = eventImageTrack.children().first();
        const targetSlide = currentSlide.next();

        if (eventImageTrack.is(':animated')) return;
  
        eventImageTrack.append(currentSlide);

        eventImageTrack.css('left', '0');

        eventImageTrack.animate({ left: '-100%', }, 200);
    }

    //슬라이도 뒤로 이동 함수
    const eventPrevSlide = () => {
        const currentSlide = eventImageTrack.children().first();
        const targetSlide = eventImageTrack.children().last();

        if (eventImageTrack.is(':animated')) return;

        eventImageTrack.prepend(targetSlide);
        eventImageTrack.css('left', '-200%');
        eventImageTrack.animate({ left: '-100%' }, 200);
    }

    //새상품 슬라이드

    const newImageTrack = $('.new-image-track');
    const newLeftBtn = $('.new-slide-btn--left');
    const newRightBtn = $('.new-slide-btn--right');

    //버튼과 네비게이션 점에 이벤트 설정
    $(() => {
        newLeftBtn.on('click', newPrevSlide);
        newRightBtn.on('click', newNextSlide);
    });

    //슬라이드 앞으로 이동 함수
    const newNextSlide = () => {
        const currentSlide = newImageTrack.children().first();
        const targetSlide = currentSlide.next();

        if (newImageTrack.is(':animated')) return;
       
        newImageTrack.append(currentSlide);
        newImageTrack.css('left', '0');
        newImageTrack.animate({ left: '-100%', }, 200);
    }

    //슬라이도 뒤로 이동 함수
    const newPrevSlide = () => {
        const currentSlide = newImageTrack.children().first();
        const targetSlide = newImageTrack.children().last();

        if (newImageTrack.is(':animated')) return;

        newImageTrack.prepend(targetSlide);
        newImageTrack.css('left', '-200%');
        newImageTrack.animate({ left: '-100%' }, 200);
    }

    //프로모션 상품 슬라이드

    const klovesImageTrack = $('.promotion-products-image-track');
    const klovesLeftBtn = $('.promotion-products-slide-btn--left');
    const klovesRightBtn = $('.promotion-products-slide-btn--right');

    //버튼과 네비게이션 점에 이벤트 설정
    $(() => {
        klovesLeftBtn.on('click', klovesPrevSlide);
        klovesRightBtn.on('click', klovesNextSlide);
    });

    //슬라이드 앞으로 이동 함수
    const klovesNextSlide = () => {
        const currentSlide = klovesImageTrack.children().first();
        const targetSlide = currentSlide.next();

        if (klovesImageTrack.is(':animated')) return;
       
        klovesImageTrack.append(currentSlide);
        klovesImageTrack.css('left', '0');
        klovesImageTrack.animate({ left: '-340px', }, 200);
    }

    //슬라이도 뒤로 이동 함수
    const klovesPrevSlide = () => {
        const currentSlide = klovesImageTrack.children().first();
        const targetSlide = klovesImageTrack.children().last();

        if (klovesImageTrack.is(':animated')) return;

        klovesImageTrack.prepend(targetSlide);
        klovesImageTrack.css('left', '-680px');
        klovesImageTrack.animate({ left: '-340px' }, 200);
    }

    //슬라이드 인터벌
    setInterval(eventNextSlide, 5000);
    setInterval(newNextSlide, 5000);
    setInterval(klovesNextSlide, 5000);
    </script>

<%@ include file="views/common/footer.jsp" %>