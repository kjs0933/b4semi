<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.Member"%>
<% Member m = (Member)session.getAttribute("loginMember");%>
	<style>
        .signup-frm-wrapper
        {
            width: 100vw;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            font-family: 'Noto Sans KR';
            font-size: 14px;
            
            margin-top: 60px;
        }

        .signup-frm
        {
            display: flex;
            flex-flow: column nowrap;
            background-color: white;
            padding: 40px 100px;
            margin: 20px 0;
			border-top: 1px solid #ccc;
        }

        .signup-frm input
        {
            font-family: 'Noto Sans KR';
            font-size: 17px;
            height: 37px;
            width: 300px;
            padding: 0;
            box-sizing: border-box;
            border: none;
            border-bottom: 1px solid #aaa;
        }
        
        .signup-frm input:focus
        {
        	outline: none;
        }

        .signup-frm input[type="submit"]
        {
            width: 300px;
            height: 45px;
            margin: 50px 0;
            border: none;
            background-color: rgb(38, 85, 139);
            color: white;
            
            box-shadow: 0 1px 5px 0 rgba(0, 0, 0, 0.3);
        }

        .signup-frm-header
        {
            font-size: 40px;
            margin: 35px;
            color:  rgb(38, 85, 139);
            width: 700px;
            text-align: center;
            padding-bottom: 30px;
        }

        .signup-frm > div
        {
            display: flex;
        }

        .signup-frm > div > div > span:first-of-type
        {
            font-size: 15px;
            color: black;
            margin: 10px 0;
        }

        .input-valid
        {
            display: block;
        }
        
        .signup-frm > div > div
        {
            position: relative;
            display: flex;
            flex-flow: column nowrap;
        }

        .signup-frm > input
        {
            width: 500px;
        }
        

        .signup-input-msg
        {
            font-size: 13px;
            margin: 10px 0;
            color: rgb(38, 85, 139);
        }

        .validation-msg
        {
            font-size: 13px;
        }

        .valid-mark
        {
            display: none;
            position: absolute;
            left: -22px;
            top: 41px;
            width: 7px;
            height: 14px;
            border-right: 3px solid green;
            border-bottom: 3px solid green;
            transform: rotateZ(40deg);
        }
		
	</style>
<section>
    <div class="signup-frm-wrapper">
    <div class="signup-frm-header">
       <span>회원가입</span>
    </div>
        <form action="memberEndroll" method="post" class="signup-frm" autocomplete="off">
            <div>
                <div>
                    <span>아이디</span>
                    <input type="text" name="memberId" id="member-id">
                    <span class="validation-msg"></span>
                    <div class="signup-input-msg">
                        4-12자 사이의 숫자와 영문자 조합<br>
                                      첫 글자는 문자
                    </div>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <div>
                <div>
                    <span>비밀번호</span>
                    <input type="password" name="memberPw" id="member-pw">
                    <span class="validation-msg"></span>
                    <div class="signup-input-msg">
                        8자 이상 16자 이하 입력<br>
                                      숫자와 특수문자는 각 1회, 영문은 2개 이상 조합
                    </div>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <div>
                <div>
                    <span>비밀번호확인</span>
                    <input type="password" name="memberPwCk" id="member-pw-ck">
                    <span class="validation-msg"></span>
                    <div class="signup-input-msg">동일한 비밀번호를 입력해 주세요</div>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <div>

                <div>
                    <span>이름</span>
                    <input type="text" name="memberName" id="member-name">
                    <span class="validation-msg"></span>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <div>

                <div>
                    <span>이메일</span>
                    <input type="email" name="memberEmail" id="member-email">
                    <span class="validation-msg"></span>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <div>
                <div>
                    <span>전화번호</span>
                    <input type="text" name="memberPhone" id="member-phone">
                    <span class="validation-msg"></span>
                </div>
                <div><span class="valid-mark"></span></div>
            </div>
            <input type="hidden" id="idAvail" value="true">
            <input type="submit" value="회원가입">
        </form>
    </div>
</section>
<script>

$(() => {
	<% if (m != null) {%>
		location.assign('<%=request.getContextPath()%>');
	<%}%>
});

//회원가입 유효성 검사
const signupFrm = $('.signup-frm');
const signupPw = $('.signup-frm #member-pw');
const signupPwCk = $('.signup-frm #member-pw-ck');
const signupId = $('.signup-frm #member-id');
const signupName = $('.signup-frm #member-name');
const signupEmail = $('.signup-frm #member-email');
const signupPhone = $('.signup-frm #member-phone');

