package dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class CuotaDao {

	private static Session session;
	private Transaction tx;
	
	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}
	
	public int agregar(Cuota objeto) {
		int id = 0;
		try {
			iniciarOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Cuota objeto) throws HibernateException {
		try {
			iniciarOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Cuota objeto) throws HibernateException {
		try {
			iniciarOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Cuota traerCuota(int nroCuota) throws HibernateException {
		Cuota objeto = null;
		try {
			iniciarOperacion();
			objeto = (Cuota) session.get(Cuota.class, nroCuota);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Cuota traerCuota(long idCuota) throws HibernateException {
		Cuota objeto = null;
		try {
			iniciarOperacion();
			objeto = (Cuota) session.get(Cuota.class, idCuota);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traerCuotas(Prestamo p) throws HibernateException {
		List<Cuota> lista = null;
		try {
			iniciarOperacion();
			String hQL = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo=" + p.getIdPrestamo();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
}
