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
		<h2>Yeni Kulup Ekle</h2>
		<form:form modelAttribute="newKulup" method="POST"
			action="/SpringHibernateActivity/saveKulup">
			<table>
				<tr>
					<td><form:label path="kulupId">Kulup ID:</form:label></td>
					<td><form:input path="kulupId" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="kulupAd">Kulup Ad:</form:label></td>
					<td><form:input path="kulupAd" value="${kulup.kulupAd}" /></td>
				</tr>
				<tr>
					<td><form:label path="kulupIcerik">Kulup Detay:</form:label></td>
					<td><form:input path="kulupIcerik"
							value="${kulup.kulupIcerik}" /></td>
				</tr>
				<tr>
					<td><form:label path="kulupLogo">Kulup Logo:</form:label></td>
					<td><form:input path="kulupLogo" value="${kulup.kulupLogo}" /></td>
				</tr>
				<tr>
					<td><form:label path="baskan.baskanId">Baskan Bilgi:</form:label>
					</td>
					<td><form:select path="baskan.baskanId"
							cssStyle="width: 150px;">
							<option value="-1">Baskan Secin!!!</option>
							<c:forEach items="${baskanlar}" var="baskan">
								<option value="${baskan.baskanId}">${baskan.baskanAdSoyad}</option>
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
		<c:if test="${!empty kulupler}">
			<table align="center" border="1">
				<tr>
					<th>Kulup ID</th>
					<th>Kulup Ad</th>
					<th>Kulup Detay</th>
					<th>Kulup Logo</th>
					<th>Kulup Baskani</th>
					<th>Ayarlar</th>
				</tr>

				<c:forEach items="${kulupler}" var="kulup">
					<tr>
						<td><c:out value="${kulup.kulupId}" /></td>
						<td><c:out value="${kulup.kulupAd}" /></td>
						<td><c:out value="${kulup.kulupIcerik}" /></td>
						<td><c:out value="${kulup.kulupLogo}" /></td>
						<td><c:out value="${kulup.baskan.baskanAdSoyad}" /></td>
						<td align="center"><a
							href="editKulup?kulupId=${kulup.kulupId}">Duzenle</a> | <a
							href="deleteKulup?kulupId=${kulup.kulupId}">Sil</a></td>
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