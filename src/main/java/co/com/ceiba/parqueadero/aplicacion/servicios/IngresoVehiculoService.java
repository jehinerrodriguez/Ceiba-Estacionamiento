package co.com.ceiba.parqueadero.aplicacion.servicios;

import co.com.ceiba.parqueadero.aplicacion.dto.IngresoVehiculoDto;
import co.com.ceiba.parqueadero.aplicacion.dto.RegistroVehiculoDto;

public interface IngresoVehiculoService {
	public RegistroVehiculoDto ingresarVehiculo(IngresoVehiculoDto ingresoVehiculoDto);
}
