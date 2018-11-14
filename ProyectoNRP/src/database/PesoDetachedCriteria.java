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

public class PesoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression peso;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	
	public PesoDetachedCriteria() {
		super(database.Peso.class, database.PesoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		peso = new IntegerExpression("peso", this.getDetachedCriteria());
		clienteId = new IntegerExpression("ORM_Cliente.null", this.getDetachedCriteria());
		cliente = new AssociationExpression("ORM_Cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("ORM_Proyecto.null", this.getDetachedCriteria());
		proyecto = new AssociationExpression("ORM_Proyecto", this.getDetachedCriteria());
	}
	
	public PesoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.PesoCriteria.class);
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
	
	public Peso uniquePeso(PersistentSession session) {
		return (Peso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Peso[] listPeso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Peso[]) list.toArray(new Peso[list.size()]);
	}
}

