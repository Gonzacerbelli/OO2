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

	public int agregar(int nroCuota, Prestamo prestamo) {
		Cuota cuotaAux = new Cuota(nroCuota, prestamo);
		return dao.agregar(cuotaAux);
	}
	
	public void modificar(Cuota c) throws Exception {
		Cuota cuotaAux = dao.traerCuota(c.getIdCuota());
		if (cuotaAux != null) {
			dao.actualizar(cuotaAux);
		} else {
			throw new Exception("No existe una cuota con el id.");
		}
	}
	
	public void eliminar(long idCuota) throws Exception {
		Cuota c = dao.traerCuota(idCuota);
		if(c == null) {
			throw new Exception("La cuota no existe.");
		}
		dao.eliminar(c);
	}
	

}
