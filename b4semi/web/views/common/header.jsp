<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR|Marcellus+SC" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <style>


        :root
        {
           --default-font: 'Noto Sans KR', 'Sans-serif';
           
        }

        body
        {
            margin: 0;
            width: 100%;
        }

        .whole-wrapper
        {
            width: 100%;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
            min-width: 1024px;

            background-color: white;
        }

        #header
        {
            height: 70px;
            width: 100%;
            min-width: 1024px;
            display: flex;
            align-items: center;
            font-family: 'Noto Sans KR';
            font-size: 14px;
            background-color: white;
        }

        #logo
        {
            font-family: 'Marcellus SC';
            font-size: 30px;
        }

        #nav
        {
            width: 100%;
            padding: 0 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        #nav ul
        {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            align-items: center;
        }

        #nav ul li
        {
            display: inline-block;
            padding: 0 10px;
            margin: 0;

            cursor: pointer;
        }

        #nav svg
        {
            width: 25px;
            height: 25px;
            fill: rgb(80, 80, 90);
            margin-bottom: -5px;
        }

        #nav ul li img
        {
            width: 25px;
            height: 25px;
            fill: rgb(80, 80, 90);
            margin-bottom: -5px;

        }

        #category-toggle-btn
        {
            width: auto;
            height: auto;
        }

        #category-toggle-btn span
        {
            display: block;
            width: 25px;
            height: 4px;
            background-color: black;
        }

        #category-toggle-btn span:not(:first-of-type)
        {
            margin-top: 3px;
        }

        .fadeOut
        {
            animation: headerFadeOut 200ms linear forwards;
        }

        .sticky
        {
            position: fixed;
            width: 100%;
            z-index: 10;

            animation: headerFade 200ms linear forwards;
        }

        .fadeout
        {
            animation: headerFade 200ms linear;
            animation-direction: reverse;
        }

        .filler
        {
            margin-top: 70px;
        }


        .section-wrapper
        {
            width: 100%;
            height: auto;

            display: flex;
            flex-flow: column;
            align-items: center;
            overflow: inherit;

            background-color: white;
            
        }

        section
        {
            font-family: 'Noto Sans KR';
        }

        /*메인 슬라이드*/

        #main-slide-container
        {
            position: relative;
            width: 100%;
            height: 650px;
            overflow: hidden;
        }

        #main-image-track
        {
            position: relative;
            width: 100%;
            height: 100%;
            white-space: nowrap;
            left: -100%;
        }

        #main-image-track img
        {
            position: relative;
            object-fit: cover;
            width: 100%;
            height: 100%;
        }
        
        .main-slide-btn
        {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            opacity: 0;
            cursor: pointer;

            transition: 200ms linear;

        }
        
        .main-slide-btn--left
        {
            left: 0%;
            z-index: 1;
        }

        .main-slide-btn--right
        {
            right: 0%;
        }

        #main-slide-container:hover .main-slide-btn
        {
            opacity: 1;
        }

        #main-slide-navbar ul
        {
            list-style: none;
            display: flex;
            justify-content: center;
        }

        #main-slide-navbar li
        {
            position: relative;
            top: -50px;
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background-color: white;
            display: inline-block;
            margin: 0 7px;
            cursor: pointer;

            opacity: 0.7;
        }

        #main-slide-navbar li:hover
        {
            transform: scale(1.3);
        }

        #main-slide-navbar li.main-current-dot
        {
            opacity: 1;
        }


        /*MD추천*/


        #md-promo
        {
            width: 100%;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
        }


        #md-promo > p
        {
            margin: 40px 0 22px 0;
            font-size: 25px;
            font-weight: bold;
            
        }

        #md-goods-box
        {
            position: relative;
            width: 1024px;
            height: auto;
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-around;
        }

        #md-goods-box > div
        {
            font-size: 0.9em;
            border: 1px solid #ccc;
        }

        #md-goods-box > div > div
        {
            height: 308px;
            width: 240px;
            background-color: black;
        }

        #md-goods-box > div > div > img
        {
            width: 100%;
            height: 100%;
            object-fit: fill;
        }

        #md-goods-box > div > div > img:hover
        {
            opacity: 0.8;
        }

        #md-goods-box p
        {
            margin: 15px 20px 20px 20px;
            line-height: 1.6em;
            
        }



        /*이벤트, 새로운 상품 슬라이드*/



        #event-and-new
        {
            position: relative;
            width: 1024px;
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-around;
        }

        #event-box > p, #news-box > p
        {
            margin: 22px;
            font-size: 25px;
            font-weight: bold;
        }
        #news-box, #event-box
        {
            display: flex;
            flex-flow: column nowrap;
            align-items: center;
        }

        #event-and-new > div
        {
            position: relative;
            width: 500px;
            height: auto;
        }

        #event-slide-container, #new-slide-container
        {
            position: relative;
            width: 100%;
            height: auto;

            overflow: hidden;
        }

        #event-image-track, #new-image-track
        {
            position: relative;
            width: 100%;
            height: auto;
            white-space: nowrap;
            left: -100%;
        }

        #event-image-track img, #new-image-track img
        {
            position: relative;
            width: 500px;
            height: auto;
            object-fit: cover;
        }

        .event-slide-btn, .new-slide-btn
        {
            position: absolute;
            width: 70px;
            height: 70px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            opacity: 0;

            transition: 200ms linear;
        }

        #event-slide-container:hover .event-slide-btn, #new-slide-container:hover .new-slide-btn
        {
            opacity: 0.8;
        }

        .event-slide-btn--left, .new-slide-btn--left
        {
            left: 0;
            z-index: 1;
        }

        .event-slide-btn--right, .new-slide-btn--right
        {
            right: 0;
        }


        /* Kurly Loves 상품 */


        #kurly-loves
        {
            position: relative;
            display: flex;
            width: 100%;
            flex-flow: column nowrap;
            align-items: center;
            padding-bottom: 42px;

            border-bottom: 1px solid #ccc;
        }

        #kurly-loves > p
        {
            margin: 20px;
            font-size: 30px;
            font-weight: bold;
        }

        #kurly-loves-container
        {
            position: relative;
            width: 1019px;
            height: auto;
            padding-left: 6px;
            overflow: hidden;
        }

        #kurly-loves-image-track
        {
            position: relative;
            width: auto;
            height: auto;
            white-space: nowrap;

            left: -340px;
        }

        .kurly-loves-image-box
        {
            position: relative;
            display: inline-block;
            width: 332px;
            margin: 0 8px 0 0;
            border: 1px solid #ccc;
            box-sizing: border-box;
            background-color: white;
        }

        .kurly-loves-image-box > div
        {
            width: 330px;
            height: 424px;
            background-color: black;
        }
        
        .kurly-loves-image-box > div > img
        {
            width: 330px;
            height: auto;
        }

        .kurly-loves-image-box > div > img:hover
        {
            opacity: 0.8;
        }


        .kurly-loves-image-box p
        {
            font-size: 0.8em;
            margin: 20px;
        }

        .kurly-loves-slide-btn
        {
            position: absolute;
            float: left;
            width: 70px;
            height: 70px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            opacity: 0;
            transition: 200ms linear;
        }

        #kurly-loves-container:hover .kurly-loves-slide-btn
        {
            opacity: 0.8;
        }

        .kurly-loves-slide-btn--left
        {
            left: 0;
            z-index: 1;
        }

        .kurly-loves-slide-btn--right
        {
            right: 0;
        }




        /*footer*/




        #footer
        {
            min-width: 1024px;
            margin: 30px 0;
            font-family: 'Noto Sans KR';
        }

        #footer > h2
        {
            margin: 5px 8px;
        }

        #footer > div
        {
            margin: 15px 8px;
        }

        #ask-wrapper
        {
            display: flex;
            justify-content: space-between;
        }

        #ask-wrapper p
        {
            font-size: 0.8em;
        }

        #ask-wrapper span
        {
            font-size: 1.2em;
            font-weight: bold;
            color: royalblue;
        }

        hr
        {
            position: absolute;
            left: 0;
            width: 100%;
            transform: translateY(5px);
            border: none;
            height: 1px;
            background-color: #ccc;
        }

        #footer-info-wrapper
        {
            margin: 20px 0;
            padding: 20px 0;
        }

        #footer-info-wrapper > ul
        {
            display: flex;
            flex-flow: row nowrap;
            list-style: none;
            justify-content: space-between;
            padding: 0;
            margin: 0;
        }

        #footer-info-wrapper > ul > li
        {
            padding: 0;
            margin: 0;

            flex-grow: 1;
        }

        #footer-info-wrapper > ul > li:last-of-type
        {
            flex-grow: 3;
        }

        #footer-info-wrapper img
        {
            float: right;
        }

        #footer-info-wrapper > ul > li > a
        {
            text-decoration: none;
            color: royalblue;
            font-weight: bold;
            font-size: 0.8em;
        }

        #footer-info-wrapper img
        {
            margin: 0 3px;
            margin-top: -5px;
        }

        #business-info
        {
            display: flex;
            flex-flow: row nowrap;
            justify-content: space-between;
        }
        
        #business-info p
        {
            font-size: 0.7em;
            color: #888;
            line-height: 1.7em;
        }


        /* 메인 폼 */

        #main-form-wrapper
        {
            position: fixed;
            left: 50vw;
            top: 50vh;
            transform: translateX(-50%) translateY(-50%);
            width: 350px;
            height: auto;
            display: flex;
            flex-flow: column nowrap;
            padding: 20px 50px;
            box-sizing: border-box;
            background-color: white;
            border-radius: 2px;
            box-shadow: 0 2px 15px 1px rgba(0, 0, 0, 0.2);

            display: none;
            z-index: 3;
            font-family: 'Noto Sans KR';
        }

        #main-form-wrapper.active
        {
            display: block;
            
            animation: loginFormPop 150ms linear forwards;
        }

        #frm-title
        {
            align-self: flex-start;
            color: #ccc;
            font-size: 2em;
            text-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
            display: flex;
            justify-content: space-between;
        }

        #frm-title > p
        {
            cursor: pointer;
        }

        .signin-frm
        {
            display: none;
            flex-flow: column nowrap;
            align-items: center;
            margin-top: 30px;
        }

        .signin-frm input
        {
            width: 250px;
            height: 35px;
            margin: 0 0 10px 0;
            border: none;
            font-size: 16px; 
        }

        .signin-frm input[type="submit"]
        {
            margin: 40px 0 20px 0;
            height: 45px;
            background-color: rgb(38, 85, 139);
            color: white;
            border-radius: 1px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }

        .signin-frm label
        {
            font-size: 13px;
            color: gray;
            text-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
        }

        .signin-frm label input
        {
            border-bottom: 1px solid #ccc;
        }

        .signin-frm input:focus
        {
            outline: none;
        }

        .signin-frm #saveId
        {
            display: none;
        }

        #saveId + label
        {
            position: relative;
            align-self: flex-start;
            width: 17px;
            height: 17px;
            background-color: rgb(38, 85, 139);
            cursor: pointer;
            border-radius: 1px;
        }

        #saveId + label span
        {
            position: absolute;
            display: none;
            left: 5px;
            top: 1px;
            width: 4px;
            height: 10px;
            border-right: 2px solid white;
            border-bottom: 2px solid white;
            transform: rotateZ(40deg);
        }

        #saveId + label:hover
        {
            background-color: rgb(47, 105, 172);
        }

        #saveId:checked + label span
        {
            display: inline-block;
        }

        .signin-frm > p
        {
            font-size: 13px;
            color: gray;
            text-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
            cursor: pointer;
        }

        .signin-frm > p:first-of-type
        {
            margin-top: -19px;
            margin-left: -110px;
            font-size: 13px;
            color: gray;
            text-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
        }

        #main-form-wrapper > p
        {
            font-size: 13px;
            color: gray;
            margin: 5px 0 0 0;
        }

        .signup-frm
        {
            flex-flow: column nowrap;
            align-items: center;
            margin-top: 25px;

            display: none;
        }

        .signup-frm input
        {
            width: 250px;
            height: 35px;
            margin: 0 0 10px 0;
            border: none;
            font-size: 16px;
            
        }

        .signup-frm input:not(:last-of-type)
        {
            border-bottom: 1px solid #ccc;
            
        }

        .signup-frm input[type="submit"]
        {
            height: 45px;
            background-color: rgb(38, 85, 139);
            color: white;
            margin-top: 30px;
            margin-bottom: 30px;
            border-radius: 1px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }

        .signup-frm > label
        {
            font-size: 13px;
            color: gray;
            align-self: flex-start;
            text-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
        }

        .signup-frm input:focus
        {
            outline: none;
        }


        .frm-title-active
        {
            color: rgb(38, 85, 139);
            font-weight: bold;
        }

        .frm-active
        {
            display: flex;
        }

        .frm-invalid-anim
        {
            animation: invalid 150ms ease forwards;
        }

        .body-inactive
        {
            background-color: black;
        }

        .whole-wrapper-inactive
        {
            opacity: 0.3;
        }

        @keyframes invalid
        {
            0%
            {
                transform: translateY(-55%) translateX(-50%) scale(0.9);
            }

            100%
            {
                transform: translateY(-55%) translateX(-50%) scale(1);
            }
        }

        @keyframes loginFormPop
        {
            0%
            {
                opacity: 0.3;
                transform: translateY(-65%) translateX(-50%);
            }

            100%
            {
                opacity: 1;
                transform: translateY(-55%) translateX(-50%);
            }
        }

        @keyframes headerFade
        {
            0%
            {
                opacity: 0;
            }

            100%
            {
                opacity: 1;
            }
        }

    </style>
</head>
<body>
<div class="whole-wrapper">
    <header id="header">
        <div id="main-image">
            <img src=""/>
        </div>
        <nav id="nav">
            <div id="category-toggle-btn">
                <span></span>
                <span></span>
                <span></span>
            </div>
            <div id="logo">The Food Forum</div>
            <ul>
                <li id="login-btn">로그인</li>
                <li>고객센터</li>
                <li><?xml version="1.0" ?><svg enable-background="new 0 0 26 26" version="1.1" id="cart" viewBox="0 0 26 26" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M24.25,2.5898438h-2.8359375c-0.0267944,0-0.0495605,0.0125122-0.0756226,0.0152588  c-0.0543823,0.0055542-0.1052246,0.0145874-0.156189,0.0315552c-0.0426636,0.0140991-0.0811768,0.0314941-0.1200562,0.0526123  c-0.0447388,0.024353-0.085083,0.0507813-0.1240845,0.0836792c-0.0358887,0.0301514-0.0663452,0.0622559-0.0960083,0.0984497  c-0.0305786,0.0372925-0.0567017,0.0752563-0.079895,0.1184692c-0.0239868,0.0443726-0.0408325,0.0899048-0.055542,0.1390991  c-0.0079956,0.0266724-0.0252686,0.0480957-0.0303955,0.0761108l-0.4295044,2.3473511L1.8930664,6.625  C1.8227539,6.6201172,1.7607422,6.6303711,1.6821289,6.6376953C1.2744141,6.6748047,0.9716797,7.0322266,1.0019531,7.4404297  c0.0024414,0.0307617,0.0063477,0.0605469,0.012207,0.0898438l1.2788086,6.9746094  c0.2924805,1.081543,1.1933594,2.1733398,2.5483398,2.1733398h13.3695679l-0.2862549,1.5644531H6.6748047  c-1.4243164,0-2.5834961,1.1591797-2.5834961,2.5834961c0,1.4248047,1.1591797,2.5839844,2.5834961,2.5839844  s2.5834961-1.1591797,2.5834961-2.5839844c0-0.3881226-0.0922241-0.7528687-0.2462769-1.0834961h6.9080811  c-0.1540527,0.3306274-0.2462769,0.6953735-0.2462769,1.0834961c0,1.4248047,1.1591797,2.5839844,2.5834961,2.5839844  s2.5834961-1.1591797,2.5834961-2.5839844c0-1.0127563-0.5914307-1.8825073-1.4421387-2.3057861l2.640564-14.430542H24.25  c0.4140625,0,0.75-0.3359375,0.75-0.75S24.6640625,2.5898438,24.25,2.5898438z M19.0220947,12.244812l-3.1782227,0.0499268  l0.1730957-1.8419189l3.3514404-0.1004639L19.0220947,12.244812z M3.1442871,10.8387451l3.1759644-0.0952148l0.2077637,1.6974487  l-3.081543,0.0484009L3.1442871,10.8387451z M7.3235474,10.7134399l3.4909058-0.1046143v1.7648315l-3.281311,0.0515747  L7.3235474,10.7134399z M10.8144531,9.6079102L7.2014771,9.7162476l-0.230835-1.885376l3.843811-0.2247314V9.6079102z   M11.8144531,7.5476685l3.4902344-0.2041016l-0.2006836,2.1357422l-3.2895508,0.0986328V7.5476685z M10.8144531,13.3739014  v1.8043213H7.8701782l-0.2148438-1.7546997L10.8144531,13.3739014z M11.8144531,13.3582153l2.9293823-0.0459595l-0.175354,1.8659668  h-2.7540283V13.3582153z M11.8144531,12.3579712v-1.7791138l3.1952515-0.0958252l-0.1717529,1.8274536L11.8144531,12.3579712z   M19.5525513,9.3459473l-3.4412842,0.1031494l0.2033691-2.1645508l3.6542358-0.2136841L19.5525513,9.3459473z M5.9707642,7.8893433  l0.227356,1.8569336l-3.236145,0.0970459C2.8256226,9.102478,2.717041,8.5267334,2.6245117,8.0849609L5.9707642,7.8893433z   M3.7548828,14.1743164l-0.1258545-0.687561l3.0212402-0.0474243l0.2128906,1.7388916H4.8413086  C4.1987305,15.1782227,3.8408203,14.4819336,3.7548828,14.1743164z M15.572937,15.1782227l0.1768188-1.8817749l3.0888062-0.0485229  l-0.3532104,1.9302979H15.572937z M7.7583008,20.8261719c0,0.5976563-0.4858398,1.0839844-1.0834961,1.0839844  s-1.0834961-0.4863281-1.0834961-1.0839844s0.4858398-1.0834961,1.0834961-1.0834961S7.7583008,20.2285156,7.7583008,20.8261719z   M18.2573242,21.9101563c-0.5976563,0-1.0834961-0.4863281-1.0834961-1.0839844s0.4858398-1.0834961,1.0834961-1.0834961  s1.0834961,0.4858398,1.0834961,1.0834961S18.8549805,21.9101563,18.2573242,21.9101563z"/></svg></li>
                <li><img src="settings.svg"></li>
            </ul>
        </nav>
    </header>