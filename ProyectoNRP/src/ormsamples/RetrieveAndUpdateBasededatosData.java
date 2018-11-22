/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateBasededatosData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = database.BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			database.Valor ldatabaseValor = database.ValorDAO.loadValorByQuery(null, null);
			// Update the properties of the persistent object
			database.ValorDAO.save(ldatabaseValor);
			database.Requisito ldatabaseRequisito = database.RequisitoDAO.loadRequisitoByQuery(null, null);
			// Update the properties of the persistent object
			database.RequisitoDAO.save(ldatabaseRequisito);
			database.Proyecto ldatabaseProyecto = database.ProyectoDAO.loadProyectoByQuery(null, null);
			// Update the properties of the persistent object
			database.ProyectoDAO.save(ldatabaseProyecto);
			database.Cliente ldatabaseCliente = database.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			database.ClienteDAO.save(ldatabaseCliente);
			database.peso ldatabasepeso = database.pesoDAO.loadPesoByQuery(null, null);
			// Update the properties of the persistent object
			database.pesoDAO.save(ldatabasepeso);
			database.ProyReq ldatabaseProyReq = database.ProyReqDAO.loadProyReqByQuery(null, null);
			// Update the properties of the persistent object
			database.ProyReqDAO.save(ldatabaseProyReq);
			database.Propietario ldatabasePropietario = database.PropietarioDAO.loadPropietarioByQuery(null, null);
			// Update the properties of the persistent object
			database.PropietarioDAO.save(ldatabasePropietario);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Valor by ValorCriteria");
		database.ValorCriteria ldatabaseValorCriteria = new database.ValorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseValorCriteria.ID.eq();
		System.out.println(ldatabaseValorCriteria.uniqueValor());
		
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
		
		System.out.println("Retrieving peso by pesoCriteria");
		database.pesoCriteria ldatabasepesoCriteria = new database.pesoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabasepesoCriteria.ID.eq();
		System.out.println(ldatabasepesoCriteria.uniquePeso());
		
		System.out.println("Retrieving ProyReq by ProyReqCriteria");
		database.ProyReqCriteria ldatabaseProyReqCriteria = new database.ProyReqCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabaseProyReqCriteria.ID.eq();
		System.out.println(ldatabaseProyReqCriteria.uniqueProyReq());
		
		System.out.println("Retrieving Propietario by PropietarioCriteria");
		database.PropietarioCriteria ldatabasePropietarioCriteria = new database.PropietarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldatabasePropietarioCriteria.ID.eq();
		System.out.println(ldatabasePropietarioCriteria.uniquePropietario());
		
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
