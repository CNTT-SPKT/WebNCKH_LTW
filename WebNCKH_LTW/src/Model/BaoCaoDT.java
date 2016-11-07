package Model;

import java.io.File;
import java.util.ArrayList;

public class BaoCaoDT {
	private String MaDT;
    private String MaBC;
    private String TenBC;
    private String NgayBC;
    private String FileBC;
    private String TenDT;
   
    
	public BaoCaoDT() {
		super();
	}

	public BaoCaoDT(String MaDT, String MaBC, String TenBC,String FileBC, String NgayBC,
			 String TenDT) {
		super();
		this.MaDT = MaDT;
		this.MaBC = MaBC;
		this.TenBC = TenBC;
		this.FileBC = FileBC;
		this.NgayBC = NgayBC;
		this.TenDT = TenDT;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public String getMaBC() {
		return MaBC;
	}

	public void setMaBC(String maBC) {
		MaBC = maBC;
	}

	public String getTenBC() {
		return TenBC;
	}

	public void setTenBC(String tenBC) {
		TenBC = tenBC;
	}

	public String getNgayBC() {
		return NgayBC;
	}

	public void setNgayBC(String ngayBC) {
		NgayBC = ngayBC;
	}

	public String getFileBC() {
		return FileBC;
	}

	public void setFileBC(String fileBC) {
		FileBC = fileBC;
	}

	public String getTenDT() {
		return TenDT;
	}

	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}

}
