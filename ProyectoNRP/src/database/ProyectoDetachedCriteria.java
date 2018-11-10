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

public class ProyectoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression importanciaId;
	public final AssociationExpression importancia;
	public final IntegerExpression pesoId;
	public final AssociationExpression peso;
	
	public ProyectoDetachedCriteria() {
		super(Proyecto.class, ProyectoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		importanciaId = new IntegerExpression("importancia.ID", this.getDetachedCriteria());
		importancia = new AssociationExpression("importancia", this.getDetachedCriteria());
		pesoId = new IntegerExpression("peso.ID", this.getDetachedCriteria());
		peso = new AssociationExpression("peso", this.getDetachedCriteria());
	}
	
	public ProyectoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ProyectoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
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
	
	public Proyecto uniqueProyecto(PersistentSession session) {
		return (Proyecto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Proyecto[] listProyecto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
	}
}

