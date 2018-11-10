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

public class ImportanciaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final IntegerExpression proyectoId;
	public final AssociationExpression proyecto;
	public final IntegerExpression importancia;
	
	public ImportanciaDetachedCriteria() {
		super(Importancia.class, ImportanciaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		importancia = new IntegerExpression("importancia", this.getDetachedCriteria());
	}
	
	public ImportanciaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ImportanciaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.ID", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		proyectoId = new IntegerExpression("proyecto.ID", this.getDetachedCriteria());
		proyecto = new AssociationExpression("proyecto", this.getDetachedCriteria());
		importancia = new IntegerExpression("importancia", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public ProyectoDetachedCriteria createProyectoCriteria() {
		return new ProyectoDetachedCriteria(createCriteria("proyecto"));
	}
	
	public Importancia uniqueImportancia(PersistentSession session) {
		return (Importancia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Importancia[] listImportancia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Importancia[]) list.toArray(new Importancia[list.size()]);
	}
}

