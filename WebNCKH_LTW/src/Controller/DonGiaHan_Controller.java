package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

import Model.DeTai;
import Model.DonGiaHan;
import Packages.DBConnect;

public class DonGiaHan_Controller {
		public ArrayList<DonGiaHan> getListDonGiaHan() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM DonGiaHan";
	        ArrayList<DonGiaHan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs =  ps.executeQuery();
	            while (rs.next()) {
	            	DonGiaHan gh = new DonGiaHan();
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            	list.add(gh);
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		public ArrayList<DonGiaHan> getListDonGiaHanByMaDT(String maDT)  throws SQLException{
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM DonGiaHan,DeTai where DonGiaHan.MaDT=DeTai.MaDT and DeTai.MaDT='"+maDT+"'";
	        ArrayList<DonGiaHan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	DonGiaHan gh = new DonGiaHan();
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            	list.add(gh);
	            
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
		
		public DonGiaHan getDGH(String maDT)  throws SQLException{
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM DonGiaHan,DeTai where DonGiaHan.MaDT=DeTai.MaDT and DeTai.MaDT='"+maDT+"'";
	        DonGiaHan gh = new DonGiaHan();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	gh.setMaDonXin(rs.getString("MaDonXin"));
	            	gh.setMaDT(rs.getString("MaDT"));
	            	gh.setLyDo(rs.getString("LyDo"));
	            	gh.setGHDen(rs.getString("GHDen"));
	            
	            }
	            cons.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return gh;
	    }
		
		public static void main(String[] args) throws SQLException {
			DonGiaHan_Controller ctrl= new DonGiaHan_Controller();
			DonGiaHan ct=ctrl.getDGH("dt1");
		    	   System.out.println(ct.getLyDo());
		    	   
			  
		}
}
