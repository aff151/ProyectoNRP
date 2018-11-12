/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: usuario(University of Almeria)
 * License Type: Academic
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
	public final CollectionExpression pesos;
	
	public RequisitoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		pesos = new CollectionExpression("ORM_pesos", this);
	}
	
	public RequisitoCriteria(PersistentSession session) {
		this(session.createCriteria(Requisito.class));
	}
	
	public RequisitoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public PesoCriteria createPesosCriteria() {
		return new PesoCriteria(createCriteria("ORM_pesos"));
	}
	
	public Requisito uniqueRequisito() {
		return (Requisito) super.uniqueResult();
	}
	
	public Requisito[] listRequisito() {
		java.util.List list = super.list();
		return (Requisito[]) list.toArray(new Requisito[list.size()]);
	}
}

