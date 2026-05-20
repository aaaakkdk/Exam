<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="content">

		<section class="me-4">

			<!-- タイトル -->
			<h2 class="h3 mb-4 fw-normal bg-secondary bg-opacity-10 py-2 px-4">
				科目情報削除
			</h2>

			<div class="px-3">

				<!-- 完了メッセージ -->
				<div class="alert alert-success text-center">

					削除が完了しました

				</div>

				<!-- 一覧リンク -->
				<div class="mt-4">

					<a href="SubjectList.action">

						科目一覧

					</a>

				</div>

			</div>

		</section>

	</c:param>

</c:import>