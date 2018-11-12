/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import org.orm.*;
public class DeleteBasededatosData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Peso ldatabasePeso = database.PesoDAO.loadPesoByQuery(null, null);
			// Delete the persistent object
			database.PesoDAO.delete(ldatabasePeso);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.loadRequisitoByQuery(null, null);
			// Delete the persistent object
			database.RequisitoDAO.delete(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.loadProyectoByQuery(null, null);
			// Delete the persistent object
			database.ProyectoDAO.delete(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			database.ClienteDAO.delete(ldatabaseCliente);
			database.Importancia ldatabaseImportancia = database.ImportanciaDAO.loadImportanciaByQuery(null, null);
			// Delete the persistent object
			database.ImportanciaDAO.delete(ldatabaseImportancia);
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
				database.BasededatosPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
