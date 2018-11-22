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
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROYECTO_PROPIETARIO) {
			this.propietario = (database.Propietario) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DATABASE_PROYECTO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_PROYECTO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=database.Propietario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PropietarioID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKProyecto567494"))	
	private database.Propietario propietario;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="NombrePropietario", nullable=true, length=255)	
	private String nombrePropietario;
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.ProyReq.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_proyReqs = new java.util.HashSet();
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.peso.class)	
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
	
	public void setNombrePropietario(String value) {
		this.nombrePropietario = value;
	}
	
	public String getNombrePropietario() {
		return nombrePropietario;
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
			lValues.add(((database.peso)lIter.next()).getCliente());
		}
		return (database.Cliente[])lValues.toArray(new database.Cliente[lValues.size()]);
	}
	
	public void removeCliente(database.Cliente aCliente) {
		database.peso[] lPesos = pesos.toArray();
		for(int i = 0; i < lPesos.length; i++) {
			if(lPesos[i].getCliente().equals(aCliente)) {
				pesos.remove(lPesos[i]);
			}
		}
	}
	
	public void addCliente(database.peso aPeso, database.Cliente aCliente) {
		aPeso.setCliente(aCliente);
		pesos.add(aPeso);
	}
	
	public database.peso getPesoByCliente(database.Cliente aCliente) {
		database.peso[] lPesos = pesos.toArray();
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
	public final database.pesoSetCollection pesos = new database.pesoSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_PESOS, ORMConstants.KEY_PESO_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Valors(java.util.Set value) {
		this.ORM_valors = value;
	}
	
	private java.util.Set getORM_Valors() {
		return ORM_valors;
	}
	
	@Transient	
	public final database.ValorSetCollection valors = new database.ValorSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_VALORS, ORMConstants.KEY_VALOR_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPropietario(database.Propietario value) {
		if (propietario != null) {
			propietario.proyectos.remove(this);
		}
		if (value != null) {
			value.proyectos.add(this);
		}
	}
	
	public database.Propietario getPropietario() {
		return propietario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Propietario(database.Propietario value) {
		this.propietario = value;
	}
	
	private database.Propietario getORM_Propietario() {
		return propietario;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
