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

@WebServlet("/index")
public class DisplayController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			EditDAO dao = new EditDAO();
			request.setAttribute("rows", dao.select());
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
		String view = "/WEB-INF/views/display.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
}



