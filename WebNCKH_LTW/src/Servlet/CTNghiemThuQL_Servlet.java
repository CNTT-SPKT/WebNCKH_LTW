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
import Controller.ThongBao_Controller;
import Model.CTNghiemThu;
import Model.DeTai;

/**
 * Servlet implementation class CTNghiemThuQL_Servlet
 */
@WebServlet("/CTNghiemThuQL_Servlet")
public class CTNghiemThuQL_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CTNghiemThu_Controller crt= new CTNghiemThu_Controller();
	DeTai_Controller ctrl = new DeTai_Controller();
	TB_TK_Controller tb_tkctrl = new TB_TK_Controller();
	ThongBao_Controller thongbaoctrl = new ThongBao_Controller();	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTNghiemThuQL_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command1");
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
		
		DeTai dt=new DeTai();
		dt=ctrl.getDeTai(maDT);
		dt.setMaTT("tt9");
		
		String url="", error="", type="";
		try{
			switch(command){			
				case "updateql":
					System.out.println("VÃ o update QL");
					
					if(crt.updateCTNT(ctnt) && ctrl.updateTrangThai_DeTai(dt))
					{			
							type ="ntdt_1";
							url="quanlyPage.jsp?&type="+type;
					}
					else
					{
						error="Nghiá»‡m thu tháº¥t báº¡i";
						type ="ntdt_0";
							url="quanlyPage.jsp?type="+type;			
					}
					break;
			}
			
		}catch(Exception e){
			error="Xáº£y ra lá»—i ngáº«u nhiÃªn!";
		}
		System.out.println(url);
		request.setAttribute("error", error);
		request.setAttribute("type", type);
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
