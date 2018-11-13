package database;

import java.util.ArrayList;
import java.util.List;
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

	@SuppressWarnings("unchecked")
	public List<Proyecto> cargarProyectos() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		List<Proyecto> listProyectos = new ArrayList<Proyecto>();
		try {
			listProyectos = ProyectoDAO.queryProyecto(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return listProyectos;
	}

	public List<Proyecto> cargarProyectosCliente(String nombreCliente) throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		List<Proyecto> listProyectos = new ArrayList<Proyecto>();
		List<Proyecto> listProyectosCliente = new ArrayList<Proyecto>();
		try {
			listProyectos = ProyectoDAO.queryProyecto(null, null);
			for(Proyecto proyecto:listProyectos) {
				for(Cliente cliente:proyecto.getClientes()) {
					if(cliente.getNombre().equals(nombreCliente)) {
						listProyectosCliente.add(proyecto);
					}
				}
					
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return listProyectosCliente;
	}
}