/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListBasededatosData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Valor...");
		database.Valor[] databaseValors = database.ValorDAO.listValorByQuery(null, null);
		int length = Math.min(databaseValors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databaseValors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Requisito...");
		database.Requisito[] databaseRequisitos = database.RequisitoDAO.listRequisitoByQuery(null, null);
		length = Math.min(databaseRequisitos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databaseRequisitos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Proyecto...");
		database.Proyecto[] databaseProyectos = database.ProyectoDAO.listProyectoByQuery(null, null);
		length = Math.min(databaseProyectos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databaseProyectos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		database.Cliente[] databaseClientes = database.ClienteDAO.listClienteByQuery(null, null);
		length = Math.min(databaseClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databaseClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing peso...");
		database.peso[] databasepesos = database.pesoDAO.listPesoByQuery(null, null);
		length = Math.min(databasepesos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databasepesos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ProyReq...");
		database.ProyReq[] databaseProyReqs = database.ProyReqDAO.listProyReqByQuery(null, null);
		length = Math.min(databaseProyReqs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databaseProyReqs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Propietario...");
		database.Propietario[] databasePropietarios = database.PropietarioDAO.listPropietarioByQuery(null, null);
		length = Math.min(databasePropietarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(databasePropietarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Valor by Criteria...");
		database.ValorCriteria ldatabaseValorCriteria = new database.ValorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabaseValorCriteria.ID.eq();
		ldatabaseValorCriteria.setMaxResults(ROW_COUNT);
		database.Valor[] databaseValors = ldatabaseValorCriteria.listValor();
		int length =databaseValors== null ? 0 : Math.min(databaseValors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databaseValors[i]);
		}
		System.out.println(length + " Valor record(s) retrieved."); 
		
		System.out.println("Listing Requisito by Criteria...");
		database.RequisitoCriteria ldatabaseRequisitoCriteria = new database.RequisitoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabaseRequisitoCriteria.ID.eq();
		ldatabaseRequisitoCriteria.setMaxResults(ROW_COUNT);
		database.Requisito[] databaseRequisitos = ldatabaseRequisitoCriteria.listRequisito();
		length =databaseRequisitos== null ? 0 : Math.min(databaseRequisitos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databaseRequisitos[i]);
		}
		System.out.println(length + " Requisito record(s) retrieved."); 
		
		System.out.println("Listing Proyecto by Criteria...");
		database.ProyectoCriteria ldatabaseProyectoCriteria = new database.ProyectoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabaseProyectoCriteria.ID.eq();
		ldatabaseProyectoCriteria.setMaxResults(ROW_COUNT);
		database.Proyecto[] databaseProyectos = ldatabaseProyectoCriteria.listProyecto();
		length =databaseProyectos== null ? 0 : Math.min(databaseProyectos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databaseProyectos[i]);
		}
		System.out.println(length + " Proyecto record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		database.ClienteCriteria ldatabaseClienteCriteria = new database.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabaseClienteCriteria.ID.eq();
		ldatabaseClienteCriteria.setMaxResults(ROW_COUNT);
		database.Cliente[] databaseClientes = ldatabaseClienteCriteria.listCliente();
		length =databaseClientes== null ? 0 : Math.min(databaseClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databaseClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing peso by Criteria...");
		database.pesoCriteria ldatabasepesoCriteria = new database.pesoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabasepesoCriteria.ID.eq();
		ldatabasepesoCriteria.setMaxResults(ROW_COUNT);
		database.peso[] databasepesos = ldatabasepesoCriteria.listPeso();
		length =databasepesos== null ? 0 : Math.min(databasepesos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databasepesos[i]);
		}
		System.out.println(length + " peso record(s) retrieved."); 
		
		System.out.println("Listing ProyReq by Criteria...");
		database.ProyReqCriteria ldatabaseProyReqCriteria = new database.ProyReqCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabaseProyReqCriteria.ID.eq();
		ldatabaseProyReqCriteria.setMaxResults(ROW_COUNT);
		database.ProyReq[] databaseProyReqs = ldatabaseProyReqCriteria.listProyReq();
		length =databaseProyReqs== null ? 0 : Math.min(databaseProyReqs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databaseProyReqs[i]);
		}
		System.out.println(length + " ProyReq record(s) retrieved."); 
		
		System.out.println("Listing Propietario by Criteria...");
		database.PropietarioCriteria ldatabasePropietarioCriteria = new database.PropietarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldatabasePropietarioCriteria.ID.eq();
		ldatabasePropietarioCriteria.setMaxResults(ROW_COUNT);
		database.Propietario[] databasePropietarios = ldatabasePropietarioCriteria.listPropietario();
		length =databasePropietarios== null ? 0 : Math.min(databasePropietarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(databasePropietarios[i]);
		}
		System.out.println(length + " Propietario record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListBasededatosData listBasededatosData = new ListBasededatosData();
			try {
				listBasededatosData.listTestData();
				//listBasededatosData.listByCriteria();
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
