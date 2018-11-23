package clases;

public class claseEstatica {

	private static String propietario = "";

	public static String getPropietario() {
		return propietario;
	}

	public static void setPropietario(String propietario) {
		claseEstatica.propietario = propietario;
	}

}
