package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public static void main(String[] args) throws SQLException {
		TB_TK_Controller ctrl= new TB_TK_Controller();
	       for(TB_TK ct: ctrl.getListTB_TKByMaTK("ltthao@gmail.com")){
	    	   System.out.println(ct.getMaTB()+"_______"+ct.getTenNguoiGui());
	    	   
	       }
		 
	    }
}
