package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CTNghiemThu_Controller;
import Controller.TB_TK_Controller;
import Model.CTNghiemThu;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/DeTai_Servlet")
public class DeTai_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
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
		
		String command = request.getParameter("command");
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
		
		String url="", error="";
		System.out.println(maDT+"______"+command+"____________"+ctnt.getMaHD());
		try{
			switch(command){
				case "update":
//					System.out.println("Vào update");
//					if(crt.deleteTB_TK(maDT))
//						error="Thành công";
//					else
//						error="Thất bại";
//					url="sinhvienPage.jsp";
					break;
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		System.out.println(url);
		request.setAttribute("error", error);
		response.sendRedirect("sinhvienPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
