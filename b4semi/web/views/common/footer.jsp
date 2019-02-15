<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <footer id="footer">
        <h2>고객센터</h2>
        <div id="ask-wrapper">
            <p><span>전화문의(1644 - 1107)</span><br><br>평일 오전 8시-오후4시<br>[점심시간 오후12시-오후1시]<br>토요일, 일요일&공휴일 오전8시-오후12시</p>
            <p><span>카카오톡문의</span><br><br>평일 오전 8시-오후4시<br>[점심시간 오후12시-오후1시]<br>토요일, 일요일&공휴일 오전8시-오후12시</p>
            <p><span>1:1문의</span><br><br>궁금한 점이 있으신가요?<br>1:1문의에 남겨주시면<br>친절히 답변 드리겠습니다.</p>
        </div>
        <hr><br>
        <div id="footer-info-wrapper">
            <ul>
                <li><a href="#">더푸드포럼 소개</a></li>
                <li><a href="#">이용안내</a></li>
                <li><a href="#">이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">인재채용</a></li>
                <li><a href="#"><img src="image/ico_fb.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="image/ico_instagram.png" alt="" width="30" height="30"
                ></a><a href="#"><img src="image/ico_blog.png" alt="" width="30" height="30"
                ></a></li>
            </ul>
        </div>
        <div id="business-info">
            <div><p>법인명(상호): 주식회사 더푸드포럼<br>대표자(성명): 김지섭 대표<br>개인정보보호책임자: 정우진(help#kh.com)
            <br>사업자등록번호: 123-45-67890<br>통신판매업: 제2019-서울강남-012345호</p></div>
            <div><p>입점문의: 입점문의하기<br>
            마케팅제휴: marketing@kh.com<br>
            채용문의: recruit@kh.com<br>
            팩스: 012-3456-7890<br>
            주소: 서울특별시 강남구 테헤란로 14길 6, 남도빌딩 4F</p></div>
            <div><img src="image/logo_footer.png" width="144" height="72"><p>THE FOOD FORUM ALL RIGHT RESERVED</p></div>
        </div>
    </footer>
</div>
    <div id="main-form-wrapper">
        <div id="frm-title">
            <p class="frm-title-active" id="login-title">로그인</p><p id="signup-title">회원가입</p>
        </div>
        <form action="#" method="post" name="signin-frm" class="signin-frm frm-active">
            <label for="id">아이디<br><input type="text" name="id" id="id"></label>
            <label for="pw">비밀번호<br><input type="password" name="pw" id="pw"></label>
            <input type="checkbox" name="saveId" id="saveId"><label for="saveId"><span></span></label>
            <p>비밀번호 기억</p>
            <input type="submit" value="로그인">
            <p>회원정보 분실</p>
            <p id="not-member">회원이 아니신가요?</p>
        </form>
        <form action="#" method="post" class="signup-frm">
            <label for="id">아이디</label>
            <input type="text" name="id" id="id">
            <label for="pw">비밀번호</label>
            <input type="password" name="pw" id="pw">
            <label for="pwck">비밀번호확인</label>
            <input type="password" name="pwck" id="pwck">
            <label for="email">이메일</label>
            <input type="email" name="email" id="email">
            <label for="phone">전화번호</label>
            <input type="tel" name="tel" id="tel">
            <label><input type="submit" value="회원가입"></label>
        </form>
    </div>
</body>
</html>