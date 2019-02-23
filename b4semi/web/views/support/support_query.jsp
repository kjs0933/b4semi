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
            position: relative;
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




        .query-wrapper
        {
            font-family: 'Noto Sans KR';
            display: flex;
            flex-flow: column nowrap;

            width: 100%;
        }

        .query-wrapper-header
        {
            font-size: 25px;
            padding: 25px 0;
        }

        .query-board
        {
            border-top: 2px solid rgb(38, 85, 139);
            border-bottom: 1px solid #ccc;
            display: flex;
            flex-flow: column nowrap;
            font-size: 15px;
        }

        .query-board-header
        {
            display: flex;
            padding: 17px 0;
        }


        .query-board-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .query-board-header > div:nth-of-type(1){flex: 2 1 0;}
        .query-board-header > div:nth-of-type(2){flex: 15 1 0;}
        .query-board-header > div:nth-of-type(3){flex: 2 1 0;}
        .query-board-header > div:nth-of-type(4){flex: 3 1 0;}

        .query-board-cols
        {
            display: flex;
            padding: 15px 0;
            border-top: 1px solid #ccc;
        }

        .query-board-cols > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .query-board-cols > div:nth-of-type(1){flex: 2 1 0;}
        .query-board-cols > div:nth-of-type(2){flex: 15 1 0;}
        .query-board-cols > div:nth-of-type(3){flex: 2 1 0;}
        .query-board-cols > div:nth-of-type(4){flex: 3 1 0;}

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
        <div class="support-wrapper">
            <div class="support-side">
                <div class="support-nav-title">
                    <p>고객센터</p>
                </div>
                <div class="support-nav">
                    <div><a href="">공지사항<img src="images/arrow_right_black.png"></a>
                    </div>
                    <div class="current-tab"><a href="#">1:1문의<img src="images/arrow_right_black.png"></a>
                    </div>
                    <div><a href="">상품제안<img src="images/arrow_right_black.png"></a>
                    </div>
                </div>
            </div>
            <div class="support-content">
                <div class="query-wrapper">
                    <div class="query-wrapper-header">
                        <span>1:1 문의</span>
                    </div>
                    <div class="query-board">
                        <div class="query-board-header">
                            <div>번호</div>
                            <div>제목</div>
                            <div>작성자</div>
                            <div>작성일</div>
                        </div>
                        <div class="query-board-cols">
                            <div>1</div>
                            <div>상품에서 쥐가 나왔어요</div>
                            <div>정우진</div>
                            <div>2019-02-18</div>
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
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>