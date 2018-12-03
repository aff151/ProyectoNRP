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
		for (Valor v : ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto) && v.getCliente().getNombre().equals(cliente)) {
				listRequisitos.add(v.getRequisito());
			}
		}
		return listRequisitos;
	}

	public List<Valor> cargarValorRequisitosClienteProyecto(String proyecto, String cliente)
			throws PersistentException {
		List<Valor> listValor = new ArrayList<Valor>();
		for (Valor v : ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto) && v.getCliente().getNombre().equals(cliente)) {
				listValor.add(v);
			}
		}
		return listValor;
	}

	public List<Valor> cargarValorProyecto(String proyecto) throws PersistentException {
		List<Valor> listValor = new ArrayList<Valor>();
		for (Valor v : ValorDAO.listValorByQuery(null, null)) {
			if (v.getProyecto().getNombre().equals(proyecto))
				listValor.add(v);
		}
		return listValor;
	}

	public void crearValor(String pro, String cli, String req, String valor) throws PersistentException {

		Valor v = ValorDAO.createValor();
		Cliente client = null;
		Proyecto proyec = null;
		Requisito requi = null;
		// coger Cliente
		for (Cliente c : ClienteDAO.listClienteByQuery(null, null)) {
			if (cli.equals(c.getNombre()))
				client = c;
		}
		// Cogemos proyecto
		for (Proyecto p : ProyectoDAO.listProyectoByQuery(null, null)) {
			if (pro.equals(p.getNombre()))
				proyec = p;
		}
		// Cogemos Requisito
		for (Requisito r : RequisitoDAO.listRequisitoByQuery(null, null)) {
			if (req.equals(r.getNombre()))
				requi = r;
		}
		// Añadimos los valores al valor
		v.setCliente(client);
		v.setProyecto(proyec);
		v.setRequisito(requi);
		v.setValor(Integer.parseInt(valor));

		ValorDAO.save(v);

	}

	public boolean modificarValor(String pro, String cli, String req, String valor) throws PersistentException {
		boolean existe = false;
		Valor val = null;
		for (Valor v : ValorDAO.listValorByQuery(null, null)) {
			if (pro.equals(v.getProyecto().getNombre()) && cli.equals(v.getCliente().getNombre())
					&& req.equals(v.getRequisito().getNombre())) {
				val = v;
				existe = true;
			}

		}
		if (existe == true) {
			val.setValor(Integer.parseInt(valor));
			ValorDAO.save(val);
		}

		return (existe == true) ? true : false;
	}

	public boolean modificarMatrizValores(String[] valoresMatriz, List<Requisito> requisitos, String proySeleccionado)
			throws PersistentException {
		boolean crea = true;
		List<Valor> listValorBorrar = new ArrayList<Valor>();
		String nombreCliente = valoresMatriz[0];
		String nombreRequisito = "";
		for (int i = 1; i < valoresMatriz.length; i++) {
			crea = true;
			nombreRequisito = requisitos.get(i - 1).getNombre();
			for (Valor v : ValorDAO.listValorByQuery(null, null)) {
				if (Integer.parseInt(valoresMatriz[i]) == 0) {
					if (v.getProyecto().getNombre().equals(proySeleccionado)
							&& v.getCliente().getNombre().equals(nombreCliente)
							&& v.getRequisito().getNombre().equals(nombreRequisito)) {
						listValorBorrar.add(v);
						crea = false;
					}
					crea = false;
				}
				if (Integer.parseInt(valoresMatriz[i]) != 0) {
					if (v.getProyecto().getNombre().equals(proySeleccionado)
							&& v.getCliente().getNombre().equals(nombreCliente)
							&& v.getRequisito().getNombre().equals(nombreRequisito)) {
						v.setValor(Integer.parseInt(valoresMatriz[i]));
						ValorDAO.save(v);
						crea = false;
					}
				}
			}
			if(crea) {
				crearValor(proySeleccionado, nombreCliente, nombreRequisito, valoresMatriz[i]);
			}
		}
		for (Valor valor : listValorBorrar) {
			ValorDAO.deleteAndDissociate(valor);
		}
		
		return true;
	}

	public void eliminarValoresClienteProyecto(Cliente cliente, String proySeleccionado) throws PersistentException {
		
		for (Valor v : ValorDAO.listValorByQuery(null, null)) {
			if(v.getCliente().equals(cliente) && v.getProyecto().getNombre().equals(proySeleccionado)) {
				ValorDAO.deleteAndDissociate(v);
			}
		}
	}
}