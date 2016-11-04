package Model;

public class CTNghiemThu {
	private String MaDT;
    private String MaHD;
    private int TongQuan;
    private int MucTieu;
    private int PhuongPhap;
    private int NoiDung;
    private int DongGop;
    private int HinhThuc;
    private int DiemThuong;
    private int TongDiem;
    private String YKien;
    private String NgayNT;
    
	public CTNghiemThu() {
		super();
	}

	public CTNghiemThu(String maDT, String maHD, int tongQuan, int mucTieu, int phuongPhap, int noiDung, int dongGop,
			int hinhThuc, int diemThuong, int tongDiem, String yKien, String ngayNT) {
		super();
		MaDT = maDT;
		MaHD = maHD;
		TongQuan = tongQuan;
		MucTieu = mucTieu;
		PhuongPhap = phuongPhap;
		NoiDung = noiDung;
		DongGop = dongGop;
		HinhThuc = hinhThuc;
		DiemThuong = diemThuong;
		TongDiem = tongDiem;
		YKien = yKien;
		NgayNT = ngayNT;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public int getTongQuan() {
		return TongQuan;
	}

	public void setTongQuan(int tongQuan) {
		TongQuan = tongQuan;
	}

	public int getMucTieu() {
		return MucTieu;
	}

	public void setMucTieu(int mucTieu) {
		MucTieu = mucTieu;
	}

	public int getPhuongPhap() {
		return PhuongPhap;
	}

	public void setPhuongPhap(int phuongPhap) {
		PhuongPhap = phuongPhap;
	}

	public int getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(int noiDung) {
		NoiDung = noiDung;
	}

	public int getDongGop() {
		return DongGop;
	}

	public void setDongGop(int dongGop) {
		DongGop = dongGop;
	}

	public int getHinhThuc() {
		return HinhThuc;
	}

	public void setHinhThuc(int hinhThuc) {
		HinhThuc = hinhThuc;
	}

	public int getDiemThuong() {
		return DiemThuong;
	}

	public void setDiemThuong(int diemThuong) {
		DiemThuong = diemThuong;
	}

	public int getTongDiem() {
		return TongDiem;
	}

	public void setTongDiem(int tongDiem) {
		TongDiem = tongDiem;
	}

	public String getYKien() {
		return YKien;
	}

	public void setYKien(String yKien) {
		YKien = yKien;
	}

	public String getNgayNT() {
		return NgayNT;
	}

	public void setNgayNT(String ngayNT) {
		NgayNT = ngayNT;
	}
    
}
