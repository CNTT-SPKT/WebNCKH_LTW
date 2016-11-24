package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CTNghiemThu_Controller;
import Controller.DeTai_Controller;
import Controller.TB_TK_Controller;
import Controller.ThongBao_Controller;
import Model.CTNghiemThu;
import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/CTNghiemThu_Servlet")
public class CTNghiemThu_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller ctrl = new DeTai_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTNghiemThu_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command = request.getParameter("command");
		String quyen = request.getParameter("Quyen");
		String maDT= request.getParameter("MaDT");
		CTNghiemThu ctnt=new CTNghiemThu();
		ctnt = crt.getListCTNghiemThu(maDT);
		ctnt.setTongQuan(Integer.parseInt(request.getParameter("diemtongquan")));
		ctnt.setMucTieu(Integer.parseInt(request.getParameter("diemmuctieu")));
		ctnt.setPhuongPhap(Integer.parseInt(request.getParameter("diemphuongphap")));
		ctnt.setNoiDung(Integer.parseInt(request.getParameter("diemnoidung")));
		ctnt.setDongGop(Integer.parseInt(request.getParameter("diemdonggop")));
		ctnt.setHinhThuc(Integer.parseInt(request.getParameter("diemhinhthuc")));
		ctnt.setDiemThuong(Integer.parseInt(request.getParameter("diemthuong")));
		ctnt.setTongDiem(Integer.parseInt(request.getParameter("tongdiem")));
		ctnt.setYKien(request.getParameter("ykien"));
		
		DeTai dt=new DeTai();
		dt=ctrl.getDeTai(maDT);
		dt.setMaTT("tt9");
		
		String url="", error="";
		try{
			switch(command){
				case "update":
					System.out.println("Vào update");
					
					if(crt.updateCTNT(ctnt) && ctrl.updateTrangThai_DeTai(dt))
					{
						error="Thành công";
						// Đánh giá thành công thì gửi thông báo về cho sinh viên
						String nguoigui = request.getParameter("nguoigui");
						TB_TK tbtk = new TB_TK();
						ThongBao tb = thongbaoctrl.getThongBao(nguoigui,dt.getMaCN());
						
						if(thongbaoctrl.getThongBao(nguoigui,dt.getMaCN()).getMaTB()==null)
					    {
							System.out.println("chua co hop thoai");
					    	int n =thongbaoctrl.getListThongBao().size();
						    tb.setMaTB("tb"+(n+1));
						    tb.setNguoiGui(nguoigui);
						    tb.setNguoiNhan(dt.getMaCN());
						    if(thongbaoctrl.createThongBao(tb))
						    	System.out.println("Tạo hộp thoại thành công");
					    }
						
						tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
						tbtk.setMaLTB("ltt1");
						tbtk.setMaTB(tb.getMaTB());
						
						System.out.println(nguoigui+"_______"+tb.getMaTB()+"______"+dt.getMaCN());
						tbtk.setTinTB("Thông báo đề tài "+maDT+" đã có kết quả nghiệm thu");
						
						if(tb_tkctrl.insertTB_TK(tbtk))
							System.out.println(tbtk.getTinTB());
						System.out.println("Gửi thông báo thành công!");
						
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp";
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp";
						
					}
					
					else
					{
						error="Thất bại";
						if(quyen.equals("Lecturers"))
							url="giangvienPage.jsp";
						if(quyen.equals("Manager"))
							url="quanlyPage.jsp";
					
					}
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
