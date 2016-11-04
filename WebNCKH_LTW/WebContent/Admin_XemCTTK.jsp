<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title> Example </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="vendor/bootstrap.js"></script>
	<script type="text/javascript" src="1.js"></script>
	<link rel="stylesheet" href="vendor/bootstrap.css">
	<link rel="stylesheet" href="1.css">
	<link rel="stylesheet" href="vendor/font-awesome.css">

</head>

<body>
	<div class="page">
		<div class="menu">
			<div class="row">
				<div class="pictureMain">
					<img src="images/skpt_banner_2.jpg" class="img-responsive" alt="Image">
				</div>
				<div class="menuBar">
					<nav class="navbar navbar-default " role="navigation">
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
									<li><a href="#"><span  style="color:blue">Admin</span></a></li>
									<li><a href="mainPage.jsp">Đăng xuất</a></li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="svContent">
			<div class="row">
				<div class="col-md-2">
					<ul class="nav nav-pills nav-stacked" style="background:white;border-radius:3px">
						<li><a class="list-group-item" href="#QLTK" data-toggle="pill">
							<span class="glyphicon glyphicon-user"></span> Quản lý tài khoản</a>
						</li>
					</ul>
				</div>
				<div class="col-md-10">	
					<div class="tab-content">
						<div class="tab-pane" id="QLTK">
							<div class="row" style="">
								<div class="QLyTK" style="background:white;height:380px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 style="margin-top:0px;padding:5px;text-align:center;font-family:sans-serif">QUẢN LÝ TÀI KHOẢN</h2>
									<a class="btn btn-default" href="Admin_ThemTK.jsp" role="button" style="float:right;
									margin:0px 5px 5px 0px;">Thêm tài khoản</a>
									<div class="ad_table_qltk">
										<table class="table table-striped table-hover" style="margin:0px 5px 0px 0px;">
											<thead class="thead-default">
												<tr class="success">
													<th><input type="checkbox" name="" id="input" value=""></th>
													<th>Tên tài khoản</th>
													<th>Mã số</th>
													<th>Tài khoản</th>
													<th>Quyền truy cập</th>
													<th>Ngành</th>
													<th>Chỉnh sửa</th>
													<th>Xóa </th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th><input type="checkbox" name="" id="input" value=""></th>
													<td> Lâm Xuân Triết</td>
													<td>123</td>
													<td>Admin</td>
													<td>Admin</td>
													<td>CNTT</td>
													<td><a href="Admin_XemCTTK.jsp">Cập nhập</a></td>
													<td><a href="Admin_XemCTTK.jsp">Xóa</a></td>
												</tr>
												<tr>
													<th><input type="checkbox" name="" id="input" value=""></th>
													<td>Lê Thị Thảo</td>
														<td>124</td>
														<td>SinhVien1</td>
														<td>SinhVien</td>
														<td>CKM</td>
														<td><a href="">Cập nhập</a></td>
														<td><a href="">Xóa</a></td>
												</tr>
												<tr>
													<th><input type="checkbox" name="" id="input" value=""></th>
													<td>Tín Trương</td>
													<td>141 </td>
													<td>SinhVien2</td>
													<td>SinhVien</td>
													<td>CNTT</td>
													<td><a href="Admin_XemCTTK.jsp">Cập nhập</a></td>
													<td><a href="Admin_XemCTTK.jsp">Xóa</a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane active" id="ttTaiKhoan" >
							<div class="row">
								<div class="svttTaiKhoan" style="background:white;height:380px;margin-right:15px;border-radius:3px;overflow:auto;">
									<h2 style="margin-top:0px;padding:5px;text-align:center;font-family:sans-serif">THÔNG TIN TÀI KHOẢN</h2>
									<div class="ttTaiKhoan_content">
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<div class="svAnhDaiDien">
												<img src="images/daidien.jpg" alt="Image" width="95%" height="280px">
												<form action="">
													<input type="file" name="pic" accept="image/*">
												</form>
											</div>
										</div>
										<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
											<div class="row">
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<br><br>
													<b><p>Tên chủ nhiệm: Sinh Viên A</p>
														<p>MSSV: 14110208</p>
														<p>Ngày sinh: 02/08/1996</p>
														<p>Thuộc khoa: CNTT</p>
														<p>Quê quán: Quảng Ngãi</p>
													</b>
												</div>
												<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<br><br>
													<b><p>Mail: zxc@gmail.com</p>
														<p>Số điện thoại: 0123456789</p>
														<p>Mã số ngân hàng: 123456789</p>
														<p>Chi nhánh ngân hàng: ABC</p>
														<p>Đơn vị công tác: ZXC</p>
													</b>
												</div>
											</div>
											<div class="row" >
												<div class="">
													<a class="btn btn-primary" data-toggle="modal" href='#modal-id'style="margin-left:150px; margin-top:10px;">Cập nhập thông tin</a>
													<div class="modal fade" id="modal-id">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
																	<h4 class="modal-title">Modal title</h4>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="title" style=" text-align:center; margin-bottom:15px;">
																			<h2> CẬP NHẬP THÔNG TIN </h2>
																			<hr>
																		</div>
																	</div>
																	<div class="row">
																		<form action="" onsubmit="" method="POST" class="form-horizontal" role="form">
																			<div class="form-group" style="margin-left:5px; margin-left:65px;">

																				<div class="col-xs-10">
																					<label for="mail">Mail<span>:</span></label> 
																					<input class="form-control" id="mail" type="text" required="required">
																				</div><br>
																				<div class="col-xs-10">
																					<label for="sdt">Số điện thoại<span>:</span></label>
																					<input class="form-control" id="sdt" type="text" required="required">
																				</div><br>
																				<div class="col-xs-10">
																					<label for="cnnh">Chi nhánh ngân hàng<span>:</span></label> 
																					<input class="form-control" id="cnnh" type="text" required="required">
																				</div><br>
																				<div class="col-xs-10">
																					<label for="dvct">Đơn vị công tác<span>:</span></label> 
																					<input class="form-control" id="dvct" type="text" required="required">
																				</div><br>
																			</div>
																			<div class="modal-footer">
																				<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
																				<button type="submit" class="btn btn-primary">Lưu</button>
																			</div>
																		</form>
																	</div>
																</div>
																
															</div>
														</div>
													</div>
													<!-- <a class="btn btn-info" href="sinhvien_CapNhatThongTin.jsp" role="button" style="margin-left:150px">Cập nhật thông tin</a> -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id='bttop'>
				<img src="images/backtotop.png" alt="backtotop" width="50px" height="50px">
			</div>
		  <footer style="margin-bottom:0px;margin-top:10px;">
            <pre style="margin-bottom:0px;" >
                Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
            </pre>
        </footer>
		</div>


</body>

</html>