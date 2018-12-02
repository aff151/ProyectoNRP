package clases;

public class claseEstatica {

	private static String propietario = "";
private static String procedencia="";
private static String proySeleccionado="";
	public static String getPropietario() {
		return propietario;
	}

	public static void setPropietario(String propietario) {
		claseEstatica.propietario = propietario;
	}

	public static String getProcedencia() {
		return procedencia;
	}

	public static void setProcedencia(String procedencia) {
		claseEstatica.procedencia = procedencia;
	}

	public static String getProySeleccionado() {
		return proySeleccionado;
	}

	public static void setProySeleccionado(String proySeleccionado) {
		claseEstatica.proySeleccionado = proySeleccionado;
	}

}
