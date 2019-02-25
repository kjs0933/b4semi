<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.MypageHeader" %>
<%@ page import="com.b4.model.vo.IssuedCoupon" %>

<%
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
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



        .review-form-wrapper
        {
            width: 1024px;
            display: flex;
            flex-flow: column nowrap;
            font-family: 'Noto Sans KR';
            margin-top: 25px;
        }

        .review-form-wrapper input
        {
            font-family: 'Noto Sans KR';
            border: 1px solid #ccc;
        }

        .review-frm
        {
            display: flex;
            flex-flow: column nowrap;
            font-size: 13px;
            width: 100%;
        }

        .review-form-header
        {
            width: 100%;
            font-size: 25px;
            border-bottom: 2px solid rgb(38, 85, 139);
            padding-bottom: 25px;
        }

        .review-product-info
        {
            display: flex;
            padding: 5px 0;
        }

        .review-product-info img
        {
            width: 70px;
        }

        .review-product-info > div 
        {
            padding: 15px;
            display: flex;
            align-items: center;
        }

        .review-frm > div
        {
            display: flex;
            border-top: 1px solid #ccc;
        }

        .review-frm > div:last-of-type{border-bottom: 1px solid #ccc;}

        .review-frm > div > div
        {
            display: flex;
            flex-flow: column nowrap;
            padding: 15px;
            padding-right: 0;

            position: relative;
        }


        .review-frm > div > div:first-of-type{background-color: #eee;flex: 1 1 0; align-items: center; justify-content: center;}
        .review-frm > div > div:last-of-type{flex: 10 1 0;}

        .review-header input
        {
            height: 30px;
        }

        .review-content textarea
        {
            max-width: 100%;
            resize: none;
            border: 1px solid #ccc;
        }

        .review-content p
        {
            position: absolute;
            right: 10px;
            bottom: 10px;
            color: gray;
        }

        .review-upload > div > div
        {
            display: flex;
        }

        .added-image-box > img:first-of-type
        {
            width: 80px;
            height: 80px;
        }

        .added-image-box{position: relative; margin-right: 10px;}


        .x-mark
        {
            position: absolute;
            width: 20px;
            height: 20px;
            right: 0;
            top: 0;
            cursor: pointer;
        }

        .review-upload > div > div > span
        {
            font-size: 13px;
        }

        
        .upload-image-container
        {
            width: 78px;
            height: 78px;
            border: 1px dotted #ccc;
            position: relative;
        }

        .upload-image-container > input
        {
            width: 100%;
            height: 100%;
            opacity: 0;
            cursor: pointer;
        }

        .upload-image-container:hover
        {
            background-color: #eee;
        }

        .upload-image-container > span
        {
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            font-size: 20px;
        }

        
        .review-upload p
        {
            position: absolute;
            right: 10px;
            bottom: 0;
            color: gray;
        }


        .review-form-wrapper input[type="submit"]
        {
            width: 150px;
            height: 45px;
            background-color: white;
            border: 1px solid #ccc;
            align-self: center;
            margin: 30px 0;

            color: #ccc;
        }

        .review-form-wrapper input[type="submit"]:focus{outline: none;}

        .review-submit-btn-active
        {
            background-color: rgb(38, 85, 139);
            color: white;
            border: none;
        }

        

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
                <div><a href="<%=request.getContextPath() %>/memberOrderlist">주문내역</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="review-form-wrapper">
                    <div class="review-form-header">
                        후기 작성
                    </div>
                    <div class="review-product-info">
                        <div><img src="images/order_sample_4.jpg"></div>
                        <div><b>[몽상클레르] 팡오 쇼콜라 크렘</b></div>
                    </div>
                    <form action="#" method="post" class="review-frm">
                        <div class="review-header">
                            <div>제목</div>
                            <div><input type="text" name="" id=""></div>
                        </div>
                        <div class="review-content">
                            <div>후기작성</div>
                            <div><textarea name="" id="" cols="30" rows="10"></textarea>
                                <p><span class="letter-count">0</span>자 / 최소 10자</p>
                            </div>
                        </div>
                        <div class="review-upload">
                            <div>사진등록</div>
                            <div>
                                <div>
                                    <div class="added-image-box"><img src="images/order_sample_4.jpg"><img
                                            class="x-mark" src="images/x_mark.png"></div>
                                    <div class="upload-image-container">
                                        <span>+</span>
                                        <input type="file" name="originalFile" id="original-file">
                                    </div>
                                </div>
                                <div>
                                    <span>
                                       	 구매한 상품이 아니거나 캡쳐 사진을 첨부할 경우, 통보없이 삭제 및 적립 혜택이 취소됩니다.
                                    </span>
                                    <p><span class="added-image-count">0</span>장 / 최대 5장</p>
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="등록하기">
                    </form>
                </div>
            </div>
        </div>
    </section>
    <script>

        //리뷰 본문 내용 길이 하단에 출력
        const textarea = $('textarea');
        const lettercount = $('.letter-count');

        $(() => {
            textarea.on('keyup', () => {
                lettercount.text(textarea.val().split(' ').join('').length);
            });
        });


    </script>
<%@ include file="/views/common/footer.jsp" %>