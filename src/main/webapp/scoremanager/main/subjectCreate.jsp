<%-- 科目登録JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">
				科目情報登録
			</h2>

			<form action="SubjectCreateExecute.action" method="post" class="px-4">

				<c:if test="${error != null}">
					<div class="text-danger mb-3">
						${error}
					</div>
				</c:if>

				<div class="mb-3">
					<label class="form-label">科目コード</label>
					<input type="text" name="cd" class="form-control" value="${cd}" required>
				</div>

				<div class="mb-3">
					<label class="form-label">科目名</label>
					<input type="text" name="name" class="form-control" value="${name}" required>
				</div>

				<button type="submit" class="btn btn-primary">
					登録
				</button>

				<a href="SubjectList.action" class="ms-3">
					戻る
				</a>
			</form>
		</section>
	</c:param>
</c:import>