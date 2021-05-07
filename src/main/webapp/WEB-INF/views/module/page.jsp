<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<ul class="pagination justify-content-center mt-4">
		<!-- 이전 -->
		<li class="page-item <c:if test="${not pr.prev}">disabled</c:if>">
			<a class="page-link" href="#1"
				<c:if test="${pr.prev}"> onclick="goPage(${pr.beginPage-1})"</c:if>
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
			<c:choose>
				<c:when test="${i eq pr.pageNo}">
					<li class="page-item active"><a class="page-link" href="#1">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="#1" onclick="goPage(${i});">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음 -->


		<li class="page-item <c:if test="${not pr.next}">disabled</c:if>"><a
			class="page-link" href="<c:if test="${pr.next}">notice?act=mvnoticelist&pageNo=${pr.endPage + 1}</c:if>"
			aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>



