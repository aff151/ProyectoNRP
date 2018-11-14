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
@Table(name="ProyReq")
public class ProyReq implements Serializable {
	public ProyReq() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROYREQ_REQUISITO) {
			this.requisito = (database.Requisito) owner;
		}
		
		else if (key == ORMConstants.KEY_PROYREQ_PROYECTO) {
			this.proyecto = (database.Proyecto) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DATABASE_PROYREQ_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_PROYREQ_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=database.Proyecto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ProyectoID", referencedColumnName="ID", nullable=false) })	
	private database.Proyecto proyecto;
	
	@ManyToOne(targetEntity=database.Requisito.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="RequisitoID", referencedColumnName="ID", nullable=false) })	
	private database.Requisito requisito;
	
	@Column(name="Esfuerzo", nullable=false, length=10)	
	private int esfuerzo;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setEsfuerzo(int value) {
		this.esfuerzo = value;
	}
	
	public int getEsfuerzo() {
		return esfuerzo;
	}
	
	public void setRequisito(database.Requisito value) {
		if (requisito != null) {
			requisito.proyReqs.remove(this);
		}
		if (value != null) {
			value.proyReqs.add(this);
		}
	}
	
	public database.Requisito getRequisito() {
		return requisito;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Requisito(database.Requisito value) {
		this.requisito = value;
	}
	
	private database.Requisito getORM_Requisito() {
		return requisito;
	}
	
	public void setProyecto(database.Proyecto value) {
		if (proyecto != null) {
			proyecto.proyReqs.remove(this);
		}
		if (value != null) {
			value.proyReqs.add(this);
		}
	}
	
	public database.Proyecto getProyecto() {
		return proyecto;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Proyecto(database.Proyecto value) {
		this.proyecto = value;
	}
	
	private database.Proyecto getORM_Proyecto() {
		return proyecto;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
