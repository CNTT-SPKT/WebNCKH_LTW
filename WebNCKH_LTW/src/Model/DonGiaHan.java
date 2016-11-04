package Model;

public class DonGiaHan {
	private String MaDonXin;
    private String MaDT;
    private String LyDo;
    private String GHDen;
    
	public DonGiaHan() {
		super();
	}

	public DonGiaHan(String maDonXin, String maDT, String lyDo, String gHDen) {
		super();
		MaDonXin = maDonXin;
		MaDT = maDT;
		LyDo = lyDo;
		GHDen = gHDen;
	}

	public String getMaDonXin() {
		return MaDonXin;
	}

	public void setMaDonXin(String maDonXin) {
		MaDonXin = maDonXin;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getLyDo() {
		return LyDo;
	}

	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}

	public String getGHDen() {
		return GHDen;
	}

	public void setGHDen(String gHDen) {
		GHDen = gHDen;
	}
    
    
}
