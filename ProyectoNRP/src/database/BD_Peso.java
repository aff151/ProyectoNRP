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
		for (Peso imp : PesoDAO.listPesoByQuery(null, null)) {
			if (imp.getProyecto().getNombre().equals(proyecto)) {
				listClientes.add(ClienteDAO.getClienteByORMID(imp.getCliente().getID()));
			}
		}
		return listClientes;
	}

	public List<Proyecto> cargarProyectosCliente(String cliente) throws PersistentException {
		List<Proyecto> listProyectos = new ArrayList<Proyecto>();
		for (Peso imp : PesoDAO.listPesoByQuery(null, null)) {
			if (imp.getCliente().getNombre().equals(cliente)) {
				listProyectos.add(ProyectoDAO.getProyectoByORMID(imp.getProyecto().getID()));
			}
		}
		return listProyectos;
	}

	public boolean comprobarCliente(String cliente, String proySeleccionado) throws PersistentException {
		boolean resultado = false;
		List<Peso> listImportancia = new ArrayList<Peso>();
		listImportancia = PesoDAO.queryPeso(null, null);
		for (Peso imp : listImportancia) {
			if (imp.getProyecto().getNombre().equals(proySeleccionado)) {
				if (imp.getCliente().getNombre().equals(cliente)) {
					resultado = true;
					break;
				}
			}
		}
		return resultado;

	}

	public List<Peso> cargarPesosProyectosCliente(String cliSeleccionado) throws PersistentException {
		List<Peso> listPesos = new ArrayList<Peso>();
		for (Peso imp : PesoDAO.listPesoByQuery(null, null)) {
			if (imp.getCliente().getNombre().equals(cliSeleccionado)) {
				listPesos.add(PesoDAO.getPesoByORMID(imp.getPeso()));
			}
		}
		return listPesos;
	}
}