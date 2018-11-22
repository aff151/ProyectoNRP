package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Proyectos {
	public BD_Principal _c_bd_proy;
	public Vector<Proyecto> _cont_proy = new Vector<Proyecto>();
	

	public boolean crearProyecto(String nombre, String descripcion) throws PersistentException {
		for(Proyecto proyecto : ProyectoDAO.listProyectoByQuery(null, null)) {
			if(proyecto.getNombre().equals(nombre))
				return false;
		}
		Proyecto proy = ProyectoDAO.createProyecto();
		proy.setNombre(nombre);
		proy.setDescripcion(descripcion);
		ProyectoDAO.save(proy);
		return true;
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
	
	public Proyecto descargarInformacion(String proySeleccionado) throws PersistentException {
		for (Proyecto proyecto : ProyectoDAO.listProyectoByQuery(null, null)) {
			if (proyecto.getNombre().equals(proySeleccionado)) {
				return proyecto;
			}
		}
		return null;
	}

	public boolean comprobarProyecto(String proySeleccionado, String nuevoNombre) throws PersistentException {
		if(proySeleccionado.equals(nuevoNombre)) {
			return false;
		}
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			if(p.getNombre().equals(nuevoNombre)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean modificarProyecto(String proySeleccionado, String nuevoNombre, String descripcion) throws PersistentException {
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			if(p.getNombre().equals(proySeleccionado)) {
				p.setNombre(nuevoNombre);
				p.setDescripcion(descripcion);
				ProyectoDAO.save(p);
				return true;
			}
		}
		return false;
	}
	
	public List<Cliente> cargarClientesProyecto(String nombreProyecto) throws PersistentException
	{
		Proyecto pro = null;
		List<Cliente> listaClientesProyecto = new ArrayList<>();
		//Cogemos el proyecto que necesitamos
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null))
		{
			if(nombreProyecto.equals(p.getNombre()))
				pro = p;
		}
		for(Cliente c : pro.getClientes())
		{
			listaClientesProyecto.add(c);
		}
		return listaClientesProyecto;
	}
	
	public List<Requisito> cargarRequisitosProyecto(String nombreProyecto) throws PersistentException
	{
		Proyecto pro = null;
		List<Requisito> listaRequisitosProyecto = new ArrayList<>();
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null))
		{
			if(nombreProyecto.equals(p.getNombre()))
				pro = p;
		}
		for(Requisito r : pro.getRequisitos())
		{
			listaRequisitosProyecto.add(r);
		}
		return listaRequisitosProyecto;
	}
}