/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package database;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProyReqDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression requisitoId;
	public final AssociationExpression requisito;
	public final IntegerExpression esfuerzo;
	
	public ProyReqDetachedCriteria() {
		super(database.ProyReq.class, database.ProyReqCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this.getDetachedCriteria());
		proyecto = new AssociationExpression("ORM_Proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("ORM_Requisito.null", this.getDetachedCriteria());
		requisito = new AssociationExpression("ORM_Requisito", this.getDetachedCriteria());
		esfuerzo = new IntegerExpression("esfuerzo", this.getDetachedCriteria());
	}
	
	public ProyReqDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.ProyReqCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this.getDetachedCriteria());
		proyecto = new AssociationExpression("ORM_Proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("ORM_Requisito.null", this.getDetachedCriteria());
		requisito = new AssociationExpression("ORM_Requisito", this.getDetachedCriteria());
		esfuerzo = new IntegerExpression("esfuerzo", this.getDetachedCriteria());
	}
	
	public ProyectoDetachedCriteria createProyectoCriteria() {
		return new ProyectoDetachedCriteria(createCriteria("proyecto"));
	}
	
	public RequisitoDetachedCriteria createRequisitoCriteria() {
		return new RequisitoDetachedCriteria(createCriteria("requisito"));
	}
	
	public ProyReq uniqueProyReq(PersistentSession session) {
		return (ProyReq) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ProyReq[] listProyReq(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ProyReq[]) list.toArray(new ProyReq[list.size()]);
	}
}

