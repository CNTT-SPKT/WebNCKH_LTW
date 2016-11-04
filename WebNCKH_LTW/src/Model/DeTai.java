package Model;

import java.util.ArrayList;

public class DeTai {
	private String MaDT;
    private String MaHienThi;
    private String MaTT;
    private String MaCN;
    private String SinhVien1;
    private String SinhVien2;
    private String GVHD;
    private String TenDT;
    private String MoTa;
    private String LinhVuc;
    private String LoaiHinh;
    private String NgayThucHien;
    private String NgayKetThuc;
    private String CoQuanChuTri;
    private String TinhHinhTrong;
    private String TinhHinhNgoai;
    private String TinhCapThiet;
    private String MucTieu;
    private String PPNC;
    private String NoiDungNC;
    private String SPDuKien;
    private String DiaChiUD;
    private double KinhPhi;
    
    private ArrayList<DonHuy> dsDonHuy= new ArrayList<DonHuy>();
    private ArrayList<DonGiaHan> dsDonGiaHan= new ArrayList<DonGiaHan>();
    
	public DeTai() {
		super();
	}

	public DeTai(String maDT, String maHienThi, String maTT, String maCN, String sinhVien1, String sinhVien2,
			String gVHD, String tenDT, String moTa, String linhVuc, String loaiHinh, String ngayThucHien,
			String ngayKetThuc, String coQuanChuTri, String tinhHinhTrong, String tinhHinhNgoai, String tinhCapThiet,
			String mucTieu, String pPNC, String noiDungNC, String sPDuKien, String diaChiUD, double kinhPhi) {
		super();
		MaDT = maDT;
		MaHienThi = maHienThi;
		MaTT = maTT;
		MaCN = maCN;
		SinhVien1 = sinhVien1;
		SinhVien2 = sinhVien2;
		GVHD = gVHD;
		TenDT = tenDT;
		MoTa = moTa;
		LinhVuc = linhVuc;
		LoaiHinh = loaiHinh;
		NgayThucHien = ngayThucHien;
		NgayKetThuc = ngayKetThuc;
		CoQuanChuTri = coQuanChuTri;
		TinhHinhTrong = tinhHinhTrong;
		TinhHinhNgoai = tinhHinhNgoai;
		TinhCapThiet = tinhCapThiet;
		MucTieu = mucTieu;
		PPNC = pPNC;
		NoiDungNC = noiDungNC;
		SPDuKien = sPDuKien;
		DiaChiUD = diaChiUD;
		KinhPhi = kinhPhi;
	}

	public String getMaDT() {
		return MaDT;
	}
	
	
	public ArrayList<DonHuy> getDsDonHuy() {
		return dsDonHuy;
	}

	public void setDsDonHuy(ArrayList<DonHuy> dsDonHuy) {
		this.dsDonHuy = dsDonHuy;
	}

	public ArrayList<DonGiaHan> getDsDonGiaHan() {
		return dsDonGiaHan;
	}

	public void setDsDonGiaHan(ArrayList<DonGiaHan> dsDonGiaHan) {
		this.dsDonGiaHan = dsDonGiaHan;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getMaHienThi() {
		return MaHienThi;
	}

	public void setMaHienThi(String maHienThi) {
		MaHienThi = maHienThi;
	}

	public String getMaTT() {
		return MaTT;
	}

	public void setMaTT(String maTT) {
		MaTT = maTT;
	}

	public String getMaCN() {
		return MaCN;
	}

	public void setMaCN(String maCN) {
		MaCN = maCN;
	}

	public String getSinhVien1() {
		return SinhVien1;
	}

	public void setSinhVien1(String sinhVien1) {
		SinhVien1 = sinhVien1;
	}

	public String getSinhVien2() {
		return SinhVien2;
	}

	public void setSinhVien2(String sinhVien2) {
		SinhVien2 = sinhVien2;
	}

	public String getGVHD() {
		return GVHD;
	}

	public void setGVHD(String gVHD) {
		GVHD = gVHD;
	}

	public String getTenDT() {
		return TenDT;
	}

	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public String getLinhVuc() {
		return LinhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		LinhVuc = linhVuc;
	}

	public String getLoaiHinh() {
		return LoaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		LoaiHinh = loaiHinh;
	}

	public String getNgayThucHien() {
		return NgayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		NgayThucHien = ngayThucHien;
	}

	public String getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public String getCoQuanChuTri() {
		return CoQuanChuTri;
	}

	public void setCoQuanChuTri(String coQuanChuTri) {
		CoQuanChuTri = coQuanChuTri;
	}

	public String getTinhHinhTrong() {
		return TinhHinhTrong;
	}

	public void setTinhHinhTrong(String tinhHinhTrong) {
		TinhHinhTrong = tinhHinhTrong;
	}

	public String getTinhHinhNgoai() {
		return TinhHinhNgoai;
	}

	public void setTinhHinhNgoai(String tinhHinhNgoai) {
		TinhHinhNgoai = tinhHinhNgoai;
	}

	public String getTinhCapThiet() {
		return TinhCapThiet;
	}

	public void setTinhCapThiet(String tinhCapThiet) {
		TinhCapThiet = tinhCapThiet;
	}

	public String getMucTieu() {
		return MucTieu;
	}

	public void setMucTieu(String mucTieu) {
		MucTieu = mucTieu;
	}

	public String getPPNC() {
		return PPNC;
	}

	public void setPPNC(String pPNC) {
		PPNC = pPNC;
	}

	public String getNoiDungNC() {
		return NoiDungNC;
	}

	public void setNoiDungNC(String noiDungNC) {
		NoiDungNC = noiDungNC;
	}

	public String getSPDuKien() {
		return SPDuKien;
	}

	public void setSPDuKien(String sPDuKien) {
		SPDuKien = sPDuKien;
	}

	public String getDiaChiUD() {
		return DiaChiUD;
	}

	public void setDiaChiUD(String diaChiUD) {
		DiaChiUD = diaChiUD;
	}

	public double getKinhPhi() {
		return KinhPhi;
	}

	public void setKinhPhi(double kinhPhi) {
		KinhPhi = kinhPhi;
	}
    
    
    
    
}
