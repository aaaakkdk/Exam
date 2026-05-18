<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>成績参照</title>

<style>

body{
	margin:0;
	font-family:sans-serif;
	background:#f5f5f5;
}

/* ヘッダー */
.header{
	background:#dfe8f3;
	height:70px;
	display:flex;
	align-items:center;
	justify-content:space-between;
	padding:0 30px;
	font-size:22px;
	font-weight:bold;
}

.user{
	font-size:14px;
	font-weight:normal;
}

/* メイン */
.main{
	display:flex;
	min-height:700px;
}

/* 左メニュー */
.sidebar{
	width:220px;
	background:white;
	border-right:1px solid #ddd;
	padding:25px 15px;
}

.sidebar a{
	display:block;
	margin-bottom:15px;
	color:#2b5dab;
	text-decoration:none;
	font-size:14px;
}

/* コンテンツ */
.content{
	flex:1;
	padding:20px 30px;
}

.page-title{
	font-size:34px;
	font-weight:bold;
	margin-bottom:20px;
}

/* 検索ボックス */
.search-box{
	background:white;
	border:1px solid #ddd;
	border-radius:5px;
	padding:20px;
	width:900px;
}

.row{
	display:flex;
	align-items:flex-end;
	gap:15px;
	margin-bottom:20px;
}

.form-group{
	display:flex;
	flex-direction:column;
}

label{
	font-size:14px;
	margin-bottom:5px;
	font-weight:bold;
}

select{
	width:140px;
	height:38px;
	border:1px solid #ccc;
	border-radius:4px;
	padding-left:10px;
	font-size:14px;
}

input[type=text]{
	width:250px;
	height:36px;
	border:1px solid #ccc;
	border-radius:4px;
	padding-left:10px;
}

.search-btn{
	height:38px;
	padding:0 20px;
	background:#666;
	color:white;
	border:none;
	border-radius:4px;
	cursor:pointer;
}

.info{
	color:#4da3d9;
	font-size:14px;
	margin-top:10px;
}

/* テーブル */
.subject-title{
	font-size:22px;
	font-weight:bold;
	margin-top:30px;
	margin-bottom:15px;
}

table{
	width:900px;
	background:white;
	border-collapse:collapse;
}

th{
	background:#eee;
	padding:12px;
	border-bottom:2px solid #ccc;
	font-size:15px;
}

td{
	padding:12px;
	border-bottom:1px solid #ddd;
	text-align:center;
	font-size:15px;
}

/* フッター */
.footer{
	background:#ddd;
	text-align:center;
	padding:20px;
	margin-top:50px;
	font-size:13px;
	color:#666;
}

.error{
	color:red;
	font-size:15px;
	font-weight:bold;
	margin-bottom:15px;
}

</style>

</head>

<body>

<!-- ヘッダー -->
<div class="header">

	得点管理システム

	<div class="user">

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

		<a href="StudentCreate.action">

			学生管理

		</a>

		<div style="margin-top:20px;">

			成績管理

		</div>

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

	<!-- 右 -->
	<div class="content">

		<div class="page-title">

			成績参照

		</div>

		<c:if test="${not empty error}">

			<div class="error">

				${error}

			</div>

		</c:if>

		<!-- 検索 -->
		<div class="search-box">

			<form action="TestListSubjectExecute.action"
				method="post">

				<div class="row">

					<div>

						科目情報

					</div>

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

					<div class="form-group">

						<label>

							科目

						</label>

						<select name="subjectCd">

							<option value="">
								--------
							</option>

							<option value="JAV">
								Java
							</option>

							<option value="DBS">
								DB
							</option>

							<option value="PYT">
								Python
							</option>

						</select>

					</div>

					<button type="submit"
						class="search-btn">

						検索

					</button>

				</div>

			</form>

			<hr>

			<form action="TestListStudentExecute.action"
				method="post">

				<div class="row">

					<div>

						学生情報

					</div>

					<div class="form-group">

						<label>

							学生番号

						</label>

						<input type="text"
							name="studentNo"
							placeholder="学生番号を入力してください">

					</div>

					<button type="submit"
						class="search-btn">

						検索

					</button>

				</div>

			</form>

			<div class="info">

				科目情報を選択または学生情報を入力して検索ボタンをクリックしてください

			</div>

		</div>

		<!-- 一覧 -->
		<c:if test="${not empty list}">

			<div class="subject-title">

				科目：${subjectCd}

			</div>

			<table>

				<tr>

					<th>入学年度</th>
					<th>クラス</th>
					<th>学生番号</th>
					<th>氏名</th>
					<th>1回</th>
					<th>2回</th>

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

					<td>

						${t.point1}

					</td>

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