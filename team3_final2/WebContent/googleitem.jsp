<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>googl-E</title>
<style>div{text-align:center}</style>

</head>
<body bgcolor="#CCDDFF">

<%
String[][] orderList = (String[][])  request.getAttribute("final");
for(int i =0 ; i < orderList.length;i++){%>
	<div>
	<a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br>
	<h style="font-size:5px ;"><%= orderList[i][1] %></h><br><br>
	</div>
<%
}
%>

<div>
<a href="http://localhost:8080/team3_final/Server"><img src="./image/again.png" alt="googl-E"
			title="standing for e-sports google" width="550" height="100"></a>
</div>
</body>
</html>
