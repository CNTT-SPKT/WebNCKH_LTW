﻿package Servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import Controller.CTNghiemThu_Controller;
import Controller.DeTai_Controller;
import Controller.TB_TK_Controller;
import Controller.TaiKhoan_Controller;
import Controller.ThongBao_Controller;
import Model.CTNghiemThu;
import Model.DeTai;
import Model.TB_TK;
import Model.TaiKhoan;
import Model.ThongBao;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/DeTai_Servlet")
public class DeTai_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTai_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Vào đề tài servlet thành công!");
		String MaDT="";
		String xuly="";
		String command = request.getParameter("command");
		
		
		String url="", error="";
		try{
			switch(command){
				case "GV_pheduyetDT":
					System.out.println("Vào phê duyệt");
					xuly = request.getParameter("xuly");
					MaDT = request.getParameter("MaDT");
					DeTai dt = detaictrl.getDeTai(MaDT);
					
					if(xuly.equals("dongy"))
						dt.setMaTT("tt3");
					if(xuly.equals("khongdongy"))
						dt.setMaTT("tt12");
 					
					if(detaictrl.updateTrangThai_DeTai(dt))
						error="Thành công";
					else
						error="Thất bại";
					System.out.println(error);
					url="giangvienPage.jsp";
					break;
				case "dkDT":
					System.out.println("Vào đăng ký đề tài");
					DeTai dkDT=new DeTai();
					int sodt=detaictrl.getListDeTai().size()+1;
					MaDT="dt"+Integer.toString(sodt);
					dkDT.setMaDT(MaDT);
					dkDT.setMaHienThi(null);
					dkDT.setMaTT("tt1");
					
					TaiKhoan tk=new TaiKhoan();
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenCN"));
					dkDT.setMaCN(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV1"));
					dkDT.setSinhVien1(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenSV2"));
					dkDT.setSinhVien2(tk.getMaTK());
					tk = taikhoanctrl.getTaiKhoanByTen(request.getParameter("tenGVHD"));
					dkDT.setGVHD(tk.getMaTK());
					dkDT.setTenDT(request.getParameter("tenDT"));
					dkDT.setMoTa(request.getParameter("mota"));
					dkDT.setLinhVuc("Tự nhiên");
					dkDT.setLoaiHinh("Cơ bản");
					dkDT.setNgayThucHien(request.getParameter("ngaybatdau"));
					dkDT.setNgayKetThuc(request.getParameter("ngayketthuc"));
					dkDT.setCoQuanChuTri(request.getParameter("coquanchutri"));
					dkDT.setTinhHinhTrong(request.getParameter("tinhhinhTrong"));
					dkDT.setTinhHinhNgoai(request.getParameter("tinhhinhNgoai"));
					dkDT.setTinhCapThiet(request.getParameter("tinhcapThiet"));
					dkDT.setMucTieu(request.getParameter("muctieu"));
					dkDT.setPPNC(request.getParameter("PPNC"));
					dkDT.setNoiDungNC(request.getParameter("NoiDungNC"));
					dkDT.setSPDuKien(request.getParameter("SPDuKien"));
					dkDT.setDiaChiUD(request.getParameter("DiaChiUD"));
					dkDT.setKinhPhi(Double.parseDouble(request.getParameter("kinhphi")));
					
					if(detaictrl.insert_DeTaiSVDK(dkDT))
					{
						error="Thành công!";
						System.out.println("Đăng ký đề tài thành công!");
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Student"))
						{
							url="sinhvienPage.jsp";
							// đăng ký thành công thì gởi thông báo có đề tài mới cho quản lý
							TB_TK tbtk = new TB_TK();
							ThongBao tb = thongbaoctrl.getListThongBao(dkDT.getMaCN());
							tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
							tbtk.setMaLTB("ltt2");
							tbtk.setTinTB("Thông báo đăng ký đề tài mới từ tài khoản "+dkDT.getMaCN());
							tbtk.setMaTB(tb.getMaTB());
							if(tb_tkctrl.insertTB_TK(tbtk))
							System.out.println("Gửi thông báo thành công!");
						}	
						if(nguoidk.equals("Lecturers"))
							url="giangvienPage.jsp";
						if(nguoidk.equals("Manager"))
							url="quanlyPage.jsp";
						
					}
					else{
						error="Thất bại!";
						String nguoidk = request.getParameter("nguoidk");
						if(nguoidk.equals("Student"))
							url="sinhvienPage.jsp";
						if(nguoidk.equals("Lecturers"))
							url="giangvienPage.jsp";
						else
							url="quanlyPage.jsp";
					}
					
					break;
				case "GV_pheduyeHuy_GiaHan":
					String yeucau = request.getParameter("yeucau");
					xuly = request.getParameter("xuly");
					MaDT = request.getParameter("MaDT");
					String MaGV = request.getParameter("MaGV");
					DeTai dt2 = detaictrl.getDeTai(MaDT);
					TB_TK tbtk = new TB_TK();
					ThongBao tb = thongbaoctrl.getThongBao(MaGV,dt2.getMaCN());
					if(thongbaoctrl.getThongBao(MaGV,dt2.getMaCN()).getMaTB()==null)
				    {
						System.out.println("chua co hop thoai");
				    	int n =thongbaoctrl.getListThongBao().size();
					    tb.setMaTB("tb"+(n+1));
					    tb.setNguoiGui(MaGV);
					    tb.setNguoiNhan(dt2.getMaCN());
					    if(thongbaoctrl.createThongBao(tb))
					    	System.out.println("Tạo hộp thoại thành công");
				    }
					tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
					tbtk.setMaLTB("ltt1");
					tbtk.setMaTB(tb.getMaTB());
					System.out.println(MaGV+"_______"+tb.getMaTB()+"______"+dt2.getMaCN());
					if(xuly.equals("khongdongy"))
					{
						dt2.setMaTT("tt3"); System.out.println("Yêu cầu không được đồng ý, đề tài vẫn được tiến hành");
						if(yeucau.equals("tt6"))
							tbtk.setTinTB("Thông báo: yêu cầu gia hạn đề tài "+MaDT+" không được đồng ý");
						else if(yeucau.equals("tt4"))
							tbtk.setTinTB("Thông báo: yêu cầu hủy đề tài "+MaDT+" không được đồng ý");
					}
					else if(xuly.equals("dongy"))
					{
						if(yeucau.equals("tt6"))
						{
							dt2.setMaTT("tt7"); System.out.println("Gia hạn đề tài thành công");
							tbtk.setTinTB("Thông báo: gia hạn đề tài "+MaDT+" thành công");
						}
						else if(yeucau.equals("tt4"))
						{
							dt2.setMaTT("tt5"); System.out.println("Hủy đề tài thành công");
							tbtk.setTinTB("Thông báo: hủy đề tài "+MaDT+" thành công");
						}
					}
					if(tb_tkctrl.insertTB_TK(tbtk))
						System.out.println(tbtk.getTinTB());
					if(detaictrl.updateTrangThai_DeTai(dt2))
						error="Thành công";
					else
						error="Thất bại";
					System.out.println(error);
					url="giangvienPage.jsp";
					
					break;
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		System.out.println(url);
		request.setAttribute("error", error);
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}