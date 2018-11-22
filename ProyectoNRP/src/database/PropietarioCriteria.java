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

public class PropietarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression propietario;
	public final CollectionExpression proyectos;
	
	public PropietarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		propietario = new StringExpression("propietario", this);
		proyectos = new CollectionExpression("ORM_proyectos", this);
	}
	
	public PropietarioCriteria(PersistentSession session) {
		this(session.createCriteria(Propietario.class));
	}
	
	public PropietarioCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ProyectoCriteria createProyectosCriteria() {
		return new ProyectoCriteria(createCriteria("ORM_proyectos"));
	}
	
	public Propietario uniquePropietario() {
		return (Propietario) super.uniqueResult();
	}
	
	public Propietario[] listPropietario() {
		java.util.List list = super.list();
		return (Propietario[]) list.toArray(new Propietario[list.size()]);
	}
}

