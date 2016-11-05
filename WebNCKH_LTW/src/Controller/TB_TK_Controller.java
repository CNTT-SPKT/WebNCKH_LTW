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
	public ArrayList<TB_TK> getListTB_TKByMaTK(String maTK) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM TB_TK,ThongBao,TaiKhoan where ThongBao.MaTB=TB_TK.MaTB and "+ 
        "ThongBao.NguoiNhan=TaiKhoan.MaTK and TaiKhoan.MaTK='"+maTK+"'";
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
	       for(TB_TK ct: ctrl.getListTB_TKByMaTK("tk5")){
	    	   System.out.println(ct.getMaTB()+"_______"+ct.getNgayGui());
	    	   
	       }
		 
	    }
}
