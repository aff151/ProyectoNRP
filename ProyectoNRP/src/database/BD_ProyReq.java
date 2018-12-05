package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import database.ProyReq;

public class BD_ProyReq {
	public BD_Principal _c_bd_proyreq;
	public Vector<ProyReq> _cont_proyreq = new Vector<ProyReq>();
	BD_Valor bdvalor=new BD_Valor();
	public void asignarRequisitoProyecto(String nombreReq, String proySeleccionado, String esfuerzo)
			throws PersistentException {
		int idReq = -1;
		int idPro = -1;
		Proyecto profin = null;
		Requisito reqfin = null;
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			for (Proyecto pro : ProyectoDAO.listProyectoByQuery(null, null)) {
				if (pro.getNombre().equals(proySeleccionado)) {
					idPro = pro.getID();
					profin = pro;
					break;
				}
			}
			for (Requisito req : RequisitoDAO.listRequisitoByQuery(null, null)) {
				if (req.getNombre().equals(nombreReq)) {
					idReq = req.getID();
					reqfin = req;
					break;
				}
			}
			ProyReq prore = ProyReqDAO.createProyReq();
			prore.setProyecto(profin);
			prore.setRequisito(reqfin);
			prore.setEsfuerzo(Integer.parseInt(esfuerzo));
			ProyReqDAO.save(prore);

			t.commit();
		} catch (PersistentException e) {
			t.rollback();
		}
	}

	public List<Requisito> cargarRequisitosProyecto(String proySeleccionado) throws PersistentException {
		List<Requisito> listRequisitos = new ArrayList<Requisito>();
		for (ProyReq req : ProyReqDAO.listProyReqByQuery(null, null)) {
			if (req.getProyecto().getNombre().equals(proySeleccionado)) {
				listRequisitos.add(req.getRequisito());
			}
		}
		return listRequisitos;
	}

	public List<ProyReq> cargarEsfuerzo(String nombre) throws PersistentException {
		List<ProyReq> listEsfuerzo = new ArrayList<ProyReq>();
		for (ProyReq req : ProyReqDAO.listProyReqByQuery(null, null)) {
			if (req.getProyecto().getNombre().equals(nombre)) {
				listEsfuerzo.add(req);
			}
		}
		return listEsfuerzo;
	}

	public List<ProyReq> cargarProyectosRequisito(String reqselec) throws PersistentException {
		List<ProyReq> listProyectos = new ArrayList<ProyReq>();
		for (ProyReq req : ProyReqDAO.listProyReqByQuery(null, null)) {
			if (req.getRequisito().getNombre().equals(reqselec)) {
				listProyectos.add(req);
			}
		}
		return listProyectos;
	}

	public List<ProyReq> cargarEsfuerzoRequisito(String reqselec) throws PersistentException {
		List<ProyReq> listEsfuerzo = new ArrayList<ProyReq>();
		for (ProyReq req : ProyReqDAO.listProyReqByQuery(null, null)) {
			if (req.getRequisito().getNombre().equals(reqselec)) {
				listEsfuerzo.add(req);
			}
		}
		return listEsfuerzo;
	}

	public void guardarEsfuerzos(List<Requisito> requisitos, String[] esfuerzos, String proyecto)throws PersistentException {
		
		for (ProyReq proyreq : ProyReqDAO.listProyReqByQuery(null, null)) {
			for (int i = 0; i < requisitos.size(); i++) {
				if (proyreq.getRequisito().getNombre().equals(requisitos.get(i).getNombre())
						&& proyreq.getProyecto().getNombre().equals(proyecto)) {
					if (Integer.parseInt(esfuerzos[i]) == 0)
						bdvalor.eliminarRequisitoProyecto(requisitos.get(i).getNombre(), proyecto);
					else {
						proyreq.setEsfuerzo(Integer.parseInt(esfuerzos[i]));
						ProyReqDAO.save(proyreq);
					}
					break;
				}
			}
		}
	}

	/*
	 * public List<Requisito> asignarOtroRequisitoProyecto(String nombreReq, String
	 * proySeleccionado,String esfuerzo) { List<Requisito> listaRequisitos = new
	 * ArrayList<Requisito>();
	 * 
	 * try { for(ProyReq pr : ProyReqDAO.listProyReqByQuery(null, null)) {
	 * 
	 * } } catch (PersistentException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } ProyReq pr = ProyReqDAO.createProyReq();
	 * 
	 * }
	 */
}