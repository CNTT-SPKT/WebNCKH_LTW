package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import Model.DonGiaHan;
import Packages.DBConnect;

public class DonGiaHan_Controller {
		public ArrayList<DonGiaHan> getListDonGiaHan() {
	        Connection cons = DBConnect.getConnecttion();
	        String sql = "SELECT * FROM DonGiaHan";
	        ArrayList<DonGiaHan> list = new ArrayList<>();
	        try {
	            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
	            ResultSet rs = (ResultSet) ps.executeQuery();
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
	            ResultSet rs = (ResultSet) ps.executeQuery();
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
}
