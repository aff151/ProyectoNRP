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

public class ProyectoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final CollectionExpression proyReqs;
	public final CollectionExpression pesos;
	public final CollectionExpression valors;
	
	public ProyectoDetachedCriteria() {
		super(database.Proyecto.class, database.ProyectoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		proyReqs = new CollectionExpression("ORM_proyReqs", this.getDetachedCriteria());
		pesos = new CollectionExpression("ORM_pesos", this.getDetachedCriteria());
		valors = new CollectionExpression("ORM_valors", this.getDetachedCriteria());
	}
	
	public ProyectoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.ProyectoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		proyReqs = new CollectionExpression("ORM_proyReqs", this.getDetachedCriteria());
		pesos = new CollectionExpression("ORM_pesos", this.getDetachedCriteria());
		valors = new CollectionExpression("ORM_valors", this.getDetachedCriteria());
	}
	
	public ProyReqDetachedCriteria createProyReqsCriteria() {
		return new ProyReqDetachedCriteria(createCriteria("ORM_proyReqs"));
	}
	
	public PesoDetachedCriteria createPesosCriteria() {
		return new PesoDetachedCriteria(createCriteria("ORM_pesos"));
	}
	
	public ValorDetachedCriteria createValorsCriteria() {
		return new ValorDetachedCriteria(createCriteria("ORM_valors"));
	}
	
	public Proyecto uniqueProyecto(PersistentSession session) {
		return (Proyecto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Proyecto[] listProyecto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
	}
}

