package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.sun.istack.internal.logging.Logger;

import Model.CTNghiemThu;
import Model.DeTai;
import Model.HoiDong;
import Packages.DBConnect;

public class HoiDong_Controller {
	public Boolean kiemTra(String MaHD)
	{
		Connection connection = DBConnect.getConnecttion();
		String sql ="SELECT * FROM HoiDong WHERE HoiDong.MaHD='"+MaHD+"'";
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
	//TINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTINTIN
		public void insert(String MaHD,String PhanBien,String ChuTich,String UyVien,String NgayThanhLap) {
		Connection cons = DBConnect.getConnecttion();
		 String sql = "INSERT INTO hoidong"
	        		+ " values (?,?,?,?,?)";
		try {
			 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	           
	            ps.setString(1, MaHD);
	            ps.setString(2, PhanBien);
	            ps.setString(3, ChuTich);
	            ps.setString(4, UyVien);
	            ps.setString(5, NgayThanhLap);
	            
	            
	          ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
		}
	}
		

		public void insert_PCPB(String MaHD,String MaDT) {
			Connection cons = DBConnect.getConnecttion();
			 String sql = "INSERT INTO ctnghiemthu(MaDT,MaHD)"
		        		+ " values (?,?)";
			try {
				 PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
		           
		            ps.setString(1, MaDT);
		            ps.setString(2, MaHD);
		          ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger(DeTai_Controller.class.getName(), null).log(Level.SEVERE, null, e);
			}
		}
	
//		public ArrayList<HoiDong> getListHoiDongQL() {
//	        Connection cons = DBConnect.getConnecttion();
//	        String sql = "SELECT distinct hoidong.MaHD as MHD, TKChuTich.HoTen as TenCT, TKPhanBien.HoTen as TenPB, "
//	        		+ "TKUyVien.HoTen as TenUV,HoiDong.NgayThanhLap as NTL "
//	        		+ "FROM HoiDong,taikhoan as TKChuTich,"
//	        		+ "taikhoan as TKPhanBien,taikhoan as TKUyVien "
//	        		+ "where  TKChuTich.MaTK=hoidong.ChuTich "
//	        		+ "and TKPhanBien.MaTK=hoidong.PhanBien and TKUyVien.MaTK=hoidong.UyVien ";
//	        ArrayList<HoiDong> list = new ArrayList<>();
//	        try {
//	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
//	            ResultSet rs = ps.executeQuery();
//	            while (rs.next()) {
//	            	HoiDong hd = new HoiDong();
//	            	hd.setMaHD(rs.getString("MHD"));
//	               	hd.setTenChuTich(rs.getString("TenCT"));
//	            	hd.setTenPhanBien(rs.getString("TenPB"));
//	            	hd.setTenUyVien(rs.getString("TenUV"));
//	            	hd.setNgayThanhLap(rs.getString("NTL"));
//	            	list.add(hd);
//	            }
//	            cons.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return list;
//	    }
		public ArrayList<HoiDong> getListHoiDongQL() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT distinct hoidong.MaHD as MHD, TKChuTich.HoTen as TenCT, "
	        		+ "TKPhanBien.HoTen as TenPB, TKUyVien.HoTen as TenUV "
	        		+ ",HoiDong.NgayThanhLap as NTL FROM HoiDong,taikhoan "
	        		+ "as TKChuTich, taikhoan as TKUyVien,taikhoan as TKPhanBien where  "
	        		+ "TKChuTich.MaTK=hoidong.ChuTich and TKPhanBien.MaTK=hoidong.PhanBien "
	        		+ "and TKUyVien.MaTK=hoidong.UyVien";
	        ArrayList<HoiDong> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	HoiDong hd = new HoiDong();
	            	hd.setMaHD(rs.getString("MHD"));
	               	hd.setTenChuTich(rs.getString("TenCT"));
	            	hd.setTenPhanBien(rs.getString("TenPB"));
	            	hd.setTenUyVien(rs.getString("TenUV"));
	            	hd.setNgayThanhLap(rs.getString("NTL"));
	            	list.add(hd);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		
		public Boolean kiemtra(String MaHD)
		{
			Connection connection = DBConnect.getConnecttion();
			String sql ="SELECT * FROM hoidong WHERE hoidong.MaHD='"+MaHD+"'";
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
		public boolean deleteHoiDong(String maHD) throws SQLException {
			 Connection connection = DBConnect.getConnecttion();
		     String sql = "DELETE FROM HoiDong WHERE MaHD = ?";
		    try {
		       
		       PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		       ps.setString(1,maHD );
		       return ps.executeUpdate()==1;
		    } catch (Exception e) {
		    	return false;
		    }
		    
		}
		//ENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTINENDTIN
	public ArrayList<HoiDong> getListThongBao() {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM HoiDong";
        ArrayList<HoiDong> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	HoiDong hd = new HoiDong();
            	hd.setMaHD(rs.getString("MaHD"));
            	hd.setPhanBien(rs.getString("PhanBien"));
            	hd.setTenChuTich(rs.getString("TenChuTich"));
            	list.add(hd);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	public static void main(String[] args) throws SQLException, Exception{
	      HoiDong_Controller ctrl= new HoiDong_Controller();
	       for(HoiDong ct : ctrl.getListHoiDongQL())
	       {
	    	   System.out.println(ct.getTenChuTich());
	       }
	      
	    }
}
