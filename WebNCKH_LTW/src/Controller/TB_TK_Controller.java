package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import Model.CTNghiemThu;
import Model.TB_TK;
import Packages.DBConnect;

public class TB_TK_Controller {
	public ArrayList<TB_TK> getListTB_TK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM TB_TK";
        ArrayList<TB_TK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TB_TK cttb = new TB_TK();
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
                list.add(cttb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public TB_TK getListTB_TKMaTB(String maCTTB) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM TB_TK where MaCTTB='"+maCTTB+"'";
        TB_TK cttb = new TB_TK();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
                
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cttb;
    }
	public ArrayList<TB_TK> getListTB_TKByMaTK(String email) throws SQLException {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT MaCTTB, ThongBao.MaTB, TinTB,NgayGui,Tk2.HoTen as TenNguoiGui FROM TB_TK,ThongBao,TaiKhoan,"+
        " TaiKhoan as TK2 where ThongBao.MaTB=TB_TK.MaTB and "+ 
        "ThongBao.NguoiNhan=TaiKhoan.MaTK and ThongBao.NguoiGui=TK2.MaTK and TaiKhoan.Email='"+email+"'";
        ArrayList<TB_TK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	TB_TK cttb= new TB_TK();
            	cttb.setMaCTTB(rs.getString("MaCTTB"));
            	cttb.setMaTB(rs.getString("MaTB"));
            	cttb.setTinTB(rs.getString("TinTB"));
            	cttb.setNgayGui(rs.getString("NgayGui"));
            	cttb.setTenNguoiGui(rs.getString("TenNguoiGui"));
                list.add(cttb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean deleteTB_TK(String maCTTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM TB_TK WHERE MaCTTB = ?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,maCTTB );
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public boolean insertTB_TK(TB_TK tbtk) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "insert into TB_TK values(?,?,?,?,?)";
	    try { 
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,tbtk.getMaCTTB());
	       ps.setString(2,tbtk.getMaTB());
	       ps.setString(3,tbtk.getMaLTB());
	       ps.setString(4,tbtk.getTinTB());
	       ps.setDate(5,date);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	
	public static void main(String[] args) throws SQLException {
		TB_TK_Controller ctrl= new TB_TK_Controller();
		TB_TK tbtk = new TB_TK();
		tbtk.setMaCTTB("cttb20");
		tbtk.setMaTB("tb1");
		tbtk.setMaLTB("ltt1");
		tbtk.setTinTB("zxczxcz");
		tbtk.setNgayGui("1/1/2011");
	     if(ctrl.insertTB_TK(tbtk))
	    	 System.out.println("Thanh cong");
	}
}
