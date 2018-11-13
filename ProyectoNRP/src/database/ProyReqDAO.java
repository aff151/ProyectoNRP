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

public class ProyReqDAO {
	public static ProyReq loadProyReqByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyReqByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq getProyReqByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getProyReqByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyReqByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq getProyReqByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getProyReqByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ProyReq) session.load(database.ProyReq.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq getProyReqByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ProyReq) session.get(database.ProyReq.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProyReq) session.load(database.ProyReq.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq getProyReqByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProyReq) session.get(database.ProyReq.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyReq(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryProyReq(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyReq(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryProyReq(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq[] listProyReqByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listProyReqByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq[] listProyReqByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listProyReqByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyReq(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.ProyReq as ProyReq");
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
	
	public static List queryProyReq(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.ProyReq as ProyReq");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ProyReq", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq[] listProyReqByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProyReq(session, condition, orderBy);
			return (ProyReq[]) list.toArray(new ProyReq[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq[] listProyReqByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProyReq(session, condition, orderBy, lockMode);
			return (ProyReq[]) list.toArray(new ProyReq[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyReqByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyReqByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ProyReq[] proyReqs = listProyReqByQuery(session, condition, orderBy);
		if (proyReqs != null && proyReqs.length > 0)
			return proyReqs[0];
		else
			return null;
	}
	
	public static ProyReq loadProyReqByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ProyReq[] proyReqs = listProyReqByQuery(session, condition, orderBy, lockMode);
		if (proyReqs != null && proyReqs.length > 0)
			return proyReqs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProyReqByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateProyReqByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProyReqByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateProyReqByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProyReqByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.ProyReq as ProyReq");
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
	
	public static java.util.Iterator iterateProyReqByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From database.ProyReq as ProyReq");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ProyReq", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq createProyReq() {
		return new database.ProyReq();
	}
	
	public static boolean save(database.ProyReq proyReq) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().saveObject(proyReq);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(database.ProyReq proyReq) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().deleteObject(proyReq);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(database.ProyReq proyReq)throws PersistentException {
		try {
			if (proyReq.getProyecto() != null) {
				proyReq.getProyecto().proyReqs.remove(proyReq);
			}
			
			if (proyReq.getRequisito() != null) {
				proyReq.getRequisito().proyReqs.remove(proyReq);
			}
			
			return delete(proyReq);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(database.ProyReq proyReq, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (proyReq.getProyecto() != null) {
				proyReq.getProyecto().proyReqs.remove(proyReq);
			}
			
			if (proyReq.getRequisito() != null) {
				proyReq.getRequisito().proyReqs.remove(proyReq);
			}
			
			try {
				session.delete(proyReq);
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
	
	public static boolean refresh(database.ProyReq proyReq) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().refresh(proyReq);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(database.ProyReq proyReq) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().evict(proyReq);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProyReq loadProyReqByCriteria(ProyReqCriteria proyReqCriteria) {
		ProyReq[] proyReqs = listProyReqByCriteria(proyReqCriteria);
		if(proyReqs == null || proyReqs.length == 0) {
			return null;
		}
		return proyReqs[0];
	}
	
	public static ProyReq[] listProyReqByCriteria(ProyReqCriteria proyReqCriteria) {
		return proyReqCriteria.listProyReq();
	}
}
