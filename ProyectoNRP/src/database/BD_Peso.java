package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Peso {
	public BD_Principal _c_bd_import;
	BD_Valor bdValor = new BD_Valor();

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
			if (peso.getProyecto().getNombre().equals(proyecto)
					&& peso.getCliente().getNombre().equals(cliSeleccionado)) {
				pesoDAO.deleteAndDissociate(peso);
			}
		}
	}

	public boolean quitarClienteProyecto(Cliente cliente, String proySeleccionado) throws PersistentException {
		// TODO Auto-generated method stub

		peso imp = null;

		for (peso c : pesoDAO.listPesoByQuery(null, null)) {
			if (c.getCliente().equals(cliente) && c.getProyecto().getNombre().equals(proySeleccionado)) {
				imp = c;
			}
		}

		bdValor.eliminarValoresClienteProyecto(cliente, proySeleccionado);

		pesoDAO.deleteAndDissociate(imp);
		return true;
	}

	////////////////////////////////////// MODIFICAR PROYECTO
	public boolean quitarRequisitoProyecto(Requisito requisito, String proySeleccionado) throws PersistentException {
		// TODO Auto-generated method stub
		ProyReq proreq = null;
		for (ProyReq prore : ProyReqDAO.listProyReqByQuery(null, null)) {
			if (prore.getRequisito().equals(requisito) && prore.getProyecto().getNombre().equals(proySeleccionado)) {
				proreq = prore;
				break;
			}
		}
		ProyReqDAO.deleteAndDissociate(proreq);
		return true;
	}

	//////////////////////////////////// MODIFICAR PROYECTO
	public List<Cliente> cargarClientesFueraProyecto(String nombreProyecto, String nombreProp)
			throws PersistentException {

		List<Cliente> clientes = new ArrayList<Cliente>();
		Proyecto auxPro = null;
		List<Cliente> clientesTotales = ClienteDAO.queryCliente(null, null);
		List<Cliente> listaFinal = new ArrayList<Cliente>();

		for (Cliente cli : ClienteDAO.listClienteByQuery(null, null)) {
			clientes.add(cli);
		}
		for (Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			if (p.getNombre().equals(nombreProyecto))
				auxPro = p;
		}

		for (Cliente cli : auxPro.getClientes()) {
			if (clientes.contains(cli))
				clientes.remove(cli);
		}

		return clientes;
	}

	public void asignaClienteProyecto(String nombre, String importancia, String proyecto) throws PersistentException {
		BD_Clientes bdcli = new BD_Clientes();
		Cliente clien = null;
		Proyecto proy = null;

		bdcli.crearCliente(nombre);
		peso imp = pesoDAO.createPeso();

		for (Cliente c : ClienteDAO.listClienteByQuery(null, null)) {
			if (nombre.equals(c.getNombre()))
				clien = c;
		}
		for (Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			if (proyecto.equals(p.getNombre()))
				proy = p;
		}

		imp.setCliente(clien);
		imp.setProyecto(proy);
		imp.setPeso(Integer.parseInt(importancia));

		pesoDAO.save(imp);

	}

	public void guardarPesos(List<peso> clientes, String[] pesos, String proyecto) throws PersistentException {
		for (peso pes : pesoDAO.listPesoByQuery(null, null)) {
			for (int i = 0; i < clientes.size(); i++) {
				if (pes.getCliente().getNombre().equals(clientes.get(i).getCliente().getNombre())
						&& pes.getProyecto().getNombre().equals(proyecto)) {
					if (Integer.parseInt(pesos[i]) == 0)
						quitarClienteProyecto(clientes.get(i).getCliente(),proyecto);
					else {
						pes.setPeso(Integer.parseInt(pesos[i]));
						pesoDAO.save(pes);
					}
					break;
				}
			}
		}
	}

}