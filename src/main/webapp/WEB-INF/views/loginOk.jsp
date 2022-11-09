<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		int checkId =Integer.parseInt(request.getAttribute("checkIdFlag").toString()); // ${checkIdFlag}
		int checkPw = Integer.parseInt(request.getAttribute("checkPwFlag").toString());
		if(checkId == 0) {			
	%>
		<script language="JavaScript">
			alert("없는 아이디 입니다.");
			history.go(-1)
		</script>
	<%
		} else if(checkPw == 1) {
	%>
		<script language="JavaScript">
			alert("로그인에 성공 했습니다");
		</script>
		<h2>${mid }님 반갑습니다.</h2>
		<h2>${mname }님 반갑습니다.</h2>
		<a href="writeForm">글쓰기</a>
		<a href="logOut">로그아웃</a>
	<% 
	} else {		
	%>
	 	<script language="JavaScript">
			alert("비밀번호가 틀렸습니다.");
			history.go(-1)
		</script>
	<%
	}
	%>
</body>
</html>