package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.DeTai_Controller;
import Model.DeTai;

/**
 * Servlet implementation class GiaHanDT_Servlet
 */
@WebServlet("/GiaHanDT_Servlet")
public class GiaHanDT_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeTai_Controller detaictrl = new DeTai_Controller();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiaHanDT_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("adsds");
		String command = request.getParameter("command");
		String xuly = request.getParameter("xuly");
		String maDT = request.getParameter("MaDT");
		DeTai dt = detaictrl.getDeTai(maDT);
		String url="", error="";
		try{
			switch(command){
				case "update":
					if(xuly.equals("guidongiahan"))
					{
						dt.setMaTT("tt6");
						System.out.println("adsds");
					}
					if(xuly.equals("xulydongh"))
					{
						dt.setMaTT("tt7");
						System.out.println("adsds");
					}
					if(detaictrl.updateTrangThai_DeTai(dt))
						error="Thành công";
					break;
			}
			
		}catch(Exception e){
			error="Xảy ra lỗi ngẫu nhiên!";
		}
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
