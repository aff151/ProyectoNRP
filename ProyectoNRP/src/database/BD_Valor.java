package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;

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
}