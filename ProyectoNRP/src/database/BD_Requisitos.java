package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Requisitos {
	public BD_Principal _c_bd_req;
	public Vector<Requisito> _cont_req = new Vector<Requisito>();
	public boolean crearRequisito(String nombre, String descripcion) throws PersistentException {
		for(Requisito requisito : RequisitoDAO.listRequisitoByQuery(null, null)) {
			if(requisito.getNombre().equals(nombre))
				return false;
		}
		Requisito req = RequisitoDAO.createRequisito();
		req.setNombre(nombre);
		req.setDescripcion(descripcion);
		RequisitoDAO.save(req);
		return true;
	}
	
}