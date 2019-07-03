package co.com.ceiba.parqueadero.dominio.excepciones;

public class ParqueaderoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ParqueaderoExcepcion(String mensajeExcepcion) {
		super(mensajeExcepcion);
	}

}
