package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {

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
	
	public int agregar(Prestamo objeto) {
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
	
	public void actualizar(Prestamo objeto) throws HibernateException {
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
	
	public void eliminar(Prestamo objeto) throws HibernateException {
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
	
	public Prestamo traerPrestamo(long idPrestamo) throws HibernateException{
		Prestamo obj = null;
		try {
			iniciarOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo="+idPrestamo;
			obj = (Prestamo) session.createQuery(hQL).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamo> traerPrestamo(Cliente c) throws HibernateException{
		List<Prestamo> lista = null;
		try {
			iniciarOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where c.idCliente="+c.getIdCliente();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	
}
