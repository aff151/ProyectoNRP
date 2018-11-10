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
import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Importancia")
public class Importancia implements Serializable {
	public Importancia() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="IMPORTANCIA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="IMPORTANCIA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToOne(targetEntity=Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ClienteID", referencedColumnName="ID", nullable=false) })	
	private Cliente cliente;
	
	@OneToOne(targetEntity=Proyecto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ProyectoID", referencedColumnName="ID", nullable=false) })	
	private Proyecto proyecto;
	
	@Column(name="Importancia", nullable=false, length=10)	
	private int importancia;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setImportancia(int value) {
		this.importancia = value;
	}
	
	public int getImportancia() {
		return importancia;
	}
	
	public void setProyecto(Proyecto value) {
		if (this.proyecto != value) {
			Proyecto lproyecto = this.proyecto;
			this.proyecto = value;
			if (value != null) {
				proyecto.setImportancia(this);
			}
			if (lproyecto != null && lproyecto.getImportancia() == this) {
				lproyecto.setImportancia(null);
			}
		}
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	public void setCliente(Cliente value) {
		if (this.cliente != value) {
			Cliente lcliente = this.cliente;
			this.cliente = value;
			if (value != null) {
				cliente.setImportancia(this);
			}
			if (lcliente != null && lcliente.getImportancia() == this) {
				lcliente.setImportancia(null);
			}
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
