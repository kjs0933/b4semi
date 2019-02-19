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