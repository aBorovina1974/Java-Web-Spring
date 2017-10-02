<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bilježnica</title>
</head>
<body>
<h1 align="center">Nova bilješka</h1>
<div align="center">
<form:form modelAttribute="novaBiljeskaForm" action="./potvrdaSpremanja" method="post">
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
<td colspan="2" align="center">
<input type="submit" value="Spremi bilješku"/>
</td>
</tr>
</table>
<table>
<tr>
<th>Bilježnica</th>
<th>Broj unesenih bilješki</th>
</tr>
<c:forEach items="${brojac}" var="entry">
<tr>
<td>${entry.key}</td>
<td>${entry.value}</td>
</tr>
</c:forEach>
</table>
</form:form>
<form action="./obrisiStatistiku" method="get">
<input type="submit" value="Obrisi statistiku"/>
</form>
</div>
</body>
</html>