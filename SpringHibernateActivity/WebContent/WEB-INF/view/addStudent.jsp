<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h2>Yeni Ogrenci Ekle</h2>
		<form:form modelAttribute="newStudent" method="POST"
			action="/SpringHibernateActivity/saveStudent">
			<table>
				<tr>
					<td><form:label path="id">Ogrenci ID:</form:label></td>
					<td><form:input path="id" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="name"> Ad:</form:label></td>
					<td><form:input path="name" value="${ogrenci.name}" /></td>
				</tr>
				<tr>
					<td><form:label path="mail">Mail:</form:label></td>
					<td><form:input path="mail" value="${ogrenci.mail}" /></td>
				</tr>

				<tr>
					<td><form:label path="etkinliks">Etkinlik Bilgi:</form:label>
					</td>
					<td><form:select path="etkinliks" items="${etkinlikler}"
							itemLabel="name" itemValue="id" cssStyle="width: 150px;">
						</form:select></td>
				</tr>
				<tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Kaydet" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<c:if test="${!empty ogrenciler}">
			<table align="center" border="1">
				<tr>
					<th>ID</th>
					<th>Ad</th>
					<th>Mail</th>
					<th>Ayarlar</th>
				</tr>

				<c:forEach items="${ogrenciler}" var="ogrenci">
					<tr>
						<td><c:out value="${ogrenci.id}" /></td>
						<td><c:out value="${ogrenci.name}" /></td>
						<td><c:out value="${ogrenci.mail}" /></td>


						<td align="center"><a href="editOgrenci?id=${ogrenci.id}">Duzenle</a>
							| <a href="deleteOgrenci?id=${ogrenci.id}">Sil</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<h2>
			<a href="/SpringHibernateActivity/">Anasayfa</a>
		</h2>
	</center>
</body>
</html>