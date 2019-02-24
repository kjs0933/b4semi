<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.Member"%>
<%@ page import="com.b4.model.vo.MypageHeader" %>

<%
	MypageHeader mh = (MypageHeader)request.getAttribute("mh");
	if(mh == null){mh = new MypageHeader();}
	
	Member lm = (Member)request.getAttribute("loginMember");
	String memberPw = lm.getMemberPw();
%>	
	
    <style>
    
    	section
    	{
    		position: relative;
    	}
    	
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
        
        .member-update-wrapper
        {
            font-family: 'Noto Sans KR';
            width: 1024px;
            
        }

        .member-update-header
        {
            font-size: 25px;
            margin: 30px 0;
            border-bottom: 2px solid rgb(42, 71, 114);
            padding-bottom: 25px;
        }

        .member-update-wrapper input
        {
            font-family: 'Noto Sans KR';
            border: 1px solid #ccc;
            padding: 5px;
            box-sizing: border-box;
            border-radius: 2px;
        }

        #member-id
        {
            background-color: #eee;
        }

        .member-update-frm > div > div > input
        {
            height: 40px;
            width: 255px;
        }

        .member-update-frm > div > input
        {
            width: 150px;
            height: 40px;
            border: 1px solid #ccc;
            background-color: white;
            margin: 10px;
            cursor: pointer;
            color: black;
        }

        .member-update-wrapper input[type="submit"]
        {
            background-color: rgb(42, 71, 114);
            border: none;
            color: white;
        }

        .member-update-frm
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
        }

        .member-update-frm > div
        {
            display: flex;
            align-items: center;
            position: relative;
        }

        .member-update-frm > div > div
        {
            padding: 15px;
        }

        .member-update-frm > div > div:nth-of-type(1){flex: 1 1 0; align-self: flex-start;}
        .member-update-frm > div > div:nth-of-type(2){flex: 4 1 0;}
        

        .valid-msg
        {
            font-size: 13px;
        }

        .member-update-input-msg
        {
            display: block;
            font-size: 13px;
            color: rgb(38, 85, 139);
            margin: 10px 0;
        }

        .update-btn-set
        {
            width: 502px;
            display: flex;
            justify-content: center;
            margin: 30px 0;
        }
        
     
    </style>
</head>
<body>
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
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_orderlist.jsp">주문내역</a></div>
                <div><a href="<%=request.getContextPath() %>/views/member/mypage_review_before.jsp">상품후기</a></div>
                <div><a href="<%=request.getContextPath() %>/memberMileage">적립금</a></div>
                <div><a href="<%=request.getContextPath() %>/memberCoupon">쿠폰</a></div>
                <div class="mypage-tab-current"><a href="<%=request.getContextPath() %>/memberUpdate">개인정보수정</a></div>
            </div>
            <div class="mypage-body">
                <div class="member-update-wrapper">
                    <div class="member-update-header">
                        	회원 정보 수정
                    </div>
                    <form action="<%=request.getContextPath()%>/memberUpdateEnd" method="post" class="member-update-frm" autocomplete="off">
                        <div>
                            <div>아이디</div>
                            <div>
                                <input type="text" name="memberId" id="member-id" value="<%=lm.getMemberId() %>" readonly="readonly">
                            </div>
                        </div>
                        <div>
                            <div>현재 비밀번호</div>
                            <div>
                            	<input type="hidden" name="checkPw" id="check-pw">
                                <input type="password" name="memberPw" id="member-pw">
                                <div class="valid-msg"></div>                 
                            </div>
                        </div>
                        <div>
                            <div>새 비밀번호</div>
                            <div>
                                <input type="hidden" name="checkPwDif" id="check-pw-dif">
                                <input type="password" name="memberPwNew" id="member-pw-new">
                                <div class="valid-msg"></div>                                         
                                <span class="member-update-input-msg">
                                	현재 비밀번호와 다르게 입력<br>
                                    8자 이상 입력<br>
                                                          숫자/특수문자 각1회, 영문 2개이상 조합
                                </span>
                            </div>
                        </div>
                        <div>
                            <div>새 비밀번호 확인</div>
                            <div>
                                <input type="password" name="memberPwNewCk" id="member-pw-new-ck">
                                <div class="valid-msg"></div>                 
                            </div>
                            
                        </div>
                        <div>
                            <div>이름</div>
                            <div>
                                <input type="text" name="memberName" id="member-name" value="<%=lm.getMemberName()%>">
                                <div class="valid-msg"></div>                                         
                            </div>
                            
                        </div>
                        <div>
                            <div>이메일</div>
                            <div>
                                <input type="email" name="memberEmail" id="member-email" value="<%=lm.getMemberEmail()%>">
                                <div class="valid-msg"></div>                                         
                            </div>
                            
                        </div>
                        <div>
                            <div>휴대폰</div>
                            <div>
                                <input type="tel" name="memberPhone" id="memberPhone" value="<%=lm.getMemberPhone()%>">
                                <div class="valid-msg"></div>                 
                                
                            </div>
                        </div>
                        <div class="update-btn-set">
                            <input id="cancel" type="button" value="취소">
                            <input id="leave" type="button" value="탈퇴">
                            <input type="submit" value="수정">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
