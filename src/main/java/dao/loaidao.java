package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;


public class loaidao extends DBContext {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		String sql="select * from loai";
		try {
			 PreparedStatement st= connection.prepareStatement(sql);
			 ResultSet rs = st.executeQuery();
			 while(rs.next()) {
				 loaibean lbean = new loaibean(rs.getString("maloai"),
						 						rs.getString("tenloai")); 
				 ds.add(lbean);
			 }
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return ds;
	}
}