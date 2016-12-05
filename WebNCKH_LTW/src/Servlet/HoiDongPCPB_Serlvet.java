package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DeTai_Controller;
import Controller.HoiDong_Controller;
import Model.DeTai;

/**
 * Servlet implementation class HoiDongPCPB_Serlvet
 */
@WebServlet("/HoiDongPCPB_Servlet")
public class HoiDongPCPB_Serlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoiDongPCPB_Serlvet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("vao servlet");
		DeTai_Controller crt= new DeTai_Controller();
		HoiDong_Controller hd=new HoiDong_Controller();
		DeTai dt= new DeTai();
	    response.setContentType("text/html;charset=UTF-8"); 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String error="";
		String type="";
		String url="";
		try{
		String chonmdt = request.getParameter("chonmdt");
		String HoiDongPCPB = request.getParameter("HoiDongPCPB");
		if(crt.kiemTraPCPB(chonmdt))
		{
			type="pcpb_t";
			url="quanlyPage.jsp?type="+type;	
		}
		else{		
			dt.setMaDT(chonmdt);
			dt.setMaTT("tt8");
			hd.insert_PCPB(HoiDongPCPB, chonmdt);
			crt.updateTrangThai_DeTai(dt);
			type="pcpb_1";
			url="quanlyPage.jsp?type="+type;	
			}
		}
		catch (Exception e ) {
			type="pcpb_0";
			url="quanlyPage.jsp?type="+type;	
		}
		request.setAttribute("error", error);
		response.sendRedirect(url);
}}
