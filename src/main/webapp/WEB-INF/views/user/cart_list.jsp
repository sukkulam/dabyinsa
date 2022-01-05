<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btnList").click(function(){
		location.herf="/user/prod/list.do";
	});
	$("#btnDelete").click(funtion()){
		if(confirm("장바구니를 비우시겠습니까?")){
			location.href="/user/cart/deleteAll.do";
		}
	}
})
</script>
</head>
<body>
<h2>장바구니</h2>
<c:choose>
	<c:when test="${map.count == 0 }">
		장바구니가 비었습니다.^^
	</c:when>
	<c:otherwise>
		<form id="form1" name="form1" method="post" action="/user/cart/update.do">
		<table border="1" width="400px">
			<tr>
				<th>상품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>&nbsp;</th>
			</tr>
			<c:forEach var="row" items="${map.list}">
			<tr>
				<td>${row.prod_name}</td>
				<td>${row.price}</td>
				<td>
					<input type="number" style="width:30px;" min="0" max="100" name="amount" value="${row.amount}">
					<input type="hidden" name="c_id" value="${row.c_id}">
				</td>
				<td>${row.money}</td>
				<td><a href="/user/cart/delete.do?c_id=${row.c_id}">삭제</a></td>
				</tr>
			
			</c:forEach>
			<tr>
				<td colspan="5" align="center">
					장바구니 금액 합계
					<fmt:formatNumber value="${map.sumMoney}" pattern="#,###,###" /><br>
					배송료: ${map.fee}<br>
					총합계: <fmt:formatNumber value="${map.sum}" pattern="#,###,###" />
			</tr>
		</table>
		<button id="btnUpdate">수정</button>
		<button type="button" id="btnOrder">주문하기</button>
		<button type="button" id="btnDelete">장바구니 비우기</button>
		
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>