/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
 */
package database;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final CollectionExpression importancias;
	public final CollectionExpression pesos;
	
	public ClienteDetachedCriteria() {
		super(database.Cliente.class, database.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		importancias = new CollectionExpression("ORM_importancias", this.getDetachedCriteria());
		pesos = new CollectionExpression("ORM_pesos", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		importancias = new CollectionExpression("ORM_importancias", this.getDetachedCriteria());
		pesos = new CollectionExpression("ORM_pesos", this.getDetachedCriteria());
	}
	
	public ImportanciaDetachedCriteria createImportanciasCriteria() {
		return new ImportanciaDetachedCriteria(createCriteria("ORM_importancias"));
	}
	
	public PesoDetachedCriteria createPesosCriteria() {
		return new PesoDetachedCriteria(createCriteria("ORM_pesos"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

