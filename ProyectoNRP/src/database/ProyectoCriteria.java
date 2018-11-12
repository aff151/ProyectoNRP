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

public class ProyectoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final CollectionExpression importancias;
	public final CollectionExpression pesos;
	
	public ProyectoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		importancias = new CollectionExpression("ORM_importancias", this);
		pesos = new CollectionExpression("ORM_pesos", this);
	}
	
	public ProyectoCriteria(PersistentSession session) {
		this(session.createCriteria(Proyecto.class));
	}
	
	public ProyectoCriteria() throws PersistentException {
		this(BasededatosPersistentManager.instance().getSession());
	}
	
	public ImportanciaCriteria createImportanciasCriteria() {
		return new ImportanciaCriteria(createCriteria("ORM_importancias"));
	}
	
	public PesoCriteria createPesosCriteria() {
		return new PesoCriteria(createCriteria("ORM_pesos"));
	}
	
	public Proyecto uniqueProyecto() {
		return (Proyecto) super.uniqueResult();
	}
	
	public Proyecto[] listProyecto() {
		java.util.List list = super.list();
		return (Proyecto[]) list.toArray(new Proyecto[list.size()]);
	}
}

