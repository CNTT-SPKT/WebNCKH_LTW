package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

import Model.BaoCaoDT;
import Model.DeTai;
import Packages.DBConnect;

public class BaoCaoDT_Controller {
	public BaoCaoDT getBaoCaoDT(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM BaoCaoDT,DeTai where DeTai.MaDT=BaoCaoDT.MaDT and MaDT='"+maDT+"'";
        BaoCaoDT bc = new BaoCaoDT();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setTenBC(rs.getString("TenBC"));
            	bc.setTenDT(rs.getString("TenDT"));
            	
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
	public ArrayList<BaoCaoDT> getListBaoCaoDT(String maDT) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM BaoCaoDT,DeTai where "+
        " DeTai.MaDT=BaoCaoDT.MaDT and DeTai.MaDT='"+maDT+"'";
        
        ArrayList<BaoCaoDT> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	BaoCaoDT bc = new BaoCaoDT();
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("DeTai.MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setTenBC(rs.getString("TenBC"));
            	bc.setTenDT(rs.getString("TenDT"));
            	list.add(bc);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public BaoCaoDT getBaoCaoDTByMaBC(String maBC) {
        Connection cons = DBConnect.getConnecttion();
        String sql = "SELECT * FROM BaoCaoDT where MaBC='"+maBC+"'";
        BaoCaoDT bc = new BaoCaoDT();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
            	
            	bc.setMaBC(rs.getString("MaBC"));
            	bc.setMaDT(rs.getString("MaDT"));
            	bc.setNgayBC(rs.getString("NgayBC"));
            	bc.setTenBC(rs.getString("TenBC"));
            	bc.setFileBC(rs.getString("FileBC"));
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }
	public static void main(String[] args) throws SQLException {
		BaoCaoDT_Controller ctrl= new BaoCaoDT_Controller();
	       for(BaoCaoDT ct:ctrl.getListBaoCaoDT("dt1"))
	       {
	    	   System.out.println(ct.getTenDT()+"______"+ct.getTenBC()+"_______"+ct.getNgayBC());
	    	   
	       }
	}

}
