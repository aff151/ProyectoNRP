/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateBasededatosData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Valor ldatabaseValor = database.ValorDAO.createValor();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valor, requisito, proyecto, cliente
			database.ValorDAO.save(ldatabaseValor);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.createRequisito();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proyReqs, valors
			database.RequisitoDAO.save(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.createProyecto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valors, pesos, proyReqs, propietario
			database.ProyectoDAO.save(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valors, pesos
			database.ClienteDAO.save(ldatabaseCliente);
			database.peso ldatabasepeso = database.pesoDAO.createPeso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proyecto, cliente, peso
			database.pesoDAO.save(ldatabasepeso);
			database.ProyReq ldatabaseProyReq = database.ProyReqDAO.createProyReq();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : esfuerzo, requisito, proyecto
			database.ProyReqDAO.save(ldatabaseProyReq);
			database.Propietario ldatabasePropietario = database.PropietarioDAO.createPropietario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proyectos
			database.PropietarioDAO.save(ldatabasePropietario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateBasededatosData createBasededatosData = new CreateBasededatosData();
			try {
				createBasededatosData.createTestData();
			}
			finally {
				database.BasededatosPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
