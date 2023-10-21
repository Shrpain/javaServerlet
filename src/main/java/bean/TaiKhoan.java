package bean;

import bo.giohangbo;

public class TaiKhoan {
	private String taikhoan,matkhau;
	private giohangbo GHB;
	
	public TaiKhoan() {
		
	}
	public TaiKhoan(String tenDangNhap, String matKhau ) {
		super();
		taikhoan = tenDangNhap;
		matkhau = matKhau;
		this.GHB = new giohangbo();
	}
	public giohangbo getGioHang() {
        return GHB;
    }

    public void setGioHang(giohangbo gioHang) {
        this.GHB = gioHang;
    }
	
	public String getTenDangNhap() {
		return taikhoan;
	}
	public void setTenDangNhap(String tenDangNhap) {
		taikhoan = tenDangNhap;
	}
	public String getMatKhau() {
		return matkhau;
	}
	public void setMatKhau(String matKhau) {
		matkhau = matKhau;
	}
	
	public giohangbo getGHB() {
		return GHB;
	}
	public void setGHB(giohangbo gHB) {
		GHB = gHB;
	}
	
	
	

}
