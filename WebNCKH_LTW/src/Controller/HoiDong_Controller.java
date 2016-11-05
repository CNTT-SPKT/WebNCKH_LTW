package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.HoiDong;
import Packages.DBConnect;

public class HoiDong_Controller {
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
