package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Clientes {
	public BD_Principal _c_bd_clien;
	public Vector<Cliente> _cont_clientes = new Vector<Cliente>();
	
	public boolean crearCliente (String nombreCliente) throws PersistentException{
		for(Cliente cliente : ClienteDAO.listClienteByQuery(null, null)) {
			if(cliente.getNombre().equals(nombreCliente))
				return false;
		}
		Cliente c = ClienteDAO.createCliente();
		c.setNombre(nombreCliente);
		ClienteDAO.save(c);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> cargarClientes() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		List<Cliente> listClientes = new ArrayList<Cliente>();
		try {
			listClientes = ClienteDAO.queryCliente(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return listClientes;
	}
/*
 * 	
 */

	public List<Cliente> cargarClientesPropios(String nombreUser) throws PersistentException
	{
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		ArrayList<Cliente> listaFinal = new ArrayList<Cliente>();
	
		
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null))
		{
			if(nombreUser.equals(p.getNombrePropietario()))
				listaProyectos.add(p);
		}
		for(Proyecto p : listaProyectos)
		{
			for(Cliente c : p.getClientes())
			{
				listaClientes.add(c);
			}
		}
		boolean esta = false;
		for(Cliente c : ClienteDAO.listClienteByQuery(null, null))
		{
			for(Cliente c1 : listaClientes)
			{
				if(c1.getNombre().equals(c.getNombre()))
					esta = true;
			}
			if(esta) {
				if(!listaFinal.contains(c))
					listaFinal.add(c);
			}
			esta = false;
		}
		return listaFinal;
	}
	
	public void eliminarCliente(String nombrePropietario,String nombreCliente) throws PersistentException
	{
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		ArrayList<Cliente> listaFinal = new ArrayList<Cliente>();
	
		
		for(Proyecto p : ProyectoDAO.listProyectoByQuery(null, null))
		{
			if(nombrePropietario.equals(p.getNombrePropietario()))
				listaProyectos.add(p);
		}
		for(Proyecto p : listaProyectos)
		{
			for(Cliente c : p.getClientes())
			{
				if(nombreCliente.equals(c.getNombre()))
						p.removeCliente(c);
			}
		}
	}

	public List<Cliente> cargarClientesProyectosRequisito(String reqselec, String pSelect) throws PersistentException {
		List<Cliente> listCliente = new ArrayList<Cliente>();
		for(Valor req: ValorDAO.listValorByQuery(null, null)) {
			if(req.getRequisito().getNombre().equals(reqselec) && req.getProyecto().getNombre().equals(pSelect)) {
				listCliente.add(req.getCliente());
			}
		}
		return listCliente;
	}

	public List<Valor> cargarValorClienteProyectoRequisito(String reqselec, String pSelect) throws PersistentException {
		List<Valor> listValor = new ArrayList<Valor>();
		for(Valor req: ValorDAO.listValorByQuery(null, null)) {
			if(req.getRequisito().getNombre().equals(reqselec) && req.getProyecto().getNombre().equals(pSelect)) {
				listValor.add(req);
			}
		}
		return listValor;
	}
	
}