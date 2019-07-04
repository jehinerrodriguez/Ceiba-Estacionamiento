package co.com.ceiba.parqueadero.aplicacion.dto;

import java.util.Calendar;

public class RegistroVehiculoDto {
	private Long id;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private String tipoVehiculo;
	private long cilindraje;
	private String placa;
	private double valor;
	
	public RegistroVehiculoDto(long id, Calendar fechaIngreso, Calendar fechaSalida, String tipoVehiculo, long cilindraje, String placa, double valor) {
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
