package co.com.ceiba.parqueadero.aplicacion.factory;

import co.com.ceiba.parqueadero.aplicacion.dto.RegistroVehiculoDto;
import co.com.ceiba.parqueadero.dominio.modelo.RegistroVehiculo;

public class FactoryRegistroParqueoDto {
	
	public RegistroVehiculoDto pasarDominio(RegistroVehiculo registroVehiculo) {
		return new RegistroVehiculoDto(registroVehiculo.getId(), registroVehiculo.getFechaIngreso(),
				registroVehiculo.getFechaSalida(), registroVehiculo.getTipoVehiculo(),
				registroVehiculo.getCilindraje(), registroVehiculo.getPlaca(), registroVehiculo.getValor());
	}
	
	public RegistroVehiculo pasarDTO(RegistroVehiculoDto registroVehiculoDto) {
		return new RegistroVehiculo(registroVehiculoDto.getId(), registroVehiculoDto.getFechaIngreso(),
				registroVehiculoDto.getFechaSalida(), registroVehiculoDto.getTipoVehiculo(),
				registroVehiculoDto.getCilindraje(), registroVehiculoDto.getPlaca(),
				registroVehiculoDto.getValor());
	}
}



	

