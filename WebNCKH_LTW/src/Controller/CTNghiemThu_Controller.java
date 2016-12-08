package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import java.sql.ResultSet;

import Model.CTNghiemThu;
import Model.TaiKhoan;
import Packages.DBConnect;

public class CTNghiemThu_Controller {
		public ArrayList<CTNghiemThu> getListCTNghiemThu() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM CTNghiemThu";
	        ArrayList<CTNghiemThu> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	CTNghiemThu ct = new CTNghiemThu();
	            	ct.setMaDT(rs.getString("MaDT"));
	            	ct.setMaHD(rs.getString("MaHD"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                list.add(ct);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public ArrayList<CTNghiemThu> getListCTNghiemThuMaDT(String maDT) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan as ct, TaiKhoan as pb,DeTai,TaiKhoan "
	        		+ "where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT and "
	        		+ "HoiDong.ChuTich=ct.MaTK and HoiDong.PhanBien=pb.MaTK "
	        		+ "and ctnghiemthu.MaTK=TaiKhoan.MaTK and ctnghiemthu.MaDT='"+maDT+"'";
	        ArrayList<CTNghiemThu> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	CTNghiemThu ct = new CTNghiemThu();
	            	ct.setMaDT(rs.getString("CTNghiemThu.MaDT"));
	            	ct.setTenDT(rs.getString("TenDT"));
	            	ct.setMaHD(rs.getString("HoiDong.MaHD"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	            	ct.setMaPhanBien(rs.getString("PhanBien"));
	            	ct.setTenPhanBien(rs.getString("pb.HoTen"));
	            	ct.setMaChuTich(rs.getString("ChuTich"));
	            	ct.setTenChuTich(rs.getString("ct.HoTen"));
	            	ct.setMaTK(rs.getString("CTNghiemThu.MaTK"));
	            	ct.setTenTK(rs.getString("TaiKhoan.HoTen"));
	                list.add(ct);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public CTNghiemThu getCTNghiemThuMaTK(String maTK) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan as ct, TaiKhoan as pb,DeTai,TaiKhoan "
	        		+ "where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT and "
	        		+ "HoiDong.ChuTich=ct.MaTK and HoiDong.PhanBien=pb.MaTK "
	        		+ "and ctnghiemthu.MaTK=TaiKhoan.MaTK and ctnghiemthu.MaTK='"+maTK+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("CTNghiemThu.MaDT"));
	            	ct.setTenDT(rs.getString("TenDT"));
	            	ct.setMaHD(rs.getString("HoiDong.MaHD"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	            	ct.setMaPhanBien(rs.getString("PhanBien"));
	            	ct.setTenPhanBien(rs.getString("pb.HoTen"));
	            	ct.setMaChuTich(rs.getString("ChuTich"));
	            	ct.setTenChuTich(rs.getString("ct.HoTen"));
	            	ct.setMaTK(rs.getString("CTNghiemThu.MaTK"));
	            	ct.setTenTK(rs.getString("TaiKhoan.HoTen"));
	               
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		public CTNghiemThu getListCTNghiemThuByDeTai(String maDT) throws SQLException {
	        Connection connection = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM CTNghiemThu where MaDT='"+maDT+"'";
	        PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	        ResultSet rs = ps.executeQuery();
	        CTNghiemThu ct = new CTNghiemThu();
	        while (rs.next()) {
	        	
	        	ct.setMaDT(rs.getString("MaDT"));
            	ct.setMaHD(rs.getString("MaHD"));
            	ct.setTongQuan(rs.getInt("TongQuan"));
            	ct.setMucTieu(rs.getInt("MucTieu"));
            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
            	ct.setNoiDung(rs.getInt("NoiDung"));
            	ct.setDongGop(rs.getInt("DongGop"));
            	ct.setHinhThuc(rs.getInt("HinhThuc"));
            	ct.setDiemThuong(rs.getInt("DiemThuong"));
            	ct.setTongDiem(rs.getInt("TongDiem"));
            	ct.setYKien(rs.getString("YKien"));
            	ct.setNgayNT(rs.getString("NgayNT"));
                
	        }
	        return ct;
	    }
		public CTNghiemThu getListCTNghiemThu(String maDT) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM CTNghiemThu,DeTai where"+
	        " CTNghiemThu.MaDT=DeTai.MaDT"+
	        " and DeTai.MaDT='"+maDT+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("MaDT"));
	            	ct.setMaHD(rs.getString("MaHD"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		public CTNghiemThu getCTNghiemThuByMaTK(String maDT,String maTK) {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan,DeTai "
	        		+ "where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT  "
	        		+ "and TaiKhoan.MaTK=CTNghiemThu.MaTK and CTNghiemThu.MaTK='"+maTK+"' and CTNghiemThu.MaDT='"+maDT+"'";
	        CTNghiemThu ct = new CTNghiemThu();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	ct.setMaDT(rs.getString("CTNghiemThu.MaDT"));
	            	ct.setTenDT(rs.getString("DeTai.TenDT"));
	            	ct.setMaHD(rs.getString("HoiDong.MaHD"));
	            	ct.setMaTK(rs.getString("CTNghiemThu.MaTK"));
	            	ct.setTenTK(rs.getString("HoTen"));
	            	ct.setTongQuan(rs.getInt("TongQuan"));
	            	ct.setMucTieu(rs.getInt("MucTieu"));
	            	ct.setPhuongPhap(rs.getInt("PhuongPhap"));
	            	ct.setNoiDung(rs.getInt("NoiDung"));
	            	ct.setDongGop(rs.getInt("DongGop"));
	            	ct.setHinhThuc(rs.getInt("HinhThuc"));
	            	ct.setDiemThuong(rs.getInt("DiemThuong"));
	            	ct.setTongDiem(rs.getInt("TongDiem"));
	            	ct.setYKien(rs.getString("YKien"));
	            	ct.setNgayNT(rs.getString("NgayNT"));
	                
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ct;
	    }
		
		public boolean updateCTNT(CTNghiemThu ctnt) throws ParseException {
			Connection cons = DBConnect.getConnecttion();
			String sql = "update CTNghiemThu set TongQuan=?, MucTieu=?, PhuongPhap=?,NoiDung=?,DongGop=?,"
					+ " HinhThuc=?, DiemThuong=?, TongDiem=?, YKien=?, NgayNT=? where MaDT=? and MaTK=? ";
			try {
				PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				ps.setInt(1, ctnt.getTongQuan());
				ps.setInt(2, ctnt.getMucTieu());
				ps.setInt(3, ctnt.getPhuongPhap());
				ps.setInt(4, ctnt.getNoiDung());
				ps.setInt(5, ctnt.getDongGop());
				ps.setInt(6, ctnt.getHinhThuc());
				ps.setInt(7, ctnt.getDiemThuong());
				ps.setInt(8, ctnt.getTongDiem());
				ps.setString(9, ctnt.getYKien());
				ps.setDate(10,  date);
				ps.setString(11, ctnt.getMaDT());
				ps.setString(12, ctnt.getMaTK());
				return ps.executeUpdate()==1;
			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			}
			return false;
		}
		public boolean deleteCTNT(String maHD) throws SQLException {
			 Connection connection = DBConnect.getConnecttion();
		     String sql = "DELETE FROM CTNghiemThu WHERE MaHD = ?";
		    try {
		       
		       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		       ps.setString(1,maHD );
		       return ps.executeUpdate()==1;
		    } catch (Exception e) {
		    	return false;
		    }
		    
		}
		
		
		 public static void main(String[] args) throws SQLException, ParseException {
		       CTNghiemThu_Controller ctrl= new CTNghiemThu_Controller();
		       CTNghiemThu ctnt=ctrl.getCTNghiemThuByMaTK("dt4","tk7");
		    	   System.out.println(ctnt.getMaDT()+"_____"+ctnt.getTenDT()+"____"+ctnt.getNoiDung());

		    	   
//		       CTNghiemThu ct= new CTNghiemThu();
//		       ct = ctrl.getListCTNghiemThu("dt9");
//		       ct.setDiemThuong(10);
//		       ct.setYKien("nhu c");
//		       if(ctrl.updateCTNT(ct))
//		    	   System.out.println("TC");
		    }
}
