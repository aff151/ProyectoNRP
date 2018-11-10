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

public class ProyectoDAO {
	public static Proyecto loadProyectoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyectoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto getProyectoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getProyectoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyectoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto getProyectoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return getProyectoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Proyecto) session.load(Proyecto.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto getProyectoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Proyecto) session.get(Proyecto.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Proyecto) session.load(Proyecto.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto getProyectoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Proyecto) session.get(Proyecto.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyecto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryProyecto(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyecto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return queryProyecto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto[] listProyectoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listProyectoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto[] listProyectoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return listProyectoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProyecto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Proyecto as Proyecto");
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
	
	public static List queryProyecto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Proyecto as Proyecto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Proyecto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto[] listProyectoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProyecto(session, condition, orderBy);
			return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto[] listProyectoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProyecto(session, condition, orderBy, lockMode);
			return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyectoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return loadProyectoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Proyecto[] proyectos = listProyectoByQuery(session, condition, orderBy);
		if (proyectos != null && proyectos.length > 0)
			return proyectos[0];
		else
			return null;
	}
	
	public static Proyecto loadProyectoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Proyecto[] proyectos = listProyectoByQuery(session, condition, orderBy, lockMode);
		if (proyectos != null && proyectos.length > 0)
			return proyectos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProyectoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateProyectoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProyectoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = BasededatosPersistentManager.instance().getSession();
			return iterateProyectoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProyectoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Proyecto as Proyecto");
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
	
	public static java.util.Iterator iterateProyectoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Proyecto as Proyecto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Proyecto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto createProyecto() {
		return new Proyecto();
	}
	
	public static boolean save(Proyecto proyecto) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().saveObject(proyecto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Proyecto proyecto) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().deleteObject(proyecto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Proyecto proyecto)throws PersistentException {
		try {
			if (proyecto.getImportancia() != null) {
				proyecto.getImportancia().setProyecto(null);
			}
			
			if (proyecto.getPeso() != null) {
				proyecto.getPeso().setProyecto(null);
			}
			
			return delete(proyecto);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Proyecto proyecto, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (proyecto.getImportancia() != null) {
				proyecto.getImportancia().setProyecto(null);
			}
			
			if (proyecto.getPeso() != null) {
				proyecto.getPeso().setProyecto(null);
			}
			
			try {
				session.delete(proyecto);
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
	
	public static boolean refresh(Proyecto proyecto) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().refresh(proyecto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Proyecto proyecto) throws PersistentException {
		try {
			BasededatosPersistentManager.instance().getSession().evict(proyecto);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proyecto loadProyectoByCriteria(ProyectoCriteria proyectoCriteria) {
		Proyecto[] proyectos = listProyectoByCriteria(proyectoCriteria);
		if(proyectos == null || proyectos.length == 0) {
			return null;
		}
		return proyectos[0];
	}
	
	public static Proyecto[] listProyectoByCriteria(ProyectoCriteria proyectoCriteria) {
		return proyectoCriteria.listProyecto();
	}
}
