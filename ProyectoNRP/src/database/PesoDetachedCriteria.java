package database;

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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PesoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression requisitoId;
	public final AssociationExpression requisito;
	public final IntegerExpression peso;
	
	public PesoDetachedCriteria() {
		super(Peso.class, PesoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("requisito.ID", this.getDetachedCriteria());
		requisito = new AssociationExpression("requisito", this.getDetachedCriteria());
		peso = new IntegerExpression("peso", this.getDetachedCriteria());
	}
	
	public PesoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PesoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		requisitoId = new IntegerExpression("requisito.ID", this.getDetachedCriteria());
		requisito = new AssociationExpression("requisito", this.getDetachedCriteria());
		peso = new IntegerExpression("peso", this.getDetachedCriteria());
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
	
	public Peso uniquePeso(PersistentSession session) {
		return (Peso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Peso[] listPeso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Peso[]) list.toArray(new Peso[list.size()]);
	}
}

