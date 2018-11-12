package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Requisitos {
	public BD_Principal _c_bd_req;
	public Vector<Requisito> _cont_req = new Vector<Requisito>();
	public void crearRequisito(String nombre, String descripcion) {
		// TODO Auto-generated method stub
		Requisito req = RequisitoDAO.createRequisito();
		req.setNombre(nombre);
		req.setDescripcion(descripcion);
		try {
			RequisitoDAO.save(req);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}