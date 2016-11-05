package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.CTNghiemThu;
import Model.DeTai;
import Packages.DBConnect;

public class DeTai_Controller {
	public ArrayList<DeTai> getListDeTai() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DeTai";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	
                list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiByMaCN(String maCN)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DeTai,TaiKhoan where DeTai.MaCN=TaiKhoan.MaTK and MaCN='"+maCN+"'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiByGVHD(String gvhd)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DeTai,TaiKhoan where DeTai.MaCN=TaiKhoan.MaTK and GVHD='"+gvhd+"'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setMaTT(rs.getString("MaTT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setSinhVien1(rs.getString("SinhVien1"));
            	dt.setSinhVien2(rs.getString("SinhVien2"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setMoTa(rs.getString("MoTa"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setLoaiHinh(rs.getString("LoaiHinh"));
            	dt.setNgayThucHien(rs.getString("NgayThucHien"));
            	dt.setNgayKetThuc(rs.getString("NgayKetThuc"));
            	dt.setCoQuanChuTri(rs.getString("CoQuanChuTri"));
            	dt.setTinhHinhTrong(rs.getString("TinhHinhTrong"));
            	dt.setTinhHinhNgoai(rs.getString("TinhHinhNgoai"));
            	dt.setTinhCapThiet(rs.getString("TinhCapThiet"));
            	dt.setMucTieu(rs.getString("MucTieu"));
            	dt.setPPNC(rs.getString("PPNC"));
            	dt.setNoiDungNC(rs.getString("NoiDungNC"));
            	dt.setSPDuKien(rs.getString("SPDuKien"));
            	dt.setDiaChiUD(rs.getString("DiaChiUD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public static void main(String[] args) throws SQLException {
		DeTai_Controller ctrl= new DeTai_Controller();
	       for(DeTai ct: ctrl.getListDeTaiByGVHD("tk4")){
	    	   System.out.print(ct.getMaCN()+"_______"+ct.getTenDT());
	    	   
	       }
		  
	    }
}
