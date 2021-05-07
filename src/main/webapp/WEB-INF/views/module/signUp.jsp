<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function regist() {
		if (document.getElementById("userid").value == "") {
			alert("아이디 입력!!!"); return;
		}
		if (document.getElementById("passwd").value == "") {
			alert("비밀번호 입력!!!"); return;
		}
		if (document.getElementById("username").value == "") {
			alert("사용자 이름 입력!!!"); return;
		}
		if (document.getElementById("nickname").value == "") {
			alert("닉네임 입력!!!"); return;
		}
		if (document.getElementById("address").value == "") {
			alert("주소정보 입력!!!"); return;
		}
		if (document.getElementById("addressdetail").value == "") {
			alert("상세 주소 입력!!!"); return;
		}
		if (document.getElementById("interarea").value == "") {
			alert("관심지역 입력!!!"); return;
		}
		if (document.getElementById("email").value == "") {
			alert("이메일 입력!!!"); return;
		}
		if (document.getElementById("phone").value == "") {
			alert("전화번호 입력!!!"); return;
		}
		
		var path = "${pageContext.request.contextPath}";
		document.getElementById("registFom").action = path + "/member?act=registMember";
		document.getElementById("registFom").submit();
	}
</script>
<div class="modal fade" id="signUpModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">SignUp</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
				<form id="registFom"method="post" action="">
					<!-- Modal body -->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="userid">User ID (* 20자 이내)</label>
                        <input type="text" class="form-control" id="userid" name="userid" required>
                    </div>
                    <div class="form-group">
                        <label for="passwd">User Password (* 20자 이내)</label>
                        <input type="password" class="form-control" id="passwd" name="passwd"
                            required>
                    </div>
                    <div class="form-group">
                        <label for="username">User Name (* 20자 이내)</label>
                        <input type="text" class="form-control"  id="username" name="username" required>
                    </div>
                    <div class="form-group">
                        <label for="nickname">닉네임 (* 20자 이내)</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address (* 20자 이내)</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                    <div class="form-group">
                        <label for="addressdetail">Address Detail (* 20자 이내)</label>
                        <input type="text" class="form-control" id="addressdetail" name="addressdetail" required>
                    </div>
                    <div class="form-group">
                        <label for="interarea">관심지역</label>
                        <input type="text" class="form-control" id="interarea" name="interarea"
                            required>
                    </div>
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="text" class="form-control" id="email" name="email"
                            required>
                    </div>
                    <div class="form-group">
                        <label for="phone">전화번호</label>
                        <input type="text" class="form-control" id="phone" name="phone"
                            required>
                    </div>
                    
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <!--  <button type="button" class="searchbtn btn btn-primary" data-toggle="modal"
                        data-target="#searchModal">Check</button> -->
                    <button type="button" onclick="javascript:regist();" class="signUpbt btn btn-primary">SignUp</button>
                    <button type="button"  class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
				</form>

            </div>
        </div>
    </div>