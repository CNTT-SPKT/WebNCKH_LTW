package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.DeTai;
import Model.ThongBao;
import Packages.DBConnect;

public class ThongBao_Controller {
	//BAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public ArrayList<ThongBao> getListThongBaoQLDK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui "
        		+ "FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui "
        		+ "where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and TenNguoiGui.MaTK=thongbao.NguoiGui "
        		+ "and TaiKhoan.Quyen='Manager' and loaitb.MaLTB='ltt2'"
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
	public ArrayList<ThongBao> getListThongBaoQLHuyGH() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui "
        		+ "FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui "
        		+ "where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and TenNguoiGui.MaTK=thongbao.NguoiGui "
        		+ "and TaiKhoan.Quyen='Manager' and (loaitb.MaLTB='ltt3' or loaitb.MaLTB='ltt4')";
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
        String sql = "SELECT * FROM ThongBao inner join TaiKhoan on ThongBao.NguoiGui=TaiKhoan.MaTK" +
        " Where ThongBao.NguoiGui='"+nguoiGui+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("ThongBao.MaTB"));
            	tb.setNguoiGui(rs.getString("ThongBao.NguoiGui"));
            	tb.setNguoiNhan(rs.getString("ThongBao.NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	
	public ThongBao getThongBao(String nguoiGui,String nguoiNhan) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM ThongBao inner join TaiKhoan on ThongBao.NguoiGui=TaiKhoan.MaTK" +
        " Where ThongBao.NguoiGui='"+nguoiGui+"' and ThongBao.NguoiNhan='"+nguoiNhan+"'";
        ThongBao tb = new ThongBao();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	tb.setMaTB(rs.getString("ThongBao.MaTB"));
            	tb.setNguoiGui(rs.getString("ThongBao.NguoiGui"));
            	tb.setNguoiNhan(rs.getString("ThongBao.NguoiNhan"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
	
	public boolean createThongBao(ThongBao tb) throws ParseException {
		Connection cons = DBConnect.getConnecttion();
		String sql = "insert into ThongBao values(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			ps.setString(1,tb.getMaTB());
			ps.setString(2, tb.getNguoiGui());
			ps.setString(3, tb.getNguoiNhan());
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(ThongBao_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
		return false;
	}
	
	
	public static void main(String[] args) throws SQLException, ParseException {
		TB_TK_Controller ctrl= new TB_TK_Controller();
		ThongBao_Controller thongbaoctrl = new ThongBao_Controller();
		ThongBao tb = thongbaoctrl.getThongBao("tk3","tk4");
	    System.out.println(tb.getMaTB());
//	    if(thongbaoctrl.getThongBao("tk3","tk4").getMaTB()==null)
//	    {
//	    	int n =thongbaoctrl.getListThongBao().size();
//		    tb.setMaTB("tb"+(n+1));
//		    tb.setNguoiGui("tk3");
//		    tb.setNguoiNhan("tk4");
//		    if(thongbaoctrl.createThongBao(tb))
//		    	System.out.println("thanh cong");
//		    
//	    }
	    
	}
}
