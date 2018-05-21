package test;
import negocio.ClienteABM;
import negocio.PrestamoABM;
import datos.Cliente;
import java.util.GregorianCalendar;

public class TestAgregarClientePrestamoCuota {

	public static void main(String[] args) {

		ClienteABM clienteABM = new ClienteABM();
		
		PrestamoABM prestamoABM = new PrestamoABM();
		
		try {
			
			System.out.println("\n\nagrego cliente\n");
			
			clienteABM.agregar("Cerbe", "Gonzalo", 39281276, new GregorianCalendar());
			
			
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
		
		try {
			
			System.out.println("\n\ntraigo cliente \n");
			
			Cliente cliente = clienteABM.traerCliente(39281276);
			
			System.out.println(cliente);
			
			System.out.println(" \ncreo prestamo con 6 cuotas \n");
			
			prestamoABM.agregar(new GregorianCalendar(), 15000, 43.75, 6, cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
