<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = request.getParameter("msg");
	String loc = request.getParameter("loc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더 푸드 포럼</title>
</head>
<body>

</body>
	<script>
		alert(msg);
		location.assign(<%=request.getContextPath()%>/loc);
	</script>
</html>