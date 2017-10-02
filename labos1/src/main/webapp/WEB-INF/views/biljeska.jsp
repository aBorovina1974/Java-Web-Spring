<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bilješka</title>
</head>
<body>
<div align="center">
<h1>${biljeska.naslov}</h1>
<p>${biljeska.text}</p>

<p>Napisao: ${biljeska.korisnik.punoIme}, korisničko ime: 
            ${biljeska.korisnik.korisnickoIme}</p>
 
<p>Nalazite se u bilježnici: ${biljeska.biljeznica.naziv}</p>
<p>Sadržaj bilježnice: ${biljeska.biljeznica.opisSadrzaja}</p>
 
<form action="./napraviNovuBiljesku" method="get">
<input type="submit" value="Napravi novu bilješku"/>
</form>
</div>
</body>
</html>