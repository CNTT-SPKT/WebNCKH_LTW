package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.HoiDong_Controller;
import javafx.print.Printer;

/**
 * Servlet implementation class HoiDong_Servlet
 */
@WebServlet("/HoiDong_Servlet")
public class HoiDong_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoiDong_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   // Set response content type
		   response.setContentType("text/html;charset=UTF-8"); 
		    request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("dooo gettt");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	     response.setContentType("text/html");
// response.setContentType("text/html");  
		StringBuilder statusMsg = new StringBuilder();
			
	    response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try{
	     

	   
		HttpSession session = request.getSession();
		session.removeAttribute("erro");
		String ChuTich = request.getParameter("ChuTich");
		String PhanBien = request.getParameter("PhanBien");
		String UyVien = request.getParameter("UyVien");
		String MaHD = request.getParameter("MaHD");
		String NgayThanhLap = request.getParameter("bday");
		HoiDong_Controller HoiDongDao = new HoiDong_Controller();
		if(HoiDongDao.kiemTra(MaHD))
		{
			out.print("Trùng mã hd");
//			  statusMsg.append("Trùng mã hội đồng!");
//			  request.setAttribute("statusMsg", statusMsg.toString());
			//  response.sendRedirect("/WebNCKH_LTW/quanlyPage_LTHDNT.jsp");
//			session.setAttribute("erro", "Đã tồn tại mã hội đồng");
//			response.sendRedirect("quanlyPage_LTHDNT.jsp");
			//out.print("trùng mã hd");
		}
		else{
			
			HoiDongDao.insert(MaHD, PhanBien, ChuTich, UyVien, NgayThanhLap);
//			 statusMsg.append("THÀNH CÔNG!");
//			  request.setAttribute("statusMsg", statusMsg.toString());
			//  response.sendRedirect("/WebNCKH_LTW/quanlyPage_LTHDNT.jsp");
			out.print("Thêm thành công");
//			session.setAttribute("scs", "thêm thành công");
//			String adding =  (String) session.getAttribute("adding");
//			if(adding != null)
//			{
//				resp.sendRedirect("addDishToRts.html");
//			}
//			else
//			{
//				resp.sendRedirect("add-new-dish.html");
//			}
			
		}
	}
		catch (Exception e ) {
		
			out.println("Lỗi rồi!:" );
//			out.println("Chủ tịch: "+ChuTich);
//			out.println("pb: "+PhanBien);
//			out.println("uv:"+UyVien);
//			out.println("mahd:" +MaHD);
//			out.println("ngaythanhlap:" +NgayThanhLap);
		
		}
		}

}
