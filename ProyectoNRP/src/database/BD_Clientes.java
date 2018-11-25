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
	public List<Cliente> cargarClientesFueraProyecto()
	{
		return null;
	}
	
	public void asignaClienteProyecto(String nombre,String importancia,String proyecto) throws PersistentException 
	{
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		Cliente clien = null;
		Proyecto proy = null;
		try {
			
			peso imp = pesoDAO.createPeso();
			
			for(Cliente c : ClienteDAO.listClienteByQuery(null, null))
			{
				if(nombre.equals(c.getNombre()))
					clien = c;
			}
			for(Proyecto p : ProyectoDAO.listProyectoByQuery(null,null))
			{
				if(proyecto.equals(p.getNombre()))
					proy = p;
			}
			
			imp.setCliente(clien);
			imp.setProyecto(proy);
			imp.setPeso(Integer.parseInt(importancia));
			
			pesoDAO.save(imp);
			
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}

	}
}