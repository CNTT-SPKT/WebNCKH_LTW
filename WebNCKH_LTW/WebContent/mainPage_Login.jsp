<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row" style="heigth:390px">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default box_shadow" style="margin-top:40px;height:330px">
			<div class="panel-heading">
				<h3 class="panel-title" style="text-align:center"><b>Sign In</b></h3>
			</div>
			<div class="panel-body">
				<form id="login_form">
					<div class="form-inline" style="margin-left:70px">
						<label>
							<input type="radio" id="input_sv" name="phanquyen" value="" >
							Sinh viên
						</label>
						<label>
							<input type="radio"  id="input_gv" name="phanquyen" value="">
							Giảng viên
						</label>
						<label>
							<input type="radio" id="input_ql" name="phanquyen" value="">
							Quản lý
						</label>
						<label>
							<input type="radio" id="input_ad" name="phanquyen" value="">
							Admin
						</label>
					</div>
					<div class="form-group">
						<input class="form-control" id="svLogin_Email" placeholder="E-mail" name="Email" type="text" >
					</div>
					<div class="form-group">
						<input class="form-control" id="svLogin_Pass" placeholder="Password" name="password" type="Password" value="">
					</div>
					<div class="checkbox">
						<label>
							<input name="remember" type="checkbox" value="Remember Me"> Remember Me
						</label>
					</div>
				</form>
				<button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:20px">
					Login
				</button>
			</div>
		</div>
	</div>
</div>
<script>
$(function() {
	$("button:submit").on("click", function() {
		if($("#svLogin_Email").val()=="14110208@student.hcmute.edu.vn" && $("#svLogin_Pass").val()=="14110208" || $("#svLogin_Email").val()=="14110180@student.hcmute.edu.vn" && $("#svLogin_Pass").val()=="14110180" || $("#svLogin_Email").val()=="14110205@student.hcmute.edu.vn" && $("#svLogin_Pass").val()=="14110205" || $("#svLogin_Email").val()=="14110184@student.hcmute.edu.vn" && $("#svLogin_Pass").val()=="14110184")
		{
			var rowCount = $('input').length;
			var i=0;
			var temp=-1;
			for(i;i<rowCount;i++)
			{
				if($('input').eq(i).is(":checked"))
				{
					temp=i;
				}
			}
			if(temp===-1)
			{
				alert("Chọn phân quyền để đăng nhập !");
			}
			else
			{
				var url;
				var x=$('input').eq(temp).attr("id");
				if(x=="input_sv")
					url="sinhvienPage.jsp";
				else if(x=="input_gv")
					url="giangvienPage.jsp";
				else if(x=="input_ql")
					url="quanlyPage.jsp";
				else	
					url="Admin.jsp";
				window.location.replace(url);
				alert("Đăng nhập thành công!");	
			}
		}
		else
		{
			if($("#svLogin_Email").val()=="" || $("#svLogin_Pass").val()=="")
				alert("Điền đầy đủ thông tin");
			else
			{
				var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
				if (!filter.test($("#svLogin_Email").val()) )
				{ 
					alert('Nhập địa chỉ email hợp lệ.\nExample@gmail.com');
					$("#svLogin_Email").focus();
				}
				else	
					alert("Email hoặc mật khẩu không chính xác");
			}
		}
	});
});
</script>