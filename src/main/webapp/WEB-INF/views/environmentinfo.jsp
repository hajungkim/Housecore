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

    <!-- 상단 main-->


    <div class="container" style="height:150px;"></div>
    <div class="container">
        <h2 style="font-weight: bold;">대기오염 정보 조회</h2>
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
        <div class="container">
            <table class="table table-hover mt-4 ">
                <thead>
                    <tr>
                        <!-- <th class="text-center" style="width: 60%;">제목</th>
                        <th style="width: 15%;">작성자</th>
                        <th style="width: 15%;">날짜</th>
                        <th style="width: 10%;">조회수</th> -->
                        <th>업체(시설)명</th>
                        <th>인허가번호</th>
                        <th>지도점검일자</th>
                        <th>점검기관</th>
                        <th>점검결과</th>
                        <th>처분대상여부</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    <tr>
                        <td>EcoSystems</td>
                        <td>NT30102120</td>
                        <td>2021.03.12</td>
                        <td>EcoSystems</td>
                        <td>정상</td>
                        <td>N</td>
                    </tr>
                    
                </tbody>
            </table>
            <nav aria-label="...">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <span class="page-link">Previous</span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item active">
                        <span class="page-link">
                            2
                            <span class="sr-only">(current)</span>
                        </span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>

        <!-- 여기 들어가기 -->

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