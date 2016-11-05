package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.DonHuy;
import Packages.DBConnect;

public class DonHuy_Controller {
	public ArrayList<DonHuy> getListThongBao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DonHuy";
        ArrayList<DonHuy> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	DonHuy dh = new DonHuy();
            	dh.setMaDonXin(rs.getString("MaDonXin"));
            	dh.setMaDT(rs.getString("MaDT"));
            	dh.setLyDo(rs.getString("LyDo"));
            	list.add(dh);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public DonHuy getListThongBao(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM DonHuy,DeTai where DoHuy.MaDT=DeTai.MaDT and DeTai.MaDT='"+maDT+"'";
        DonHuy dh = new DonHuy();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	dh.setMaDonXin(rs.getString("MaDonXin"));
            	dh.setMaDT(rs.getString("MaDT"));
            	dh.setLyDo(rs.getString("LyDo"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dh;
    }
}
