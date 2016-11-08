<%@ page import="Controller.*,Model.*" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
    <script type="text/javascript" src="jquery.validate.min.js"></script>
    <link rel="stylesheet" href="vendor/bootstrap.css">
    <link rel="stylesheet" href="1.css">
    <link rel="stylesheet" href="vendor/font-awesome.css">
</head>

<body>
<%
	DeTai_Controller detaiDAO = new DeTai_Controller();
	TrangThai_Controller trangthaiDAO =new TrangThai_Controller();
	ThongBao_Controller thongbaoDAO = new ThongBao_Controller();
	HoiDong_Controller hoidongDao =new HoiDong_Controller();
	TB_TK_Controller cttb= new TB_TK_Controller();
	ThongBao_Controller tb= new ThongBao_Controller();
	TrangThai_Controller tt=  new TrangThai_Controller();
	CTNghiemThu_Controller ctnt= new CTNghiemThu_Controller();
	TaiKhoan_Controller taikhoanDAO=new TaiKhoan_Controller();
%>

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
                                    <li><a  href="#"> <span  id="username" value=""  type="text" style="color:blue"> <%=session.getAttribute("Email") %></span></a></li>
                                    <li><a href="mainPage.jsp">Đăng xuất</a></li>
                                </ul>
                            </div>
                            <!-- /.navbar-collapse -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <div class="qlContent">
            <div class="row">
                <div class="col-md-2">
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a class="list-group-item" href="#postThongBao" data-toggle="pill">
                                <span class="glyphicon glyphicon-home"></span> Thông báo</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#quanLyDeTai" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-list-alt"></span> Quản lý đề tài</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsDeTaiPhanBien" class="list-group-item" data-toggle="pill" style="border-radius:0px;">
                                <span class="glyphicon glyphicon-th-list"></span> DSĐT được phân công phản biện</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsDeTaiPheDuyet" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-list-alt"></span> DSĐT được phân công phê duyệt</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsDeTaiHuongDan" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-th-list"></span> DS đề tài hướng dẫn</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a class="list-group-item" href="#dkDeTai" data-toggle="pill">
                                <span class="glyphicon glyphicon-inbox"></span> Đăng ký đề tài</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsDeTaiDK" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-list-alt"></span> DS đề tài đã đăng ký</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#duyetHuy_GianHan" class="list-group-item" data-toggle="pill" style="border-radius:0px;">
                                <span class="glyphicon glyphicon-check"></span> Duyệt đơn hủy/gia hạn đề tài</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsHDNT" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-list-alt"></span> Danh sách hội đồng nghiệm thu</a>
                        </li>
                        <li style="margin-top:0px;">
                            <a href="#dsDTPB" class="list-group-item" data-toggle="pill">
                                <span class="glyphicon glyphicon-edit"></span> Phân công phản biện</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-10">
                    <div class="tab-content">
                          <div class="tab-pane active" id="postThongBao">
                            <div class="row">
                                <div class="clposthongbao" style="overflow:auto; background:white;height:600px;margin-right:15px;border-radius:3px">
                                    <h2 class="tieude_theh">THÔNG BÁO</h2><hr>
                                    <div class="ql_table_thongbao">
                                        <table class="table table-striped table-hover">
                                            <thead class="thead-default">
                                                <tr class="success">
                                                    <th><input type="checkbox" name="" id="selectAll_ThongBao" value=""></th>
                                                    <th>Thông báo</th>
                                                    <th>Người gửi</th>
                                                    <th>Ngày gửi</th>
                                                    <th>Chi tiết thông báo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                             <%
                                         	     	for(ThongBao c: thongbaoDAO.getListThongBaoQL()){                      			
                                              %>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td><%=c.getTenLoaiTB() %></td>
                                                    <td><%=c.getTenNguoiGui() %></td>
                                                    <td><%=c.getNgayGui() %></td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                         <%} %>
                                            </tbody>
                                        </table>
                                        <script>
                                                $('#selectAll_ThongBao').change(function(){
                                                    if($(this).prop('checked')){
                                                        $('tbody tr td input[type="checkbox"]').each(function(){
                                                            $(this).prop('checked', true);
                                                        });
                                                    }else{
                                                        $('tbody tr td input[type="checkbox"]').each(function(){
                                                            $(this).prop('checked', false);
                                                        });
                                                    }
                                                });
                                               
                                        </script>
                                        </div>
                                        <button type="button" class="btn btn-danger" id="btn_Xoa" style="float:right; margin-right:10px; margin-bottom:10px;">
                                            <span class="glyphicon glyphicon-trash"></span> Xóa thông báo</button>
                                </div>
                            </div>
                        </div>
                        
						<div class="tab-pane active" id="dsDeTaiDeXuat"  >
							<div class="row">
								<div class="qldsDeTai" style="background:white;height:500px;margin-right:15px;border-radius:3px">
									<h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐƯỢC ĐỀ XUẤT</h2>
									<hr>
									<div class="ql_table_dsDeTai" style="Margin-top:20px;">
										<table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã số</th>
													<th>Tên đề tài</th>
													<th>Ngày đăng ký</th>	
													<th>Giảng viên hướng dẫn</th>
													<th></th>
													
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>141</td>
													<td>Nghiên cứu hệ thống nhúng</td>
													<td>12/12/2012</td>
													<td>Lê Thị B</td>
													<td><a href="quanly_CTDTDeXuat.jsp" >Đăng ký</a></td>
												</tr>
												<tr>
													<td>142</td>
													<td>Xây dựng web bán điện thoại</td>
													<td>12/12/2012</td>
													<td>Lê C</td>
													<td><a href="quanly_CTDTDeXuat.jsp" >Đăng ký</a></td>
												</tr>
												<tr>
													<td>143</td>
													<td>Xây dựng web laptop</td>
													<td>12/12/2012</td>
													<td>Lê C</td>
													<td><a href="quanly_CTDTDeXuat.jsp" >Đăng ký</a></td>
												</tr>
											</tbody>
										</table>
									</div>

								</div>
							</div>
						</div>
                         <div class="tab-pane" id="postThongBao">
                            <div class="row">
                                <div class="clposthongbao" style="overflow:auto; background:white;height:600px;margin-right:15px;border-radius:3px">
                                    <h2 class="tieude_theh">THÔNG BÁO</h2><hr>
                                    <div class="ql_table_thongbao">
                                        <table class="table table-striped table-hover">
                                            <thead class="thead-default">
                                                <tr class="success">
                                                    <th><input type="checkbox" name="" id="selectAll_ThongBao" value=""></th>
                                                    <th>Thông báo</th>
                                                    <th>Người gửi</th>
                                                    <th>Ngày gửi</th>
                                                    <th>Chi tiết thông báo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2014</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr id="select6">
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đăng ký đề tài mới...</td>
                                                    <td>Giảng viên 1</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_PheDuyetDT.jsp">Xem</a></td>
                                                </tr>

                                                <tr >
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đơn xin hủy đề tài</td>
                                                    <td>Sinh viên 1</td>
                                                    <td>12/12/2012</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đơn xin gia hạn đề tài</td>
                                                    <td>Sinh viên 2</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>
                                                <tr >
                                                    <td><input type="checkbox" name=""  value=""></td>
                                                    <td>Đơn xin gia hạn đề tài</td>
                                                    <td>Sinh viên 2</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>
                                                <tr > 
                                                    <td><input type="checkbox" name=""  value=""></td>
                                                    <td>Đơn xin gia hạn đề tài</td>
                                                    <td>Sinh viên 2</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>
                                                <tr >
                                                    <td><input type="checkbox" name="" value=""></td>
                                                    <td>Đơn xin gia hạn đề tài</td>
                                                    <td>Sinh viên 2</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" name=""  value=""></td>
                                                    <td>Đơn xin gia hạn đề tài</td>
                                                    <td>Sinh viên 2</td>
                                                    <td>12/12/2013</td>
                                                    <td><a href="quanly_DuyetDonHuy.jsp">Xem</a></td>
                                                </tr>

                                            </tbody>
                                        </table>
                                        <script>
                                                $('#selectAll_ThongBao').change(function(){
                                                    if($(this).prop('checked')){
                                                        $('tbody tr td input[type="checkbox"]').each(function(){
                                                            $(this).prop('checked', true);
                                                        });
                                                    }else{
                                                        $('tbody tr td input[type="checkbox"]').each(function(){
                                                            $(this).prop('checked', false);
                                                        });
                                                    }
                                                });
                                               
                                        </script>
                                        </div>
                                        <button type="button" class="btn btn-danger" id="btn_Xoa" style="float:right; margin-right:10px; margin-bottom:10px;">
                                            <span class="glyphicon glyphicon-trash"></span> Xóa thông báo</button>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane" id="dsHDNT">
                            <div class="row">
                                <div class="cldsHDNT" style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px">
                                    <h2 class="tieude_theh">DANH SÁCH HỘI ĐỒNG NGHIỆM THU</h2><hr>
                                    
                                    <div class="quanly_dsHDNT">
                                        <div class="ql_table_dsHDNT"></div>

                                       <table class="table table-striped table-hover">
                                            <thead class="thead-default">
                                                <tr class="success">
                                                    <th>Mã HĐ</th>
                                                    <th>Chủ tịch</th>
                                                    <th>Phản biện</th>
                                                    <th>Ủy viên</th>
                                                    <th>Ngày thành lập</th>
                                                    <th style="">Xóa</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                               <% for (HoiDong hd:hoidongDao.getListHoiDongQL()){ %>
                                                <tr>
                                                    <td><%=hd.getMaHD() %></td>
                                                   <td><%=hd.getTenChuTich() %></td>
                                                    <td><%=hd.getTenPhanBien() %></td>
                                                    <td><%=hd.getTenUyVien() %></td>
                                                    <td><%=hd.getNgayThanhLap() %></td>
                                                    <td class="dropdown">
                                                        <a style="margin-top: -5px;" class="btn btn-danger dsDeTai_actionButton" data-toggle="dropdown" href="#"> Xóa hội đồng </a></td>
                                                </tr>
                                                <%} %>
                                            </tbody>
                                        </table>
                                         <a class="btn btn-info" style="float:right; margin-right: 10px;" href="quanlyPage_LTHDNT.jsp" role="button">Thành lập hội đồng nghiệm thu</a>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="tab-pane" id="dsDTPB">
                            <!--danh sách đề tài phản biện-->
                            <div class="row">
                                <div class="cldsDTPB" style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px">
                                    <h2 class="tieude_theh">PHÂN CÔNG PHẢN BIỆN</h2><hr>
                                    <div class="quanly_dsHDPB">

                                        <div class="ql_table_dsDTPB">
                                             <table class="table table-striped table-hover">
                                                <thead class="thead-default">
                                                    <tr class="success">
                                                        <th>Mã đề tài</th>
                                                        <th>Tên đề tài</th>
                                                        <th>Chủ nhiện đề tài</th>
                                                        <th>Giảng viên hướng dẫn</th>
                                                            <th>Hội đồng phản biện</th>
                                                        <th>Chi tiết</th>
                                                        <th>Xem báo cáo</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <%for(DeTai c:detaiDAO.getListPCPBQL()){ %>
                                                    <tr>
                                                        <td><%=c.getMaDT() %></td>
                                                        <td><%=c.getTenDT() %></td>
                                                        <td><%=c.getHoTen() %></td>
                                                        <td><%=c.getTenGVHD() %></td>
                                                        <td><%=c.getMaHD() %></td>
                                                        <td><a href="quanly_ChiTiet.jsp">Xem</a></td>
                                                        <td><a href="quanly_XemBaoCao.jsp"><span style="color:gray">Chi tiết</span></a></td>
                                                    </tr>
                                                    <%} %>
                                                </tbody>
                                            </table>
                                             <a class="btn btn-info" style="float:right; margin-right: 10px;" href="quanlyPage_PCPB.jsp" role="button">Phân công phản biện</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       <div class="tab-pane" id="dsDeTaiPhanBien">
                            <div class="row">
                                <div class="ql_dsDeTaiPhanBien" style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px">
                                    <h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐƯỢC PHÂN CÔNG PHẢN BIỆN</h2><hr>
                                    <div class="ql_tb_dsDeTaiPhanBien">
                                       <table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Giảng viên hướng dẫn</th>
													<th>Chi tiết</th>
													<th>Báo cáo</th>
													<th>Đánh giá</th>
												</tr>
											</thead>
											<tbody>
											   <%
				     							for (DeTai ct: detaiDAO.getListDeTaiPhanCongPhanBien(session.getAttribute("Email").toString())) {
												%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><%=ct.getTenGVHD() %></th>
													<th><a href="giangvienPage_ChiTiet.jsp?MaDT=">Chi tiết</a></th>
													<th><a href="giangvienPage_XemBC.jsp?MaDT=">Xem báo cáo</a></th>
													<th><a href="giangvienPage_DanhGia.jsp?MaDT=">Đánh giá</a></th>
												</tr>
												<%
			    											}
												%>		
											</tbody>
										</table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                       <div class="tab-pane " id="quanLyDeTai">
                            <div class="row">
                                <div class="form-group" style="margin-bottom:0px;">
                                    <div class="ql_quanLyDeTai" style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px;">
                                        <h2 class="tieude_theh">QUẢN LÝ ĐỀ TÀI</h2><hr>
                                        <div class="ql_tb_quanLyDeTai" style="font-size:13px">
                                            <div class="timQLDT" style="float:right;margin-bottom:10px;padding-top:-5;">
                                                <div style="margin-left:0px;" class=" col-sm-6 col-sm-offset-3 ">

                                                            <select style="float:left;width:150p x; " class="form-control" id="tkql" >
                                                    <option  value="tatca" selected>Tất cả</option>     
                                                    <option  value="madetai">Mã đề tài</option>
                                                    <option  value="tengvhd">Tên GVHD</option>
                                                    </select>

                                                    <div style=";width:400px; " id="imaginary_container ">
                                                        <div class="input-group stylish-input-group">
                                                            <input type="text " id="myInput" class="form-control" onkeyup="myFunction()" placeholder="Search ">
                                                            <span class="input-group-addon ">
                                                                        <button type="submit" id="tkiem">
                                                                            <span class="glyphicon glyphicon-search "></span>
                                                            </button>
                                                            </span>
                                                        </div>

                                                    </div>

                                                </div>
                                            </div>

                                        </div>
                                        <table class="table table-striped table-hover" id="myTable">
                                            <thead class="thead-default ">
                                                <tr class="success ">
                                                    <th>Mã đề tài</th>
                                                    <th>Tên đề tài</th>
                                                    <th>Chủ nghiệm đề tài</th>
                                                    <th>Giảng viên hướng dẫn</th>
                                                    <th>Chi tiết</th>
                                                    <th>Trạng thái</th>
                                                    <th>Báo cáo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                         	   <%
                                         	  		
                                                	for(DeTai c: detaiDAO.getListDeTaiQL()){                      			
                                                %>
                                                <tr>
                                                
                                                    <th><%=c.getMaHienThi()%></th>
                                                    <th><%=c.getTenDT()%> </th>
                                                    <th><%=c.getHoTen()%></th>
                                               		<th><%=c.getTenGVHD() %></th>                                      
                                                    <th><a href="quanly_ChiTiet.jsp">Chi tiết</a></th>
                                                    <th>
                                                        <div class="form-group ">
                                                      
                                                            <select class="ql_TrangThai ">
                                                       			 <option value="<%=c.getMaTT() %> "><%=c.getTenTT() %></option>   
                                                       			      <%   for(TrangThai ct:trangthaiDAO.getListTrangThai() ){ %>
                                                                  <option value="<%=ct.getMaTT() %> "><%=ct.getTenTT() %></option>       
		                                                                <%
		                                                				}
		                                                  		     %>  
                                                           </select>
                                                             
                                                         </div>
                                                    </th>
                                              
                                                    <th><a href="quanly_XemBaoCao.jsp">Xem </a></th>
                                                     
                                                </tr>    
                                                   <%
                                                   }
                                                    %>                       
                                            </tbody>
                                        </table>
                                        <button style="margin-left:20px;margin-bottom:20px" class="btn btn-primary btn-lg" id="CapNhat">Cập nhật trạng thái</button>
                                        <script>
                                         $(function() {
                                        	 $('#CapNhat').on('click', function(){
                                        			 var rowCount = $('#myTable tbody tr').length;
                                        			 var i=0;
                                        			 var madt;
                                   				 	 var matt="";
                                   				 	 for(i;i<rowCount;i++)
                                   				 	{
                                   				 		var x=$('#myTable tbody').find('tr:eq('+i+')').find('th:eq(0)').text();
                                       				 	var y=$('#myTable tbody').find('tr:eq('+i+')').find('option').val();
                                       				 	// Ham cap nhat trang thai
                                   				 	}
                                        	 });
                                         });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                       <div class="tab-pane " id="dsDeTaiPheDuyet">
                            <div class="row ">
                                <div class="ql_dsDeTaiPheDuyet " style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px ">
                                    <h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐƯỢC PHÂN CÔNG PHÊ DUYỆT</h2><hr>
                                    <div class="ql_tb_dsDeTaiPheDuyet ">
                                        <table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Cấp đề tài</th>
													<th>Tên đề tài</th>
													<th>Lĩnh vực</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Phê duyệt</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: detaiDAO.getListDeTaiPheDuyetQL()) {
											%>
												<tr>
													<th><input style="width:100px"type="text" name="fname"  placeholder="Cấp mã đề tài" value=""/></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getLinhVuc() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><a href="">Phê duyệt</a></th>
												</tr>
											<%
			    							}
											%>
											</tbody>
										</table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane " id="dsDeTaiHuongDan">
                            <div class="row ">
                                <div class="ql_dsDeTaiHuongDan " style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px ">
                                    <h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI HƯỚNG DẪN</h2><hr>
                                    <div class="ql_tb_dsDeTaiHuongDan ">
                                      <table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nghiệm đề tài</th>
													<th>Chi tiết</th>
													<th>Báo cáo</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: detaiDAO.getListDeTaiHuongDan(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><a href="">Chi tiết</a></th>
													<th><a href="">Xem báo cáo</a></th>
												</tr>
												<%
			    							}
											%>
											</tbody>
										</table>
                                    </div>
                                </div>
                            </div>
                        </div>
                           <div class="tab-pane" id="dkDeTai">
										<div class="row" style="margin-right:0px;">
											<div class="qldkDeTai" style="background:white;border-radius:3px">
												<h2 class="tieude_theh">ĐĂNG KÝ ĐỀ TÀI</h2>
												<hr>
												<div class="container" style="width:800px">
													<div class="row">
														<div class="mota">
															<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
																<form action=" " onsubmit="" method="POST" role="form" class="form-horizontal">
																	<div class="form-group">
																		<label class="col-sm-2 control-label" for="tendetai">Tên đề tài:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<input type="text" name="mota" class="form-control required mota" placeholder="Đề tài 1"  id="" required minlength="6" data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này,ít nhất 6 ký tự.">
																		</div>
																		<label class="col-sm-2 control-label" for="mota">Mô tả:</label>
																		<div class="col-sm-10">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="tạo 1 website bán hàng"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>
																		<br>
																		<br>
																		<label class="col-sm-2 control-label" for="linhvucnghiencuu">Lĩnh vực:</label>
																		<div class="col-sm-10" id="linhvucnghiencuu">
																			<label class="radio-inline"><input type="radio" value="tunhien" name="linhvucnghiencuu" checked="checked"> Tự nhiên</label>
																			<label class="radio-inline"><input type="radio" value="xhnv" name="linhvucnghiencuu">Xã hội nhân văn</label>
																			<label class="radio-inline"><input type="radio" value="giaoduc" name="linhvucnghiencuu">Giáo dục</label>
																			<label class="radio-inline"><input type="radio" value="kythuat" name="linhvucnghiencuu">Kỹ thuật</label>
																			<label class="radio-inline"><input type="radio" value="nong_ngulam" name="linhvucnghiencuu">Nông-ngư lâm</label>
																			<label class="radio-inline"><input type="radio" value="yduoc" name="linhvucnghiencuu">Y dược</label>
																			<label class="radio-inline"><input type="radio" value="moitruong" name="linhvucnghiencuu">Môi trường</label>
																		</div>
																		<br>
																		<br>
																		<label class="col-sm-2 control-label" for="loaihinhnghiencuu">Loại hình:</label>
																		<div class="col-sm-10" id="loaihinhnghiencuu">
																			<label class="radio-inline"><input type="radio" value="coban" name="loaihinhnghiencuu" checked="checked"> Cơ bản:</label>
																			<label class="radio-inline"><input type="radio" value="ungdung" name="loaihinhnghiencuu">Ứng dụng:</label>
																			<label class="radio-inline"><input type="radio" value="trienkhai" name="loaihinhnghiencuu">Triển khai:</label>
																		</div>
																		<br>
																		<br><br>
																		<div class="container" style="margin-top:35px; margin-left:20px;width:800px">
																			<div class="row">
																				<label class="col-sm-2 control-label" for="thoigianthuchien">Thời gian thực hiện:</label>
																				<div class="col-sm-10" id="thoigianthuchien">
																					<div class="row">
																						<label class="col-sm-1 control-label" for="thoigianbatdau">Từ:</label>
																						<div class="col-sm-4" style="margin-bottom:5px;">
																							<input type="text" type="text" name="ngay" class="form-control required ngay"  id="" required data-placement="right" data-trigger="hover" data-content="Vui lòng nhập theo định dạng mm/dd/yy" placeholder="mm/dd/yy" style="float:left; margin-top:10px;"required>
																						</div>
																						<label class="col-sm-1 control-label" for="thoigianketthuc">Đến:</label>
																						<div class="col-sm-4" style="margin-bottom:5px;">
																							<input type="text" type="text" name="ngay" class="form-control required ngay"  id="" required data-placement="right" data-trigger="hover" data-content="Vui lòng nhập theo định dạng mm/dd/yy" placeholder="mm/dd/yy" style="float:left; margin-left:10px; margin-top:10px;"required>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<label class="col-sm-2 control-label" for="coquanchutri">Cơ quan chủ trì:</label>
																		<div class="col-sm-10">
																			<input class="form-control" id="tendetai" type="text" placeholder="Khoa/Bộ môn trực thuộc">
																		</div>
																		<br>
																		<div class="container" style="margin-top:35px;width:800px">
																			<div class="row">
																				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																					<label style="margin-left:60px">Chủ nhiệm đề tài:</label><br>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																						<div class="col-sm-8">
																							<input type="text" name="name" class="form-control required name" placeholder="Lê Văn A"  id="" required minlength="3" data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này,ít nhất 3 ký tự.">
																						</div>
																					</div>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="mssv1">MS:</label>
																						<div class="col-sm-8">
																							<input type="text" name="mssv" class="form-control required mssv" placeholder="141101"  id="" required minlength="6" data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này,ít nhất 6 ký tự.">
																						</div>
																					</div>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="mail1">Email:</label>
																						<div class="col-sm-8">
																							<input type="text" name="email" class="form-control required email" placeholder="LVA@gmail.com"  id="" required data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này">
																						</div>
																					</div>
																					<br>
																					<label style="margin-left:60px">Người cùng thực hiện:</label><br>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																						<div class="col-sm-8">
																							<input class="form-control" id="hoten1" type="text">
																						</div>
																					</div>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="mssv1">MS:</label>
																						<div class="col-sm-8">
																							<input class="form-control" id="mss1" type="text">
																						</div>
																					</div>
																				</div>
																				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
																					<label style="margin-left:60px">Người hướng dẫn:</label><br>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																						<div class="col-sm-8">
																							<input type="text" name="name" class="form-control required name" placeholder="Lê B"  id="" required minlength="3" data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này,ít nhất 3 ký tự.">
																						</div>
																					</div>
																					<div class="row" style="margin-bottom:5px">
																						<label class="col-sm-4 control-label" for="mssv1">Email:</label>
																						<div class="col-sm-8">
																							<input type="text" name="email" class="form-control required email" placeholder="LVA@gmail.com"  id="" required data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này">
																						</div>
																						<br><br><br><br><br><br>
																						<label style="margin-left:60px">Người cùng thực hiện(2):</label><br>
																						<div class="row" style="margin-bottom:5px">
																							<label class="col-sm-4 control-label" for="hoten1">Họ và tên:</label>
																							<div class="col-sm-8">
																								<input class="form-control" id="hoten1" type="text">
																							</div>
																						</div>
																						<div class="row" style="margin-bottom:5px">
																							<label class="col-sm-4 control-label" for="mssv1">MS:</label>
																							<div class="col-sm-8">
																								<input class="form-control" id="mss1" type="text">
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<label class="control-label" for="">Tình hình nghiên cứu trong và ngoài nước:</label><br>
																		<label class="col-sm-2 control-label" for="mota">Trong nước:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Tình hình nghiên cứu trong nước"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>
																		<label class="col-sm-2 control-label" for="mota">Ngoài nước:</label><br><br>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Tình hình nghiên cứu ngoài nước"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>

																		<label class="col-sm-2 control-label" for="mota">Tính cấp thiết:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Tính cấp thiết"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>

																		<label class="col-sm-2 control-label" for="mota">Mục tiêu:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Mục tiêu của đề tài"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>

																		<label class="col-sm-2 control-label" for="mota">Phương pháp nghiên cứu:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Phương pháp và phạm vi nghiên cứu"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>

																		<label class="col-sm-2 control-label" for="mota">Nội dung nghiên cứu:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Nội dung nghiên cứu và tiến độ thực hiện"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>

																		<label class="col-sm-2 control-label" for="sanphamdukiem">Sản phẩm dự kiến:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<textarea type="text" name="mota" class="form-control required mota" placeholder="Sản phẩm dự kiến"  id="" required  data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này" rows="2" required></textarea>
																		</div>


																		<label class="col-sm-2 control-label" for="diachiungdung">Địa chỉ ứng dụng:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<input class="form-control" id="diachiungdung" type="text" required>
																		</div>

																		<label class="col-sm-2 control-label" for="dxuatkinhphi">Đề xuất kinh phí:</label>
																		<div class="col-sm-10" style="margin-bottom:5px">
																			<input type="text" name="dxuatkinhphi" class="form-control required dxuatkinhphi" placeholder="2000000" minlength="0" maxlength="6" id="" required data-placement="right" data-trigger="hover" data-content="Bạn cần phải nhập vào trường này">
																		</div>

																		<label class="col-sm-2 control-label" for="tendetai">Tải file chi tiết:</label>
																		<div class="col-sm-10" style="margin-bottom:10px">
																			<input class="form-control" id="tendetai" type="file">
																		</div>

																		<div id="guidon" style="">
																			<button type="submit" id="btn_GuiDon" style="color: #fff;background-color: #5bc0de;border-color: #46b8da; height:35px;width:150px;background-image: none;border: 1px solid transparent;border-radius: 4px; margin-right:15px;float:right;">Gửi đơn đăng ký</button>
																			<a class="btn btn-warning" href="quanly_DeTaiDeXuat.jsp" role="button" style="margin-left:10px">Đăng ký đề tài được đề xuất</a>

																		</div>
																	</div>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>                    
                    
                         <div class="tab-pane " id="dsDeTaiDK">
                            <div class="row ">
                                <div class="ql_dsDeTaiDK " style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px ">
                                    <h2 class="tieude_theh">DANH SÁCH ĐỀ TÀI ĐÃ ĐĂNG KÝ</h2><hr>
                                    <div class="ql_tb_dsDeTaiDK ">
                                        <table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Giảng viên hướng dẫn</th>
													<th>Chi tiết</th>
													<th>Trạng thái</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: detaiDAO.getListDeTaiGV_DK(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenGVHD() %></th>
													<th><%=ct.getTenTT() %></th>
													<th><a href="">Chi tiết</a></th>
												</tr>
											<%
			    							}
											%>							
											</tbody>
										</table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane " id="duyetHuy_GianHan">
                            <div class="row ">
                                <div class="ql_duyetHuy_GianHan " style="background:white;height:600px; overflow: auto;margin-right:15px;border-radius:3px ">
                                    <h2 class="tieude_theh">DUYỆT HỦY/GIA HẠN ĐỀ TÀI</h2><hr>
                                    <div class="ql_tb_dsDeTaiDK ">
                                        <table class="table table-striped table-hover">
											<thead class="thead-default">
												<tr class="success">
													<th>Mã đề tài</th>
													<th>Tên đề tài</th>
													<th>Chủ nhiệm đề tài</th>
													<th>Yêu cầu</th>
													<th>Xử lý</th>
												</tr>
											</thead>
											<tbody>
											<%
											for (DeTai ct: detaiDAO.getListDeTai_YC_Huy_GiaHan(session.getAttribute("Email").toString())) {
											%>
												<tr>
													<th><%=ct.getMaDT() %></th>
													<th><%=ct.getTenDT() %></th>
													<th><%=ct.getTenCN() %></th>
													<th><%=ct.getTenTT() %></th>
													<th><a href="">Xử lý</a></th>
												</tr>
												<%
			    							}
											%>	
											</tbody>
										</table>
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
            <pre style="margin-bottom:0px;">
                Copyright@ Phòng nghiên cứu khoa học và quan hệ quốc tế
            </pre>
        </footer>
    </div>
</body>

</html>