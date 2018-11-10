package database;


/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
import org.orm.*;
public class RetrieveAndUpdateBasededatosData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			Peso peso = PesoDAO.loadPesoByQuery(null, null);
			// Update the properties of the persistent object
			PesoDAO.save(peso);
			Cliente cliente = ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			ClienteDAO.save(cliente);
			Importancia importancia = ImportanciaDAO.loadImportanciaByQuery(null, null);
			// Update the properties of the persistent object
			ImportanciaDAO.save(importancia);
			Proyecto proyecto = ProyectoDAO.loadProyectoByQuery(null, null);
			// Update the properties of the persistent object
			ProyectoDAO.save(proyecto);
			Requisito requisito = RequisitoDAO.loadRequisitoByQuery(null, null);
			// Update the properties of the persistent object
			RequisitoDAO.save(requisito);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Peso by PesoCriteria");
		PesoCriteria pesoCriteria = new PesoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pesoCriteria.ID.eq();
		System.out.println(pesoCriteria.uniquePeso());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		ClienteCriteria clienteCriteria = new ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//clienteCriteria.ID.eq();
		System.out.println(clienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Importancia by ImportanciaCriteria");
		ImportanciaCriteria importanciaCriteria = new ImportanciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//importanciaCriteria.ID.eq();
		System.out.println(importanciaCriteria.uniqueImportancia());
		
		System.out.println("Retrieving Proyecto by ProyectoCriteria");
		ProyectoCriteria proyectoCriteria = new ProyectoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//proyectoCriteria.ID.eq();
		System.out.println(proyectoCriteria.uniqueProyecto());
		
		System.out.println("Retrieving Requisito by RequisitoCriteria");
		RequisitoCriteria requisitoCriteria = new RequisitoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//requisitoCriteria.ID.eq();
		System.out.println(requisitoCriteria.uniqueRequisito());
		
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
