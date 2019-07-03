package co.com.ceiba.parqueadero.dominio.modelo;

import java.util.Calendar;

import co.com.ceiba.parqueadero.dominio.excepciones.ParqueaderoExcepcion;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

public class Vigilante {

	public static final int CUPO_MAXIMO_CARROS = 20;
	public static final int CUPO_MAXIMO_MOTOS = 10;

	public static final int PRECIO_MOTO_DIA = 4000;
	public static final int PRECIO_CARRO_DIA = 8000;
	public static final int PRECIO_MOTO_HORA = 500;
	public static final int PRECIO_CARRO_HORA = 1000;
	public static final int PRECIO_ADICIONAL = 2000;

	public static final int HORAS_MAXIMAS_HORA_POR_DIA = 9;
	public static final int HORAS_MAXIMAS_POR_DIA = 24;

	public static final String INICIAL_NO_PERMITIDA = "A";

	public static final int DIA_DOMINGO = 1;
	public static final int DIA_LUNES = 2;

	public static final int CILINDRAJE_ALTO = 500;

	public static final String MENSAJE_NO_HABIL = "No se permite el ingreso del vehículo";

	public static final String PLACA_REGISTRADA = "La placa del vehículo ya se encuentra registrada";

	public static final String TIPO_CARRO = "C";
	public static final String TIPO_MOTO = "M";

	public static final String MENSAJE_CARRO_MAXIMO = "La cantidad actual de carros es la capacidad máxima";
	public static final String MENSAJE_MOTO_MAXIMO = "La cantidad actual de motos es la capacidad máxima";

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;

	public Vigilante() {
		//this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
	}

	public void validarCupo(IngresoVehiculo ingresoVehiculo) {
		String tipoVehiculo = ingresoVehiculo.getTipoVehiculo();

		int cantidadVehiculos = repositorioRegistroVehiculo.calcularVehiculos(tipoVehiculo);

		if (tipoVehiculo.equals(TIPO_CARRO) && cantidadVehiculos == CUPO_MAXIMO_CARROS) {
			throw new ParqueaderoExcepcion(MENSAJE_CARRO_MAXIMO);
		}

		if (tipoVehiculo.equals(TIPO_MOTO) && cantidadVehiculos == CUPO_MAXIMO_MOTOS) {
			throw new ParqueaderoExcepcion(MENSAJE_CARRO_MAXIMO);
		}
	}

	public void validarPlaca(String placa) {
		RegistroVehiculo registroVehiculo = repositorioRegistroVehiculo.buscarVehiculo(placa);
		if (registroVehiculo != null) {
			throw new ParqueaderoExcepcion(PLACA_REGISTRADA);
		}
	}

	public void validarDia(IngresoVehiculo ingresoVehiculo) {
		int diaIngreso = ingresoVehiculo.getFechaIngreso().get(Calendar.DAY_OF_WEEK);
		if (ingresoVehiculo.getPlaca().startsWith(INICIAL_NO_PERMITIDA) && diaIngreso != DIA_LUNES
				&& diaIngreso != DIA_DOMINGO)
			throw new ParqueaderoExcepcion(MENSAJE_NO_HABIL);
	}

	public double calcularPrecio(Calendar fechaIngreso, Calendar fechaSalida, String tipoVehiculo, int cilindraje) {
		double precioFinal = 0;
		long diferenciaDias = 0;
		double diferenciaHoras = 0;
		long diferenciaMilisegundos = 0;
		double milisegundosHora = (1000 * 60 * 60);
		double milisegundosDia = (milisegundosHora * 24);
		
		diferenciaMilisegundos = (fechaSalida.getTimeInMillis() - fechaIngreso.getTimeInMillis());
		
		diferenciaDias = (long) (diferenciaMilisegundos / milisegundosDia);
		
		diferenciaMilisegundos = (long) (diferenciaMilisegundos - (milisegundosDia * diferenciaDias));
		
		diferenciaHoras = diferenciaMilisegundos/milisegundosHora;
		
		if(diferenciaHoras >= HORAS_MAXIMAS_HORA_POR_DIA) {
			diferenciaHoras = 0;
			diferenciaDias++;
		}
		
		diferenciaHoras = Math.ceil(diferenciaHoras);
		
		if(tipoVehiculo.equals(TIPO_CARRO)) {
			precioFinal = diferenciaDias * PRECIO_CARRO_DIA + 
					(diferenciaHoras * PRECIO_CARRO_HORA);
		}else {
			precioFinal = (double) (diferenciaDias * PRECIO_MOTO_DIA) + 
					(diferenciaHoras * PRECIO_MOTO_HORA);
				
			if(cilindraje > CILINDRAJE_ALTO) {
				precioFinal += PRECIO_ADICIONAL;
			}
		}
		return precioFinal;
	}
}
