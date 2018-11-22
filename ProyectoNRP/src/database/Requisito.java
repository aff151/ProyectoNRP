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
@Table(name="Requisito")
public class Requisito implements Serializable {
	public Requisito() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_REQUISITO_VALORS) {
			return ORM_valors;
		}
		else if (key == ORMConstants.KEY_REQUISITO_PROYREQS) {
			return ORM_proyReqs;
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
	@GeneratedValue(generator="DATABASE_REQUISITO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_REQUISITO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@OneToMany(mappedBy="requisito", targetEntity=database.Valor.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_valors = new java.util.HashSet();
	
	@OneToMany(mappedBy="requisito", targetEntity=database.ProyReq.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_proyReqs = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private void setORM_Valors(java.util.Set value) {
		this.ORM_valors = value;
	}
	
	private java.util.Set getORM_Valors() {
		return ORM_valors;
	}
	
	@Transient	
	public final database.ValorSetCollection valors = new database.ValorSetCollection(this, _ormAdapter, ORMConstants.KEY_REQUISITO_VALORS, ORMConstants.KEY_VALOR_REQUISITO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public database.Proyecto[] getProyectos() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = proyReqs.getIterator();lIter.hasNext();) {
			lValues.add(((database.ProyReq)lIter.next()).getProyecto());
		}
		return (database.Proyecto[])lValues.toArray(new database.Proyecto[lValues.size()]);
	}
	
	public void removeProyecto(database.Proyecto aProyecto) {
		database.ProyReq[] lProyReqs = proyReqs.toArray();
		for(int i = 0; i < lProyReqs.length; i++) {
			if(lProyReqs[i].getProyecto().equals(aProyecto)) {
				proyReqs.remove(lProyReqs[i]);
			}
		}
	}
	
	public void addProyecto(database.ProyReq aProyReq, database.Proyecto aProyecto) {
		aProyReq.setProyecto(aProyecto);
		proyReqs.add(aProyReq);
	}
	
	public database.ProyReq getProyReqByProyecto(database.Proyecto aProyecto) {
		database.ProyReq[] lProyReqs = proyReqs.toArray();
		for(int i = 0; i < lProyReqs.length; i++) {
			if(lProyReqs[i].getProyecto().equals(aProyecto)) {
				return lProyReqs[i];
			}
		}
		return null;
	}
	
	private void setORM_ProyReqs(java.util.Set value) {
		this.ORM_proyReqs = value;
	}
	
	private java.util.Set getORM_ProyReqs() {
		return ORM_proyReqs;
	}
	
	@Transient	
	public final database.ProyReqSetCollection proyReqs = new database.ProyReqSetCollection(this, _ormAdapter, ORMConstants.KEY_REQUISITO_PROYREQS, ORMConstants.KEY_PROYREQ_REQUISITO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
