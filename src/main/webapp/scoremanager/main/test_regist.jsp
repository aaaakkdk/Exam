<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core" %>

<!DOCTYPE html>!
<html>

<head>

<meta charset="UTF-8">

<title>成績登録</title>

<style>

body{
	font-family:sans-serif;
	background:#f5f5f5;
	margin:0;
	padding:30px;
}

.container{
	width:95%;
	margin:auto;
}

.title{
	font-size:42px;
	font-weight:bold;
	margin-bottom:25px;
}

.search-box{
	background:white;
	padding:25px;
	border-radius:8px;
	border:1px solid #ddd;
	display:flex;
	align-items:flex-end;
	gap:30px;
}

.form-group{
	display:flex;
	flex-direction:column;
}

label{
	font-weight:bold;
	margin-bottom:10px;
	font-size:18px;
}

select{
	width:180px;
	height:45px;
	border:1px solid #ccc;
	border-radius:6px;
	font-size:18px;
	padding-left:10px;
	background:white;
}

.search-btn{
	height:45px;
	width:90px;
	background:#666;
	color:white;
	border:none;
	border-radius:6px;
	font-size:18px;
	cursor:pointer;
}

.subject-title{
	margin-top:35px;
	font-size:28px;
	font-weight:bold;
}

table{
	width:100%;
	border-collapse:collapse;
	margin-top:20px;
	background:white;
}

th{
	border-bottom:2px solid #ccc;
	padding:18px;
	font-size:22px;
	text-align:left;
}

td{
	border-bottom:1px solid #ddd;
	padding:18px;
	font-size:22px;
}

.score-input{
	width:180px;
	height:40px;
	font-size:22px;
	padding-left:10px;
	border:1px solid #aaa;
	border-radius:4px;
}

.register-btn{
	margin-top:25px;
	background:#666;
	color:white;
	border:none;
	padding:14px 30px;
	font-size:20px;
	border-radius:6px;
	cursor:pointer;
}

.error{
	color:red;
	font-size:20px;
	margin-top:20px;
}

</style>

</head>

<body>

<div class="container">

<div class="title">

	成績管理

</div>

<!-- 検索フォーム -->
<div class="search-box">

<form action="TestRegist.action"
	method="post"
	style="display:flex; gap:30px; align-items:flex-end;">

	<!-- 入学年度 -->
	<div class="form-group">

		<label>

			入学年度

		</label>

		<select name="entYear">

			<option value="">

				---------

			</option>

			<option value="2020">2020</option>

			<option value="2021">2021</option>

			<option value="2022">2022</option>

			<option value="2023">2023</option>

			<option value="2024">2024</option>

			<option value="2025">2025</option>

		</select>

	</div>

	<!-- クラス -->
	<div class="form-group">

		<label>

			クラス

		</label>

		<select name="classNum">

			<option value="131">

				131

			</option>

			<option value="132">

				132

			</option>

			<option value="201">

				201

			</option>

		</select>

	</div>

	<!-- 科目 -->
	<div class="form-group">

		<label>

			科目

		</label>

		<select name="subjectCd"
			style="width:320px;">

			<option value="Python1">

				Python1

			</option>

			<option value="Java">

				Java

			</option>

			<option value="DB">

				DB

			</option>

		</select>

	</div>

	<!-- 回数 -->
	<div class="form-group">

		<label>

			回数

		</label>

		<select name="count">

			<option value="1">

				1

			</option>

			<option value="2">

				2

			</option>

			<option value="3">

				3

			</option>

		</select>

	</div>

	<button type="submit"
		class="search-btn">

		検索

	</button>

</form>

</div>

<!-- エラー -->
<c:if test="${not empty error}">

	<div class="error">

		${error}

	</div>

</c:if>

<!-- 一覧 -->
<c:if test="${not empty scoreList}">

<div class="subject-title">

	科目：${subjectName}
	（${count}回）

</div>

<form action="TestRegistExecute.action"
	method="post">

<table>

	<tr>

		<th>入学年度</th>

		<th>クラス</th>

		<th>学生番号</th>

		<th>氏名</th>

		<th>点数</th>

	</tr>

	<c:forEach var="s"
		items="${scoreList}">

	<tr>

		<td>

			${s.entYear}

		</td>

		<td>

			${s.classNum}

		</td>

		<td>

			${s.no}

			<input type="hidden"
				name="studentNo"
				value="${s.no}">

		</td>

		<td>

			${s.name}

		</td>

		<td>

			<input type="text"
				name="point"
				class="score-input">

		</td>

	</tr>

	</c:forEach>

</table>

<input type="hidden"
	name="subjectCd"
	value="${subjectCd}">

<input type="hidden"
	name="count"
	value="${count}">

<button type="submit"
	class="register-btn">

	登録して終了

</button>

</form>

</c:if>

</div>

</body>
</html>