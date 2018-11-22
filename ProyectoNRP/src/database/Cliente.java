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
@Table(name="Cliente")
public class Cliente implements Serializable {
	public Cliente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLIENTE_PESOS) {
			return ORM_pesos;
		}
		else if (key == ORMConstants.KEY_CLIENTE_VALORS) {
			return ORM_valors;
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
	@GeneratedValue(generator="DATABASE_CLIENTE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_CLIENTE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@OneToMany(mappedBy="cliente", targetEntity=database.peso.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pesos = new java.util.HashSet();
	
	@OneToMany(mappedBy="cliente", targetEntity=database.Valor.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_valors = new java.util.HashSet();
	
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
	
	public database.Proyecto[] getProyectos() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = pesos.getIterator();lIter.hasNext();) {
			lValues.add(((database.peso)lIter.next()).getProyecto());
		}
		return (database.Proyecto[])lValues.toArray(new database.Proyecto[lValues.size()]);
	}
	
	public void removeProyecto(database.Proyecto aProyecto) {
		database.peso[] lPesos = pesos.toArray();
		for(int i = 0; i < lPesos.length; i++) {
			if(lPesos[i].getProyecto().equals(aProyecto)) {
				pesos.remove(lPesos[i]);
			}
		}
	}
	
	public void addProyecto(database.peso aPeso, database.Proyecto aProyecto) {
		aPeso.setProyecto(aProyecto);
		pesos.add(aPeso);
	}
	
	public database.peso getPesoByProyecto(database.Proyecto aProyecto) {
		database.peso[] lPesos = pesos.toArray();
		for(int i = 0; i < lPesos.length; i++) {
			if(lPesos[i].getProyecto().equals(aProyecto)) {
				return lPesos[i];
			}
		}
		return null;
	}
	
	private void setORM_Pesos(java.util.Set value) {
		this.ORM_pesos = value;
	}
	
	private java.util.Set getORM_Pesos() {
		return ORM_pesos;
	}
	
	@Transient	
	public final database.pesoSetCollection pesos = new database.pesoSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENTE_PESOS, ORMConstants.KEY_PESO_CLIENTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Valors(java.util.Set value) {
		this.ORM_valors = value;
	}
	
	private java.util.Set getORM_Valors() {
		return ORM_valors;
	}
	
	@Transient	
	public final database.ValorSetCollection valors = new database.ValorSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENTE_VALORS, ORMConstants.KEY_VALOR_CLIENTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
