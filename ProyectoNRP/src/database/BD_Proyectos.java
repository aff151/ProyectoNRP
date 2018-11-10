package database;

import java.util.Vector;

import org.orm.PersistentException;

public class BD_Proyectos {
	public BD_Principal _c_bd_proy;
	public Vector<Proyecto> _cont_proy = new Vector<Proyecto>();
	
	public void crearProyecto(String nombre, String descripcion) {
		Proyecto proy = ProyectoDAO.createProyecto();
		proy.setNombre(nombre);
		proy.setDescripcion(descripcion);
		try {
			ProyectoDAO.save(proy);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}