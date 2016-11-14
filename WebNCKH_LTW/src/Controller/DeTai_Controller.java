package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.DeTai;
import Model.TaiKhoan;
import Packages.DBConnect;

public class DeTai_Controller {
	
/*BẮT ĐÀU TÍn*/
	
	public ArrayList<DeTai> getListDeTaiPheDuyetQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select distinct * from detai,trangthai,taikhoan "
        		+ "where detai.MaTT='tt1' and detai.matt=trangthai.matt and taikhoan.matk=detai.macn";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setMaCN(rs.getString("MaCN"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("HoTen"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
//	public ArrayList<DeTai> getListDeTaiPhanCongPheDuyetQL(String Email)  throws SQLException{
//        Connection cons = DBConnect.getConnecttion();
//        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK1.HoTen as MaCN,TK2.HoTen as GVHD,DeTai.LinhVuc as LinhVuc "+
//			" from DeTai,TaiKhoan as TK1,TaiKhoan as TK2"+
//			" where DeTai.MaCN=TK1.MaTK and DeTai.GVHD=TK2.MaTK and TK2.Email='"+Email+"' and DeTai.MaTT='tt1'" ;
//        ArrayList<DeTai> list = new ArrayList<>();
//        try {
//            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//            	DeTai dt = new DeTai();
//            	dt.setMaDT(rs.getString("MaDT"));
//            	dt.setTenDT(rs.getString("TenDT"));
//            	dt.setTenCN(rs.getString("MaCN"));
//            	dt.setTenGVHD(rs.getString("GVHD"));
//            	dt.setLinhVuc(rs.getString("LinhVuc"));
//            	list.add(dt);
//            }
//           
//            cons.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
	
	public ArrayList<DeTai> getListDeTaiCanPhanCongPB()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select *"
        		+ "from detai,trangthai,taikhoan "
        		+ "where detai.MaTT='tt11' and detai.matt=trangthai.matt and taikhoan.matk=detai.macn";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("HoTen"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiChoNghiemThu()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select *"
        		+ "from detai,trangthai "
        		+ "where detai.MaTT='tt11' and detai.matt=trangthai.matt";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setTenDT(rs.getString("TenDT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListPCPBQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select detai.MaDT,TenDT,tensv.HoTen as TenSV,tengv.HoTen as TenGV,ctnghiemthu.MaHD as MHD "
        		+ "from detai,ctnghiemthu,taikhoan as tensv,taikhoan as tengv "
        		+ "where detai.MaDT=ctnghiemthu.MaDT and detai.GVHD=tengv.MaTK and detai.MaCN=tensv.MaTK";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("TenSV"));
            	dt.setTenGVHD(rs.getString("TenGV"));
            	dt.setMaHD(rs.getString("MHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiQL()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql ="select TKGV.HoTen as TenGV, TKSV.HoTen as TenSV, MaHienThi, TenDT, GVHD,TenTT"
        		+ " from DeTai,TaiKhoan as TKSV, TaiKhoan as TKGV,TrangThai "
        		+ "where DeTai.MaCN=TKSV.MaTk and TrangThai.MaTT=DeTai.MaTT and DeTai.GVHD=TKGV.MaTk";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaHienThi(rs.getString("MaHienThi"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setHoTen(rs.getString("TenSV"));
            	dt.setTenGVHD(rs.getString("TenGV"));
            	dt.setGVHD(rs.getString("GVHD"));
            	dt.setTenTT(rs.getString("TenTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	/*KẾT THÚC TIn*/
	public DeTai getDeTai(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DeTai,TaiKhoan,TaiKhoan as TK1,TaiKhoan as TK2,TaiKhoan as TK3"+
        " where TaiKhoan.MaTK=DeTai.MaCN and TK1.MaTK=DeTai.GVHD"+
        " and TK2.MaTK=DeTai.SinhVien1 and TK3.MaTK=DeTai.SinhVien2 and MaDT='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	
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
            	dt.setTenCN(rs.getString("TaiKhoan.HoTen"));
            	dt.setMSSVCN(rs.getString("TaiKhoan.MatKhau"));
            	dt.setTenSV1(rs.getString("TK2.HoTen"));
            	dt.setTenSV2(rs.getString("TK3.HoTen"));
            	dt.setTenGVHD(rs.getString("TK1.HoTen"));
            	dt.setEmailCN(rs.getString("TaiKhoan.Email"));
            	dt.setEmailGV(rs.getString("TK1.Email"));
            	dt.setMSSV1(rs.getString("TK2.MatKhau"));
            	dt.setMSSV2(rs.getString("TK3.MatKhau"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	public ArrayList<DeTai> getListDeTaiByMaCN(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,"+
				" DeTai.NgayKetThuc as NgayNT, TrangThai.tenTT as TenTT"+
				" from DeTai,TaiKhoan,TrangThai"+
				" where DeTai.MaCN=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT "+
				" and TaiKhoan.Email='"+Email+"'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setNgayKetThuc(rs.getString("NgayNT"));
            	dt.setTenTT(rs.getString("TenTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ArrayList<DeTai> getListDeTaiDeXuat()  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,"+
				" TaiKhoan.HoTen as TenGVHD "+
				" from DeTai,TaiKhoan,TrangThai where DeTai.GVHD=TaiKhoan.MaTK "+
				" and DeTai.MaTT=TrangThai.MaTT and TrangThai.MaTT='tt11' ";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setTenGVHD(rs.getString("TenGVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public DeTai getListDeTaiByMaDT(String maDT)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,"+
				" DeTai.NgayKetThuc as NgayNT, TrangThai.tenTT as TenTT,MatKhau as MSSV, HoTen as TenCN"+
				" from DeTai,TaiKhoan,TrangThai"+
				" where DeTai.MaCN=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT "+
				" and MaDT='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setNgayThucHien(rs.getString("NgayDK"));
            	dt.setNgayKetThuc(rs.getString("NgayNT"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMSSVCN(rs.getString("MSSV"));
            	dt.setTenCN(rs.getString("TenCN"));
            	
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
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
	public ArrayList<DeTai> getListDeTaiNT(String email)  throws SQLException{
		 Connection cons = DBConnect.getConnecttion();
	        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,"+
					" CTNghiemThu.NgayNT as NgayNT"+
					" from DeTai,TaiKhoan,CTNghiemThu "+
					" where DeTai.MaCN=TaiKhoan.MaTK "+
					" and DeTai.MaDT=CTNghiemThu.MaDT and TaiKhoan.Email='"+email+"'";
	        ArrayList<DeTai> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	DeTai dt = new DeTai();
	            	dt.setMaDT(rs.getString("MaDT"));
	            	dt.setTenDT(rs.getString("TenDT"));
	            	dt.setNgayThucHien(rs.getString("NgayDK"));
	            	dt.setNgayNT(rs.getString("NgayNT"));
	            	list.add(dt);
	            }
	           
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiPhanCongPhanBien(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK1.HoTen as MaCN,TK2.HoTen as GVHD"+
			" from DeTai,CTNghiemThu,HoiDong,TaiKhoan,TaiKhoan as TK1, TaiKhoan as TK2"+
			" where DeTai.MaDT=CTNghiemThu.MaDT and CTNghiemThu.MaHD=HoiDong.MaHD and HoiDong.PhanBien=TaiKhoan.MaTK"+
			" and TaiKhoan.Email='"+Email+"' and DeTai.MaCN=TK1.MaTK and DeTai.GVHD=TK2.MaTK and MaTT='tt8' ";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiPhanCongPheDuyet(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK1.HoTen as MaCN,TK2.HoTen as GVHD,DeTai.LinhVuc as LinhVuc "+
			" from DeTai,TaiKhoan as TK1,TaiKhoan as TK2"+
			" where DeTai.MaCN=TK1.MaTK and DeTai.GVHD=TK2.MaTK and TK2.Email='"+Email+"' and DeTai.MaTT='tt2'";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	dt.setLinhVuc(rs.getString("LinhVuc"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiHuongDan(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK1.HoTen as MaCN,TK2.HoTen as GVHD "+
			" from DeTai,TaiKhoan as TK1,TaiKhoan as TK2"+
			" where DeTai.MaCN=TK1.MaTK and DeTai.GVHD=TK2.MaTK and TK2.Email='"+Email+"' and (DeTai.MaTT='tt11' or"+
			" DeTai.MaTT='tt3' or DeTai.MaTT='tt4' or DeTai.MaTT='tt6' or DeTai.MaTT='tt7' or DeTai.MaTT='tt8')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("MaCN"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTaiGV_DK(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TaiKhoan.HoTen as GVHD,TrangThai.tenTT as TenTT,DeTai.LinhVuc"+
			" from DeTai,TaiKhoan,TrangThai "+
			" where DeTai.GVHD=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT and TaiKhoan.Email='"+Email+"' "+
			" and (DeTai.MaTT='tt11' or DeTai.MaTT='tt10')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenGVHD(rs.getString("GVHD"));
            	dt.setLinhVuc(rs.getString("DeTai.LinhVuc"));
            	dt.setTenTT(rs.getString("TenTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public ArrayList<DeTai> getListDeTai_YC_Huy_GiaHan(String Email)  throws SQLException{
        Connection cons = DBConnect.getConnecttion();
        String sql = "select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK2.HoTen as TenCN,TaiKhoan.HoTen as GVHD,TrangThai.tenTT as TenTT,DeTai.MaTT"+
			" from DeTai,TaiKhoan,TrangThai,TaiKhoan as TK2 "+
			" where DeTai.MaCN=TK2.MaTK and DeTai.GVHD=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT and TaiKhoan.Email='"+Email+"' " + 
			" and (DeTai.MaTT='tt4' or DeTai.MaTT='tt6')";
        ArrayList<DeTai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DeTai dt = new DeTai();
            	dt.setMaDT(rs.getString("MaDT"));
            	dt.setTenDT(rs.getString("TenDT"));
            	dt.setTenCN(rs.getString("TenCN"));
            	dt.setTenTT(rs.getString("TenTT"));
            	dt.setMaTT(rs.getString("DeTai.MaTT"));
            	list.add(dt);
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public DeTai getDeTaiGV(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DeTai,TaiKhoan"+
        " where TaiKhoan.MaTK=DeTai.GVHD"+
        " and  MaDT='"+maDT+"'";
        DeTai dt = new DeTai();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	
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
            	dt.setTenGVHD(rs.getString("TaiKhoan.HoTen"));
            	dt.setEmailGV(rs.getString("TaiKhoan.Email"));
            	dt.setKinhPhi(rs.getDouble("KinhPhi"));
            }
           
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dt;
    }
	
	public boolean updateTrangThai_DeTai(DeTai dt) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update DeTai set MaTT=? where MaDT=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,dt.getMaTT());
			ps.setString(2, dt.getMaDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public static void main(String[] args) throws SQLException, Exception {
		DeTai_Controller ctrl = new DeTai_Controller();
		DeTai dt=new DeTai();
		dt = ctrl.getDeTai("dt9");  //tt8
		dt.setMaTT("tt8");
		if(ctrl.updateTrangThai_DeTai(dt))
			System.out.println("TC");
	}
}
