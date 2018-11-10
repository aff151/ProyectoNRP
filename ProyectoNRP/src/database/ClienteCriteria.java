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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final IntegerExpression importanciaId;
	public final AssociationExpression importancia;
	public final IntegerExpression pesoId;
	public final AssociationExpression peso;
	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		importanciaId = new IntegerExpression("importancia.ID", this);
		importancia = new AssociationExpression("importancia", this);
		pesoId = new IntegerExpression("peso.ID", this);
		peso = new AssociationExpression("peso", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ImportanciaCriteria createImportanciaCriteria() {
		return new ImportanciaCriteria(createCriteria("importancia"));
	}
	
	public PesoCriteria createPesoCriteria() {
		return new PesoCriteria(createCriteria("peso"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