<script>
    const memberUpdateFrm = $('.member-update-frm');
    const memberUpdatePw = $('.member-update-frm #member-pw');
    const memberUpdatePwNew = $('.member-update-frm #member-pw-new');
    const memberUpdatePwNewCk = $('.member-update-frm #member-pw-new-ck');
    const memberUpdateName = $('.member-update-frm #member-name');
    const memberUpdateEmail = $('.member-update-frm #member-email');
    const memberUpdatePhone = $('.member-update-frm #member-phone');
    const checkPw = $('#check-pw');
    const checkPwDif = $('#check-pw-dif');
    
    const validationMsg = $('.valid-msg');

    const memberUpdateInputs = $('.valid-msg').prev();


    //회원가입수정 공백체크
    const checkBlank = () => {
        for(let i = 0 ; i < memberUpdateInputs.length ; i++)
        {
            if(memberUpdateInputs[i].value.trim().length == 0)
            {
                memberUpdateInputs[i].focus();
                return;
            }
        }
    }

    //각 input blur시 체크 이벤트
    $(() => {
    	memberUpdatePw.on('blur', checkCurrentPw);
        memberUpdatePwNew.on('blur', pwRegExpValid);
        memberUpdatePwNewCk.on('blur', pwCkNewValid);
        memberUpdateEmail.on('blur', emailRegExpValid);
        memberUpdatePhone.on('blur', phoneRegExpValid);
    });

    //새 패스워드 정규식
    const pwRegExpValid = (e) => {
        if(memberUpdatePwNew.val().length == 0) return;
        const regex = new RegExp('(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,16}$');
        let result = regex.test(memberUpdatePwNew.val());
        if(!result)
       	{
        	$(e.target).next().css('color', 'crimson').text('잘못된 패스워드 조합입니다.');
       	}
        else
        {
        	$(e.target).next().css('color', 'green').text('사용 가능한 패스워드 입니다.');
        }
        
        if(!result) return false;
        pwCkDifference(e);
        if(checkPwDif.val() == 'false'){result = false;}
        return result;
    }
    
    //새 패스워드가 기존패스워드와 다른지 여부를 판단
    const pwCkDifference = e => {
    	
    	$.ajax({
    		url: '<%=request.getContextPath()%>/checkPw',
    		type: 'post',
    		data: {'memberPwCk':memberUpdatePwNew.val(), 'memberPwOri':'<%=lm.getMemberPw()%>'},
    		dataType: 'text',
    		success: data => {
    			if(data == 1)
    			{
    				$(e.target).next().css('color', 'crimson').text('기존 패스워드와 동일한 패스워드입니다.');
    				checkPwDif.val('false');
    			}
    			else
    			{
    				$(e.target).next().css('color', 'green').text('사용 가능한 패스워드 입니다.');
    				checkPwDif.val('true');
    			}
    		}
    	});
    }
    
    //새 패스워드 확인 일치여부
    const pwCkNewValid = (e) => {
    	if(memberUpdatePwNewCk.val().trim().length == 0) return;
    	if(memberUpdatePwNew.val().trim() != memberUpdatePwNewCk.val().trim())
    	{
    		$(e.target).next().css('color', 'crimson').text('패스워드가 일치하지 않습니다.');
    		return false;
    	}
    	else
    	{
    		if(memberUpdatePwNew.val().trim().length == 0) return false;
    		$(e.target).next().css('color', 'green').text('패스워드가 일치합니다.');
    		return true;
    	}
    }
    
    //이메일 정규식
    const emailRegExpValid = (e) => {
	    if(memberUpdateEmail.val().length == 0) return;
	        
	    const regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	    const result = regex.test(memberUpdateEmail.val());
	    if(!result)
	   	{
	    	$(e.target).next().css('color', 'crimson').text('이메일이 올바른 형식이 아닙니다.');
	   	}
	    else
	   	{
	    	$(e.target).next().text('');
	   	}
	    return result;
    }
    
    //휴대전화 정규식
    const phoneRegExpValid = (e) => {
        if(memberUpdatePhone.val().length == 0) return;
        
        const regex = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        const result = regex.test(memberUpdatePhone.val());
        if(!result) 
        {
        	$(e.target).next().css('color', 'crimson').text('전화번호가 올바른 형식이 아닙니다.');
        }
        else
      	{
        	$(e.target).next().text('');
        }
        return result;
    }
    
    //기존 비밀번호 일치 여부 확인
    const checkCurrentPw = (e) => {
    	if(memberUpdatePw.val().trim().length == 0) return;
    	$.ajax({
    		url: '<%=request.getContextPath()%>/checkPw',
    		type: 'post',
    		data: {'memberPwCk' : memberUpdatePw.val(), 'memberPwOri' : '<%=memberPw%>'},
    		dataType: 'text',
    		success: data => {
    			if(data == 1)
    			{
    				$(e.target).next().css('color', 'green').text('패스워드가 일치합니다.');
    				checkPw.val('true');
    			}
    			else
    			{
    				checkPw.val('false');
    				$(e.target).next().css('color', 'crimson').text('패스워드가 일치하지 않습니다.');	
    			}
    		}
    	});
    }
    
    //취소버튼 클릭시
    $(() => {
    	const cancel = $('#cancel');
    	cancel.on('click', () => {
    	   	memberUpdatePw.val('');
    	    memberUpdatePwNew.val('');
    	    memberUpdatePwNewCk.val('');
    	    memberUpdateName.val('<%=lm.getMemberName()%>');
    	    memberUpdateEmail.val('<%=lm.getMemberEmail()%>');
    	    memberUpdatePhone.val('<%=lm.getMemberPhone()%>');
    	    validationMsg.text('');
    	    checkPwDif.val('');
    	    checkPw.val('');
    	});
    });
   
    //회원정보 수정 submit시
    $(() => {
    	memberUpdateFrm.on('submit', (e) => {
    		checkBlank();
    		
    		let invalidCount = 0;
    		
    		if(checkPw.val() != 'true') invalidCount++;
        	if(!checkCurrentPw) invalidCount++;
        	if(!pwRegExpValid) invalidCount++;
        	if(!pwCkNewValid) invalidCount++;
        	if(!emailRegExpValid) invalidCount++;
        	if(!phoneRegExpValid) invalidCount++;
            if(invalidCount==0) {memberUpdateFrm.submit();}
            else{alert("입력정보가 조건에 맞지 않습니다.")};
    	});
    });
    
    //탈퇴버튼 클릭시
    const leaveBtn = $('#leave');
    $(() => {
    	leaveBtn.on('click', () => {
    		flag = confirm('정말로 탈퇴하시겠습니까?');
    		if(flag)
    		{
    			location.href='<%=request.getContextPath()%>/memberDelete';
    		}
    	});
    });
    
    //세션 만료시 메인으로 이동
    $(() => {
    	if(<%=lm==null%>){
    		alert("세션이 만료되었습니다.");
    		location.assign('<%=request.getContextPath()%>');
    	}
    });
    
</script>

<%@ include file="/views/common/footer.jsp" %>