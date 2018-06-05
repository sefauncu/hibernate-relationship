<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<center>
		<h2>Kulup Baskani Ekle</h2>
		<form:form modelAttribute="newBaskan" method="POST"
			action="/SpringHibernateActivity/saveBaskan">
			<table>
				<tr>
					<td><form:label path="baskanId">Baskan ID:</form:label></td>
					<td><form:input path="baskanId" value="${baskan.baskanId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="baskanAdSoyad">Baskan Ad Soyad:</form:label></td>
					<td><form:input path="baskanAdSoyad"
							value="${baskan.baskanAdSoyad}" /></td>
				</tr>


				<tr>
					<td><form:label path="baskanMail">Baskan Mail:</form:label></td>
					<td><form:input path="baskanMail" value="${baskan.baskanMail}" /></td>
				</tr>
				<tr>
					<td><form:label path="baskanTelefon">Baskan Telefon:</form:label></td>
					<td><form:input path="baskanTelefon"
							value="${baskan.baskanTelefon}" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Kaydet" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<c:if test="${!empty baskanlar}">
			<table align="center" border="1">
				<tr>
					<th>Baskan ID</th>
					<th>Baskan Ad Soyad</th>
					<th>Baskan Mail</th>
					<th>Baskan Telefon</th>
					<th>Duzenle</th>
					<th>Sil</th>
				</tr>

				<c:forEach items="${baskanlar}" var="baskan">
					<tr>
						<td><c:out value="${baskan.baskanId}" /></td>
						<td><c:out value="${baskan.baskanAdSoyad}" /></td>
						<td><c:out value="${baskan.baskanMail}" /></td>
						<td><c:out value="${baskan.baskanTelefon}" /></td>
						<td><a href="<c:url value="/editBaskan?baskanId=${baskan.baskanId}"/>">Duzenle</a></td>
						<td><a href="<c:url value="/deleteBaskan?baskanId=${baskan.baskanId}"/>">Sil</a></td>
							
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