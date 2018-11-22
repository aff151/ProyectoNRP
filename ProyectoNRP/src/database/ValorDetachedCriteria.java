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

public class ValorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression requisitoId;
	public final AssociationExpression requisito;
	public final IntegerExpression valor;
	
	public ValorDetachedCriteria() {
		super(database.Valor.class, database.ValorCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("requisito.ID", this.getDetachedCriteria());
		requisito = new AssociationExpression("requisito", this.getDetachedCriteria());
		valor = new IntegerExpression("valor", this.getDetachedCriteria());
	}
	
	public ValorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, database.ValorCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("requisito.ID", this.getDetachedCriteria());
		requisito = new AssociationExpression("requisito", this.getDetachedCriteria());
		valor = new IntegerExpression("valor", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public ProyectoDetachedCriteria createProyectoCriteria() {
		return new ProyectoDetachedCriteria(createCriteria("proyecto"));
	}
	
	public RequisitoDetachedCriteria createRequisitoCriteria() {
		return new RequisitoDetachedCriteria(createCriteria("requisito"));
	}
	
	public Valor uniqueValor(PersistentSession session) {
		return (Valor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Valor[] listValor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Valor[]) list.toArray(new Valor[list.size()]);
	}
}

