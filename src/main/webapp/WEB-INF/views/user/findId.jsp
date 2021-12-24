<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="user/css/user.css" rel="stylesheet" type="text/css">
    <title>답인사 | 아이디 찾기</title>
    <jsp:include page="header.jsp"></jsp:include>
    
</head>
<body>
<span class="back-button"><a href="#none"
			onclick="history.go(-1);return false;" class="btnBack"><Strong>BACK</Strong></a>
		</span>

    <form class="find_id_form">
        <div>
            <h3>아이디 찾기</h3>
            <input type="radio" checked="checked" class="email_radio"><a>이메일 인증</a>
        </div>
        <div>
            <input type="email" class="find_email" name="m_email" placeholder=" 예) dabyinsa@dabyinsa.com">
        </div>
        <div>
            <input type="submit" class="find_id_button" value="아이디 찾기">
        </div>
    </form>
    <footer>
    <jsp:include page="footer.jsp"></jsp:include>
    </footer>
</body>
</html>