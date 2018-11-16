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
	public List<Requisito> cargarRequisitosProyecto(String proySeleccionado) throws PersistentException {
		List<Requisito> listRequisitos = new ArrayList<Requisito>();
			listRequisitos = RequisitoDAO.queryRequisito(null, null);
		return listRequisitos;
	}
	public List<Requisito> cargarRequisitos() throws PersistentException {
		List<Requisito> listaRequisitos = new ArrayList<Requisito>();
			listaRequisitos = RequisitoDAO.queryRequisito(null, null);
		
		return listaRequisitos;
	}

	public List<Requisito> cargarRequisitosOtros(String nombreProyecto) throws PersistentException
	{
		List<Requisito> listTodosRequisitos = new ArrayList<Requisito>();
		listTodosRequisitos = RequisitoDAO.queryRequisito(null, null);
		boolean borrar = false;
		List<Requisito> listRequisitosEliminar = new ArrayList<Requisito>();
		List<Requisito> listaFinal = new ArrayList<Requisito>();
		
			for(ProyReq pr : ProyReqDAO.listProyReqByQuery(null, null))
			{
				if(nombreProyecto.equals(pr.getProyecto().getNombre().toString()))
				{
					listRequisitosEliminar.add(pr.getRequisito());
				}
			}
			//HASTA AQUI TODO PERFECTO
			
			//YA TENEMOS LOS REQUISITOS QUE DEBEMOS DE EVITAR
			for(Requisito r1 : listTodosRequisitos)
			{
				borrar = false;
				for(Requisito r2 : listRequisitosEliminar)
				{
					if(r1.getNombre().equals(r2.getNombre()))
						borrar = true;
				}
				if(!borrar)
					listaFinal.add(r1);
			}

		return listaFinal;
	}
}