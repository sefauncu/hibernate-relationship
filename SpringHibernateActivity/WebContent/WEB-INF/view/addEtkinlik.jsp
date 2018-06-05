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
		<h2>Yeni Etkinlik Ekle</h2>
		<form:form modelAttribute="newEtkinlik" method="POST"
			action="/SpringHibernateActivity/saveEtkinlik">
			<table>
				<tr>
					<td><form:label path="id">Etkinlik ID:</form:label></td>
					<td><form:input path="id" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="name"> Ad:</form:label></td>
					<td><form:input path="name" value="${etkinlik.name}" /></td>
				</tr>
				<tr>
					<td><form:label path="content"> Detay:</form:label></td>
					<td><form:input path="content" value="${etkinlik.content}" /></td>
				</tr>
				<tr>
					<td><form:label path="address"> Adres:</form:label></td>
					<td><form:input path="address" value="${etkinlik.address}" /></td>
				</tr>

				<tr>

					<td><form:label path="kulup.kulupId">Kulup Bilgi:</form:label>
					</td>
					<td><form:select path="kulup.kulupId" cssStyle="width: 150px;">
							<option value="-1">Kulup Sec !</option>
							<c:forEach items="${kulupler}" var="kulup">
								<option value="${kulup.kulupId}">${kulup.kulupAd}</option>
							</c:forEach>
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
		<c:if test="${!empty etkinlikler}">
			<table align="center" border="1">
				<tr>
					<th>ID</th>
					<th>Ad</th>
					<th>Detay</th>
					<th>Adres</th>
					<th>Kulup</th>
					<th>Ayarlar</th>
				</tr>

				<c:forEach items="${etkinlikler}" var="etkinlik">
					<tr>
						<td><c:out value="${etkinlik.id}" /></td>
						<td><c:out value="${etkinlik.name}" /></td>
						<td><c:out value="${etkinlik.content}" /></td>
						<td><c:out value="${etkinlik.address}" /></td>
						<td><c:out value="${etkinlik.kulup.kulupAd}" /></td>
						<td align="center"><a href="editEtkinlik?id=${etkinlik.id}">Duzenle</a>
							| <a href="deleteEtkinlik?id=${etkinlik.id}">Sil</a></td>
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