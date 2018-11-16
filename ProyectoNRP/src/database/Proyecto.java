/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alfonso(University of Almeria)
 * License Type: Academic
 */
package database;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Proyecto")
public class Proyecto implements Serializable {
	public Proyecto() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PROYECTO_PROYREQS) {
			return ORM_proyReqs;
		}
		else if (key == ORMConstants.KEY_PROYECTO_PESOS) {
			return ORM_pesos;
		}
		else if (key == ORMConstants.KEY_PROYECTO_VALORS) {
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
	@GeneratedValue(generator="DATABASE_PROYECTO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_PROYECTO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.ProyReq.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_proyReqs = new java.util.HashSet();
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.Peso.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pesos = new java.util.HashSet();
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.Valor.class)	
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
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public database.Requisito[] getRequisitos() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = proyReqs.getIterator();lIter.hasNext();) {
			lValues.add(((database.ProyReq)lIter.next()).getRequisito());
		}
		return (database.Requisito[])lValues.toArray(new database.Requisito[lValues.size()]);
	}
	
	public void removeRequisito(database.Requisito aRequisito) {
		database.ProyReq[] lProyReqs = proyReqs.toArray();
		for(int i = 0; i < lProyReqs.length; i++) {
			if(lProyReqs[i].getRequisito().equals(aRequisito)) {
				proyReqs.remove(lProyReqs[i]);
			}
		}
	}
	
	public void addRequisito(database.ProyReq aProyReq, database.Requisito aRequisito) {
		aProyReq.setRequisito(aRequisito);
		proyReqs.add(aProyReq);
	}
	
	public database.ProyReq getProyReqByRequisito(database.Requisito aRequisito) {
		database.ProyReq[] lProyReqs = proyReqs.toArray();
		for(int i = 0; i < lProyReqs.length; i++) {
			if(lProyReqs[i].getRequisito().equals(aRequisito)) {
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
	public final database.ProyReqSetCollection proyReqs = new database.ProyReqSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_PROYREQS, ORMConstants.KEY_PROYREQ_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public database.Cliente[] getClientes() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = pesos.getIterator();lIter.hasNext();) {
			lValues.add(((database.Peso)lIter.next()).getCliente());
		}
		return (database.Cliente[])lValues.toArray(new database.Cliente[lValues.size()]);
	}
	
	public void removeCliente(database.Cliente aCliente) {
		database.Peso[] lPesos = pesos.toArray();
		for(int i = 0; i < lPesos.length; i++) {
			if(lPesos[i].getCliente().equals(aCliente)) {
				pesos.remove(lPesos[i]);
			}
		}
	}
	
	public void addCliente(database.Peso aPeso, database.Cliente aCliente) {
		aPeso.setCliente(aCliente);
		pesos.add(aPeso);
	}
	
	public database.Peso getPesoByCliente(database.Cliente aCliente) {
		database.Peso[] lPesos = pesos.toArray();
		for(int i = 0; i < lPesos.length; i++) {
			if(lPesos[i].getCliente().equals(aCliente)) {
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
	public final database.PesoSetCollection pesos = new database.PesoSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_PESOS, ORMConstants.KEY_PESO_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Valors(java.util.Set value) {
		this.ORM_valors = value;
	}
	
	private java.util.Set getORM_Valors() {
		return ORM_valors;
	}
	
	@Transient	
	public final database.ValorSetCollection valors = new database.ValorSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_VALORS, ORMConstants.KEY_VALOR_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
