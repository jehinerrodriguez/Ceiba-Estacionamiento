package co.com.ceiba.parqueadero.aplicacion.factory;

import co.com.ceiba.parqueadero.aplicacion.dto.IngresoVehiculoDto;
import co.com.ceiba.parqueadero.dominio.modelo.IngresoVehiculo;

public class FactoryIngresoVehiculoDto {
	
	public IngresoVehiculoDto pasarDominio(IngresoVehiculo ingresoVehiculo) {
		return new IngresoVehiculoDto(ingresoVehiculo.getFechaIngreso(), ingresoVehiculo.getTipoVehiculo(), ingresoVehiculo.getPlaca());
	}
}
