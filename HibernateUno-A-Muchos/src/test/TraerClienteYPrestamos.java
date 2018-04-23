package test;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;

public class TraerClienteYPrestamos {

	public static void main(String[] args) {

		try {
			
			long idCliente = 1;
			
			ClienteABM cliAbm = new ClienteABM();
			
			Cliente c = cliAbm.traerClienteYPrestamos(idCliente);
			
			System.out.println("\n---> Traer Cliente y Prestmos idCliente="+idCliente);
			System.out.println("\n"+c);
			for (Prestamo p : c.getPrestamos()) {
				System.out.println("\n"+p);
			}
			
			
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}

	}

}
