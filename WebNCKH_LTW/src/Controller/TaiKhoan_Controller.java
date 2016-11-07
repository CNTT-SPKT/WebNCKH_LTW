package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.CTNghiemThu;
import Model.TaiKhoan;
import Packages.DBConnect;

public class TaiKhoan_Controller {
	
	//TINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTIN
		public ArrayList<TaiKhoan> getListTenThanhVienHDQL() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "select HoTen "
	        		+ "from TaiKhoan "
	        		+ "where Quyen='Lecturers' or Quyen='Manager'";
	        ArrayList<TaiKhoan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	TaiKhoan hd = new TaiKhoan();
	            	hd.setHoTen(rs.getString("HoTen"));
	               	list.add(hd);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		//TINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTIN
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

	public TaiKhoan getTaiKhoanByMaTK(String email) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT * FROM TaiKhoan where Email='" + email + "'";
		TaiKhoan tk = new TaiKhoan();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tk.setMaTK(rs.getString("MaTK"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setQuyen(rs.getString("Quyen"));
				tk.setHoTen(rs.getString("HoTen"));
				tk.setNgaySinh(rs.getString("NgaySinh"));
				tk.setNganh(rs.getString("Nganh"));
				tk.setEmail(rs.getString("Email"));
				tk.setMSNH(rs.getString("MSNH"));
				tk.setCNNH(rs.getString("CNNH"));

			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}

	public TaiKhoan gettk(String tk) throws SQLException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT * FROM TaiKhoan where MaTK='" + tk + "'";
		TaiKhoan tkh = new TaiKhoan();
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tkh.setMaTK(rs.getString("MaTK"));
				tkh.setMatKhau(rs.getString("MatKhau"));
				tkh.setQuyen(rs.getString("Quyen"));
				tkh.setHoTen(rs.getString("HoTen"));
				tkh.setNgaySinh(rs.getString("NgaySinh"));
				tkh.setNganh(rs.getString("Nganh"));
				tkh.setEmail(rs.getString("Email"));
				tkh.setMSNH(rs.getString("MSNH"));
				tkh.setCNNH(rs.getString("CNNH"));

			}
			cons.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tkh;
	}

	public ArrayList<TaiKhoan> getListTaiKhoantheoMaTK(String matk) {
		Connection cons = DBConnect.getConnecttion();
		String sql = "SELECT * FROM TaiKhoan where MaTK='" + matk + "' ";
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

	public static void main(String[] args) throws SQLException {
		TaiKhoan_Controller ctrl = new TaiKhoan_Controller();
		for (TaiKhoan c : ctrl.getListTaiKhoantheoMaTK("tk1")) {
			System.out.println(c.getHoTen()+"--------"+c.getEmail());
		}
	}

}
