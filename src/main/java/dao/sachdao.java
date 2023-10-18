package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.sachbean;

public class sachdao extends DBContext {
public ArrayList<sachbean> getsach() throws Exception{
	ArrayList<sachbean> ds= new ArrayList<sachbean>();
	String sql="select * from sach";
	try {
		 PreparedStatement st= connection.prepareStatement(sql);
		 ResultSet rs = st.executeQuery();
		 while(rs.next()) {
			 sachbean sbean = new sachbean(rs.getString("masach"),
					 						rs.getString("tensach"),
					 						rs.getString("tacgia"),
					 						rs.getLong("soluong"),
					 						rs.getLong("gia"),
					 						rs.getString("anh"),
					 						rs.getString("maloai")); 
			 ds.add(sbean);
		 }
	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	return ds;
}

	
}