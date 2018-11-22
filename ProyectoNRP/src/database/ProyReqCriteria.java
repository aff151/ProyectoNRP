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

public class ProyReqCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression requisitoId;
	public final AssociationExpression requisito;
	public final IntegerExpression esfuerzo;
	
	public ProyReqCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this);
		proyecto = new AssociationExpression("ORM_Proyecto", this);
		requisitoId = new IntegerExpression("ORM_Requisito.null", this);
		requisito = new AssociationExpression("ORM_Requisito", this);
		esfuerzo = new IntegerExpression("esfuerzo", this);
	}
	
	public ProyReqCriteria(PersistentSession session) {
		this(session.createCriteria(ProyReq.class));
	}
	
	public ProyReqCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ProyectoCriteria createProyectoCriteria() {
		return new ProyectoCriteria(createCriteria("ORM_Proyecto"));
	}
	
	public RequisitoCriteria createRequisitoCriteria() {
		return new RequisitoCriteria(createCriteria("ORM_Requisito"));
	}
	
	public ProyReq uniqueProyReq() {
		return (ProyReq) super.uniqueResult();
	}
	
	public ProyReq[] listProyReq() {
		java.util.List list = super.list();
		return (ProyReq[]) list.toArray(new ProyReq[list.size()]);
	}
}

