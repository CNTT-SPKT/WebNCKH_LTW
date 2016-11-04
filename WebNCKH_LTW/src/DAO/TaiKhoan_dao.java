package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.TaiKhoan;
import Packages.DBConnect;


public class TaiKhoan_dao {
	public ArrayList<TaiKhoan> getListTaiKhoan() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM TaiKhoan";
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TaiKhoan tk = new TaiKhoan();
            	tk.setMaTK(rs.getString("MaTK"));
            	tk.setMatKhau(rs.getString("MatKhau"));
            	tk.setQuyen(rs.getString("Quyen"));
            	tk.setHoTen(rs.getString("HoTen"));
            	tk.setNgaySinh(rs.getString("NgaySinh"));
            	tk.setNganh(rs.getString("Nganh"));
            	tk.setEmail(rs.getString("Email"));
            	tk.setMSNH(rs.getString("MSNH"));
            	tk.setCNNH(rs.getString("CNNH"));
                list.add(tk);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//	public static void main(String[] args) {
//	   TaiKhoan_dao tkdao =new TaiKhoan_dao();
//	}
}


