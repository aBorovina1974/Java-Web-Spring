<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Potvrda spremanja</title>
</head>
<body>
<h1 align="center">Pregled bilješke prije spremanja</h1>
<form action="./spremiBiljesku" method="post">
<table align="center">
<tr>
<td>Korisnik:</td>
<td>${punoIme}</td>
</tr>
<tr>
<td>Bilježnica:</td>
<td>${novaBiljeskaForm.nazivBiljeznice}</td>
</tr>
<tr>
<td>Naslov:</td>
<td>${novaBiljeskaForm.naslovBiljeske}</td>
</tr>
<tr>
<td>Tekst:</td>
<td>${novaBiljeskaForm.text}</td>
</tr>
<tr>
<td>
<input type="button" value="Vrati se na uređivanje bilješke"
 onclick="window.location.href='http://localhost:8080/labos1/novaBiljeska'"/>
</td>
<td>
<input type="submit" value="Spremi bilješku"/>
</td>
</tr>
</table>
</form>
</body>
</html>