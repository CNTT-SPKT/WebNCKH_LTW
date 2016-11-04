package Model;

public class DonHuy {
	private String MaDonXin;
    private String MaDT;
    private String LyDo;
    
	public DonHuy() {
		super();
	}

	public DonHuy(String maDonXin, String maDT, String lyDo) {
		super();
		MaDonXin = maDonXin;
		MaDT = maDT;
		LyDo = lyDo;
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
	
    
}
