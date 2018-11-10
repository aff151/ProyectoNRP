package database;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Proyectos {
	public BD_Principal _c_bd_proy;
	public Vector<Proyecto> _cont_proy = new Vector<Proyecto>();
	
	public void crearProyecto(String nombre, String descripcion) throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			Proyecto proy = ProyectoDAO.createProyecto();
			proy.setNombre(nombre);
			proy.setDescripcion(descripcion);
			ProyectoDAO.save(proy);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
	}
}