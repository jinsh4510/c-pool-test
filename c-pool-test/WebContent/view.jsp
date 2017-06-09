<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	


	
	<c:forEach var="name" items="${strList}">

		${name}<br>

	</c:forEach>
	
	<table border="1">
		<thead>
			<tr>
				<th>이름</th><th>성별</th><th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${userList}">
				<tr>
					<td>${u.name}</td>
					<td>
						<c:if test="${u.gender=='M'}">남자</c:if>
						<c:if test="${u.gender=='F'}">여</c:if>
					</td>
					<td>${u.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>