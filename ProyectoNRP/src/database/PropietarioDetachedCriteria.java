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

public class PropietarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression propietario;
	public final CollectionExpression proyectos;
	
	public PropietarioDetachedCriteria() {
		super(database.Propietario.class, database.PropietarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		propietario = new StringExpression("propietario", this.getDetachedCriteria());
		proyectos = new CollectionExpression("ORM_proyectos", this.getDetachedCriteria());
	}
	
	public PropietarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.PropietarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		propietario = new StringExpression("propietario", this.getDetachedCriteria());
		proyectos = new CollectionExpression("ORM_proyectos", this.getDetachedCriteria());
	}
	
	public ProyectoDetachedCriteria createProyectosCriteria() {
		return new ProyectoDetachedCriteria(createCriteria("ORM_proyectos"));
	}
	
	public Propietario uniquePropietario(PersistentSession session) {
		return (Propietario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Propietario[] listPropietario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Propietario[]) list.toArray(new Propietario[list.size()]);
	}
}

