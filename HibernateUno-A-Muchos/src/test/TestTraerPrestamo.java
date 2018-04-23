package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args) {

		
		try {
			PrestamoABM prestamoABM = new PrestamoABM();
			long idPrestamo = 1;
			
			System.out.println("\n---> TraerPerstamo idPrestamo="+idPrestamo+"\n\n");
			Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p +"\nPertenece a "+p.getCliente());
			
			ClienteABM clienteABM = new ClienteABM();
			int dni = 14000000;
			Cliente c = clienteABM.traerCliente(dni);
			
			System.out.println("\n---> TraerPerstamo del cliente="+c+"\n\n");
			List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
			for (Prestamo o : prestamos) {
				System.out.println(o + "\nPertenece a "+ o.getCliente());
			}
			
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
		
		
		
	}

}
