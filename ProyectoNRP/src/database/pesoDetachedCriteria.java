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

public class pesoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression peso;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	
	public pesoDetachedCriteria() {
		super(database.peso.class, database.pesoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		peso = new IntegerExpression("peso", this.getDetachedCriteria());
		clienteId = new IntegerExpression("ORM_Cliente.null", this.getDetachedCriteria());
		cliente = new AssociationExpression("ORM_Cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this.getDetachedCriteria());
		proyecto = new AssociationExpression("ORM_Proyecto", this.getDetachedCriteria());
	}
	
	public pesoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.pesoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		peso = new IntegerExpression("peso", this.getDetachedCriteria());
		clienteId = new IntegerExpression("ORM_Cliente.null", this.getDetachedCriteria());
		cliente = new AssociationExpression("ORM_Cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this.getDetachedCriteria());
		proyecto = new AssociationExpression("ORM_Proyecto", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public ProyectoDetachedCriteria createProyectoCriteria() {
		return new ProyectoDetachedCriteria(createCriteria("proyecto"));
	}
	
	public peso uniquePeso(PersistentSession session) {
		return (peso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public peso[] listPeso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (peso[]) list.toArray(new peso[list.size()]);
	}
}

