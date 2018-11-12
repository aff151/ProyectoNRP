/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import org.orm.*;
public class CreateBasededatosData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Peso ldatabasePeso = database.PesoDAO.createPeso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso, requisito, proyecto, cliente
			database.PesoDAO.save(ldatabasePeso);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.createRequisito();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pesos
			database.RequisitoDAO.save(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.createProyecto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pesos, importancias
			database.ProyectoDAO.save(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pesos, importancias
			database.ClienteDAO.save(ldatabaseCliente);
			database.Importancia ldatabaseImportancia = database.ImportanciaDAO.createImportancia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proyecto, cliente, importancia
			database.ImportanciaDAO.save(ldatabaseImportancia);
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
