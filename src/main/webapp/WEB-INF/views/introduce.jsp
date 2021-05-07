<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Happy House</title>
  <link rel="stylesheet" href="${root}/css/index.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
  
  <!-- 상단 nav top -->
  <%@ include file="module/header.jsp" %>
  
  <div class="container-fluid " style="height:150px;"></div>

  <div class="container-fluid">
    <div class="container mt-2" style="opacity: 70%;">홈 > HappyHouse 소개
      <hr>
    </div>
    <div class="container-fluid mt-5" style="font-size:55px; text-align:center; height:200px;">
      <h6 style="display: inline; font-size:75px; color:#28a745">HappyHouse </h6>는 고객님의 행복한 집 마련을 위한 <br>아래와 같은 차별화된
      서비스를 제공하고있습니다.
    </div>
  </div>
  <div class="row container-fluid mt-5" style="text-align:center; height:500px; ">

    <div class="col-sm-4" style="font-size:25px; width:400px; border-right:1px solid gray;">
      <div style="height:40%;"></div>
      <h6 style="font-size:35px; color:skyblue; display: inline;">HappyHouse</h6>는 허위매물이 아닌<br> 직원이 집적 방문하여 검증된 매물만을
      소개합니다.
    </div>
    <div class="col-sm-4" style="font-size:25px; width:400px; border-right:1px solid gray;">
      <div style="height:40%;"></div>
      <h6 style="font-size:35px; color:skyblue; display: inline;">HappyHouse</h6>는 고객의 입장에서<br> 소개해드리며, 고객의 소리에 항상 귀
      기울입니다.
    </div>
    <div class="col-sm-4" style="font-size:25px; width:400px; border-right:1px solid gray; ">
      <div style="height:40%;"></div>
      <h6 style="font-size:35px; color:skyblue; display: inline;">HappyHouse</h6>는 그저 주택이아닌<br> 고객님의 삶의 보금자리를 소개해드립니다.
    </div>

  </div>

  <div style="height:50px;"></div>
  
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