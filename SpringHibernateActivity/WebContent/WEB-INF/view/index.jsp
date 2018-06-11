<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<center>
		<h2 style="color: gray; font-weight: bold;">Anasayfa</h2>

		<br />

		<h2>
			<a style="color: red" href="addKulup">Kulup Ekle</a>
		</h2>
		<br />

		<h2>
			<a style="color: black" href="addEtkinlik">Etkinlik Ekle</a>
		</h2>
		<br />

		<h2>
			<a style="color: red" href="addBaskan">Baskan Ekle</a>
		</h2>
		<h2>
			<a style="color: blue" href="${pageContext.request.contextPath}/api/presidents">Baskanlar</a>
		</h2>
		
		<h2>
			<a style="color: black" href="addOgrenci">Ogrenci Ekle</a>
		</h2>
	</center>
</body>
</html>