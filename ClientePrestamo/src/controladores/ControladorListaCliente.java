package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import datos.Cliente;
import negocio.ClienteABM;

public class ControladorListaCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		int jstl = Integer.parseInt(request.getParameter("jstl"));
		try {
			
			ClienteABM clienteabm = new ClienteABM();
			List<Cliente> clientes = clienteabm.traerCliente();
			request.setAttribute("clientes", clientes);
			
			if(jstl == 0) {
				request.getRequestDispatcher("/vistalistacliente.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/vistalistaclientejstl.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			response.sendError(500, "Hubo un problema al trael el listado de clientes.");
		}
	}
	
}
