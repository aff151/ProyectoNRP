
package database;
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
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ImportanciaDAO {
	public static Importancia loadImportanciaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadImportanciaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia getImportanciaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getImportanciaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadImportanciaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia getImportanciaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getImportanciaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Importancia) session.load(Importancia.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia getImportanciaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Importancia) session.get(Importancia.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Importancia) session.load(Importancia.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia getImportanciaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Importancia) session.get(Importancia.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImportancia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryImportancia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImportancia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryImportancia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia[] listImportanciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listImportanciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia[] listImportanciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listImportanciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryImportancia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Importancia as Importancia");
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
	
	public static List queryImportancia(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Importancia as Importancia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Importancia", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia[] listImportanciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryImportancia(session, condition, orderBy);
			return (Importancia[]) list.toArray(new Importancia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia[] listImportanciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryImportancia(session, condition, orderBy, lockMode);
			return (Importancia[]) list.toArray(new Importancia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadImportanciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadImportanciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Importancia[] importancias = listImportanciaByQuery(session, condition, orderBy);
		if (importancias != null && importancias.length > 0)
			return importancias[0];
		else
			return null;
	}
	
	public static Importancia loadImportanciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Importancia[] importancias = listImportanciaByQuery(session, condition, orderBy, lockMode);
		if (importancias != null && importancias.length > 0)
			return importancias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateImportanciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateImportanciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImportanciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateImportanciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImportanciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Importancia as Importancia");
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
	
	public static java.util.Iterator iterateImportanciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Importancia as Importancia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Importancia", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia createImportancia() {
		return new Importancia();
	}
	
	public static boolean save(Importancia importancia) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().saveObject(importancia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Importancia importancia) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().deleteObject(importancia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Importancia importancia)throws PersistentException {
		try {
			if (importancia.getCliente() != null) {
				importancia.getCliente().setImportancia(null);
			}
			
			if (importancia.getProyecto() != null) {
				importancia.getProyecto().setImportancia(null);
			}
			
			return delete(importancia);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Importancia importancia, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (importancia.getCliente() != null) {
				importancia.getCliente().setImportancia(null);
			}
			
			if (importancia.getProyecto() != null) {
				importancia.getProyecto().setImportancia(null);
			}
			
			try {
				session.delete(importancia);
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
	
	public static boolean refresh(Importancia importancia) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().refresh(importancia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Importancia importancia) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().evict(importancia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Importancia loadImportanciaByCriteria(ImportanciaCriteria importanciaCriteria) {
		Importancia[] importancias = listImportanciaByCriteria(importanciaCriteria);
		if(importancias == null || importancias.length == 0) {
			return null;
		}
		return importancias[0];
	}
	
	public static Importancia[] listImportanciaByCriteria(ImportanciaCriteria importanciaCriteria) {
		return importanciaCriteria.listImportancia();
	}
}
