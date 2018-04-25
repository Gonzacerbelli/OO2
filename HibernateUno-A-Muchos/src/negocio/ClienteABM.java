package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();

	public Cliente traerCliente(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception("El cliente no existe.");
		}
		return c;
	}

	public Cliente traerCliente(int dni) throws Exception {
		Cliente c = dao.traerCliente(dni);
		// implementar si c es null lanzar Exception
		if (c == null) {
			throw new Exception("El cliente no existe.");
		}
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) throws Exception {
		// consultar si existe un cliente con el mismo dni , si existe arrojar la
		// Excepcion
		Cliente clienteAux = dao.traerCliente(dni);
		if (clienteAux != null) {
			throw new Exception("Existe un cliente con el mismo dni.");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
		Cliente clienteAux = dao.traerCliente(c.getDni());
		if (clienteAux == null) {
			clienteAux = dao.traerCliente(c.getIdCliente());
			if (clienteAux == null) {
				dao.actualizar(c);
			} else {
				throw new Exception("Existe un cliente con el mismo id.");
			}
		} else {
			throw new Exception("Existe un cliente con el mismo dni.");
		}
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		
		if(c == null) {
			throw new Exception("El cliente no existe.");
		}
		
		dao.eliminar(c);
	}

	public List<Cliente> traerCliente() {
		return dao.traerCliente();
	}
	
	public Cliente traerClienteYPrestamos(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		if(c == null) {
			throw new Exception("El cliente no existe.");
		}
		
		///¿COMO TRAIGO LOS PRESTAMOS?¿YA LOS TENGO EN EL SET?
		//inner join fetch y traigo los prestamos 
		return c;
	}
}