<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${root}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${root}/css/noticeList.css" />
    <script src="board_main.js" type="text/javascript"></script>
    <title>게시판 메인 화면</title>
    <script type="text/javascript">
	  function writeArticle() {
		if(document.getElementById("subject").value == "") {
			alert("제목을 입력하세요");
			return;
		} else if(document.getElementById("content").value == "") {
			alert("내용을 입력하세요");
			return;
		} else {
		  	document.getElementById("modifyform").action = "${root}/notice";
		  	document.getElementById("modifyform").submit();
		}
	  }
	  
	  </script>
</head>

<body>
    <%@ include file="module/header.jsp" %>
    <div style="height:170px;"></div>
    
    <div align="center">      
    <div class="col-lg-6" align="center">
		<form id="modifyform" method="post" action="">
		<input type="hidden" name="act" id="act" value="modify">
		<input type="hidden" name="articleno" id="articleno" value="${notice.articleno}">
		<input type="hidden" name="viewcnt" id="viewcnt" value="${notice.viewcnt}">
			<div class="form-group" align="left">
				<label for="subject">제목:</label>
				<input type="text" class="form-control" id="subject" name="subject" value="${notice.subject}">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="15" id="content" name="content" > ${notice.content} </textarea>
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">수정</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
	</div>
    
    <!-- footer -->
    <%@ include file="module/footer.jsp" %>
    <!-- 로그인 모달창 -->
    <%@ include file="module/login.jsp" %>

    <!-- 회원가입 모달창-->
    <%@ include file="module/signUp.jsp" %>

    <!-- 회원 정보 확인 모달창-->
  	<%@ include file="module/checkMemberInfo.jsp" %>

  	<!-- 비밀번호 찾기 -->
  	<%@ include file="module/findPassword.jsp" %>
    <script src="js/index.js" type="text/javascript"></script>
</body>

</html>