const validationMsg = $('.validation-msg');
const signupInputs = $('.validation-msg').prev();
const idAvail = $('#idAvail');


	//회원가입 submit시 체크
	$(() => {
		signupFrm.on('submit', e => {
			e.preventDefault();
			
			let invalidCount = 0;
       
            checkBlank();
            if(!idRegExpValid(e)) invalidCount++;
            if(idAvail.val() == 'false') invalidCount++;
            if(!pwRegExpValid(e)) invalidCount++;
            if(!emailRegExpValid(e)) invalidCount++;
            if(!pwCkValid(e)) invalidCount++;
            if(!phoneRegExpValid(e)) invalidCount++;
            
            
            
            if(invalidCount == 0)
            {
                $.ajax({
                    url: '<%=request.getContextPath()%>/memberEnroll',
                    type: 'post',
                    data: signupFrm.serialize(),
                    dataType: 'text',
                    success: data => {
                        if(data > 0)
                        {
                            alert('회원가입이 완료되었습니다.');
                            location.assign('<%=request.getContextPath()%>');
                        }
                        else
                        {
                            alert('회원가입에 실패하였습니다.')
                        }
                    }
                });
                return true;
            }
            else
            {
				alert('회원가입 양식에 수정이 필요합니다.');
            }
		});
	});


	//아이디 중복체크
    const idAvailAjax = (e) => {
        $.ajax({
        	url: '<%=request.getContextPath()%>/checkId?memberId='+signupId.val(),
        	type: 'get',
        	dataType: 'text',
        	success: data => {
        		if(data == 'true')
        		{
            		idAvail.val('false');
            		$(e.target).next().css('color', 'crimson');
            		$(e.target).next().text('해당 아이디가 이미 존재합니다.');
            		
					
        		}
        		else
        		{
        			idAvail.val('true');
        			$(e.target).next().css('color', 'green');
        			$(e.target).next().text('사용가능한 아이디입니다.');

        			$(e.target).parent().next().children().show();
        			
        		}
        	}
        });
    }
    
    //회원가입란 공백체크
    const checkBlank = () => {
        for(let i = 0 ; i < signupInputs.length ; i++)
        {
            if(signupInputs[i].value.trim().length == 0)
            {
                signupInputs[i].focus();
                return;
            }
        }
    }
    
    //아이디 정규식
    const idRegExpValid = (e)=> {
        if(signupId.val().length == 0) return;
        
        const regex = new RegExp('^[a-zA-Z][a-zA-Z0-9]{3,11}$');
        const result = regex.test(signupId.val());
       	if(!result) $(e.target).next().css('color','crimson').text('잘못된 아이디 문자 조합입니다.');
        return result;
    }
    
    //각 input blur시 체크 이벤트
    $(() => {
        signupId.on('blur', (e) => {
        	let result = idRegExpValid(e);
        	if(result) idAvailAjax(e);
        });
        
        signupPw.on('blur', pwRegExpValid);
        signupPwCk.on('blur', pwCkValid);
        
        signupName.on('blur', (e) => {
        	if(signupName.val().trim().length != 0)
        		{$(e.target).parent().next().children().show();}
        	else
        		{$(e.target).parent().next().children().hide();}
        });
        
        signupEmail.on('blur', emailRegExpValid);
        signupPhone.on('blur', phoneRegExpValid);
    });
    
    
    //패스워드 정규식
    const pwRegExpValid = (e) => {
        if(signupPw.val().length == 0) return;
        const regex = new RegExp('(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,16}$');
        const result = regex.test(signupPw.val());
        if(!result)
       	{
        	$(e.target).next().css('color', 'crimson').text('잘못된 패스워드 조합입니다.');
        	$(e.target).parent().next().children().hide();
       	}
        else
        {
        	$(e.target).next().css('color', 'green').text('사용 가능한 패스워드 입니다.');
        	$(e.target).parent().next().children().show();
        }
        return result;
    }
    
    //패스워드 확인 일치여부
    const pwCkValid = (e) => {
    	if(signupPw.val().trim() != signupPwCk.val().trim())
    	{
    		$(e.target).next().css('color', 'crimson').text('패스워드가 일치하지 않습니다.');
    		$(e.target).parent().next().children().hide();
    		return false;
    	}
    	else
    	{
    		if(signupPw.val().trim().length == 0) return false;
    		$(e.target).next().css('color', 'green').text('패스워드가 일치합니다.');
    		$(e.target).parent().next().children().show();
    		return true;
    	}
    }
    
    //이메일 정규식
    const emailRegExpValid = (e) => {
	    if(signupEmail.val().length == 0) return;
	        
	    const regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	    const result = regex.test(signupEmail.val());
	    if(!result)
	   	{
	    	$(e.target).next().css('color', 'crimson').text('이메일이 올바른 형식이 아닙니다.');
	    	$(e.target).parent().next().children().hide();
	   	}
	    else
	   	{
	    	$(e.target).next().text('');
	    	$(e.target).parent().next().children().show();
	   	}
	    return result;
    }
    
    //휴대전화 정규식
    const phoneRegExpValid = (e) => {
        if(signupPhone.val().length == 0) return;
        
        const regex = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        const result = regex.test(signupPhone.val());
        if(!result) 
        {
        	$(e.target).next().css('color', 'crimson').text('전화번호가 올바른 형식이 아닙니다.');
	        $(e.target).parent().next().children().hide();
        }
        else
      	{
        	$(e.target).next().text('');
        	$(e.target).parent().next().children().show();        	
        }
        return result;
    }
   
</script>
<%@ include file="/views/common/footer.jsp" %>