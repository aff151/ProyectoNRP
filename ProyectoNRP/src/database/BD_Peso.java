package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Peso {
	public BD_Principal _c_bd_import;

	public List<Cliente> cargarClientesProyecto(String proyecto) throws PersistentException {
		List<Cliente> listClientes = new ArrayList<Cliente>();
		for (peso imp : pesoDAO.listPesoByQuery(null, null)) {
			if (imp.getProyecto().getNombre().equals(proyecto)) {
				listClientes.add(ClienteDAO.getClienteByORMID(imp.getCliente().getID()));
			}
		}
		return listClientes;
	}

	public List<Proyecto> cargarProyectosCliente(String cliente) throws PersistentException {
		List<Proyecto> listProyectos = new ArrayList<Proyecto>();
		for (peso imp : pesoDAO.listPesoByQuery(null, null)) {
			if (imp.getCliente().getNombre().equals(cliente)) {
				listProyectos.add(ProyectoDAO.getProyectoByORMID(imp.getProyecto().getID()));
			}
		}
		return listProyectos;
	}

	public boolean comprobarCliente(String cliente, String proySeleccionado) throws PersistentException {
		boolean resultado = false;
		List<peso> listImportancia = new ArrayList<peso>();
		listImportancia = pesoDAO.queryPeso(null, null);
		for (peso imp : listImportancia) {
			if (imp.getProyecto().getNombre().equals(proySeleccionado)) {
				if (imp.getCliente().getNombre().equals(cliente)) {
					resultado = true;
					break;
				}
			}
		}
		return resultado;

	}

	public List<peso> cargarPesosProyectosCliente(String cliSeleccionado) throws PersistentException {
		List<peso> listPesos = new ArrayList<peso>();
		for (peso imp : pesoDAO.listPesoByQuery(null, null)) {
			if (imp.getCliente().getNombre().equals(cliSeleccionado)) {
				listPesos.add(imp);
			}
		}
		return listPesos;
	}

	public List<peso> cargarPesosProyecto(String nombre) throws PersistentException {
		List<peso> listPesos = new ArrayList<peso>();
		for (peso imp : pesoDAO.listPesoByQuery(null, null)) {
			if (imp.getProyecto().getNombre().equals(nombre)) {
				listPesos.add(imp);
			}
		}
		return listPesos;
	}
	
	public List<peso> cargarPesosClienteProyecto(String proyecto) throws PersistentException {
		List<peso> listPesos = new ArrayList<peso>();
		for (peso peso : pesoDAO.listPesoByQuery(null, null)) {
			if (peso.getProyecto().getNombre().equals(proyecto) && !listPesos.contains(peso)) {
				listPesos.add(peso);
			}
		}
		return listPesos;
	}

	public void eliminarProyecto(String proyecto, String cliSeleccionado) throws PersistentException {
		// TODO Auto-generated method stub
		List<peso> listPesos = new ArrayList<peso>();
		for (peso peso : pesoDAO.listPesoByQuery(null, null)) {
			if (peso.getProyecto().getNombre().equals(proyecto) && peso.getCliente().getNombre().equals(cliSeleccionado)) {
				pesoDAO.deleteAndDissociate(peso);
			}
		}
	}
}