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
			
			clienteABM.agregar("Cabrera", "Pablo", 39147259, new GregorianCalendar());
			
			
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
		
		try {
			
			System.out.println("\n\ntraigo cliente \n");
			
			Cliente cliente = clienteABM.traerCliente(39147259);
			
			System.out.println(cliente);
			
			System.out.println(" \ncreo prestamo con cuotas \n");
			
			prestamoABM.agregar(new GregorianCalendar(), 15000, 43.75, 6, cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
