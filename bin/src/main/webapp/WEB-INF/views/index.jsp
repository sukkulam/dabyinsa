<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% @taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
</head>
<body>
<h2>메인페이지</h2>
<c:forEach var="i" begin="1" end="10" step="1">
   <c:out value="${i}"/>
   <br/>
  </c:forEach>

  ${person.address.city}
</body>
</html>