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
     <%@ include file="module/css.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body>
     <!-- 상단 nav top -->
  	<%@ include file="module/header.jsp" %>
    
    <div class="container-fluid " style="height:20px;"></div>

    <!-- 상단 main-->
    <div class="container-fluid pl-0 pr-0" style="height:500px;">
        <div class="img1 top_main container-fluid ">
            <div style="padding-top: 200px; font-size:50px; font-weight: bold; color:black; ">
                <div style="width:50%; margin:0 auto; border-bottom:3px solid black;">행복한 우리집</div>
                <div style="font-size:30px;">간편한 부동산 실거래 정보 조회 서비스</div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-4"></div>
           <div class="col-md-4">
        	<button class="btn btn-outline-success w-100 h-100" onclick="searchDaum();">동 검색</button>
      		</div>
        </div>
    </div>

    <!-- 슬라이드 배너 start -->
    <div class="container mt-5">
        <h3>급상승 인기 매물</h3>
    </div>
    <div class="container mt-1">
        <div class="row">
            <div class="col-sm">
                <div id="demo" class="carousel slide" data-ride="carousel">

                    <!-- Indicators -->
                    <ul class="carousel-indicators">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>

                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${root}/res/img/home1.jpg" alt="Los Angeles" width="100%" height="400em">
                        </div>
                        <div class="carousel-item">
                            <img src="${root}/res/img/home2.png" alt="Los Angeles" width="100%" height="400em">
                        </div>
                        <div class="carousel-item">
                            <img src="${root}/res/img/home3.jpg" alt="Los Angeles" width="100%" height="400em">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- 슬라이드 배너 end -->



    <!-- 중단 main-->
    <div class="container" style="height:500px;">
        <div onclick="location.href='${root}/aptDeal'" class="img2 float-left mt-5 mr-3 ml-5"
            style="width:300px; height:300px; cursor: pointer;">
            <div style="width:100%; height:80%;"></div>
            <button type="button" onclick="location.href='${root}/aptDeal'" class="btn btn-light"
                style="width:80%;">실거래 검색 보기</button>
        </div>
        <div onclick="location.href='https\://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260'"
            class="img3 float-left mt-5 mr-3 ml-5" style="width:300px; height:300px; cursor: pointer;">
            <div style="width:100%; height:80%;"></div>
            <button type="button"
                onclick="location.href='https\://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260'"
                class="btn btn-light" style="width:80%;">부동산 최근동향</button>
        </div>
        <div onclick="location.href='https\://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260'"
            class="img4 float-left mt-5 mr-3 ml-5" style="width:300px; height:300px; cursor: pointer;">
            <div style="width:100%; height:80%;"></div>
            <button type="button"
                onclick="location.href='https\://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260'"
                class="btn btn-light" style="width:80%;">주거관련 뉴스</button>
        </div>
    </div>


   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    function searchDaum() {
    	let str = "${root}/aptDeal/";
        new daum.Postcode({
            oncomplete: function(data) {
                location.href = str + data.bcode;
            }
        }).open();
    }
    
	</script>

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
    <!-- 자바스크립트 -->
    <script src="js/index.js" type="text/javascript"></script>
</body>

</html>
