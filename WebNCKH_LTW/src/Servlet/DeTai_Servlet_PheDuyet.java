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
		System.out.println("Vào đề tài servlet thành công!");
		String MaDT="";
		String capMHT="";
		String error="";
		String url="";
			try{
				System.out.println("Vào phê duyệt");
				MaDT = request.getParameter("laymaDT");
				capMHT=request.getParameter("CapMHT");
				DeTai dtql = detaictrl.getDeTai(MaDT);
				System.out.println("Ma de tai: "+MaDT);
					dtql.setMaTT("tt2");
					dtql.setMaHienThi(capMHT);
				
				
				if(detaictrl.updateTrangThai_DeTai_QL(dtql))
				{
					System.out.println("Update thành công");
					//System.out.println("MaHienThi: "+capMHT);
				}
				
				else
				{
//					error="Thất bại";
//					if(quyen1.equals("Lecturers"))
//						url="giangvienPage.jsp";
//					if(quyen1.equals("Manager"))
//						url="quanlyPage.jsp";
					System.out.println("thêm thất bại");
				
				}
			
			}
		catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
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
