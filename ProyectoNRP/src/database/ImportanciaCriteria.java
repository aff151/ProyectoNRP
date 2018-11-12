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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ImportanciaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression importancia;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	
	public ImportanciaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		importancia = new IntegerExpression("importancia", this);
		clienteId = new IntegerExpression("ORM_Cliente.null", this);
		cliente = new AssociationExpression("ORM_Cliente", this);
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this);
		proyecto = new AssociationExpression("ORM_Proyecto", this);
	}
	
	public ImportanciaCriteria(PersistentSession session) {
		this(session.createCriteria(Importancia.class));
	}
	
	public ImportanciaCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("ORM_Cliente"));
	}
	
	public ProyectoCriteria createProyectoCriteria() {
		return new ProyectoCriteria(createCriteria("ORM_Proyecto"));
	}
	
	public Importancia uniqueImportancia() {
		return (Importancia) super.uniqueResult();
	}
	
	public Importancia[] listImportancia() {
		java.util.List list = super.list();
		return (Importancia[]) list.toArray(new Importancia[list.size()]);
	}
}

