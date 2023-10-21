package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.DangNhap;

public class dangnhapdao extends DBContext {
	public DangNhap check(String TenDangNhap,String MatKhau) {
		
		String sql="SELECT [TenDangNhap]\r\n"
				+ "      ,[MatKhau]\r\n"
				+ "      ,[Quyen]\r\n"
				+ "  FROM [dbo].[DangNhap]\r\n"
				+ "  where TenDangNhap=?, MatKhau=?";
		try {
			PreparedStatement pt =connection.prepareStatement(sql);
			pt.setString(1, TenDangNhap);
			pt.setString(2, MatKhau);
			ResultSet rs=pt.executeQuery();
			if(rs.next()) {
				DangNhap dn = new DangNhap(rs.getString("TenDangNhap"),
										   rs.getString("MatKhau"),
										   rs.getInt("Quyen"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
