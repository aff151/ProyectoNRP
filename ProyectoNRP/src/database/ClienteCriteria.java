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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final CollectionExpression pesos;
	public final CollectionExpression valors;
	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		pesos = new CollectionExpression("ORM_pesos", this);
		valors = new CollectionExpression("ORM_valors", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public PesoCriteria createPesosCriteria() {
		return new PesoCriteria(createCriteria("ORM_pesos"));
	}
	
	public ValorCriteria createValorsCriteria() {
		return new ValorCriteria(createCriteria("ORM_valors"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

