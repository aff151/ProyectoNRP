package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Clientes {
	public BD_Principal _c_bd_clien;
	public Vector<Cliente> _cont_clientes = new Vector<Cliente>();
	
	public void crearCliente (String nombreCliente) throws PersistentException
	{
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
		Cliente c = ClienteDAO.createCliente();
		c.setNombre(nombreCliente);
		ClienteDAO.save(c);
		t.commit();
		} 
		catch (PersistentException e)
		{
			t.rollback();
		}
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
}