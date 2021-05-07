<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="pageno" value="${pageno}"/>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${root}/css/boardResult.css" />
  <link rel="stylesheet" href="${root}/css/index.css">
</head>

<body>
<c:set var="pr" value="${result.pageResult}" scope="request"/>
  <!-- 상단 nav top -->
  <%@ include file="module/header.jsp" %>
  
  <div class="container">
	
    <!-- d-->
    <div style="height:170px;"></div>
    
    <div class="row mt-5">
      <div class="col-md-4"></div>
     

      <div class="col-md-4">
        <button class="btn btn-outline-success w-100 h-100" onclick="sample4_execDaumPostcode();">동 검색</button>
      </div>
    </div>

    <!-- 게시물 영역 start -->
    <div class="mt-3">
      <h2>실거래 정보</h2>
      <div class="mb-3" style="border-bottom: 2px solid rgb(233, 232, 232);"></div>
    </div>
    
    <c:if test="${empty result.list}">
    	<div class="container" style="height:300px;">
	    	<h2>검색결과가 없습니다.</h2>
    	</div>
    </c:if>
    
    <c:set var="loopFlag" value="false" />
    <c:forEach var="aptDeal"  items="${result.list}" varStatus="loop">
        			<c:if test="${loop.index % 3 == 0}"><div class="card-deck"></c:if>
		    	  	<div class="card">
			     	<img src="${root}/res/img/${aptDeal.aptName}.jpg" onerror="this.src='${root}/res/img/다세대주택.jpg'" />
			     	<div class="card-body text-center">
			          <h5>${aptDeal.aptName}</h5>
			          <p class="card-text">실거래 금액 : ${aptDeal.dealAmount}만원</p>
			          <p class="card-text">건축년도 : ${aptDeal.buildYear}년</p>
			          <p class="card-text">면적 : ${aptDeal.area} 제곱미터</p>
			        </div>
			      	</div>
    			<c:if test="${loop.index % 3 == 2 || loop.last}"></div></c:if>
    </c:forEach>     
   </div>
    
  <!-- 게시물 영역 -->

  <!-- pagenation -->
  <!-- c:import page.jsp -->
 <c:if test="${pr.count != 0}">
   <nav aria-label="...">
    <ul class="pagination justify-content-center mt-4">
      <li class="page-item <c:if test="${not pr.prev}">disabled</c:if>">
        <a class="page-link" href="#1" <c:if test="${pr.prev}">onclick="goPage(${pr.beginPage - 1});"</c:if> aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a>
      </li>
	      <c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
	      	<c:if test="${i != pr.pageNo}">
	      		<li class="page-item">
	      			<!--   <a class="page-link" href="${root}/aptDeal?act=searchbylist&dongcode=${dongcode}&pageNo=${i}">${i}</a> -->
	      			<a class="page-link" href="${root}/aptDeal?pageNo=${i}&dongcode=${dongcode}">${i}</a>
	      		</li>
	      	</c:if>
	      	<c:if test="${i == pr.pageNo}">
	      		<li class="page-item active">
			      	<span class="page-link">
			          ${i}
			          <span class="sr-only">(${i})</span>
			        </span>
		        </li>
	  		</c:if>
		  </c:forEach>

      <li class="page-item <c:if test="${not pr.next}">disabled</c:if>">
        <a class="page-link" href="#" <c:if test="${pr.next}">onclick="goPage(${pr.endPage + 1});"</c:if>><span aria-hidden="true">&raquo;</span></a>
      </li>
    </ul>
  </nav>
 </c:if>
  
  <!-- pagenation -->
  
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
  <script src="${root}/js/index.js" type="text/javascript"></script>
  
  <!-- 동 코드 리턴하는 다음 팝업 -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    function sample4_execDaumPostcode() {
    	let str = "${root}/aptDeal?act=searchbylist&dongcode=";
        new daum.Postcode({
            oncomplete: function(data) {
                location.href = str + data.bcode + "&pageNo=1";
            }
        }).open();
    }
    function goPage(pageNo) {
		//alert(pageNo);
		let str = "${root}/aptDeal?act=";
		//alert(${dongcode});
		if(${not empty dongcode}){
			str += "searchbylist&dongcode=${dongcode}&pageNo=";
		} else {
			str += "list&pageNo=";
		}
		location.href = str + pageNo;
	}
    function changeNumber() {
    	console.log("찍힘");
    }
	</script>
</body>

</html>
