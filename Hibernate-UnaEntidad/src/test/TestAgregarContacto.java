package test;

import dao.ClienteDao;
import dao.ContactoDao;
import datos.Contacto;
import datos.Cliente;

public class TestAgregarContacto {

	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		long idCliente = 1;
		Cliente c = dao.traerCliente(idCliente);
		System.out.println(c);
		Contacto con = new Contacto("ajaramillo@unla.edu.ar","11-1111-11","11-1111-1111", c);
		ContactoDao dao1 = new ContactoDao();
		dao1.agregar(con);
	}

}
