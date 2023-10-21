package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.TaiKhoan;

public class dangnhapdao extends DBContext {
	public TaiKhoan check(String taikhoan, String matkhau) {

		String sql = "SELECT [TenDangNhap]\r\n" + "      ,[MatKhau]\r\n" + "  FROM [dbo].[DangNhap]\r\n"
				+ "  where TenDangNhap=? AND MatKhau=?";
		try {
			PreparedStatement pt = connection.prepareStatement(sql);
			pt.setString(1, taikhoan);
			pt.setString(2, matkhau);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				TaiKhoan dn = new TaiKhoan(rs.getString("TenDangNhap"), rs.getString("MatKhau"));
				return dn;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public boolean kiemTraTenTK(String taikhoan) {

		String sql = "SELECT *" + "  FROM [dbo].[DangNhap]\r\n" + "  where TenDangNhap=?";
		try {
			PreparedStatement pt = connection.prepareStatement(sql);
			pt.setString(1, taikhoan);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	// check dang ky
	public void DangKy(TaiKhoan tk) {
		String sql = "INSERT INTO [dbo].[DangNhap] (TenDangNhap, MatKhau) VALUES (?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, tk.getTenDangNhap());
			st.setString(2, tk.getMatKhau()); 
			st.executeUpdate();
			System.out.println("Tạo Tài Khoản Thành Công");
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Tạo Tài Khoản Không Thành Công");
		}
	}

}
