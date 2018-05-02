package negocio;

import dao.CuotaDao;
import java.util.GregorianCalendar;
import java.util.List;
import datos.Prestamo;
import datos.Cuota;

public class CuotaABM {
	
	CuotaDao dao = new CuotaDao();
	
	public Cuota traerCuota(long idCuota) throws Exception {
		Cuota c = dao.traerCuota(idCuota);
		if(c == null) {
			throw new Exception("La cuota no existe.");
		}
		return c;
	}
	
	public List<Cuota> traerCuotas(Prestamo p) throws Exception {
		List<Cuota> cuotasAux = dao.traerCuotas(p);
		if(cuotasAux.size() == 0) {
			throw new Exception("El prestamo no tiene cuotas.");
		}
		return dao.traerCuotas(p);
	}

	public int agregar(int nroCuota, GregorianCalendar fechaVencimiento, double saldoPendiente, double amortizacion, double interesCuota, double cuota, double deuda, boolean cancelada, GregorianCalendar fechaDePago, double punitorios) {
		Cuota cuotaAux = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda, cancelada, fechaDePago, punitorios);
		return dao.agregar(cuotaAux);
	}
	
	/////////¿Tengo que traer el prestamo y despues la cuota que quiero modificar?
	public void modificar(Cuota c) throws Exception {
		Cuota cuotaAux = dao.traerCuota(c.getNroCuota());
		if (cuotaAux == null) {
			dao.actualizar(cuotaAux);
		} else {
			throw new Exception("Existe un prestamo con el mismo id.");
		}
	}
	/*
	public void eliminar(long idPrestamo) throws Exception {
		Cuota c = dao.traerPrestamo(idPrestamo);
		if(p == null) {
			throw new Exception("El prestamo no existe.");
		}
		dao.eliminar(p);
	}
	*/

}
