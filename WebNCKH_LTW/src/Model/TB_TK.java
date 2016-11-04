package Model;

public class TB_TK {
	private String MaCTTB;
    private String MaTB;
    private String TinTB;
    private String NgayGui;
    
    
	public TB_TK() {
		super();
	}
	public TB_TK(String maCTTB, String maTB, String tinTB, String ngayGui) {
		super();
		MaCTTB = maCTTB;
		MaTB = maTB;
		TinTB = tinTB;
		NgayGui = ngayGui;
	}
	public String getMaCTTB() {
		return MaCTTB;
	}
	public void setMaCTTB(String maCTTB) {
		MaCTTB = maCTTB;
	}
	public String getMaTB() {
		return MaTB;
	}
	public void setMaTB(String maTB) {
		MaTB = maTB;
	}
	public String getTinTB() {
		return TinTB;
	}
	public void setTinTB(String tinTB) {
		TinTB = tinTB;
	}
	public String getNgayGui() {
		return NgayGui;
	}
	public void setNgayGui(String ngayGui) {
		NgayGui = ngayGui;
	}
 
}
