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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RequisitoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final CollectionExpression valors;
	public final CollectionExpression proyReqs;
	
	public RequisitoDetachedCriteria() {
		super(database.Requisito.class, database.RequisitoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		valors = new CollectionExpression("ORM_valors", this.getDetachedCriteria());
		proyReqs = new CollectionExpression("ORM_proyReqs", this.getDetachedCriteria());
	}
	
	public RequisitoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.RequisitoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		valors = new CollectionExpression("ORM_valors", this.getDetachedCriteria());
		proyReqs = new CollectionExpression("ORM_proyReqs", this.getDetachedCriteria());
	}
	
	public ValorDetachedCriteria createValorsCriteria() {
		return new ValorDetachedCriteria(createCriteria("ORM_valors"));
	}
	
	public ProyReqDetachedCriteria createProyReqsCriteria() {
		return new ProyReqDetachedCriteria(createCriteria("ORM_proyReqs"));
	}
	
	public Requisito uniqueRequisito(PersistentSession session) {
		return (Requisito) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Requisito[] listRequisito(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Requisito[]) list.toArray(new Requisito[list.size()]);
	}
}

