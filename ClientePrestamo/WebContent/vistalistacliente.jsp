<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Cliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Francés</title>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>
	<BR> Listado Sin utilizar JSTL
	<table border="1">
		<tr>
			<th>Cliente</th>
			<th>DNI</th>
		</tr>
		<% List<Cliente> clientes=(List)request.getAttribute("clientes");
			for​(Cliente cliente:clientes){ %>
				<tr>
					<td><%= cliente.getApellido()+", "+cliente.getNombre() %></td>
					<td><%= cliente.getDocumento() %></td>
				</tr>
		<% } %>
	</table>
	<BR>
	<A href="/SistemaFrances/index.jsp">Volver...</A>
</body>
</html>