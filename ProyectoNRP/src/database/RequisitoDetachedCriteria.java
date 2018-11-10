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

public class RequisitoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression pesoId;
	public final AssociationExpression peso;
	
	public RequisitoDetachedCriteria() {
		super(Requisito.class, RequisitoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		pesoId = new IntegerExpression("peso.ID", this.getDetachedCriteria());
		peso = new AssociationExpression("peso", this.getDetachedCriteria());
	}
	
	public RequisitoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, RequisitoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		pesoId = new IntegerExpression("peso.ID", this.getDetachedCriteria());
		peso = new AssociationExpression("peso", this.getDetachedCriteria());
	}
	
	public PesoDetachedCriteria createPesoCriteria() {
		return new PesoDetachedCriteria(createCriteria("peso"));
	}
	
	public Requisito uniqueRequisito(PersistentSession session) {
		return (Requisito) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Requisito[] listRequisito(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Requisito[]) list.toArray(new Requisito[list.size()]);
	}
}

