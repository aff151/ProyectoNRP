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
@Table(name="Proyecto")
public class Proyecto implements Serializable {
	public Proyecto() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PROYECTO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PROYECTO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@OneToOne(mappedBy="proyecto", targetEntity=Importancia.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Importancia importancia;
	
	@OneToOne(mappedBy="proyecto", targetEntity=Peso.class, fetch=FetchType.LAZY)	
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
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setImportancia(Importancia value) {
		if (this.importancia != value) {
			Importancia limportancia = this.importancia;
			this.importancia = value;
			if (value != null) {
				importancia.setProyecto(this);
			}
			if (limportancia != null && limportancia.getProyecto() == this) {
				limportancia.setProyecto(null);
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
				peso.setProyecto(this);
			}
			if (lpeso != null && lpeso.getProyecto() == this) {
				lpeso.setProyecto(null);
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
