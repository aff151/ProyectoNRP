/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteBasededatosData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Valor ldatabaseValor = database.ValorDAO.loadValorByQuery(null, null);
			// Delete the persistent object
			database.ValorDAO.delete(ldatabaseValor);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.loadRequisitoByQuery(null, null);
			// Delete the persistent object
			database.RequisitoDAO.delete(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.loadProyectoByQuery(null, null);
			// Delete the persistent object
			database.ProyectoDAO.delete(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			database.ClienteDAO.delete(ldatabaseCliente);
			database.peso ldatabasepeso = database.pesoDAO.loadPesoByQuery(null, null);
			// Delete the persistent object
			database.pesoDAO.delete(ldatabasepeso);
			database.ProyReq ldatabaseProyReq = database.ProyReqDAO.loadProyReqByQuery(null, null);
			// Delete the persistent object
			database.ProyReqDAO.delete(ldatabaseProyReq);
			database.Propietario ldatabasePropietario = database.PropietarioDAO.loadPropietarioByQuery(null, null);
			// Delete the persistent object
			database.PropietarioDAO.delete(ldatabasePropietario);
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
