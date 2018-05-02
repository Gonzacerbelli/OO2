package negocio;

import dao.PrestamoDao;
import java.util.GregorianCalendar;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {

	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if (p == null) {
			throw new Exception("El prestamo no existe.");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) throws Exception {
		List<Prestamo> prestamosAux = dao.traerPrestamo(c);
		if (prestamosAux.size() == 0) {
			throw new Exception("El cliente no tiene prestamos otorgados.");
		}
		return dao.traerPrestamo(c);
	}

	public int agregar(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception {
		Prestamo prestamoAux = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(prestamoAux);
	}

	public void modificar(Prestamo p) throws Exception {
		Prestamo prestamoAux = dao.traerPrestamo(p.getIdPrestamo());
		if (prestamoAux == null) {
			throw new Exception("No existe el prestamo que se quiere modificar.");
		} else {
			dao.actualizar(p);
		}
	}

	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if (p == null) {
			throw new Exception("El prestamo no existe.");
		}
		dao.eliminar(p);
	}

}
