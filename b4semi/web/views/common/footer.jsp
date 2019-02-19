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
            <div><img src="images/logo_footer.png" width="144" height="72"><p>THE FOOD FORUM ALL RIGHT RESERVED</p></div>
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
        <form action="#" method="post" class="signup-frm" autocomplete="off">
            <label for="member-id">아이디<span></span></label>
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
            <input type="submit" value="회원가입">
        </form>
    </div>
</body>
    <script type="text/javascript" src="js/header.js"></script>
    <script type="text/javascript" src="js/footer.js"></script>
</html>