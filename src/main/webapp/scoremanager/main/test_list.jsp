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

.error{
	color:red;
	font-size:18px;
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

input[type=text]{
	width:220px;
	height:38px;
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

	</div>

	<!-- メイン -->
	<div class="content">

		<div class="page-title">

			成績参照

		</div>

		<!-- エラー表示 -->
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

							<option value="2016"
								<c:if test="${entYear == '2016'}">
									selected
								</c:if>>
								2016
							</option>

							<option value="2017"
								<c:if test="${entYear == '2017'}">
									selected
								</c:if>>
								2017
							</option>

							<option value="2018"
								<c:if test="${entYear == '2018'}">
									selected
								</c:if>>
								2018
							</option>

							<option value="2019"
								<c:if test="${entYear == '2019'}">
									selected
								</c:if>>
								2019
							</option>

							<option value="2020"
								<c:if test="${entYear == '2020'}">
									selected
								</c:if>>
								2020
							</option>

							<option value="2021"
								<c:if test="${entYear == '2021'}">
									selected
								</c:if>>
								2021
							</option>

							<option value="2022"
								<c:if test="${entYear == '2022'}">
									selected
								</c:if>>
								2022
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
								--------
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
								--------
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

					<!-- 検索 -->
					<button type="submit"
						class="search-btn">

						検索

					</button>

				</div>

			</form>

		</div>

	</div>

</div>

<!-- フッター -->
<div class="footer">

	© 2023 TIC<br>
	大原学園

</div>

</body>
</html>