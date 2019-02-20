<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <footer class="footer">
        <h2>고객센터</h2>
        <div class="ask-wrapper">
            <p><span>전화문의(1644 - 1107)</span><br><br>평일 오전 8시-오후4시<br>[점심시간 오후12시-오후1시]<br>토요일, 일요일&공휴일 오전8시-오후12시</p>
            <p><span>카카오톡문의</span><br><br>평일 오전 8시-오후4시<br>[점심시간 오후12시-오후1시]<br>토요일, 일요일&공휴일 오전8시-오후12시</p>
            <p><span>1:1문의</span><br><br>궁금한 점이 있으신가요?<br>1:1문의에 남겨주시면<br>친절히 답변 드리겠습니다.</p>
        </div>
        <hr><br>
        <div class="footer-info-wrapper">
            <ul>
                <li><a href="#">더푸드포럼 소개</a></li>
                <li><a href="#">이용안내</a></li>
                <li><a href="#">이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">인재채용</a></li>
                <li><a href="#"><img src="images/ico_fb.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="images/ico_instagram.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="images/ico_blog.png" alt="" width="30" height="30"
                ></a></li>
            </ul>
        </div>
        <div class="business-info">
            <div><p>법인명(상호): 주식회사 더푸드포럼<br>대표자(성명): 김지섭 대표<br>개인정보보호책임자: 정우진(help#kh.com)
            <br>사업자등록번호: 123-45-67890<br>통신판매업: 제2019-서울강남-012345호</p></div>
            <div><p>입점문의: 입점문의하기<br>
            마케팅제휴: marketing@kh.com<br>
            채용문의: recruit@kh.com<br>
            팩스: 012-3456-7890<br>
            주소: 서울특별시 강남구 테헤란로 14길 6, 남도빌딩 4F</p></div>
            <div><img src="<%=request.getContextPath()%>/images/logo_footer.png" width="144" height="72"><p>THE FOOD FORUM ALL RIGHT RESERVED</p></div>
        </div>
    </footer>
</div>
    <div class="main-form-wrapper">
        <div class="frm-title">
            <p class="login-title frm-title-active">로그인</p><p class="signup-title">회원가입</p>
        </div>
        <div class="login-msg"></div>
        <form action="<%=request.getContextPath()%>/login" method="post" name="signin-frm" class="signin-frm frm-active" autocomplete="off">
            <label for="login-id">아이디<br><input type="text" name="memberId" id="login-id"></label>
            <label for="login-pw">비밀번호<br><input type="password" name="memberPw" id="login-pw"></label>
            <input type="checkbox" name="saveId" id="saveId"><label for="saveId"><span></span></label>
            <p>비밀번호 기억</p>
            <input type="submit" value="로그인">
            <p>회원정보 분실</p>
            <p class="not-member">회원이 아니신가요?</p>
        </form>
        <form action="memberEnroll" method="post" class="signup-frm" autocomplete="off">
            <label for="<%=request.getContextPath()%>/member-id">아이디<span></span></label>
            <input type="text" name="memberId" id="member-id" placeholder="영문 대소문자와 숫자로 4자이상 12자미만">
            <label for="member-name">이름<span></span></label>
            <input type="text" name="memberName" id="member-name">
            <label for="member-pw">비밀번호<span></span></label>
            <input type="password" name="memberPw" id="member-pw" placeholder="영문 대소문자 특수문자 하나씩 포함 8자이상">
            <label for="member-pw-ck">비밀번호확인<span></span></label>
            <input type="password" name="memberPwCk" id="member-pw-ck">
            <label for="member-email">이메일<span></span></label>
            <input type="email" name="memberEmail" id="member-email">
            <label for="member-phone">전화번호<span></span></label>
            <input type="tel" name="memberPhone" id="member-phone" placeholder="- 포함하여 입력">
          	<input type="hidden" name="idAvail" id="idAvail">
            <input type="submit" value="회원가입">
        </form>
    </div>
</body>
<script>
//카테고리 호출 로직

const categoryBtn = $('#category-toggle-btn');
const categoryMenu = $('.category-menu');

$(() => {
	categoryBtn.on('click', showCategory)
});

const showCategory = (e) => {
	e.stopPropagation()
	if(categoryMenu.hasClass('active'))
	{
		categoryMenu.toggleClass('active');
		$('body').off('click');
		return;
	}
        
	categoryMenu.toggleClass('active');
	$('body').on('click', closeCategory)
}

const closeCategory = (e) => {
	if(e.currentTarget == categoryBtn[0] || categoryMenu[0].contains(e.target)) return;
	categoryMenu.toggleClass('active');
    if(e.target == loginBtn[0]) return;
	$('body').off('click');
}

//로그인 유저 my account 토글
const myAccountBtn = $('#my-account-btn');
const myAccountBox = $('.my-account-box');
$(() => {
    myAccountBtn.on('click', () => {
        myAccountBox.fadeToggle(200);
    });
    
    myAccountBox.find('li').on('click', (e) => {
    	e.stopPropagation();
    	myAccountBox.fadeToggle(200);
    });
});

//공지사항 my account 토글
const supportBtn = $('#support-btn');
const supportBox = $('.support-box');

$(() => {
    supportBtn.on('click', () => {
        supportBox.fadeToggle(200);
    });
    
    supportBox.find('li').on('click', () => {
    	supportBox.fadeToggle(200);
    });
});

//ESC 누를시 로그인 모달 창 나가기
$(() => {
    $('body').on('keydown', (e) => {
        if(e.key == 'Escape') $('body').trigger('click');
    });
});


//로그인 모달 창 띄우기

const mainFrmBox = $('.main-form-wrapper');
const loginBtn = $('#login-btn');
const idInput = $('.signin-frm #login-id');
const pwInput = $('.signin-frm #login-pw');
const body = $('body');
const wholeWrapper = $('.whole-wrapper');

$(() => {
    loginBtn.on('click', popUpLoginBox)
});

const toggleSet = () => {
	idInput.val('');
	pwInput.val('');
    loginMsg.text('');
    signupInputs.prev().children('span').text('');

    body.toggleClass('body-inactive');
        wholeWrapper.toggleClass('whole-wrapper-inactive');
        mainFrmBox.toggleClass('active');
        mainFrmBox.addClass('main-frm-anim');
        setTimeout(() => {mainFrmBox.removeClass('main-frm-anim')}, 150);
    }

    const popUpLoginBox = () => {
        if (mainFrmBox.hasClass('active')) {
            toggleSet();
            $('body').off('click');
            return;
        }
        toggleSet();

        $('body').on('click', (e) => {

            if (e.target.closest('li') == loginBtn[0] || mainFrmBox[0].contains(e.target)) return;
            toggleSet();
            $('body').off('click');
        });
    }

    //로그인-회원가입 간 전환

    const signinFrm = $('.signin-frm');
    const signupFrm = $('.signup-frm');
    const frmTitle = $('.frm-title');
    const loginTitle = $('.login-title');
    const signupTitle = $('.signup-title');
    const notMember = $('.not-member');
    const signupInputs = signupFrm.children('label').next();
    const signinInputs = $('.signin-frm label input');
    const loginMsg = $('.login-msg');
    
    
    const toggleFrm = (e) => {
        if($(e.target).hasClass('frm-title-active')) return;
        loginTitle.toggleClass('frm-title-active');
        signupTitle.toggleClass('frm-title-active');
        signinFrm.toggleClass('frm-active');
        signupFrm.toggleClass('frm-active');
        
        signupInputs.prev().children('span').text('');
        loginMsg.text('');
    }

    $(() => {
        loginTitle.on('click', toggleFrm);
        signupTitle.on('click', toggleFrm);
        notMember.on('click', toggleFrm);
    });

    //로그인 유효성 검사 및 로그인 ajax 처리
    $(() => {
        signinFrm.on('submit', e => {
        	e.preventDefault();
        	
            for(let i = 0 ; i < signinInputs.length ; i++)
            {
                if(signinInputs[i].value.trim().length == 0)
                {
                    mainFrmBox.addClass('frm-invalid-anim');
                    setTimeout(() => {mainFrmBox.removeClass('frm-invalid-anim')}, 200);
                    signinInputs[i].focus();
                    return;
                }
            }

            $.ajax({
                url: 'login',
                type: 'post',
                data: {'memberId' : signinInputs[0].value, 'memberPw' : signinInputs[1].value},
                dataType: 'json',
                success: data => {
                	if(data == null)
                	{
                		loginMsg.text('아이디/비밀번호가 일치하지 않습니다.');
                		loginMsg.css('color', 'crimson');
                	}
                	else
                    {
                    	location.reload();
                    }
                }
            });
        });
    });
    
    //회원가입 유효성 검사

    const signupPw = $('.signup-frm #member-pw');
    const signupPwCk = $('.signup-frm #member-pw-ck');
    const signupId = $('.signup-frm #member-id');
    const signupEmail = $('.signup-frm #member-email');
    const signupPhone = $('.signup-frm #member-phone');

    $(() => {
        //정규식 돌리기
        signupFrm.on('submit', e => {
            e.preventDefault();
            let invalidCount = 0;
    
            checkBlank();
            if(!idRegExpValid()) invalidCount++;
            if($('#idAvail').val() == 'false') invalidCount++;
            if(!pwRegExpValid()) invalidCount++;
            if(!emailRegExpValid()) invalidCount++;
            if(!pwCkValid()) invalidCount++;
            if(!phoneRegExpValid()) invalidCount++;
            
            if(invalidCount == 0)
            {
                $.ajax({
                    url: 'memberEnroll',
                    type: 'post',
                    data: signupFrm.serialize(),
                    dataType: 'text',
                    success: data => {
                        if(data > 0)
                        {
                            alert('회원가입이 완료되었습니다.');
                            location.reload();
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
                mainFrmBox.addClass('frm-invalid-anim');
                setTimeout(() => {mainFrmBox.removeClass('frm-invalid-anim')}, 200);
                return false;
            }
        });

        signupPw.on('keyup', () =>{signupPw.prev().children('span').text('')});
        signupPwCk.on('keyup', () =>{signupPwCk.prev().children('span').text('')});
        signupId.on('keyup', () =>{signupId.prev().children('span').text('')});
        signupEmail.on('keyup', () =>{signupEmail.prev().children('span').text('')});
        signupPhone.on('keyup', () =>{signupPhone.prev().children('span').text('')});

    });

    //회원가입란 공백 체크
    const checkBlank = () => {
        for(let i = 0 ; i < signupInputs.length ; i++)
        {
            if(signupInputs[i].value.trim().length == 0)
            {
                mainFrmBox.addClass('frm-invalid-anim');
                setTimeout(() => {mainFrmBox.removeClass('frm-invalid-anim')}, 200);
                signupInputs[i].focus();
                return;
            }
        }
    }

    //invalid시 애니메이션
    const runAnim = () => {
        mainFrmBox.addClass('frm-invalid-anim');
    }

    //아이디 정규식 + 중복여부 확인
    const idRegExpValid = () => {
        const signupIdVal = signupId.val();
        if(signupIdVal.length == 0) return;
        
        const regex = new RegExp('^[a-zA-Z][a-zA-Z0-9]{3,11}$');
        const result = regex.test(signupIdVal);
        if(!result) signupId.prev().children('span').text('아이디가 올바른 형식이 아닙니다.');
        $.ajax({
        	url: 'checkId?memberId='+signupIdVal,
        	type: 'get',
        	dataTpe: 'text',
        	success: data => {
        		if(data)
        		{
            		$('#idAvail').val('false');
            		signupId.prev().children('span').text('해당 아이디가 이미 존재합니다.');
        		}
        		else 
        		{
        			$('#idAvail').val('true');
            		signupId.prev().children('span').text('사용가능한 아이디 입니다.');        			
        		}
        	}
        });
        return result;
    }

    //패스워드 정규식
    const pwRegExpValid = () => {
        const signupPwVal = signupPw.val();
        if(signupPwVal.length == 0) return;
        const regex = new RegExp('(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,16}$');
        const result = regex.test(signupPwVal);
        if(!result) signupPw.prev().children('span').text('패스워드가 올바른 형식이 아닙니다.');

        return result;
    }

    //패스워드 확인 일치 여부
    const pwCkValid = () => {
    	const signupPwVal = signupPw.val();
    	const signupPwCkVal = signupPwCk.val();
    	if(signupPwVal.trim() != signupPwCkVal.trim())
    	{
    		signupPwCk.prev().children('span').css('color', 'crimson');
    		signupPwCk.prev().children('span').text('패스워드가 일치하지 않습니다.');
    		return false;
    	}
    	else
    	{
    		if(signupPwVal.trim().length == 0) return false;
    		signupPwCk.prev().children('span').css('color', 'green');
    		signupPwCk.prev().children('span').text('패스워드가 일치합니다.');
    		return true;
    	}
    }
    
    $(() => {
    	
    });
    
    //이메일 정규식
    const emailRegExpValid = () => {
        const signupEmailVal = signupEmail.val();
        if(signupEmailVal.length == 0) return;
        
        const regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        const result = regex.test(signupEmailVal);
        if(!result) signupEmail.prev().children('span').text('이메일이 올바른 형식이 아닙니다.');
        

        return result;
    }

    //휴대전화 정규식
    const phoneRegExpValid = () => {
        const signupPhoneVal = signupPhone.val();
        if(signupPhoneVal.length == 0) return;
        
        const regex = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        const result = regex.test(signupPhoneVal);
        if(!result) signupPhone.prev().children('span').text('전화번호가 올바른 형식이 아닙니다.');

        return result;
    }
    
    //키입력시 유효성 체크 이벤트
    
    $(() => {
    	signupId.on('blur', idRegExpValid);
    	signupPw.on('blur', pwRegExpValid);
    	signupPwCk.on('blur', pwCkValid);
    	signupEmail.on('blur', emailRegExpValid);
    	signupPhone.on('blur', phoneRegExpValid);
    	
    });
</script>
</html>