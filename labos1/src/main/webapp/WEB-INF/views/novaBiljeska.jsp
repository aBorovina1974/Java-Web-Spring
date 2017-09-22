<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bilježnica</title>
</head>
<body>
<h1 align="center">Nova bilješka</h1>
<div align="center">
<form:form modelAttribute="novaBiljeskaForm" method="POST">
<table>
<tr>
<td>Korisnik:</td>
<td>
<form:select id="korisnikId" path="korisnikId">
<form:options items="${korisnici}" itemLabel="punoIme"  itemValue="korisnikId"/>
</form:select>
</td>
</tr>
<tr>
<td>Bilježnica:</td>
<td>
<form:select id="biljeznicaId" path="nazivBiljeznice">
<form:options items="${biljeznice}"  itemValue="naziv" />
</form:select>
</td>
</tr>
<tr>
<td>Naslov:</td>
<td>
<form:input path="naslovBiljeske"/>
</td>
</tr>
<tr>
<td>Text:</td>
<td>
<form:textarea path="text" rows="10" cols="30"/>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Spremi bilješku"/>
</td>
</tr>
</table>
</form:form>
</div>
</body>
</html>