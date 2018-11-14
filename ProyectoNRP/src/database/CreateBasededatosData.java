/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package database;

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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valors, pesos, proyReqs
			database.ProyectoDAO.save(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valors, pesos
			database.ClienteDAO.save(ldatabaseCliente);
			database.Peso ldatabasePeso = database.PesoDAO.createPeso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proyecto, cliente, peso
			database.PesoDAO.save(ldatabasePeso);
			database.ProyReq ldatabaseProyReq = database.ProyReqDAO.createProyReq();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : esfuerzo, requisito, proyecto
			database.ProyReqDAO.save(ldatabaseProyReq);
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
