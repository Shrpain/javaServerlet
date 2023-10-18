package bean;

import bo.giohangbo;

public class DangNhap {
	private String TenDangNhap,MatKhau;
	private int Quyen;
	private giohangbo GHB;
	public DangNhap(String tenDangNhap, String matKhau, int quyen) {
		super();
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Quyen = quyen;
		this.GHB = new giohangbo();
	}
	
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public int getQuyen() {
		return Quyen;
	}
	public void setQuyen(int quyen) {
		Quyen = quyen;
	}
	public giohangbo getGHB() {
		return GHB;
	}
	public void setGHB(giohangbo gHB) {
		GHB = gHB;
	}
	
	
	

}
