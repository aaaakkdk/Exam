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
	margin:0;
	font-family:sans-serif;
	background:#f5f5f5;
}

.header{
	background:#dfe8f3;
	padding:20px 40px;
	font-size:42px;
	font-weight:bold;
}

.top-right{
	float:right;
	font-size:16px;
	margin-top:10px;
}

.main{
	display:flex;
	min-height:700px;
}

.sidebar{
	width:220px;
	background:white;
	padding:30px 20px;
	border-right:1px solid #ccc;
}

.sidebar a{
	display:block;
	margin-bottom:18px;
	text-decoration:none;
	color:#2b5dab;
	font-size:18px;
}

.content{
	flex:1;
	padding:20px 40px;
}

.page-title{
	font-size:38px;
	font-weight:bold;
	margin-bottom:20px;
}

.search-area{
	background:white;
	border:1px solid #ccc;
	border-radius:8px;
	padding:20px;
	margin-bottom:25px;
}

.form-row{
	display:flex;
	align-items:flex-end;
	gap:20px;
	flex-wrap:wrap;
}

.form-group{
	display:flex;
	flex-direction:column;
}

label{
	font-size:16px;
	margin-bottom:5px;
	font-weight:bold;
}

select{
	width:180px;
	height:40px;
	font-size:16px;
	border:1px solid #aaa;
	border-radius:5px;
	padding-left:10px;
}

.search-btn{
	height:40px;
	padding:0 20px;
	background:#666;
	color:white;
	border:none;
	border-radius:5px;
	cursor:pointer;
	font-size:16px;
}

.error{
	color:red;
	font-size:18px;
	font-weight:bold;
	margin-bottom:20px;
}

.subject-title{
	font-size:24px;
	font-weight:bold;
	margin-bottom:20px;
}

table{
	width:100%;
	border-collapse:collapse;
	background:white;
}

th{
	background:#e5e5e5;
	padding:14px;
	border-bottom:2px solid #bbb;
	font-size:18px;
}

td{
	padding:14px;
	border-bottom:1px solid #ccc;
	font-size:18px;
	text-align:center;
}

.footer{
	background:#ddd;
	text-align:center;
	padding:20px;
	font-size:14px;
	color:#666;
}

</style>

</head>

<body>

<!-- ヘッダー -->
<div class="header">

	得点管理システム

	<div class="top-right">

		大原 太郎様　
		<a href="Logout.action">

			ログアウト

		</a>

	</div>

</div>

<div class="main">

	<!-- サイドバー -->
	<div class="sidebar">

		<a href="menu.jsp">

			メニュー

		</a>

		<br>

		<a href="StudentCreate.action">

			学生管理

		</a>

		<a href="TestRegist.action">

			成績登録

		</a>

		<a href="TestList.action">

			成績参照

		</a>

		<a href="#">

			科目管理

		</a>

	</div>

	<!-- メイン -->
	<div class="content">

		<div class="page-title">

			成績一覧（科目）

		</div>

		<!-- エラー -->
		<c:if test="${not empty error}">

			<div class="error">

				${error}

			</div>

		</c:if>

		<!-- 検索 -->
		<div class="search-area">

			<form action="TestListSubjectExecute.action"
				method="post">

				<div class="form-row">

					<!-- 入学年度 -->
					<div class="form-group">

						<label>

							入学年度

						</label>

						<select name="entYear">

							<option value="">
								--------
							</option>

							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
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

							<option value="">
								--------
							</option>

							<option value="101">101</option>
							<option value="102">102</option>
							<option value="201">201</option>
							<option value="202">202</option>

						</select>

					</div>

					<!-- 科目 -->
					<div class="form-group">

						<label>

							科目

						</label>

						<select name="subjectCd">

							<option value="">
								--------
							</option>

							<option value="JAV">Java</option>
							<option value="DBS">DB</option>
							<option value="PYT">Python</option>

						</select>

					</div>

					<button type="submit"
						class="search-btn">

						検索

					</button>

				</div>

			</form>

		</div>

		<!-- 科目名 -->
		<c:if test="${not empty subjectCd}">

			<div class="subject-title">

				科目：${subjectCd}

			</div>

		</c:if>

		<!-- 一覧 -->
		<c:if test="${not empty list}">

		<table>

			<tr>

				<th>

					入学年度

				</th>

				<th>

					クラス

				</th>

				<th>

					学生番号

				</th>

				<th>

					氏名

				</th>

				<th>

					1回

				</th>

				<th>

					2回

				</th>

			</tr>

			<c:forEach var="t"
				items="${list}">

			<tr>

				<td>

					${t.student.entYear}

				</td>

				<td>

					${t.student.classNum}

				</td>

				<td>

					${t.student.no}

				</td>

				<td>

					${t.student.name}

				</td>

				<!-- 1回 -->
				<td>

					${t.point}

				</td>

				<!-- 2回 -->
				<td>

					${t.point2}

				</td>

			</tr>

			</c:forEach>

		</table>

		</c:if>

	</div>

</div>

<!-- フッター -->
<div class="footer">

	© 2023 TIC<br>
	大原学園

</div>

</body>
</html>