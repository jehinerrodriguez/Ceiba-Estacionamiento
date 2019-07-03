package co.com.ceiba.parqueadero.dominio.modelo;

import java.util.Calendar;

import co.com.ceiba.parqueadero.dominio.excepciones.ParqueaderoExcepcion;

public class IngresoVehiculo {

	public static final String CAMPOS_REQUERIDOS = "Todos los campos del formulario deben ser diligenciados.";
	
	private Calendar fechaIngreso;
	private String tipoVehiculo;
	private String placa;

	public IngresoVehiculo(Calendar fechaIngreso, String tipoVehiculo, String placa) {
		validarDatos(tipoVehiculo, placa);
		this.fechaIngreso = fechaIngreso;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
	}

	public void validarDatos(String tipoVehiculo, String placa) {
		if (tipoVehiculo == null || placa == null) 
			throw new ParqueaderoExcepcion(CAMPOS_REQUERIDOS);
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
