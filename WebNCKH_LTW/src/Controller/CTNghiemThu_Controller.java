package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

import Model.CTNghiemThu;
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
		 public static void main(String[] args) throws SQLException {
		       CTNghiemThu_Controller ctrl= new CTNghiemThu_Controller();
		       CTNghiemThu ct= ctrl.getListCTNghiemThuByDeTai("dt7");
		       System.out.print(ct.getMaDT()+"_______"+ct.getNgayNT());
		    	   
		    
			  
		    }
}
