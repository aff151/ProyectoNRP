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

	public void asignarRequisitoProyecto(String nombreReq, String proySeleccionado) throws PersistentException {
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
			ProyReqDAO.save(prore);
			
			t.commit();
		} catch (PersistentException e) {
			t.rollback();
		}
	}
	public List<Requisito> cargarRequisitosProyecto(String proyecto) throws PersistentException {
		List<Requisito> listReq = new ArrayList<Requisito>();
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			for(ProyReq pr : ProyReqDAO.listProyReqByQuery(null, null)) {
				if(pr.getProyecto().getNombre().equals(proyecto)) {
					listReq.add(pr.getRequisito());
				}
			}
			t.commit();
		} catch (PersistentException e) {
			t.rollback();
		}
		return listReq;
	}
}