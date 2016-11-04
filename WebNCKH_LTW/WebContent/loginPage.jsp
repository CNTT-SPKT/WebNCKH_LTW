<!DOCTYPE html>
<html lang="en"><head>
<title> Example </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">  
<script type="text/javascript" src="vendor/bootstrap.js"></script>
<script type="text/javascript" src="1.js"></script>
<link rel="stylesheet" href="vendor/bootstrap.css">
<link rel="stylesheet" href="1.css">
</head>
<body>
	<div class="page">
		<div class="menu">
			<div class="row">
				<div class="pictureMain">
					<img src="images/skpt_banner_2.jpg" class="img-responsive" alt="Image">
				</div>
				<div class="menuBar">
					<nav class="navbar navbar-default" role="navigation">
						<div class="container" id="container_menuBar">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse navbar-ex1-collapse" id="menuMain">
								<ul class="nav navbar-nav">
									<li><a href="#">Trang chủ</a></li>
									<li><a href="#">Biểu Mẫu</a></li>
									<li><a href="#">Liên Hệ</a></li>
									<li><a href="#">Hướng dẫn</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li><a href="#">Đăng nhập</a></li>
								</ul>
							</div><!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>	
		</div>	
		<div class="loginPage">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-default" style="margin-top:40px">
						<div class="panel-heading">
							<h3 class="panel-title" style="text-align:center"><b>Sign In</b></h3>
						</div>
						<div class="panel-body">
							<form >
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
							<button class="btn btn-lg btn-primary btn-block" type="submit">
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
		</div>	
		<div id='bttop'>
			<img src="images/backtotop.png" alt="backtotop" width="50px" height="50px">
		</div>
		<footer style="margin-bottom:0px;margin-top:10px;">
			<pre style="margin-bottom:0px;">
				Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
			</pre>
		</footer>

	
	</div>



</body>
</html>