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
import Controller.TaiKhoan_Controller;
import Controller.ThongBao_Controller;
import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;

/**
 * Servlet implementation class DeTai_Servlet_PheDuyet
 */
@WebServlet("/DeTai_Servlet_PheDuyet")
public class DeTai_Servlet_PheDuyet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
	TaiKhoan_Controller taikhoanctrl = new TaiKhoan_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTai_Servlet_PheDuyet() {
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
		System.out.println("Vào servlet");
		String MaDT="";
		String capMHT="";
		String error="";
		String type="";
		String url="";
			try{
				String Submit=request.getParameter("Submit");
				System.out.print("Submit:  "+Submit);
				MaDT = request.getParameter("laymaDT");
				String cndetaiql=request.getParameter("cndetaiql");
				String matkdn=request.getParameter("matkdn");
				String matkgv=request.getParameter("matkgv");
				
				DeTai dtql = new DeTai();
						dtql=detaictrl.getDeTai(MaDT);
				if(Submit.equals("dongy"))
				{
					capMHT=request.getParameter("CapMHT");
					System.out.println("cndetaiql:"+cndetaiql);
					System.out.println("maDT: "+MaDT);
					System.out.println("ma chu nhien: "+dtql.getMaCN());
						if(cndetaiql.equals("") || cndetaiql.equals(null)||cndetaiql.equals("null"))
						{
							dtql.setMaDT(MaDT);
							dtql.setMaTT("tt11");
							dtql.setMaHienThi(capMHT);
						}
						else
						{
							if(matkdn.equals(matkgv))
							{
								dtql.setMaDT(MaDT);
								dtql.setMaTT("tt3");
								dtql.setMaHienThi(capMHT);
							}
							else
							{
							dtql.setMaDT(MaDT);
							dtql.setMaTT("tt2");
							dtql.setMaHienThi(capMHT);
							}
						}
						if(detaictrl.updateTrangThai_DeTai_QL(dtql))
						{
							type="pddt_1";
							System.out.println("Update thÃ nh cÃ´ng");
							String nguoigui = request.getParameter("nguoigui");
							String nguoinhan=request.getParameter("nguoinhan");
							TB_TK tbtk = new TB_TK();
							ThongBao tb = thongbaoctrl.getThongBao(nguoigui,nguoinhan);
							System.out.println("Nguoi gui:" +nguoigui);
							System.out.println("Nguoi nhan:" +nguoinhan);
							if(thongbaoctrl.getThongBao(nguoigui,nguoinhan).getMaTB()==null)
						    {
								System.out.println("chua co hop thoai");
						    	int n =thongbaoctrl.getListThongBao().size();
							    tb.setMaTB("tb"+(n+1));
							    tb.setNguoiGui(nguoigui);	
							    tb.setNguoiNhan(nguoinhan);
							    if(thongbaoctrl.createThongBao(tb))
							    	System.out.println("Tạo hộp thoại thành công");
						    }
							tbtk.setMaCTTB("cttb"+Integer.toString(tb_tkctrl.getListTB_TK().size()+5));
							tbtk.setMaLTB("ltt1");
							tbtk.setMaTB(tb.getMaTB());
								
							System.out.println(nguoigui+"_______"+tb.getMaTB()+"______"+nguoinhan);
							tbtk.setTinTB("Thông báo quản lý đã duyệt đề tài "+MaDT+"");
							
							if(tb_tkctrl.insertTB_TK(tbtk))
								System.out.println(tbtk.getTinTB());
							System.out.println("Gửi thông báo thành công!");
							url="quanlyPage.jsp?type="+type;	
						}
			
						else
						{
							type="pddt_0";
							System.out.println("Update thatbai");
							url="quanlyPage.jsp?type="+type;	
						}
				}
				if(Submit.equals("khongdongy"))
						{
					System.out.println("vào kiem tra khong dong y");
							dtql.setMaDT(MaDT);
							dtql.setMaTT("tt5");
							if(detaictrl.updateTrangThai_DeTai(dtql))
							{
								type="kpd_1";
								System.out.println("Update thành công");
								url="quanlyPage.jsp?type="+type;	
							}
							
							else
							{
								type="kpd_0";
								System.out.println("Update thatbai");
								url="quanlyPage.jsp?type="+type;	
							}
						}
			
			}
		catch(Exception e){
			error="Xáº£y ra lá»—i ngáº«u nhiÃªn!";
		}
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
