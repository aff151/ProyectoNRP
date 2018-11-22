/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package database;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class pesoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression peso;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	
	public pesoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		peso = new IntegerExpression("peso", this);
		clienteId = new IntegerExpression("ORM_Cliente.null", this);
		cliente = new AssociationExpression("ORM_Cliente", this);
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this);
		proyecto = new AssociationExpression("ORM_Proyecto", this);
	}
	
	public pesoCriteria(PersistentSession session) {
		this(session.createCriteria(peso.class));
	}
	
	public pesoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("ORM_Cliente"));
	}
	
	public ProyectoCriteria createProyectoCriteria() {
		return new ProyectoCriteria(createCriteria("ORM_Proyecto"));
	}
	
	public peso uniquePeso() {
		return (peso) super.uniqueResult();
	}
	
	public peso[] listPeso() {
		java.util.List list = super.list();
		return (peso[]) list.toArray(new peso[list.size()]);
	}
}

