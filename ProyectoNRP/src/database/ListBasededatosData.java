package database;

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
import org.orm.*;
public class ListBasededatosData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Peso...");
		Peso[] pesos = PesoDAO.listPesoByQuery(null, null);
		int length = Math.min(pesos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pesos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		Cliente[] clientes = ClienteDAO.listClienteByQuery(null, null);
		length = Math.min(clientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(clientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Importancia...");
		Importancia[] importancias = ImportanciaDAO.listImportanciaByQuery(null, null);
		length = Math.min(importancias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(importancias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Proyecto...");
		Proyecto[] proyectos = ProyectoDAO.listProyectoByQuery(null, null);
		length = Math.min(proyectos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(proyectos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Requisito...");
		Requisito[] requisitos = RequisitoDAO.listRequisitoByQuery(null, null);
		length = Math.min(requisitos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(requisitos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Peso by Criteria...");
		PesoCriteria pesoCriteria = new PesoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pesoCriteria.ID.eq();
		pesoCriteria.setMaxResults(ROW_COUNT);
		Peso[] pesos = pesoCriteria.listPeso();
		int length =pesos== null ? 0 : Math.min(pesos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pesos[i]);
		}
		System.out.println(length + " Peso record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		ClienteCriteria clienteCriteria = new ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//clienteCriteria.ID.eq();
		clienteCriteria.setMaxResults(ROW_COUNT);
		Cliente[] clientes = clienteCriteria.listCliente();
		length =clientes== null ? 0 : Math.min(clientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(clientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing Importancia by Criteria...");
		ImportanciaCriteria importanciaCriteria = new ImportanciaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//importanciaCriteria.ID.eq();
		importanciaCriteria.setMaxResults(ROW_COUNT);
		Importancia[] importancias = importanciaCriteria.listImportancia();
		length =importancias== null ? 0 : Math.min(importancias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(importancias[i]);
		}
		System.out.println(length + " Importancia record(s) retrieved."); 
		
		System.out.println("Listing Proyecto by Criteria...");
		ProyectoCriteria proyectoCriteria = new ProyectoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//proyectoCriteria.ID.eq();
		proyectoCriteria.setMaxResults(ROW_COUNT);
		Proyecto[] proyectos = proyectoCriteria.listProyecto();
		length =proyectos== null ? 0 : Math.min(proyectos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(proyectos[i]);
		}
		System.out.println(length + " Proyecto record(s) retrieved."); 
		
		System.out.println("Listing Requisito by Criteria...");
		RequisitoCriteria requisitoCriteria = new RequisitoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//requisitoCriteria.ID.eq();
		requisitoCriteria.setMaxResults(ROW_COUNT);
		Requisito[] requisitos = requisitoCriteria.listRequisito();
		length =requisitos== null ? 0 : Math.min(requisitos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(requisitos[i]);
		}
		System.out.println(length + " Requisito record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListBasededatosData listBasededatosData = new ListBasededatosData();
			try {
				listBasededatosData.listTestData();
				//listBasededatosData.listByCriteria();
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
