package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.HoiDong;
import Packages.DBConnect;

public class HoiDong_Controller {
	//TINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTIN
	
	
		public ArrayList<HoiDong> getListHoiDongQL() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct hoidong.MaHD as MHD, TKChuTich.HoTen as TenCT, TKPhanBien.HoTen as TenPB, "
	        		+ "TKUyVien.HoTen as TenUV,HoiDong.NgayThanhLap as NTL "
	        		+ "FROM HoiDong,taikhoan as TKChuTich,"
	        		+ "taikhoan as TKPhanBien,taikhoan as TKUyVien "
	        		+ "where  TKChuTich.MaTK=hoidong.ChuTich "
	        		+ "and TKPhanBien.MaTK=hoidong.PhanBien and TKUyVien.MaTK=hoidong.UyVien ";
	        ArrayList<HoiDong> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	HoiDong hd = new HoiDong();
	            	hd.setMaHD(rs.getString("MHD"));
	               	hd.setTenChuTich(rs.getString("TenCT"));
	            	hd.setTenPhanBien(rs.getString("TenPB"));
	            	hd.setTenUyVien(rs.getString("TenUV"));
	            	hd.setNgayThanhLap(rs.getString("NTL"));
	            	list.add(hd);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		
		
		//ENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTIN
	public ArrayList<HoiDong> getListThongBao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HoiDong";
        ArrayList<HoiDong> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HoiDong hd = new HoiDong();
            	hd.setMaHD(rs.getString("MaHD"));
            	hd.setPhanBien(rs.getString("PhanBien"));
            	hd.setTenChuTich(rs.getString("TenChuTich"));
            	list.add(hd);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
