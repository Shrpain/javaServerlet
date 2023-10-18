package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bo.giohangbo;

/**
 * Servlet implementation class xoacontroller
 */
public class xoacontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoacontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		giohangbo ghbo = (giohangbo) session.getAttribute("gh");
		String ms = request.getParameter("ms");
		String ms1 = request.getParameter("ms1");
		String tru = request.getParameter("tru");
		String cong = request.getParameter("cong");
		String[] itemsToDelete = request.getParameterValues("itemToDelete");
		try {
			if (ms != null) {
				ghbo.Xoahang(ms);
			}
			String xoaall = request.getParameter("xoa");
			if (xoaall != null) {
				session.removeAttribute("gh");
			}
			if (tru != null) {
				ghbo.tru(ms1);
			}
			if (cong != null) {
				ghbo.Cong(ms1);
			}
			
			if(itemsToDelete != null){
				if (ghbo != null) {
		            // Xóa các mặt hàng đã chọn
		            for (String itemIndex : itemsToDelete) {
		                int index = Integer.parseInt(itemIndex);
		                ghbo.XoaMuc(index);
		            }
		            
		            // Lưu lại giỏ hàng đã cập nhật
		            session.setAttribute("gh", ghbo);
		        }
			}
			if (request.getParameter("deleteAll") != null) {
		        
		        if (ghbo != null) {
		            ghbo.XoaALL();
		            session.setAttribute("gh", ghbo);
		        }
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}	
		 RequestDispatcher rd = request.getRequestDispatcher("dathangcontroller");
         rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
