package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.TrangThai;
import Packages.DBConnect;

public class TrangThai_Controller {
	public ArrayList<TrangThai> getListTrangThai() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM TrangThai";
        ArrayList<TrangThai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TrangThai tt = new TrangThai();
            	tt.setMaTT(rs.getString("MaTT"));
            	tt.setTenTT(rs.getString("tenTT"));
                list.add(tt);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
