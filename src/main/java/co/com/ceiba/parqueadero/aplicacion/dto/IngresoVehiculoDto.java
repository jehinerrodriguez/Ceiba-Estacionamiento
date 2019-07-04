package co.com.ceiba.parqueadero.aplicacion.dto;

import java.util.Calendar;

public class IngresoVehiculoDto {
	
	private Calendar fechaIngreso;
	private String tipoVehiculo;
	private String placa;
	
	public IngresoVehiculoDto(Calendar fechaIngreso, String tipoVehiculo, String placa) {
		this.fechaIngreso = fechaIngreso;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
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
