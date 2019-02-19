<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Marcellus+SC" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <title>Document</title>
    <style>
        
        body
        {
            margin: 0;
            height: 100vh;
        }

        .whole-wrapper
        {
            width: 100%;
            height: auto;
            display: flex;
            font-family: 'Noto Sans KR';
        }

        .header-section-wrapper
        {
            width: 100%;
            height: 100%;
            min-width: 764px;
            display: flex;
            flex-flow: column nowrap;
            box-sizing: border-box;
            margin: 0 20px;
        }

        .admin-header
        {
            width: 100%;
            height: 85px;
            border-bottom: 1px solid #ccc;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-sizing: border-box;
            padding: 15px;
        }

        

        .admin-header img
        {
            width: auto;
            height: 90%;
            cursor: pointer;
        }

        .admin-nav
        {
            position: relative;
            height: auto;
            min-height: 100vh;
            color: #eee;
            background-color: rgb(52, 52, 65);
            min-width: 220px;
        }

        .admin-nav-header
        {
            position: relative;     
            background-color: rgb(40, 40, 52);
            height: 85px;
            padding: 0 23px; 
            box-sizing: border-box;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            cursor: pointer;     
        }

        .admin-nav-header > span
        {
            font-size: 20px;
            padding-left: 30px;
        }

        .admin-main-menu
        {
            display: flex;
            flex-flow: column;
            padding: 20px 22px 20px 20px;
            font-size: 17px;
            cursor: pointer;

            border-bottom: 1px solid #444;
        }

        .admin-main-menu:hover
        {           
            background-color: rgb(62, 62, 75);
        }

        .admin-main-menu > div > span
        {
            margin-left: 5px;
        }

        .admin-main-menu:last-of-type{padding-bottom: 20px;}

        .admin-main-menu > div:first-of-type
        {
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .admin-main-menu > div > svg
        {
            fill: #eee;
        }

        .admin-sub-menu
        {
            font-size: 15px;
            display: none;
            padding-top: 10px;
        }

        .admin-sub-menu > ul > li > a
        {
            text-decoration: none;
            color: rgb(134, 146, 163);
        }

        .admin-sub-menu > ul > li > a:hover
        {
            color: white;
        }

        .admin-sub-menu > ul
        {
            list-style: none;
            margin: 5px 0 5px 25px;
            padding: 0;
        }

        .admin-main-menu-active
        {
            box-shadow: inset 0px 1px 1px rgba(0, 0, 0, 0.3);
            background-color: rgb(32, 32, 37);
        }

        .admin-menu-arrow-active
        {
            transform: rotateZ(180deg);
        }
    </style>
</head>

<body>
    <div class="whole-wrapper">
        <nav class="admin-nav">
            <div class="admin-nav-header">
                <svg width="50px" height="50px" viewBox="0 0 16 16" id="icon-view">
                    <g inkscape:label="Layer 1" inkscape:groupmode="layer" id="layer1" transform="translate(0,-1036.3622)">
                    <g id="g4608-9" transform="translate(0,0.0198085)">
                    <g transform="translate(1100.5659,-21.019708)" id="g10290">
                    <path style="fill:rgb(168, 51, 87)" d="M 8 1.9960938 L 7.7636719 2.125 L 0.5 6.0390625 L 8 10.080078 L 15.5 6.0390625 L 8 1.9960938 z M 8 3.1308594 L 13.392578 6.0390625 L 8 8.9453125 L 2.6074219 6.0390625 L 8 3.1308594 z M 1.5429688 7.5527344 L 0.5 8.1171875 L 8 12.169922 L 15.5 8.1171875 L 14.457031 7.5527344 L 8 11.041016 L 1.5429688 7.5527344 z M 1.5429688 9.6972656 L 0.5 10.261719 L 8 14.314453 L 15.5 10.261719 L 14.457031 9.6972656 L 8 13.185547 L 1.5429688 9.6972656 z " transform="translate(-1100.5659,1057.3621)"/>
                    </g>
                    </g>
                    </g>
                </svg>
                <span>펼쳐보기</span>
            </div>
            
            <div class="admin-main-menu">
                <div>
                    <span>주문관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>  
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">전체주문조회</a></li>
                        <li><a href="#">결제변동조회</a></li>
                        <li><a href="#">배송관리</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>
            </div>

            <div class="admin-main-menu">
                <div>
                    <span>고객관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">회원관리</a></li>
                        <li><a href="#">마일리지관리</a></li>
                        <li><a href="#">쿠폰관리</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>
            </div>

            <div class="admin-main-menu">
                <div>
                    <span>판매상품관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">판매상품등록</a></li>
                        <li><a href="#">상품진열관리</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>판매통계</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">일별매출</a></li>
                        <li><a href="#">주별매출</a></li>
                        <li><a href="#">판매상품별매출</a></li>
                        <li><a href="#">공급사별매출</a></li>
                        <li><a href="#">시간대별매출</a></li>
                        <li><a href="#">환불통계</a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>상품마스터관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">신규상품등록</a></li>
                        <li><a href="#">입고등록</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>재고관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">재고조회</a></li>
                        <li><a href="#">유통기한관리</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>게시판관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">상품문의</a></li>
                        <li><a href="#">상품후기</a></li>
                        <li><a href="#">1대1문의</a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>쿠폰관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">쿠폰조회</a></li>
                        <li><a href="#">쿠폰만들기</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>

            </div>
            <div class="admin-main-menu">
                <div>
                    <span>공급사관리</span>
                    <svg width="24" height="24" viewBox="0 0 24 24"><path d="M7 10l5 5 5-5z"/></svg>
                </div>
                <div class="admin-sub-menu">
                    <ul>
                        <li><a href="#">공급사등록</a></li>
                        <li><a href="#">납품문의</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="header-section-wrapper">
            <header class="admin-header">
                <h1>관리자메인</h1><img src="image/admin_exit.png">

            </header>
            <section class="admin-section"></section>
        </div>
    </div>
</body>
    <script>

        //관리자 사이드메뉴 토글

        const viewIcon = $('.admin-nav-header');
        const adminSubMenu = $('.admin-sub-menu');
        const adminMainMenu = $('.admin-main-menu');
        $(() => {
            viewIcon.on('click', (e) => {

                let count = 0;
                adminSubMenu.each( (index, el) => {
                    if($(el).css('display') == 'block'){count++;}
                });


                if(count == 0){
                    adminMainMenu.toggleClass('admin-main-menu-active');
                    adminSubMenu.slideToggle(200);
                    adminMainMenu.find('svg').toggleClass('admin-menu-arrow-active');
                }
                else if(count >= 4){
                    adminSubMenu.css('display', 'block');
                    adminMainMenu.removeClass('admin-main-menu-active');
                    adminMainMenu.find('svg').removeClass('admin-menu-arrow-active');
                    adminSubMenu.slideToggle(200);
                }
                else{
                    adminSubMenu.css('display', 'none');
                    adminMainMenu.addClass('admin-main-menu-active');
                    adminMainMenu.find('svg').addClass('admin-menu-arrow-active');
                    adminSubMenu.slideToggle(200);
                }
            });
        
            adminMainMenu.on('click', (e) => {
                if(adminSubMenu.has(e.target).length != 0) return;
                $(e.currentTarget).toggleClass('admin-main-menu-active');
                $(e.currentTarget).children('.admin-sub-menu').slideToggle(200);
                $(e.currentTarget).find('svg').toggleClass('admin-menu-arrow-active');
            });
        });
    </script>
</html>