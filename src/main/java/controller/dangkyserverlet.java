package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bean.TaiKhoan;
import dao.dangnhapdao;

/**
 * Servlet implementation class dangkyserverlet
 */
public class dangkyserverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyserverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u = request.getParameter("taikhoan");
		String p = request.getParameter("matkhau");
		dangnhapdao dn = new dangnhapdao();
		TaiKhoan d = dn.check(u, p);
		if(d!=null || (dn.kiemTraTenTK(u))) {
			// quay ve dang ky lai
			request.setAttribute("error", "Tài Khoản Đã Tồn Tại");
			request.getRequestDispatcher("dangky.jsp").forward(request, response);
			System.out.println("Tài Khoản Đã Tồn Tại");
		}else {
			// chuwa co tk
			System.out.println("Tài Khoản Chưa Có Trong Database");
			TaiKhoan tk1 = new TaiKhoan(u,p);
			dn.DangKy(tk1);
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
