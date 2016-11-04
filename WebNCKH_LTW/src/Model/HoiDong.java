package Model;

import java.util.ArrayList;

public class HoiDong {
	private String MaHD;
    private String PhanBien;
    private String TenChuTich;
    
    private ArrayList<CTNghiemThu> dsCTNghiemThu= new ArrayList<CTNghiemThu>();
    
	public HoiDong() {
		super();
	}
	

	public ArrayList<CTNghiemThu> getDsCTNghiemThu() {
		return dsCTNghiemThu;
	}


	public void setDsCTNghiemThu(ArrayList<CTNghiemThu> dsCTNghiemThu) {
		this.dsCTNghiemThu = dsCTNghiemThu;
	}


	public HoiDong(String maHD, String phanBien, String tenChuTich) {
		super();
		MaHD = maHD;
		PhanBien = phanBien;
		TenChuTich = tenChuTich;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public String getPhanBien() {
		return PhanBien;
	}

	public void setPhanBien(String phanBien) {
		PhanBien = phanBien;
	}

	public String getTenChuTich() {
		return TenChuTich;
	}

	public void setTenChuTich(String tenChuTich) {
		TenChuTich = tenChuTich;
	}
    

}
