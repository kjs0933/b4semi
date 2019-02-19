    //로그인 모달 창 띄우기
    
    const mainFrmBox = $('.main-form-wrapper');
    const loginBtn = $('#login-btn');
    const idInput = $('.signin-frm #login-id');
    const pwInput = $('.signin-frm #login-pw');
    const body = $('body');
    const wholeWrapper = $('.whole-wrapper');

    
    $(() => {
        loginBtn.on('click', popUpLoginBox)
    })

    const toggleSet = () => {
    	idInput.val('');
        pwInput.val('');
        
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
   
    const toggleFrm = (e) => {
        if($(e.target).hasClass('frm-title-active')) return;
        loginTitle.toggleClass('frm-title-active');
        signupTitle.toggleClass('frm-title-active');
        signinFrm.toggleClass('frm-active');
        signupFrm.toggleClass('frm-active');
        
        signupInputs.prev().children('span').text('');
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
                		$('.login-msg').text('아이디/비밀번호가 일치하지 않습니다.');
                		$('.login-msg').css('color', 'crimson');
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
            if(!pwRegExpValid()) invalidCount++;
            if(!emailRegExpValid()) invalidCount++;
            if(!pwCkValid()) invalidCount++;
            if(!phoneRegExpValid()) invalidCount++;
            
            if(invalidCount == 0)
            {
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

    //회원가입란 빈칸 체크
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

    //아이디 정규식
    const idRegExpValid = () => {
        const signupIdVal = signupId.val();
        const regex = new RegExp('^[a-zA-Z][a-zA-Z0-9]{3,11}$');
        const result = regex.test(signupIdVal);
        if(!result) signupId.prev().children('span').text('아이디가 올바른 형식이 아닙니다.');
        return result;
    }

    //패스워드 정규식
    const pwRegExpValid = () => {
        const signupPwVal = signupPw.val();
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
    		signupPwCk.prev().children('span').text('패스워드가 일치하지 않습니다.');
    		return false;
    	}
    	return true;
    }
    
    //이메일 정규식
    const emailRegExpValid = () => {
        const signupEmailVal = signupEmail.val();
        const regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        const result = regex.test(signupEmailVal);
        if(!result) signupEmail.prev().children('span').text('이메일이 올바른 형식이 아닙니다.');
        

        return result;
    }


    //휴대전화 정규식
    const phoneRegExpValid = () => {
        const signupPhoneVal = signupPhone.val();
        const regex = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        const result = regex.test(signupPhoneVal);
        if(!result) signupPhone.prev().children('span').text('전화번호가 올바른 형식이 아닙니다.');

        return result;
    }