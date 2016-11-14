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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		String quyen = request.getParameter("Quyen");
		TaiKhoan tk=new TaiKhoan();
		try {
			tk = crt.gettk(request.getParameter("MaTK"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tk.setEmail(request.getParameter("email"));
		tk.setSoDT(request.getParameter("sodt"));
		tk.setCNNH(request.getParameter("cnnganhang"));
		tk.setMSNH(request.getParameter("masoNH"));
		
		String url="", error="";
		
		try{
			switch(command){
			case "insert":
				url="";
				break;
			case "update":
				boolean ktra=crt.updateTaiKhoan(tk);
				if(ktra)
				{
					if(quyen=="Admin")
						url="Admin.jsp";
					else if(quyen=="Student")
						url="SinhVienPage.jsp";
					error="Cập nhật thành công!";
				}
				else
				{
					if(quyen=="Admin")
						url="Admin.jsp";
					else if(quyen=="Student")
						url="SinhVienPage.jsp";
					error="Cập nhật thất bại!";
				}
				break;
			}
		}
		catch(Exception e)
		{
			error="Xảy ra lỗi ngẫu nhiên!";
		}
		request.setAttribute("error", error);
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//		rd.forward(request, response);
		response.sendRedirect("Admin_XemCTTK.jsp");
		
	}

}
