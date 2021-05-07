<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	function login() {
		if (document.getElementById("userid").value == "") {
			alert("아이디 입력!!!"); return;
		}
		if (document.getElementById("passwd").value == "") {
			alert("비밀번호 입력!!!"); return;
		}
		
		$("#loginForm").attr("action", "${root}/member/login").submit();
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
                        <input type="text" class="form-control"  id="userid" name="userid" value="ssafy" required>
                    </div>
                    <div class="form-group">
                        <label for="loginid">Password (* 20자 이내)</label>
                        <input type="password" class="form-control"  id="passwd" name="passwd" value="ssafy" 
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