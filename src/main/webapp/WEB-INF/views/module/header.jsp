<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function deleteMember() {
		if (confirm("정말로 탈퇴하시겠습니까?")) {
			location.href = "${root}/member/delete";
		}
	}
	function logout() {
		location.href = "${root}/member/logout";
	}
	function selectMember() {
		location.href = "${root}/member/select";
	}
</script>
<!-- 상단 nav top -->
  <div class="container-fluid shadow" style=" background-color: white;
  color: red;
  height:130px;
  font-size:25px;
  position: fixed;
  z-index: 999;">
    <div class="row">
      <div class="col-sm-12 mt-4">
        <div class="container"> <a href="${root}" id="main-title">Happy House</a>
        <c:choose>
       	  <c:when test="${empty userinfo}">
		          <a class="float-right mr-2" style="font-size:20px; color:black; font-weight: bold;" id="topsignup"
		            data-toggle="modal" data-target="#signUpModal">회원가입</a>
		          <a class="float-right mr-2" style="font-size:20px; color:black; font-weight: bold;" id="toplogin"
		            data-toggle="modal" data-target="#myModal">로그인</a>
		  </c:when>
		  <c:otherwise>
		  		  <a class="float-right mr-2" style="font-size:20px; color:black; font-weight: bold;" id="toplogin"
		             onclick="selectMember();">회원정보수정</a>
		          <a class="admin float-right mr-2" style="font-size:20px; color:black; font-weight: bold;"
		            onclick="deleteMember();">회원탈퇴</a>
		          <a class="admin float-right mr-2" style="font-size:20px; color:black; font-weight: bold;"
		            onclick="logout();">로그아웃</a>
		            
          </c:otherwise>
        </c:choose>
          <a class="float-right mr-2" style="font-size:20px; color:black; font-weight: bold; display: none;" href=""
            id="toplogout">로그아웃</a>
          <a class="float-right mr-2 searchbtn" data-toggle="modal" data-target="#searchModal"
            style="font-size:20px; color:blue; font-weight: bold; display: none;" href="#" id="topid"></a>
        </div>
      </div>

    </div>
    <div class="row">
      <!-- asdad -->
      <!-- 상단 navigator -->
      <nav class="navbar navbar-expand-sm" style="margin: 0 auto;">
        <div class="container">
          <a class="nav-link" href="${root}/introduce" style="color: #28a745">소개</a>
          <a class="nav-link" href="${root}/notice">공지사항</a>
          <a class="nav-link" href="${root}/neighbor">동네 업종정보</a>
          <a class="nav-link" href="${root}/environment">대기오염 정보</a>
        </div>
      </nav>
    </div>
  </div>
