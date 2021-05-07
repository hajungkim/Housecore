<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Happy House</title>
     <%@ include file="module/css.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function update() {
		if (document.getElementById("passwd").value == "") {
			alert("비밀번호 입력!!!"); return;
		}
		if (document.getElementById("address").value == "") {
			alert("주소정보 입력!!!"); return;
		}
		if (document.getElementById("addressdetail").value == "") {
			alert("상세 주소정보 입력!!!"); return;
		}
		if (document.getElementById("nickname").value == "") {
			alert("닉네임 정보 입력!!!"); return;
		}
		if (document.getElementById("interarea").value == "") {
			alert("관심지역 정보 입력!!!"); return;
		}
		if (document.getElementById("email").value == "") {
			alert("이메일 정보 입력!!!"); return;
		}
		
		document.getElementById("updateForm").action = "${root}/member/update";
		document.getElementById("updateForm").submit();
		alert('회원정보가 수정되었습니다!');
	}
	</script>
</head>
<body>
	<!-- 상단 nav top -->
  	<%@ include file="module/header.jsp" %>
    
    <div class="container-fluid " style="height:200px;"></div>

	<div class="container">
		<form id="updateForm" method="post" action="">
				<div style="font-weight: bold; font-size: 30px;">회원정보를 확인해주세요</div>
				<div id="div1" style="font-size: 20px;">
					아이디 : <input type="text" class="form-control" id="userid"
						name="userid" value="${userinfo.userid}"  required readonly>
				</div>
				<div id="div2" style="font-size: 20px;">
					비밀번호 : <input type="password" class="form-control" id="passwd"
						name="passwd" value="${userinfo.passwd}" required>
				</div>
				<div id="div3" style="font-size: 20px;">
					이름 : <input type="text" class="form-control" id="username"
						name="username" value="${userinfo.username}" required readonly>

				</div>
				<div id="div4" style="font-size: 20px;">
					닉네임 : <input type="text" class="form-control" id="nickname"
						name="nickname" value="${userinfo.nickname}" required>
				</div>
				<div id="div5" style="font-size: 20px;">
					주소 : <input type="text" class="form-control" id="address"
						name="address" value="${userinfo.address}" required>
				</div>
				<div id="div5" style="font-size: 20px;">
					상세주소 : <input type="text" class="form-control"
						id="addressdetail" name="addressdetail" value="${userinfo.addressdetail}" required>
				</div>
				<div id="div5" style="font-size: 20px;">
					관심지역 : <input type="text" class="form-control" id="interarea"
						name="interarea" value="${userinfo.interarea}"required>
				</div>
				<div id="div5" style="font-size: 20px;">
					이메일 : <input type="text" class="form-control" id="email"
						name="email" value="${userinfo.email}" required>
				</div>
				<div id="div5" style="font-size: 20px;">
					전화번호 : <input type="text" class="form-control" id="phone"
						name="phone" value="${userinfo.phone}" required>
				</div>
				<br>
				<button type="button" class="btn btn-primary" onclick="update();">수정</button>
				<button type="button" class="btn btn-danger">Close</button>
		</form>
	</div>

</body>
</html>