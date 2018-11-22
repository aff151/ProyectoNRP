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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Propietario")
public class Propietario implements Serializable {
	public Propietario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PROPIETARIO_PROYECTOS) {
			return ORM_proyectos;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DATABASE_PROPIETARIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_PROPIETARIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Propietario", nullable=true, length=255)	
	private String propietario;
	
	@OneToMany(mappedBy="propietario", targetEntity=database.Proyecto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_proyectos = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPropietario(String value) {
		this.propietario = value;
	}
	
	public String getPropietario() {
		return propietario;
	}
	
	private void setORM_Proyectos(java.util.Set value) {
		this.ORM_proyectos = value;
	}
	
	private java.util.Set getORM_Proyectos() {
		return ORM_proyectos;
	}
	
	@Transient	
	public final database.ProyectoSetCollection proyectos = new database.ProyectoSetCollection(this, _ormAdapter, ORMConstants.KEY_PROPIETARIO_PROYECTOS, ORMConstants.KEY_PROYECTO_PROPIETARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
