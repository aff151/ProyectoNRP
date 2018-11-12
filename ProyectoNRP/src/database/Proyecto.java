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
		if (key == ORMConstants.KEY_PROYECTO_IMPORTANCIAS) {
			return ORM_importancias;
		}
		else if (key == ORMConstants.KEY_PROYECTO_PESOS) {
			return ORM_pesos;
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
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.Importancia.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_importancias = new java.util.HashSet();
	
	@OneToMany(mappedBy="proyecto", targetEntity=database.Peso.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pesos = new java.util.HashSet();
	
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
	
	public database.Cliente[] getClientes() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = importancias.getIterator();lIter.hasNext();) {
			lValues.add(((database.Importancia)lIter.next()).getCliente());
		}
		return (database.Cliente[])lValues.toArray(new database.Cliente[lValues.size()]);
	}
	
	public void removeCliente(database.Cliente aCliente) {
		database.Importancia[] lImportancias = importancias.toArray();
		for(int i = 0; i < lImportancias.length; i++) {
			if(lImportancias[i].getCliente().equals(aCliente)) {
				importancias.remove(lImportancias[i]);
			}
		}
	}
	
	public void addCliente(database.Importancia aImportancia, database.Cliente aCliente) {
		aImportancia.setCliente(aCliente);
		importancias.add(aImportancia);
	}
	
	public database.Importancia getImportanciaByCliente(database.Cliente aCliente) {
		database.Importancia[] lImportancias = importancias.toArray();
		for(int i = 0; i < lImportancias.length; i++) {
			if(lImportancias[i].getCliente().equals(aCliente)) {
				return lImportancias[i];
			}
		}
		return null;
	}
	
	private void setORM_Importancias(java.util.Set value) {
		this.ORM_importancias = value;
	}
	
	private java.util.Set getORM_Importancias() {
		return ORM_importancias;
	}
	
	@Transient	
	public final database.ImportanciaSetCollection importancias = new database.ImportanciaSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_IMPORTANCIAS, ORMConstants.KEY_IMPORTANCIA_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Pesos(java.util.Set value) {
		this.ORM_pesos = value;
	}
	
	private java.util.Set getORM_Pesos() {
		return ORM_pesos;
	}
	
	@Transient	
	public final database.PesoSetCollection pesos = new database.PesoSetCollection(this, _ormAdapter, ORMConstants.KEY_PROYECTO_PESOS, ORMConstants.KEY_PESO_PROYECTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
