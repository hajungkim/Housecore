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
    <%@ include file="module/header.jsp" %>
    <div class="container-fluid " style="height:20px;"></div>

    <!-- 상단 main-->
    <div class="container" style="height:150px;"></div>
    <div class="container">
        <h2 style="font-weight: bold;">동네 업종 정보 조회</h2>
        <div class="row">

            <div class="col-md-4"></div>
            <div class="col-md-2">
                <select class="form-control" id="sel1" style="font-size: 20px;">
                    <option>지역선택</option>
                    <option>서울시</option>
                    <option>경기도</option>
                    <option>인천광역시</option>
                    <option>부산광역시</option>
                    <option>대전광역시</option>
                    <option>대구광역시</option>
                    <option>울산광역시</option>
                    <option>세종</option>
                    <option>광주광역시</option>
                    <option>강원도</option>
                    <option>충청북도</option>
                    <option>충청남도</option>
                </select>
            </div>
            <div class="col-md-2">
                <select class="form-control" id="sel1" style="font-size: 20px;">
                    <option>동으로 검색 </option>
                    <option>학성동 </option>
                    <option>수진동 </option>
                    <option>수정동 </option>
                    <option>유곡동 </option>
                    <option>태화동 </option>
                    <option>다운동 </option>
                    <option>남외동 </option>
                    <option>약사동 </option>
                    <option>반구동 </option>
                    <option>무천동 </option>
                    <option>상개동 </option>
                    <option>고사동 </option>
                </select>
            </div>
            <div class="col-md-3">
                <input type="text" class="form-control" placeholder="HappyHouse 통합검색">
            </div>
            <div class="col-md-1">
                <button class="btn btn-outline-success w-100 h-100">검색</button>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-7">
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
                                        <img src="${root}/res/img/shop1.jpg" alt="Los Angeles" width="100%" height="400em">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${root}/res/img/shop2.jpg" alt="Los Angeles" width="100%" height="400em">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${root}/res/img/shop3.jpg" alt="Los Angeles" width="100%" height="400em">
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
            </div>
            <div class="col-md-5 environ-info">
                <div class="shop-card shadow">
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-6">
                            양푼이 김치찌개
                        </div>
                        <div class="col-sm-4">
                            한식/백반
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10">서울특별시 마포구 공덕동</div>
                    </div>
                </div>
                <div class="shop-card shadow">
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-6">
                            이삭토스트
                        </div>
                        <div class="col-sm-4">
                            토스트
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10">서울특별시 마포구 공덕동</div>
                    </div>
                </div>
                <div class="shop-card shadow">
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-6">
                            명랑핫도그
                        </div>
                        <div class="col-sm-4">
                            핫도그
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10">서울특별시 마포구 공덕동</div>
                    </div>
                </div>
                <div class="shop-card shadow">
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-6">
                            롯데리아
                        </div>
                        <div class="col-sm-4">
                            패스트푸드
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10">서울특별시 마포구 공덕동</div>
                    </div>
                </div>
                <div class="shop-card shadow">
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-6">
                            양푼이 김치찌개
                        </div>
                        <div class="col-sm-4">
                            한식/백반
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10">서울특별시 마포구 공덕동</div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="container" style="height:50px;"></div>

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
    <!-- 자바스크립트 -->
</body>

</html>