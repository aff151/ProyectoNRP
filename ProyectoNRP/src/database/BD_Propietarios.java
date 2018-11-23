package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Propietarios {
	public BD_Principal _c_bd_proy;
	public Vector<Propietario> _cont_proy = new Vector<Propietario>();
	

	public boolean crearPropietario(String nombre) throws PersistentException {
		for(Propietario proyecto : PropietarioDAO.listPropietarioByQuery(null, null)) {
			if(proyecto.getPropietario().equals(nombre))
				return false;
		}
		Propietario proy = PropietarioDAO.createPropietario();
		proy.setPropietario(nombre);
	
		PropietarioDAO.save(proy);
		return true;
	}


	public boolean comprobarPropietario(String propietario) throws PersistentException {
		
		for(Propietario p : PropietarioDAO.listPropietarioByQuery(null, null)) {
			if(p.getPropietario().equals(propietario)) 
				return true;	
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