<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>成績一覧</title>

<style>

body{
	font-family:sans-serif;
	background:#f5f5f5;
	padding:30px;
}

.title{
	font-size:40px;
	font-weight:bold;
	margin-bottom:30px;
}

table{
	width:100%;
	border-collapse:collapse;
	background:white;
}

th{
	background:#ddd;
	padding:12px;
	border:1px solid #999;
}

td{
	padding:12px;
	border:1px solid #999;
}

</style>

</head>

<body>

<div class="title">

	成績一覧

</div>

<table>

<tr>

	<th>学生番号</th>

	<th>氏名</th>

	<th>点数</th>

</tr>

<c:forEach var="t"
	items="${list}">

<tr>

	<td>

		${t.student.no}

	</td>

	<td>

		${t.student.name}

	</td>

	<td>

		${t.point}

	</td>

</tr>

</c:forEach>

</table>

</body>
</html>