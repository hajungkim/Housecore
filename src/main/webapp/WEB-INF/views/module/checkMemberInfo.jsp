<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
		var path = "${pageContext.request.contextPath}";
		function update() {
			if (document.getElementById("updatePwd").value == "") {
				alert("비밀번호 입력!!!"); return;
			}
			if (document.getElementById("updateAddr").value == "") {
				alert("주소정보 입력!!!"); return;
			}
			if (document.getElementById("updateAddrDetail").value == "") {
				alert("상세 주소정보 입력!!!"); return;
			}
			if (document.getElementById("updateNickname").value == "") {
				alert("닉네임 정보 입력!!!"); return;
			}
			if (document.getElementById("updateInterArea").value == "") {
				alert("관심지역 정보 입력!!!"); return;
			}
			if (document.getElementById("updateEmail").value == "") {
				alert("이메일 정보 입력!!!"); return;
			}
			
			document.getElementById("updateForm").action = path + "/member?act=updateMember";
			document.getElementById("updateForm").submit();
			alert('회원정보가 수정되었습니다!');
		}
</script>

<!-- The Modal -->
<div class="modal fade" id="searchModal" style="height: 500px;">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Check</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
		
			<!-- Modal body -->
			<form id="updateForm" method="post" action="">
				<div class="modal-body">
					<div style="font-weight: bold; font-size: 30px;">회원정보를 확인해주세요</div>
					<div id="div1" style="font-size: 20px;">
						아이디 : <input type="text" class="form-control"  id="updateUserId" name="updateUserId" required readonly  >
					</div>
					<div id="div2" style="font-size: 20px;">
						비밀번호 : <input type="password" class="form-control"  id="updatePwd" name="updatePwd" required>
					</div>
					<div id="div3" style="font-size: 20px;">
						이름 : <input type="text" class="form-control"  id="updateUsername" name="updateUsername" required readonly  > 
						
					</div>
					<div id="div4" style="font-size: 20px;">
						닉네임 : <input type="text" class="form-control"  id="updateNickname" name="updateNickname" required>
					</div>
					<div id="div5" style="font-size: 20px;">
						주소 : <input type="text" class="form-control"  id="updateAddr" name="updateAddr" required>
					</div>
					<div id="div5" style="font-size: 20px;">
						상세주소 : <input type="text" class="form-control"  id="updateAddrDetail" name="updateAddrDetail" required>
					</div>
					<div id="div5" style="font-size: 20px;">
						관심지역 : <input type="text" class="form-control"  id="updateInterArea" name="updateInterArea" required>
					</div>
					<div id="div5" style="font-size: 20px;">
						이메일 : <input type="text" class="form-control"  id="updateEmail" name="updateEmail" required>
					</div>
					<div id="div5" style="font-size: 20px;">
						전화번호 : <input type="text" class="form-control"  id="updatePhone" name="updatePhone" required>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="update();">수정</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>