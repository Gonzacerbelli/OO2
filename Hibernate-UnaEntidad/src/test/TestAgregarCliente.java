package test;
import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		String apellido = "Cerbelli" ;
		String nombre = "Gonzalo" ;
		int documento = 3333333;
		GregorianCalendar fechaDeNacimiento = new GregorianCalendar(); // tu fecha de nacimiento
		ClienteABM abm = new ClienteABM();
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento,fechaDeNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

