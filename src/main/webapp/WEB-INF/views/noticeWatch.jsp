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
	  function mvnoticemodify() {
			location.href="${root}/notice?act=mvnoticemodify&articleno=${notice.articleno}";
		}
	  function noticedelete() {
			location.href="${root}/notice?act=delete&articleno=${notice.articleno}";
		}
	  </script>
</head>

<body>
    <%@ include file="module/header.jsp" %>
    <div style="height:170px;"></div>
    	<c:if test="${userinfo ne null && userinfo.userid == notice.userid }">
	        <div class="container" align="right">
	        	<button class="btn btn-warning" onclick="javascript:mvnoticemodify();">수정</button>
	        	<button class="btn btn-danger" onclick="javascript:noticedelete();">삭제</button>
	        </div>
        </c:if>
        <br>
        <br>
    <div class="col-lg-12" align="center">
		<div class="container" align="center">
		  <table class="table">
		    <thead>
		      <tr>
		        <th>제목: ${notice.subject}</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>내용: ${notice.content}</td>
		      </tr>
		    </tbody>
		  </table>
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
