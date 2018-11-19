package clases;

public class RequisitoSat implements Comparable<RequisitoSat>{
	
	private String nombre;
	private int esfuerzo;
	private int satisfaccion;
	
	public RequisitoSat(String nombre, int esfuerzo, int satisfaccion){
		this.nombre = nombre;
		this.esfuerzo = esfuerzo;
		this.satisfaccion = satisfaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEsfuerzo() {
		return esfuerzo;
	}

	public void setEsfuerzo(int esfuerzo) {
		this.esfuerzo = esfuerzo;
	}

	public int getSatisfaccion() {
		return satisfaccion;
	}

	public void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}
	@Override
	public int compareTo(RequisitoSat otro) {
		if(Integer.compare(this.satisfaccion, otro.satisfaccion) == 0)
			return Integer.compare(this.esfuerzo, otro.esfuerzo);
		return -Integer.compare(this.satisfaccion, otro.satisfaccion);
	}
}
