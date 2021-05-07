<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${root}/css/index.css">
<link rel="stylesheet" type="text/css" href="${root}/css/noticeList.css" />



<!-- 라이브 러리 겹치는 거 확인 -->



<script src="board_main.js" type="text/javascript"></script>
<title>게시판 메인 화면</title>
<script type="text/javascript">
	function movenoticewrite() {
		location.href = "${root}/notice/write";
	}
</script>
</head>
<c:set var="pr" value="${result.pageResult}" scope="request" />
<body>
	<%@ include file="module/header.jsp"%>
	<div style="height: 170px;"></div>
	<div class="container">
		<h2>
			<span>${userinfo.nickname}</span>님의 <b>관심지역</b> 정보
		</h2>
		
		<div class="row">
			<div class="col-sm-3" onclick="location.href='${root}/neighbor'">
				<div class="shop-card shadow">
                	서울특별시 마포구 공덕동
            	</div>
			</div>
			<div class="col-sm-3" onclick="location.href='${root}/neighbor'">
				<div class="shop-card shadow">
                	경기도 성남시 수정구
            	</div>
			</div>
			<div class="col-sm-3" onclick="location.href='${root}/neighbor'">
				<div class="shop-card shadow">
                	대전광역시 유성구 덕명동
            	</div>
			</div>
			<div class="col-sm-3" onclick="location.href='${root}/neighbor'">
				<div class="shop-card shadow">
                	대전광역시 유성구 봉명동
            	</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3" onclick="location.href='${root}/neighbor'">
				<div class="shop-card shadow">
                	천안시 동남구 병천면
            	</div>
			</div>
		</div>
		

	</div>

	<!-- footer -->
	<%@ include file="module/footer.jsp"%>
	<!-- 로그인 모달창 -->
	<%@ include file="module/login.jsp"%>

	<!-- 회원가입 모달창-->
	<%@ include file="module/signUp.jsp"%>

	<!-- 회원 정보 확인 모달창-->
	<%@ include file="module/checkMemberInfo.jsp"%>

	<!-- 비밀번호 찾기 -->
	<%@ include file="module/findPassword.jsp"%>
	<script src="js/index.js" type="text/javascript"></script>
</body>
<script>
	// $("ul.nav > li").removeClass("active");
	// $("ul.nav > li:eq(4)").addClass("active");

	function goPage(pageNo) {
		location.href = "notice?act=mvnoticelist&pageNo=" + pageNo;
	}
</script>
</html>
