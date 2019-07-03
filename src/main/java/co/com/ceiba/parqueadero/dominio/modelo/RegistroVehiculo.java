package co.com.ceiba.parqueadero.dominio.modelo;

import java.util.Calendar;

public class RegistroVehiculo {
	
	private Long id;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private String tipoVehiculo;
	private long cilindraje;
	private String placa;
	private double valor;

	public RegistroVehiculo(long id, Calendar fechaIngreso, Calendar fechaSalida, String tipoVehiculo, long cilindraje, String placa, double valor) {
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.placa = placa;
		this.valor = valor;
	}
}
