package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

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
	public ArrayList<TaiKhoan> getListTaiKhoan() throws ParseException {
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
	
	public boolean insertTaiKhoan(TaiKhoan tk) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into TaiKhoan values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
			java.util.Date myDate = format.parse(tk.getNgaySinh());
			java.sql.Date sqlDate = new java.sql.Date( myDate.getTime() );
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, tk.getMaTK());
			ps.setString(2, tk.getMatKhau());
			ps.setString(3, tk.getQuyen());
			ps.setString(4, tk.getHoTen());
			ps.setDate(5,sqlDate);
			ps.setString(6, tk.getNganh());
			ps.setString(7, tk.getEmail());
			ps.setString(8, tk.getHinhAnh());
			ps.setString(9, tk.getMSNH());
			ps.setString(10, tk.getCNNH());
			ps.setString(11, tk.getSoDT());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean updateTaiKhoan(TaiKhoan tk) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "update TaiKhoan set Email=?, SoDT=?, MSNH=?,CNNH=? where MaTK=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, tk.getEmail());
			ps.setString(2, tk.getSoDT());
			ps.setString(3, tk.getMSNH());
			ps.setString(4, tk.getCNNH());
			ps.setString(5,tk.getMaTK());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	public boolean deleteTaiKhoan(TaiKhoan tk) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "delete from TaiKhoan where MaTK=?";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1, tk.getMaTK());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(TaiKhoan_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
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

	public static void main(String[] args) throws SQLException, Exception {
		TaiKhoan_Controller ctrl = new TaiKhoan_Controller();
		TaiKhoan tk=new TaiKhoan();
		tk = ctrl.gettk("tk7");
		tk.setEmail("xuantriet3@gmail.com");
		tk.setMSNH("123456");
		tk.setSoDT("01645059996");
		tk.setCNNH("ABCXCZ");
		ctrl.updateTaiKhoan(tk);
	}

}
