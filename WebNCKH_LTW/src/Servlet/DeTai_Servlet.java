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
import Model.CTNghiemThu;
import Model.DeTai;

/**
 * Servlet implementation class TB_TK_Servlet
 */
@WebServlet("/DeTai_Servlet")
public class DeTai_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller detaictrl = new DeTai_Controller();
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
		
		String url="", error="";
		try{
			switch(command){
				case "pheduyet":
					System.out.println("Vào phê duyệt");
					String xuly = request.getParameter("xuly");
					String MaDT = request.getParameter("MaDT");
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
