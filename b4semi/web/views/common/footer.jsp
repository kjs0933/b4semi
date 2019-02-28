<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <footer class="footer">
    	<div class="footer-wrapper">
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
                <li><a href="#"><img src="<%=request.getContextPath() %>/images/ico_fb.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="<%=request.getContextPath() %>/images/ico_instagram.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="<%=request.getContextPath() %>/images/ico_blog.png" alt="" width="30" height="30"
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
    </div>
    </footer>

</div>
    <div class="main-form-wrapper">
        <div class="login-frm-title">
            <p>로그인</p>
        </div>
        <div class="login-msg"></div>
        <form action="<%=request.getContextPath()%>/login" method="post" name="signin-frm" class="signin-frm" autocomplete="off">
            <label for="login-id">아이디<br><input type="text" name="memberId" id="login-id" value=""/></label>
            <label for="login-pw">비밀번호<br><input type="password" name="memberPw" id="login-pw"></label>
            <input type="submit" value="로그인">
            <p class="not-member"><a href="<%=request.getContextPath()%>/memberEnroll">회원이 아니신가요?</a></p>
        </form>
    </div>
</body>
<script>

//카테고리 호출 로직

const categoryBtn = $('#category-toggle-btn');
const categoryMenu = $('.category-menu');

$(() => {
	categoryBtn.on('click', e => {
		e.stopPropagation();
		categoryMenu.toggleClass('active');
		
		$('body').on('click', e => {
			if(e.target == categoryBtn[0] || categoryMenu[0].contains(e.target)) return;
			categoryMenu.toggleClass('active');
			$('body').off('click');
		});
	});
});


//로그인 유저 my account 토글
const myAccountBtn = $('#my-account-btn');
const myAccountBox = $('.my-account-box');

$(() => {
	myAccountBtn.on('click', e => {
    	if(myAccountBox.is(':animated')) return;
    	if(supportBtn)
    	myAccountBox.fadeToggle(200);
    });
});

//supportBox 토글
const supportBtn = $('#support-btn');
const supportBox = $('.support-box');

$(() => {
    supportBtn.on('click', e => {
    	if(supportBox.is(':animated')) return;
        supportBox.fadeToggle(200);
    });
});

//ESC body 에 클릭 이벤트 트리거
$(() => {
    $('body').on('keydown', (e) => {
        if(e.key == 'Escape') $('body').trigger('click');
    });
});


//검색어 입력 후 엔터키를 누를 때
$(function(){
	$("#header-keyword").on("keyup",function(){
		if(window.event.keyCode == 13)
		{
			location.href="<%=request.getContextPath()%>/dplist?keyword="+event.target.value;
		}
	});
});


//로그인 모달 창 띄우기

const mainFrmBox = $('.main-form-wrapper');
const loginBtn = $('#login-btn');
const idInput = $('.signin-frm #login-id');
const pwInput = $('.signin-frm #login-pw');
const body = $('body');
const wholeWrapper = $('.whole-wrapper');
const signinFrm = $('.signin-frm');
const loginMsg = $('.login-msg');
const signinInputs = signinFrm.find('input');


$(() => {
    loginBtn.on('click', popUpLoginBox)
});

const toggleSet = () => {
	idInput.val('');
	pwInput.val('');
    loginMsg.text('');

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

    //로그인 유효성 검사 및 로그인 ajax 처리
    const saveId = $('#saveId');
    
    $(() => {
        signinFrm.on('submit', e => {
        	e.preventDefault();
        	
            for(let i = 0 ; i < signinInputs.length ; i++)
            {
                if(signinInputs[i].value.trim().length == 0)
                {
                	runInvaldAnim();
                    signinInputs[i].focus();
                    return;
                }
            }

            $.ajax({
                url: '<%=request.getContextPath()%>/login',
                type: 'post',
                data: {'memberId' : signinInputs[0].value, 'memberPw' : signinInputs[1].value, 'saveId' : saveId.prop('checked')},
                dataType: 'json',
                success: data => {
                	if(data == null)
                	{
                		runInvaldAnim();
                		loginMsg.text('아이디/비밀번호가 일치하지 않습니다.');
                		loginMsg.css('color', 'crimson');
                	}
                	else
                    {
                		if(location.pathName == '<%=request.getContextPath()%>/views/member/signup.jsp')
                		{
                			location.assign('<%=request.getContextPath()%>');
                		}
                		else
                		{
                			location.reload();
                		}
                    }
                }
            });
        });
    });
    
    //invalid시 애니메이션
    const runInvaldAnim = () => {
        mainFrmBox.addClass('frm-invalid-anim');
        setTimeout(() => {mainFrmBox.removeClass('frm-invalid-anim')}, 200);
    }
</script>
</html>