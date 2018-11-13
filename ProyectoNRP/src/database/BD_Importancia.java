package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Importancia {
	public BD_Principal _c_bd_import;
	public Vector<Importancia> _importancias = new Vector<Importancia>();

	public List<Cliente> cargarClientesProyecto(String proyecto) throws PersistentException  {
		List<Cliente> listClientes = new ArrayList<Cliente>();
		
			/*
			 * for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			 * if(p.getNombre().equals(proyecto)) { proy = p; break; } }
			 */
			for (Importancia imp : ImportanciaDAO.listImportanciaByQuery(null, null)) {
				if (imp.getProyecto().getNombre().equals(proyecto)) {
					listClientes.add(ClienteDAO.getClienteByORMID(imp.getCliente().getID()));
				}
			}
		return listClientes;
	}

}