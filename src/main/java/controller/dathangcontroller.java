package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bo.giohangbo;

/**
 * Servlet implementation class dathangcontroller
 */
public class dathangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dathangcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			giohangbo gbo = new giohangbo();
			// Xử lý yêu cầu khi được gọi qua phương thức GET
			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String tg = request.getParameter("tg");
			String anh = request.getParameter("anh");
			String gia = request.getParameter("gia");
			Long sl = (long) 0;

			if (ms != null && ts != null && tg != null && anh != null) {
				// them sp
				

				if (request.getSession().getAttribute("gh") == null) {
					request.getSession().setAttribute("gh", gbo);
				}

				gbo = (giohangbo) request.getSession().getAttribute("gh");
				gbo.Themhang(ms, ts, tg, sl, Long.parseLong(gia), anh);
				request.getSession().setAttribute("gh", gbo);
				RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
				request.setAttribute("gh", gbo); 
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// Xử lý ngoại lệ (exception) tại đây, ví dụ: ghi log hoặc thông báo lỗi
		}
		RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
		giohangbo gbo = new giohangbo();
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
