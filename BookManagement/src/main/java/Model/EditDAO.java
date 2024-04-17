package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EditDAO {
	String url = "jdbc:mysql://localhost/LastWorkDB";
	String user = "root";
	String password = "password";
	Connection conection = null;

	public void conect() throws Exception {
		// おまじない
		Class.forName("com.mysql.cj.jdbc.Driver");
		// ①DBに接続
		conection = DriverManager.getConnection(url, user, password);
	}
	
	public ArrayList<HashMap<String, String>> select() throws Exception {
		PreparedStatement statement = null;
		ResultSet results = null;
		String sql = "SELECT JAN_CD,BOOK_NM, PRICE,ISSUE_DATE FROM BOOK";
		//String sql = "SELECT * FROM employeesInfo";
		
		// DB接続メソッド呼び出し
		conect();
		// ステートメント生成
		statement = conection.prepareStatement(sql);
		
		//statement.setInt(1, user_id);
		// SQL実行
		results = statement.executeQuery();
		// 取得結果を格納

		ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
		while (results.next()) {
			HashMap<String, String> columns = new HashMap<String, String>();
			
			String id = results.getString("JAN_CD");
			columns.put("id", id);

			String name = results.getString("BOOK_NM");
			columns.put("name", name);

			String price = results.getString("PRICE");
			columns.put("price", price);

			String date = results.getString("ISSUE_DATE");
			columns.put("date", date);

			rows.add(columns);
		}
		return rows;
	}
	
	public void update(String id, String name , String price ,String date) throws Exception {

		PreparedStatement statement = null;
		String sql = "UPDATE BOOK SET BOOK_NM = ?, PRICE = ?,ISSUE_DATE = ? ,CREATE_DATETIME = CURRENT_TIMESTAMP WHERE ISBN_CD = ?";
		
		// DB接続メソッド呼び出し
		conect();
		// ステートメント生成
		statement = conection.prepareStatement(sql);
		
		statement.setString(4, id);
		statement.setString(1, name);
		statement.setString(2,price);
		statement.setString(3,date);
		
		statement.executeUpdate();
	}
	
	public boolean isNumeric(String str) {
		if (str == "") {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	
}