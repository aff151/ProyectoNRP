/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import org.orm.*;
public class RetrieveAndUpdateBasededatosData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Peso ldatabasePeso = database.PesoDAO.loadPesoByQuery(null, null);
			// Update the properties of the persistent object
			database.PesoDAO.save(ldatabasePeso);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.loadRequisitoByQuery(null, null);
			// Update the properties of the persistent object
			database.RequisitoDAO.save(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.loadProyectoByQuery(null, null);
			// Update the properties of the persistent object
			database.ProyectoDAO.save(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			database.ClienteDAO.save(ldatabaseCliente);
			database.Importancia ldatabaseImportancia = database.ImportanciaDAO.loadImportanciaByQuery(null, null);
			// Update the properties of the persistent object
			database.ImportanciaDAO.save(ldatabaseImportancia);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Peso by PesoCriteria");
		database.PesoCriteria ldatabasePesoCriteria = new database.PesoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabasePesoCriteria.ID.eq();
		System.out.println(ldatabasePesoCriteria.uniquePeso());
		
		System.out.println("Retrieving Requisito by RequisitoCriteria");
		database.RequisitoCriteria ldatabaseRequisitoCriteria = new database.RequisitoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseRequisitoCriteria.ID.eq();
		System.out.println(ldatabaseRequisitoCriteria.uniqueRequisito());
		
		System.out.println("Retrieving Proyecto by ProyectoCriteria");
		database.ProyectoCriteria ldatabaseProyectoCriteria = new database.ProyectoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseProyectoCriteria.ID.eq();
		System.out.println(ldatabaseProyectoCriteria.uniqueProyecto());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		database.ClienteCriteria ldatabaseClienteCriteria = new database.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseClienteCriteria.ID.eq();
		System.out.println(ldatabaseClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Importancia by ImportanciaCriteria");
		database.ImportanciaCriteria ldatabaseImportanciaCriteria = new database.ImportanciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseImportanciaCriteria.ID.eq();
		System.out.println(ldatabaseImportanciaCriteria.uniqueImportancia());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateBasededatosData retrieveAndUpdateBasededatosData = new RetrieveAndUpdateBasededatosData();
			try {
				retrieveAndUpdateBasededatosData.retrieveAndUpdateTestData();
				//retrieveAndUpdateBasededatosData.retrieveByCriteria();
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
