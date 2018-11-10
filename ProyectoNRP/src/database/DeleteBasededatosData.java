package database;

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
import org.orm.*;
public class DeleteBasededatosData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			Peso peso = PesoDAO.loadPesoByQuery(null, null);
			// Delete the persistent object
			PesoDAO.delete(peso);
			Cliente cliente = ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			ClienteDAO.delete(cliente);
			Importancia importancia = ImportanciaDAO.loadImportanciaByQuery(null, null);
			// Delete the persistent object
			ImportanciaDAO.delete(importancia);
			Proyecto proyecto = ProyectoDAO.loadProyectoByQuery(null, null);
			// Delete the persistent object
			ProyectoDAO.delete(proyecto);
			Requisito requisito = RequisitoDAO.loadRequisitoByQuery(null, null);
			// Delete the persistent object
			RequisitoDAO.delete(requisito);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteBasededatosData deleteBasededatosData = new DeleteBasededatosData();
			try {
				deleteBasededatosData.deleteTestData();
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
