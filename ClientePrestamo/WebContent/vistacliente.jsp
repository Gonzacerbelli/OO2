<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClientePrestamo</title>
</head>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
	<BR> Apellido:
	<%=cliente.getApellido()%><BR> Nombre :
	<%=cliente.getNombre()%><BR> DNI :
	<%=cliente.getDni()%><BR> ID :
	<%=cliente.getIdCliente()%><BR>
	<BR>
	<A href="/ClientePrestamo/index.jsp">Volver...</A>
</BODY>
</html>