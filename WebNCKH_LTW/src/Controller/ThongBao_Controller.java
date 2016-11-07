package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Model.ThongBao;
import Packages.DBConnect;

public class ThongBao_Controller {
	//BAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public ArrayList<ThongBao> getListThongBaoQL() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui "
        		+ "FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui "
        		+ "where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and TenNguoiGui.MaTK=thongbao.NguoiGui "
        		+ "and TaiKhoan.Quyen='Manager'"
			;
        		
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setTenLoaiTB(rs.getString("TenLoaiTB"));
            	tb.setTenNguoiGui(rs.getString("TenNG"));
            	tb.setNgayGui(rs.getString("NgayGui"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//KET THUC TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public ArrayList<ThongBao> getListThongBao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM ThongBao";
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setMaTB(rs.getString("MaTB"));
            	tb.setNguoiGui(rs.getString("NguoiGui"));
            	tb.setNguoiNhan(rs.getString("NguoiNhan"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public ThongBao getListThongBaoNN(String maTB) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM ThongBao where MaTB='"+maTB+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
            	tb.setMaTB(rs.getString("MaTB"));
            	tb.setNguoiGui(rs.getString("NguoiGui"));
            	tb.setNguoiNhan(rs.getString("NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	public ThongBao getListThongBao(String nguoiGui) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM ThongBao, TaiKhoan" +
        "Where ThongBao.NguoiGui=TaiKhoan.MaTK and ThongBao.NguoiNhan=TaiKhoan.MaTK and NguoiGui='"+nguoiGui+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("MaTB"));
            	tb.setNguoiGui(rs.getString("NguoiGui"));
            	tb.setNguoiNhan(rs.getString("NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
}
