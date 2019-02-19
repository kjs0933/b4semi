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