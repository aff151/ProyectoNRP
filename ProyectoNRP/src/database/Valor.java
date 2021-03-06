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
@Table(name="Valor")
public class Valor implements Serializable {
	public Valor() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_VALOR_REQUISITO) {
			this.requisito = (database.Requisito) owner;
		}
		
		else if (key == ORMConstants.KEY_VALOR_PROYECTO) {
			this.proyecto = (database.Proyecto) owner;
		}
		
		else if (key == ORMConstants.KEY_VALOR_CLIENTE) {
			this.cliente = (database.Cliente) owner;
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
	@GeneratedValue(generator="DATABASE_VALOR_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DATABASE_VALOR_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=database.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ClienteID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKValor422757"))	
	private database.Cliente cliente;
	
	@ManyToOne(targetEntity=database.Proyecto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProyectoID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKValor615710"))	
	private database.Proyecto proyecto;
	
	@ManyToOne(targetEntity=database.Requisito.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="RequisitoID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKValor838152"))	
	private database.Requisito requisito;
	
	@Column(name="Valor", nullable=false, length=10)	
	private int valor;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setValor(int value) {
		this.valor = value;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setRequisito(database.Requisito value) {
		if (requisito != null) {
			requisito.valors.remove(this);
		}
		if (value != null) {
			value.valors.add(this);
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
			proyecto.valors.remove(this);
		}
		if (value != null) {
			value.valors.add(this);
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
	
	public void setCliente(database.Cliente value) {
		if (cliente != null) {
			cliente.valors.remove(this);
		}
		if (value != null) {
			value.valors.add(this);
		}
	}
	
	public database.Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Cliente(database.Cliente value) {
		this.cliente = value;
	}
	
	private database.Cliente getORM_Cliente() {
		return cliente;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
