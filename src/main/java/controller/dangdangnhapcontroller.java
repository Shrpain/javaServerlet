package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bean.TaiKhoan;
import bo.giohangbo;
import dao.dangnhapdao;

/**
 * Servlet implementation class dangdangnhapcontroller
 */
public class dangdangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangdangnhapcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("log.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String u = request.getParameter("taikhoan");
		String p = request.getParameter("matkhau");
		dangnhapdao dn = new dangnhapdao();
		TaiKhoan d = dn.check(u, p);
		HttpSession ss = request.getSession();
		if(d==null){ 
			request.setAttribute("error", "Sai Thông tin tài khoản hoặc mật khẩu");
			request.getRequestDispatcher("log.jsp").forward(request, response);
			System.out.println("SAI THÔNG TIN TÀI KHOẢN HOẶC MẬT KHẨU!!");
		}
		else {
			
			// taoj gio hang cho tk
			giohangbo gbo = new giohangbo();
			gbo = d.getGioHang();
			ss.setAttribute("acc", d);
			ss.setAttribute("gh", gbo);
			ss.setAttribute("TenDangNhap", u);
	        request.getRequestDispatcher("sachcontroller").forward(request, response);
	        System.out.println("Đăng Nhập Thành Công!!");
	        System.out.println("Xin chào " + u); // In ra console
	     }
		
		}
			
		
	}


