<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
    <style>
        .support-notice-view-wrapper
        {
            width: 1024px;
            font-family: 'Noto Sans KR';
            font-size: 14px;
        }

        .support-notice-view-wrapper input
        {
            font-family: 'Noto Sans KR';
            font-size: 12px;
            width: 120px;
            height: 40px;
            margin: 0;
            border: none;
            background-color: rgb(42, 71, 114);
            color: white;
            margin: 0 10px;
            border-radius: 2px;
            cursor: pointer;
        }

        .support-notice-view-wrapper input:focus
        {
            outline: none;
        }

        .support-notice-view-title p
        {
            font-size: 21px;
            display: inline-block;
        }

        .support-notice-view-title span
        {
            margin-left: 10px;
        }

        .support-notice-view
        {
            display: flex;
            flex-flow: column nowrap;
            border-top: 2px solid rgb(42, 71, 114);
            border-bottom: 1px solid rgb(42, 71, 114);
        }

        .support-notice-view > div
        {
            display: flex;  
            border-bottom: 1px solid #eee;
        }

        .support-notice-view > div > div
        {
            display: flex;
            justify-items: flex-start;
            padding: 15px;
        }

        .support-notice-view > div > div:nth-of-type(1){flex: 1 1 0;  background-color: rgb(245, 245, 245);}
        .support-notice-view > div > div:nth-of-type(2){flex: 9 1 0;}

        .support-notice-view-date-hit > div:nth-of-type(1){flex: 1 1 0 !important;padding-right: 21px !important;}
        .support-notice-view-date-hit > div:nth-of-type(2){flex: 4 1 0 !important;}        
        .support-notice-view-date-hit > div:nth-of-type(3){flex: 1 1 0; background-color: rgb(245, 245, 245) !important;}
        .support-notice-view-date-hit > div:nth-of-type(4){flex: 4 1 0;}


        .support-notice-view-content > div
        {
            background-color: white !important;
            
        }

        .support-notice-view-btns
        {
            display: flex;
            justify-content: flex-end;
            padding: 10px 0;
        }

        .support-notice-prev > div, .support-notice-next > div
        {
            background-color: white !important;
            padding: 5px 5px !important;
        }

        .support-notice-prev > div > img, .support-notice-next > div > img
        {
            width: 13px;
            height: 13px;
            margin-right: 5px;
            margin-top: 4px;
        }
    </style>

<section>
    <div class="support-notice-view-wrapper">
        <div class="support-notice-view-title">
            <p>공지사항</p><span>더 푸드 포럼의 새로운 소식들을 확인하세요.</span>
        </div>
        <div class="support-notice-view">
            <div class="support-notice-view-title">
                <div>제목</div>
                <div>[가격인상공지] 미니 드리퍼 5종</div>
            </div>
            <div class="support-notice-view-wrtier">
                <div>작성자</div>
                <div>TheFoodForum</div>
            </div>
            <div class="support-notice-view-date-hit">
                <div>작성일</div>
                <div>2019-02-19</div>
                <div>조회수</div>
                <div>338</div>
            </div>
            <div class="support-notice-view-content">
                <div>
                    dfasdfasdf
                </div>
            </div>
            <div class="support-notice-view-btns">
                <input type="button" value="수정">
                <input type="button" value="목록보기">
            </div>
            <div class="support-notice-prev">
                <div><img src="arrow-up.png">이전글</div>
                <div>[가격인상공지] 무농약</div>
            </div>
            <div class="support-notice-next">
                <div><img src="arrow-down.png">다음글</div>
                <div>[가격인상공지] 무농약</div>
            </div>
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp" %>