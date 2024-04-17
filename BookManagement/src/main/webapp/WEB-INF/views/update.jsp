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
<h1>編集</h1>
	<h2>編集前</h2>
	<label>書籍名：</label><%=request.getAttribute("name")%><br>
	<label>価格：</label><%=request.getAttribute("price")%><br>
	<label>発行日：</label><%=request.getAttribute("date")%>
	
	<h2>編集</h2>
    <form method="POST" action="update">
        <label for="name">書籍名:</label>
        <input type="text" id="name" name="name"><br>
        
        <div style="color:red">
        <%if(request.getAttribute("error") != null){%>
        <%=request.getAttribute("error") %>
        <%} %>
        </div>
        <label for="dpt">価格:</label>
        <input type="text" id="price" name="price"><br>
        
         <label for="position">発行日:</label>
         <input type="date" id="date" name="date"><br>
         
        <input type="hidden" name="id" value=<%=request.getAttribute("id")%>>
        <button type="submit">更新</button>
    </form>

</body>
</html>