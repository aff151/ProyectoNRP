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

public class ProyectoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression propietarioId;
	public final AssociationExpression propietario;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final StringExpression nombrePropietario;
	public final CollectionExpression proyReqs;
	public final CollectionExpression pesos;
	public final CollectionExpression valors;
	
	public ProyectoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		propietarioId = new IntegerExpression("propietario.ID", this);
		propietario = new AssociationExpression("propietario", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		nombrePropietario = new StringExpression("nombrePropietario", this);
		proyReqs = new CollectionExpression("ORM_proyReqs", this);
		pesos = new CollectionExpression("ORM_pesos", this);
		valors = new CollectionExpression("ORM_valors", this);
	}
	
	public ProyectoCriteria(PersistentSession session) {
		this(session.createCriteria(Proyecto.class));
	}
	
	public ProyectoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public PropietarioCriteria createPropietarioCriteria() {
		return new PropietarioCriteria(createCriteria("propietario"));
	}
	
	public ProyReqCriteria createProyReqsCriteria() {
		return new ProyReqCriteria(createCriteria("ORM_proyReqs"));
	}
	
	public pesoCriteria createPesosCriteria() {
		return new pesoCriteria(createCriteria("ORM_pesos"));
	}
	
	public ValorCriteria createValorsCriteria() {
		return new ValorCriteria(createCriteria("ORM_valors"));
	}
	
	public Proyecto uniqueProyecto() {
		return (Proyecto) super.uniqueResult();
	}
	
	public Proyecto[] listProyecto() {
		java.util.List list = super.list();
		return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
	}
}

