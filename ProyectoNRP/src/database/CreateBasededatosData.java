package database;

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
import org.orm.*;
public class CreateBasededatosData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = BasededatosPersistentManager.instance().getSession().beginTransaction();
		try {
			Peso peso = PesoDAO.createPeso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso, requisito, proyecto, cliente
			PesoDAO.save(peso);
			Cliente cliente = ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso, importancia
			ClienteDAO.save(cliente);
			Importancia importancia = ImportanciaDAO.createImportancia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : importancia, proyecto, cliente
			ImportanciaDAO.save(importancia);
			Proyecto proyecto = ProyectoDAO.createProyecto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso, importancia
			ProyectoDAO.save(proyecto);
			Requisito requisito = RequisitoDAO.createRequisito();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peso
			RequisitoDAO.save(requisito);
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
				BasededatosPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
