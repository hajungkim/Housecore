<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function login() {
		if (document.getElementById("loginid").value == "") {
			alert("아이디 입력!!!"); return;
		}
		if (document.getElementById("loginpasswd").value == "") {
			alert("비밀번호 입력!!!"); return;
		}
		
		
		var path = "${pageContext.request.contextPath}";
		document.getElementById("loginForm").action = path + "/member?act=login";
		document.getElementById("loginForm").submit();
	}
</script>
<div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Login</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
				<form id="loginForm"method="post" action="">
				<!-- Modal body -->
					<div class="modal-body">
                    <div class="form-group">
                        <label for="loginid">User ID (* 20자 이내)</label>
                        <input type="text" class="form-control"  id="loginid" name="loginid" required>
                    </div>
                    <div class="form-group">
                        <label for="loginid">Password (* 20자 이내)</label>
                        <input type="password" class="form-control"  id="loginpasswd" name="loginpasswd"
                            required>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" onclick="javascript:login();" class="loginbt btn btn-primary" data-dismiss="modal">Login</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
				</form>
                
                
            </div>
        </div>
    </div>