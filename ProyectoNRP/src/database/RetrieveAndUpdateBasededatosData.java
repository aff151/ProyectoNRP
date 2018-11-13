/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import org.orm.*;
public class RetrieveAndUpdateBasededatosData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			Peso ldatabasePeso = PesoDAO.loadPesoByQuery(null, null);
			// Update the properties of the persistent object
			PesoDAO.save(ldatabasePeso);
			Requisito ldatabaseRequisito = RequisitoDAO.loadRequisitoByQuery(null, null);
			// Update the properties of the persistent object
			RequisitoDAO.save(ldatabaseRequisito);
			Proyecto ldatabaseProyecto = ProyectoDAO.loadProyectoByQuery(null, null);
			// Update the properties of the persistent object
			ProyectoDAO.save(ldatabaseProyecto);
			Cliente ldatabaseCliente = ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			ClienteDAO.save(ldatabaseCliente);
			Importancia ldatabaseImportancia = ImportanciaDAO.loadImportanciaByQuery(null, null);
			// Update the properties of the persistent object
			ImportanciaDAO.save(ldatabaseImportancia);
			ProyReq ldatabaseProyReq = ProyReqDAO.loadProyReqByQuery(null, null);
			// Update the properties of the persistent object
			ProyReqDAO.save(ldatabaseProyReq);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Peso by PesoCriteria");
		PesoCriteria ldatabasePesoCriteria = new PesoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabasePesoCriteria.ID.eq();
		System.out.println(ldatabasePesoCriteria.uniquePeso());
		
		System.out.println("Retrieving Requisito by RequisitoCriteria");
		RequisitoCriteria ldatabaseRequisitoCriteria = new RequisitoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseRequisitoCriteria.ID.eq();
		System.out.println(ldatabaseRequisitoCriteria.uniqueRequisito());
		
		System.out.println("Retrieving Proyecto by ProyectoCriteria");
		ProyectoCriteria ldatabaseProyectoCriteria = new ProyectoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseProyectoCriteria.ID.eq();
		System.out.println(ldatabaseProyectoCriteria.uniqueProyecto());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		ClienteCriteria ldatabaseClienteCriteria = new ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseClienteCriteria.ID.eq();
		System.out.println(ldatabaseClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Importancia by ImportanciaCriteria");
		ImportanciaCriteria ldatabaseImportanciaCriteria = new ImportanciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseImportanciaCriteria.ID.eq();
		System.out.println(ldatabaseImportanciaCriteria.uniqueImportancia());
		
		System.out.println("Retrieving ProyReq by ProyReqCriteria");
		ProyReqCriteria ldatabaseProyReqCriteria = new ProyReqCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseProyReqCriteria.ID.eq();
		System.out.println(ldatabaseProyReqCriteria.uniqueProyReq());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateBasededatosData retrieveAndUpdateBasededatosData = new RetrieveAndUpdateBasededatosData();
			try {
				retrieveAndUpdateBasededatosData.retrieveAndUpdateTestData();
				//retrieveAndUpdateBasededatosData.retrieveByCriteria();
			}
			finally {
				BasededatosPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
