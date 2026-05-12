<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>成績登録完了</title>

<style>

body{
	font-family:sans-serif;
	background:#f5f5f5;
	margin:0;
	padding:0;
}

.container{
	width:700px;
	margin:80px auto;
	background:white;
	border-radius:12px;
	padding:80px;
	text-align:center;
}

.title{
	font-size:60px;
	font-weight:bold;
	margin-bottom:50px;
}

.message{
	font-size:28px;
	margin-bottom:60px;
}

.button-area{
	display:flex;
	justify-content:center;
	gap:30px;
}

.menu-btn{
	display:inline-block;
	background:#666;
	color:white;
	text-decoration:none;
	font-size:28px;
	padding:20px 40px;
	border-radius:8px;
}

.menu-btn:hover{
	background:#444;
}

.list-btn{
	display:inline-block;
	background:#888;
	color:white;
	text-decoration:none;
	font-size:28px;
	padding:20px 40px;
	border-radius:8px;
}

.list-btn:hover{
	background:#666;
}

</style>

</head>

<body>

<div class="container">

	<div class="title">

		成績登録完了

	</div>

	<div class="message">

		成績を登録しました。

	</div>

	<div class="button-area">

		<!-- メニュー -->
		<a href="menu.jsp"
			class="menu-btn">

			メニューへ戻る

		</a>

		<!-- 成績参照 -->
		<a href="TestList.action"
			class="list-btn">

			成績参照

		</a>

	</div>

</div>

</body>
</html>