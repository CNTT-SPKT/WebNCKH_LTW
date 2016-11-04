package Model;

import java.util.ArrayList;

public class ThongBao {
	private String MaTB;
    private String NguoiGui;
    private String NguoiNhan;
   
    private ArrayList<TB_TK> CTTB = new ArrayList<TB_TK>();
    
	public ThongBao() {
		super();
	}
	public ThongBao(String maTB, String nguoiGui, String nguoiNhan) {
		super();
		MaTB = maTB;
		NguoiGui = nguoiGui;
		NguoiNhan = nguoiNhan;
	}
	
	public ArrayList<TB_TK> getCTTB() {
		return CTTB;
	}
	public void setCTTB(ArrayList<TB_TK> cTTB) {
		CTTB = cTTB;
	}
	public String getMaTB() {
		return MaTB;
	}
	public void setMaTB(String maTB) {
		MaTB = maTB;
	}
	public String getNguoiGui() {
		return NguoiGui;
	}
	public void setNguoiGui(String nguoiGui) {
		NguoiGui = nguoiGui;
	}
	public String getNguoiNhan() {
		return NguoiNhan;
	}
	public void setNguoiNhan(String nguoiNhan) {
		NguoiNhan = nguoiNhan;
	}
	
   
    
}
