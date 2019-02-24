<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
    <style>
    
        .support-wrapper
        {
            display: flex;
            font-family: 'Noto Sans KR';
            width: 1024px;
            margin-top: 100px;
        }

        .support-wrapper > div:first-of-type
        {
            flex: 2 1 0;
        }

        .support-wrapper > div:last-of-type
        {
            flex: 7 1 0;
        }

        .support-nav-title > p
        {
            margin: 20px 0;
            font-size: 30px;
        }
        
        .support-nav
        {
            display: flex;
            flex-flow: column nowrap;
        }

        .support-nav > div
        {
            height: 50px;
            border: 1px solid #ccc;
            border-bottom: none;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-sizing: border-box;
            padding: 0 30px;
            font-size: 15px;

            cursor: pointer;
        }

        .support-nav > div:hover
        {
            background-color: rgb(248, 248, 248);
        }

        .support-nav a
        {
            text-decoration: none;
            color: black;
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
        }

        .support-nav img
        {
            width: 25px;
            height: 25px;
            position: absolute;
            right: 0;
        }

        .support-nav > div:last-of-type
        {
            border-bottom: 1px solid #ccc;
        }

        .current-tab
        {
            background-color: rgb(248, 248, 248);
        }

        .support-content
        {
            display: flex;
            flex-flow: column nowrap;
            justify-content: center;
            margin-left: 30px;
        }

        .support-board-title
        {
            display: flex;
        }

        .support-board-title p:first-of-type
        {
            margin: 25px 0;
            font-size: 25px;
        }
        .support-board-title p:last-of-type
        {
            margin: 34px 20px;
            font-size: 15px;
        }

        .support-board-rows
        {
            border-top: 2px solid rgb(38, 85, 139);
            font-size: 12px;
        }

        .support-board-header
        {
            display: flex;
        }

        .support-board-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 17px 0;
        }

        .support-board-header > div:nth-of-type(1){flex: 1 0;}
        .support-board-header > div:nth-of-type(2){flex: 14 1 0;}
        .support-board-header > div:nth-of-type(3){flex: 4 1 0;}
        .support-board-header > div:nth-of-type(4){flex: 3 1 0;}
        .support-board-header > div:nth-of-type(5){flex: 1 1 0;}


        .support-board-cols
        {
            display: flex;

        }

        .support-board-cols > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 15px 0;
            border-top: 1px solid rgb(230, 230, 230);
        }

        .support-board-cols:last-of-type
        {
            border-bottom: 1px solid rgb(38, 85, 139);
        }

        .support-board-cols > div:nth-of-type(1){flex: 1 1 0;}
        .support-board-cols > div:nth-of-type(2){flex: 14 1 0;}
        .support-board-cols > div:nth-of-type(3){flex: 4 1 0;}
        .support-board-cols > div:nth-of-type(4){flex: 3 1 0;color: #aaa;}
        .support-board-cols > div:nth-of-type(5){flex: 1 1 0;color: #aaa;}



        .pagebar img
        {
            width: 40%;
            height: 40%;
        }

        .pagebar
        {
            display: flex;
            align-self: center;
            margin: 30px;
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
        <div class="support-wrapper">
            <div class="support-side">
                <div class="support-nav-title">
                    <p>고객센터</p>
                </div>
                <div class="support-nav">
                    <div class="current-tab"><a href="<%=request.getContextPath()%>/views/support/support_notice.jsp">공지사항<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
                    </div>
                    <div><a href="<%=request.getContextPath()%>/views/support/support_query.jsp">1:1문의<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
                    </div>
                    <div><a href="">상품제안<img src="<%=request.getContextPath()%>/images/arrow_right_black.png"></a>
                    </div>
                </div>
            </div>
            <div class="support-content">
                <div class="support-board-title">
                    <p>공지사항</p>
                    <p>더 푸드 포럼의 새로운 소식들을 확인하세요.</p>
                </div>
                <div class="support-board-rows">
                    <div class="support-board-header">
                        <div>번호</div>
                        <div>제목</div>
                        <div>작성자</div>
                        <div>작성일</div>
                        <div>조회</div>
                    </div>
                    <div class="support-board-cols">
                        <div>8</div>
                        <div>공지 8</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>7</div>
                        <div>공지 7</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>6</div>
                        <div>공지 6</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>5</div>
                        <div>공지 5</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>4</div>
                        <div>공지 4</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>3</div>
                        <div>공지 3</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>2</div>
                        <div>공지 2</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                    <div class="support-board-cols">
                        <div>1</div>
                        <div>공지 1</div>
                        <div>TheFoodForum</div>
                        <div>2019-02-13</div>
                        <div>95</div>
                    </div>
                </div>

                <div class="pagebar">
                    <div><img src="image/board-arrow-left.png"></div>
                    <div>1</div>
                    <div>2</div>
                    <div>3</div>
                    <div>4</div>
                    <div>5</div>
                    <div><img src="image/board-arrow-right.png"></div>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>