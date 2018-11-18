package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import database.Valor;

public class BD_Valor {
	public BD_Principal _c_bd_peso;
	public Vector<Valor> _cont_peso = new Vector<Valor>();
	
	public List<Requisito> cargarRequisitosClienteProyecto(String proyecto, String cliente) throws PersistentException {
		List<Requisito> listRequisitos = new ArrayList<Requisito>();
		for(Valor v: ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto) 
					&& v.getCliente().getNombre().equals(cliente)) {
				listRequisitos.add(v.getRequisito());
			}
		}
		return listRequisitos;
	}
	public List<Valor> cargarValorRequisitosClienteProyecto(String proyecto, String cliente) throws PersistentException {
		List<Valor> listValor = new ArrayList<Valor>();
		for(Valor v: ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto) 
					&& v.getCliente().getNombre().equals(cliente)) {
				listValor.add(v);
			}
		}
		return listValor;
	}
	public List<Valor> cargarValorProyecto(String proyecto) throws PersistentException {
		List<Valor> listValor = new ArrayList<Valor>();
		for(Valor v: ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto)) 
				listValor.add(v);
		}
		return listValor;
	}
	
	public void crearValor(String pro,String cli,String req,String valor) throws PersistentException
	{
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();

		Valor val = null;
		for(Valor v : ValorDAO.listValorByQuery(null, null))
		{
			if(pro.equals(v.getProyecto().getNombre()) && 
					cli.equals(v.getCliente().getNombre()) && req.equals(v.getRequisito().getNombre()))
				
			{
				val = v;
				
				val.setValor(Integer.parseInt(valor));
			}
		}
		ValorDAO.save(val);
	}
}