package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EditDAO;

/**
 * Servlet implementation class ResisterController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("date", date);
		
		String view = "/WEB-INF/views/update.jsp";
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		EditDAO dao = new EditDAO();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		
		if(!dao.isNumeric(price)) {
			request.setAttribute("error", "適切な数値のみ入力してください");
			doGet(request,response);
		}
		try {
			dao.update(id,name,price,date);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// リクエストスコープへのデータ格納（リストデータの格納）
			request.setAttribute("message", "例外が発生しました");
			String view = "WEB-INF/view/error.jsp";
			// 転送オブジェクトを取得
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			// 転送
			dispatcher.forward(request, response);
		}
		String view = "/BookManagement/index";
		response.sendRedirect(view);
	}

}
