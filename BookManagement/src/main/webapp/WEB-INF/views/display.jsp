<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
	%>
	<form action="index" method="POST">
	
	<table border="1">
		<tr>
			<th>書籍名</th>
			<th>価格</th>
			<th>発行日</th>
		</tr>
		<%
		for (HashMap<String, String> columns : rows) {
		%>
		<tr>
				<td><%=columns.get("name")%></td>
				<td><%=columns.get("price")%></td>
				<td><%=columns.get("date")%></td>
				
				</form>
				<form action="update" method="GET">
				<td><button type="submit" value="update" class="btn" name="action">更新</button></td>
				<input type="hidden" name="id" value=<%=columns.get("id")%>>
				<input type="hidden" name="name" value=<%=columns.get("name")%>>
				<input type="hidden" name="price" value=<%=columns.get("price")%>>
				<input type="hidden" name="date" value=<%=columns.get("date")%>>
				</form>
		</tr>
		<%}%>
	</table>
</body>
</html>