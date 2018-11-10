package database;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Clientes {
	public BD_Principal _c_bd_clien;
	public Vector<Cliente> _cont_clientes = new Vector<Cliente>();
	
	public void crearCliente (String nombreCliente, String nombreProyecto) throws PersistentException
	{
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		

	}
}