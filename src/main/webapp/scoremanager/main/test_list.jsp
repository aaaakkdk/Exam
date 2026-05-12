<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>成績参照</title>

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

.search-box{
	background:white;
	padding:25px;
	border-radius:8px;
	border:1px solid #ccc;
}

.form-row{
	display:flex;
	gap:20px;
	align-items:flex-end;
}

.form-group{
	display:flex;
	flex-direction:column;
}

select{
	width:180px;
	height:40px;
	font-size:18px;
}

button{
	height:42px;
	padding:0 25px;
	font-size:18px;
	background:#666;
	color:white;
	border:none;
	border-radius:5px;
	cursor:pointer;
}

</style>

</head>

<body>

<div class="title">

	成績参照

</div>

<div class="search-box">

<form action="TestListSubjectExecute.action"
	method="post">

<div class="form-row">

	<div class="form-group">

		<label>

			入学年度

		</label>

		<select name="entYear">

			<option value="2023">
				2023
			</option>

			<option value="2024">
				2024
			</option>

			<option value="2025">
				2025
			</option>

		</select>

	</div>

	<div class="form-group">

		<label>

			クラス

		</label>

		<select name="classNum">

			<option value="101">
				101
			</option>

			<option value="102">
				102
			</option>

			<option value="201">
				201
			</option>

			<option value="202">
				202
			</option>

		</select>

	</div>

	<div class="form-group">

		<label>

			科目

		</label>

		<select name="subjectCd">

			<option value="JAV">
				JAVA
			</option>

			<option value="DBS">
				DB
			</option>

			<option value="PYT">
				Python
			</option>

		</select>

	</div>

	<button type="submit">

		検索

	</button>

</div>

</form>

</div>

</body>
</html>