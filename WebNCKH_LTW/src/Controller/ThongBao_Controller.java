package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.DeTai;
import Model.TB_TK;
import Model.ThongBao;
import Packages.DBConnect;

public class ThongBao_Controller {
	//BAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TINBAT DAU TIN
	public boolean insert_thongbao(ThongBao tb) {
		Connection cons = DBConnect.getConnecttion();
		 String sql = "INSERT INTO thongbao(MaTB,NguoiGui,NguoiNhan)"
	        		+ " values (?,?,?)";
		try {
			 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	            ps.setString(1, tb.getMaTB());
	            ps.setString(2, tb.getNguoiGui());
	            ps.setString(3, tb.getNguoiNhan());
	        
	          return ps.executeUpdate()==1;

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			return false;
		}
	}
	public Boolean kiemTraKhoaChinhTB(String maTB)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM ThongBao WHERE thongbao.Matb='"+maTB+"'";
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Boolean kiemTraKhoaChinhTBTK(String maCTTB)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM tb_tk WHERE tb_tk.MaCTTB='"+maCTTB+"'";
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insert_CTthongbao(TB_TK cttb) {
		Connection cons = DBConnect.getConnecttion();
		 String sql = "INSERT INTO tb_tk(MaCTTB,MaTB,MaLTB,TinTB,NgayGui)"
	        		+ " values (?,?,?,?,?)";
		try {
			 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
			 java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	            ps.setString(1, cttb.getMaCTTB());
	            ps.setString(2, cttb.getMaTB());
	            ps.setString(3, cttb.getMaLTB());
	            ps.setString(4, cttb.getTinTB());
	            ps.setDate(5,date);
	          return ps.executeUpdate()==1;

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			return false;
		}
	}
	public ArrayList<ThongBao> getListThongBaoQLDK() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT tb_tk.MaCTTB,thongbao.MaTB,loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui "
        		+ "FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui "
        		+ "where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk"
        		+ " and TenNguoiGui.MaTK=thongbao.NguoiGui "
        		+ "and TaiKhoan.Quyen='Manager' and loaitb.MaLTB='ltt2'";
        		
        ArrayList<ThongBao> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ThongBao tb = new ThongBao();
            	tb.setTenLoaiTB(rs.getString("TenLoaiTB"));
            	tb.setTenNguoiGui(rs.getString("TenNG"));
            	tb.setNgayGui(rs.getString("NgayGui"));
            	tb.setMaTB(rs.getString("thongbao.matb"));
            	tb.setMaCTTB(rs.getString("tb_tk.MaCTTB"));
            	list.add(tb);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public boolean deleteThongBao(String MaTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM ThongBao WHERE MaTB =?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,MaTB);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public boolean deleteThongBao_TaiKhoan(String MaCTTB) throws SQLException {
		 Connection connection = DBConnect.getConnecttion();
	     String sql = "DELETE FROM tb_tk WHERE MaCTTB =?";
	    try {
	       
	       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
	       ps.setString(1,MaCTTB);
	       return ps.executeUpdate()==1;
	    } catch (Exception e) {
	    	return false;
	    }
	    
	}
	public ArrayList<ThongBao> getListThongBaoQLHuyGH() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT tb_tk.MaCTTB, thongbao.matb, loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui "
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
            	tb.setMaTB(rs.getString("thongbao.matb"));
            	tb.setMaCTTB(rs.getString("tb_tk.MaCTTB"));
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
	public ThongBao getTBNguoiNhan(String nguoiNhan) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM ThongBao inner join TaiKhoan on ThongBao.NguoiGui=TaiKhoan.MaTK" +
        " Where ThongBao.NguoiNhan='"+nguoiNhan+"'";
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
	//	ThongBao tb = thongbaoctrl.getThongBao("tk3","tk4");
		for(ThongBao c: thongbaoctrl.getListThongBaoQLHuyGH()){              
	    System.out.println(c.getMaTB());
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
	    
		}}
}
