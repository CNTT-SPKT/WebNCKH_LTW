package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TaiKhoan_Controller;
import Model.TaiKhoan;

/**
 * Servlet implementation class TaiKhoan_Servlet
 */
@WebServlet("/TaiKhoan_Servlet")
public class TaiKhoan_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    TaiKhoan_Controller crt = new   TaiKhoan_Controller(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiKhoan_Servlet() {
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
			case "insert":
				url="";
				break;
			case "update":
				System.out.println("Vào update TT");
				String quyen = request.getParameter("Quyen");
				TaiKhoan tk=new TaiKhoan();
				String maTK = request.getParameter("MaTK");
				tk=crt.getTaiKhoanByMaTK(maTK);
				tk.setEmail(request.getParameter("email"));
				tk.setNganh(request.getParameter("nganh"));
				tk.setCNNH(request.getParameter("cnnganhang"));
				tk.setMSNH(request.getParameter("masoNH"));
				System.out.println(tk.getMaTK()+"______"+tk.getEmail()+"_________"+tk.getNganh()+"________"+tk.getCNNH()+"_____"+tk.getMSNH());
				boolean ktra=crt.updateTaiKhoan(tk);
				if(ktra)
				{

					error="Thành công";
					if(quyen.equals("Admin"))
						url="Admin.jsp";
					if(quyen.equals("Student"))
						url="sinhvienPage.jsp";
				}
				else
				{
					error="Thất bại";
					if(quyen.equals("Admin"))
						url="Admin.jsp";
					if(quyen.equals("Student"))
						url="sinhvienPage.jsp";
					
				}
				break;
			case "doimk":
				System.out.println("Vào đổi mk");
				TaiKhoan tk1= new TaiKhoan();
				tk1 = crt.gettk(request.getParameter("MaTK"));
				tk1.setMatKhau(request.getParameter("matkhau"));
				if(crt.updateTKDoiMK(tk1))
					error="Thành công";
				else
					error="Thất bại";
				url="sinhvienPage.jsp";
				System.out.println(error+"__________"+url);
				break;
			}
		}
		catch(Exception e)
		{
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
