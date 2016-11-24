package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CTNghiemThu_Controller;
import Controller.HoiDong_Controller;

/**
 * Servlet implementation class XoaHoiDong_Servlet
 */
@WebServlet("/XoaHoiDong_Servlet")
public class XoaHoiDong_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaHoiDong_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HoiDong_Controller crt= new HoiDong_Controller();
		CTNghiemThu_Controller ctctrl= new CTNghiemThu_Controller();
		String command = request.getParameter("command");
		String maHD= request.getParameter("MaHD");
		
		String url="", error="";
		
		try{
			switch(command){
				case "delete":
					System.out.println("Vào delete");
					boolean f=ctctrl.deleteCTNT(maHD);
					boolean g=crt.deleteHoiDong(maHD);
					if(f&g)
						error="Thành công";
					else
						error="Thất bại";
					url="quanlyPage.jsp";
					System.out.println(error+"__________"+url);
					break;
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		request.setAttribute("error", error);
		response.sendRedirect("quanlyPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
