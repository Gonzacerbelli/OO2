package negocio;

import java.util.GregorianCalendar;

import datos.Cuota;

public class CuotaABM {
	
	private CuotaABM dao = new CuotaABM();
	
	public int agregar(int nroCuota, GregorianCalendar fechaVencimiento, double saldoPendiente, double amortizacion, double interesCuota, double cuota, double deuda, boolean cancelada, GregorianCalendar fechaDePago, double punitorios) {
		Cuota cuotaAux = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda, cancelada, fechaDePago, punitorios);
		return dao.agregar(cuotaAux);
	}
	
	/*
	public void modificar(Cuota c) throws Exception {
		Cuota cuotaAux = dao.traerPrestamo(p.getIdPrestamo());
		if (cuotaAux == null) {
			dao.actualizar(p);
		} else {
			throw new Exception("Existe un prestamo con el mismo id.");
		}
	}

	public void eliminar(long idPrestamo) throws Exception {
		Cuota c = dao.traerPrestamo(idPrestamo);
		if(p == null) {
			throw new Exception("El prestamo no existe.");
		}
		dao.eliminar(p);
	}
	*/

}
