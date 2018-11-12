/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class PesoDAO {
	public static Peso loadPesoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadPesoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso getPesoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getPesoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadPesoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso getPesoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getPesoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Peso) session.load(database.Peso.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso getPesoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Peso) session.get(database.Peso.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Peso) session.load(database.Peso.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso getPesoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Peso) session.get(database.Peso.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeso(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryPeso(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeso(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryPeso(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso[] listPesoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listPesoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso[] listPesoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listPesoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeso(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.Peso as Peso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeso(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.Peso as Peso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Peso", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso[] listPesoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPeso(session, condition, orderBy);
			return (Peso[]) list.toArray(new Peso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso[] listPesoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPeso(session, condition, orderBy, lockMode);
			return (Peso[]) list.toArray(new Peso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadPesoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadPesoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Peso[] pesos = listPesoByQuery(session, condition, orderBy);
		if (pesos != null && pesos.length > 0)
			return pesos[0];
		else
			return null;
	}
	
	public static Peso loadPesoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Peso[] pesos = listPesoByQuery(session, condition, orderBy, lockMode);
		if (pesos != null && pesos.length > 0)
			return pesos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePesoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iteratePesoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePesoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iteratePesoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePesoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.Peso as Peso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePesoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.Peso as Peso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Peso", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso createPeso() {
		return new database.Peso();
	}
	
	public static boolean save(database.Peso peso) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().saveObject(peso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(database.Peso peso) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().deleteObject(peso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(database.Peso peso)throws PersistentException {
		try {
			if (peso.getCliente() != null) {
				peso.getCliente().pesos.remove(peso);
			}
			
			if (peso.getProyecto() != null) {
				peso.getProyecto().pesos.remove(peso);
			}
			
			if (peso.getRequisito() != null) {
				peso.getRequisito().pesos.remove(peso);
			}
			
			return delete(peso);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(database.Peso peso, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (peso.getCliente() != null) {
				peso.getCliente().pesos.remove(peso);
			}
			
			if (peso.getProyecto() != null) {
				peso.getProyecto().pesos.remove(peso);
			}
			
			if (peso.getRequisito() != null) {
				peso.getRequisito().pesos.remove(peso);
			}
			
			try {
				session.delete(peso);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(database.Peso peso) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().refresh(peso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(database.Peso peso) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().evict(peso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peso loadPesoByCriteria(PesoCriteria pesoCriteria) {
		Peso[] pesos = listPesoByCriteria(pesoCriteria);
		if(pesos == null || pesos.length == 0) {
			return null;
		}
		return pesos[0];
	}
	
	public static Peso[] listPesoByCriteria(PesoCriteria pesoCriteria) {
		return pesoCriteria.listPeso();
	}
}
