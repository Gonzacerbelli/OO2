<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Francés</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<BR>
	<BR> Listado utilizando JSTL
	<table border="1">
		<tr>
			<th>Cliente</th>
			<th>DNI</th>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
				<td>${cliente.apellido},${cliente.nombre}</td>
				<td>${cliente.documento}</td>
			</tr>
		</c:forEach>
	</table>
	<BR>
	<A href="/ClientePrestamo/index.jsp">Volver...</A>
</body>
</html>