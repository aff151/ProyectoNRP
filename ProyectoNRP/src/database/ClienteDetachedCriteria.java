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

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final IntegerExpression importanciaId;
	public final AssociationExpression importancia;
	public final IntegerExpression pesoId;
	public final AssociationExpression peso;
	
	public ClienteDetachedCriteria() {
		super(Cliente.class, ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		importanciaId = new IntegerExpression("importancia.ID", this.getDetachedCriteria());
		importancia = new AssociationExpression("importancia", this.getDetachedCriteria());
		pesoId = new IntegerExpression("peso.ID", this.getDetachedCriteria());
		peso = new AssociationExpression("peso", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		importanciaId = new IntegerExpression("importancia.ID", this.getDetachedCriteria());
		importancia = new AssociationExpression("importancia", this.getDetachedCriteria());
		pesoId = new IntegerExpression("peso.ID", this.getDetachedCriteria());
		peso = new AssociationExpression("peso", this.getDetachedCriteria());
	}
	
	public ImportanciaDetachedCriteria createImportanciaCriteria() {
		return new ImportanciaDetachedCriteria(createCriteria("importancia"));
	}
	
	public PesoDetachedCriteria createPesoCriteria() {
		return new PesoDetachedCriteria(createCriteria("peso"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

