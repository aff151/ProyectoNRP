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

public class PesoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression requisitoId;
	public final AssociationExpression requisito;
	public final IntegerExpression peso;
	
	public PesoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		clienteId = new IntegerExpression("cliente.ID", this);
		cliente = new AssociationExpression("cliente", this);
		proyectoId = new IntegerExpression("proyecto.ID", this);
		proyecto = new AssociationExpression("proyecto", this);
		requisitoId = new IntegerExpression("requisito.ID", this);
		requisito = new AssociationExpression("requisito", this);
		peso = new IntegerExpression("peso", this);
	}
	
	public PesoCriteria(PersistentSession session) {
		this(session.createCriteria(Peso.class));
	}
	
	public PesoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("cliente"));
	}
	
	public ProyectoCriteria createProyectoCriteria() {
		return new ProyectoCriteria(createCriteria("proyecto"));
	}
	
	public RequisitoCriteria createRequisitoCriteria() {
		return new RequisitoCriteria(createCriteria("requisito"));
	}
	
	public Peso uniquePeso() {
		return (Peso) super.uniqueResult();
	}
	
	public Peso[] listPeso() {
		java.util.List list = super.list();
		return (Peso[]) list.toArray(new Peso[list.size()]);
	}
}

