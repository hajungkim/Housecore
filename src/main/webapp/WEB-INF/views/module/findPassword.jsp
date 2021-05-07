<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- The Modal -->
  <div class="modal fade" id="passModal" style="height:500px;">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Find Password</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <div style="font-weight:bold; font-size:30px;">개인정보를 입력해주세요</div>
          <div class="form-group">
            <label for="usrid">User ID (* 20자 이내)</label>
            <input type="text" class="form-control" placeholder="ID" id="findid" name="userid" required>
          </div>
          <div class="form-group">
            <label for="name">User Name (* 20자 이내)</label>
            <input type="text" class="form-control" placeholder="Name" id="findname" name="name" required>
          </div>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="findbtn btn btn-primary">Find</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>

      </div>
    </div>
  </div>