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
@Table(name="Cliente")
public class Cliente implements Serializable {
	public Cliente() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="CLIENTE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="CLIENTE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@OneToOne(mappedBy="cliente", targetEntity=Importancia.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Importancia importancia;
	
	@OneToOne(mappedBy="cliente", targetEntity=Peso.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Peso peso;
	
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
	
	public void setImportancia(Importancia value) {
		if (this.importancia != value) {
			Importancia limportancia = this.importancia;
			this.importancia = value;
			if (value != null) {
				importancia.setCliente(this);
			}
			if (limportancia != null && limportancia.getCliente() == this) {
				limportancia.setCliente(null);
			}
		}
	}
	
	public Importancia getImportancia() {
		return importancia;
	}
	
	public void setPeso(Peso value) {
		if (this.peso != value) {
			Peso lpeso = this.peso;
			this.peso = value;
			if (value != null) {
				peso.setCliente(this);
			}
			if (lpeso != null && lpeso.getCliente() == this) {
				lpeso.setCliente(null);
			}
		}
	}
	
	public Peso getPeso() {
		return peso;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
