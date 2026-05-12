<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core" %>

<!DOCTYPE html>
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
	font-size:40px;
	font-weight:bold;
	margin-bottom:30px;
}

.search-box{
	background:white;
	border:1px solid #ccc;
	border-radius:8px;
	padding:25px;
	margin-bottom:30px;
}

.search-form{
	display:flex;
	align-items:flex-end;
	gap:25px;
	flex-wrap:wrap;
}

.form-group{
	display:flex;
	flex-direction:column;
}

label{
	font-size:18px;
	font-weight:bold;
	margin-bottom:8px;
}

select{
	width:180px;
	height:42px;
	font-size:18px;
	border:1px solid #aaa;
	border-radius:5px;
	padding-left:10px;
	background:white;
}

.search-btn{
	height:42px;
	width:90px;
	background:#666;
	color:white;
	border:none;
	border-radius:5px;
	font-size:18px;
	cursor:pointer;
}

.menu-btn{
	height:42px;
	background:#999;
	color:white;
	border:none;
	border-radius:5px;
	font-size:18px;
	padding:0 20px;
	cursor:pointer;
}

.error{
	color:red;
	font-size:16px;
	font-weight:bold;
	margin-top:5px;
}

.subject-title{
	font-size:28px;
	font-weight:bold;
	margin-bottom:20px;
}

table{
	width:100%;
	border-collapse:collapse;
	background:white;
}

th{
	border-bottom:2px solid #ccc;
	padding:15px;
	font-size:20px;
	text-align:left;
}

td{
	border-bottom:1px solid #ddd;
	padding:15px;
	font-size:20px;
	vertical-align:top;
}

.score-input{
	width:140px;
	height:38px;
	font-size:20px;
	border:1px solid #aaa;
	border-radius:4px;
	padding-left:10px;
}

.register-btn{
	margin-top:25px;
	background:#666;
	color:white;
	border:none;
	padding:12px 28px;
	font-size:20px;
	border-radius:5px;
	cursor:pointer;
}

.bottom-menu-btn{
	margin-top:25px;
	margin-left:15px;
	background:#999;
	color:white;
	border:none;
	padding:12px 28px;
	font-size:20px;
	border-radius:5px;
	cursor:pointer;
}

</style>

</head>

<body>

<div class="container">

<div class="title">

	成績管理

</div>

<!-- エラー -->
<c:if test="${not empty error}">

	<div class="error">

		${error}

	</div>

</c:if>

<!-- 検索フォーム -->
<div class="search-box">

<form action="TestRegist.action"
	method="post"
	class="search-form">

	<!-- 入学年度 -->
	<div class="form-group">

		<label>

			入学年度

		</label>

		<select name="entYear">

			<option value="">
				---------
			</option>

			<option value="2016"
				<c:if test="${entYear == '2016'}">
					selected
				</c:if>>
				2016
			</option>

			<option value="2023"
				<c:if test="${entYear == '2023'}">
					selected
				</c:if>>
				2023
			</option>

			<option value="2024"
				<c:if test="${entYear == '2024'}">
					selected
				</c:if>>
				2024
			</option>

			<option value="2025"
				<c:if test="${entYear == '2025'}">
					selected
				</c:if>>
				2025
			</option>

		</select>

	</div>

	<!-- クラス -->
	<div class="form-group">

		<label>

			クラス

		</label>

		<select name="classNum">

			<option value="">
				---------
			</option>

			<option value="101"
				<c:if test="${classNum == '101'}">
					selected
				</c:if>>
				101
			</option>

			<option value="102"
				<c:if test="${classNum == '102'}">
					selected
				</c:if>>
				102
			</option>

			<option value="201"
				<c:if test="${classNum == '201'}">
					selected
				</c:if>>
				201
			</option>

			<option value="202"
				<c:if test="${classNum == '202'}">
					selected
				</c:if>>
				202
			</option>

		</select>

	</div>

	<!-- 科目 -->
	<div class="form-group">

		<label>

			科目

		</label>

		<select name="subjectCd">

			<option value="">
				---------
			</option>

			<option value="JAV"
				<c:if test="${subjectCd == 'JAV'}">
					selected
				</c:if>>
				JAVA
			</option>

			<option value="DBS"
				<c:if test="${subjectCd == 'DBS'}">
					selected
				</c:if>>
				DB
			</option>

			<option value="PYT"
				<c:if test="${subjectCd == 'PYT'}">
					selected
				</c:if>>
				Python
			</option>

		</select>

	</div>

	<!-- 回数 -->
	<div class="form-group">

		<label>

			回数

		</label>

		<select name="count">

			<option value="">
				---------
			</option>

			<option value="1"
				<c:if test="${count == 1}">
					selected
				</c:if>>
				1
			</option>

			<option value="2"
				<c:if test="${count == 2}">
					selected
				</c:if>>
				2
			</option>

			<option value="3"
				<c:if test="${count == 3}">
					selected
				</c:if>>
				3
			</option>

		</select>

	</div>

	<!-- 検索 -->
	<button type="submit"
		class="search-btn">

		検索

	</button>

	<!-- メニュー -->
	<a href="<%=request.getContextPath()%>/scoremanager/main/menu.jsp">

		<button type="button"
			class="menu-btn">

			メニュー

		</button>

	</a>

</form>

</div>

<!-- 成績一覧 -->
<c:if test="${not empty scoreList}">

<div class="subject-title">

	科目：${subjectCd}
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

			${s.student.entYear}

		</td>

		<td>

			${s.student.classNum}

		</td>

		<td>

			${s.student.no}

			<input type="hidden"
				name="studentNo"
				value="${s.student.no}">

		</td>

		<td>

			${s.student.name}

		</td>

		<td>

			<input type="text"
				name="point"
				value="${s.point}"
				class="score-input">

			<c:if test="${errors[s.student.no] != null}">

				<div class="error">

					${errors[s.student.no]}

				</div>

			</c:if>

		</td>

	</tr>

	</c:forEach>

</table>

<!-- hidden -->

<input type="hidden"
	name="subjectCd"
	value="${subjectCd}">

<input type="hidden"
	name="count"
	value="${count}">

<input type="hidden"
	name="classNum"
	value="${classNum}">

<input type="hidden"
	name="entYear"
	value="${entYear}">

<button type="submit"
	class="register-btn">

	登録して終了

</button>

<a href="<%=request.getContextPath()%>/scoremanager/main/menu.jsp">

	<button type="button"
		class="bottom-menu-btn">

		メニューへ戻る

	</button>

</a>

</form>

</c:if>

</div>

</body>
</html>