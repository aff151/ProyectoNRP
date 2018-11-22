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

public class RequisitoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final CollectionExpression valors;
	public final CollectionExpression proyReqs;
	
	public RequisitoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		valors = new CollectionExpression("ORM_valors", this);
		proyReqs = new CollectionExpression("ORM_proyReqs", this);
	}
	
	public RequisitoCriteria(PersistentSession session) {
		this(session.createCriteria(Requisito.class));
	}
	
	public RequisitoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ValorCriteria createValorsCriteria() {
		return new ValorCriteria(createCriteria("ORM_valors"));
	}
	
	public ProyReqCriteria createProyReqsCriteria() {
		return new ProyReqCriteria(createCriteria("ORM_proyReqs"));
	}
	
	public Requisito uniqueRequisito() {
		return (Requisito) super.uniqueResult();
	}
	
	public Requisito[] listRequisito() {
		java.util.List list = super.list();
		return (Requisito[]) list.toArray(new Requisito[list.size()]);
	}
}

