package co.com.ceiba.parqueadero.infraestructura.persistencia.builder;

import co.com.ceiba.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.infraestructura.persistencia.entidad.RegistroParqueoEntity;

public class RegistroParqueoBuilder {

	private RegistroParqueoBuilder() {
	}

	public static RegistroVehiculo convertirADominio(RegistroParqueoEntity registroParqueoEntity) {

		RegistroVehiculo registroVehiculo = null;

		if (registroParqueoEntity != null) {
			registroVehiculo = new RegistroVehiculo(registroParqueoEntity.getId(),
					registroParqueoEntity.getFechaIngreso(), registroParqueoEntity.getFechaSalida(),
					registroParqueoEntity.getTipoVehiculo(), registroParqueoEntity.getCilindraje(),
					registroParqueoEntity.getPlaca(), registroParqueoEntity.getValor());
		}

		return registroVehiculo;
	}

	public static RegistroParqueoEntity convertirAEntity(RegistroVehiculo registroVehiculo) {

		RegistroParqueoEntity registroParqueoEntity = new RegistroParqueoEntity();

		registroVehiculo.setFechaIngreso(registroVehiculo.getFechaIngreso());
		registroVehiculo.setFechaSalida(registroVehiculo.getFechaSalida());
		registroVehiculo.setTipoVehiculo(registroVehiculo.getTipoVehiculo());
		registroVehiculo.setCilindraje(registroVehiculo.getCilindraje());
		registroVehiculo.setPlaca(registroVehiculo.getPlaca());
		registroVehiculo.setValor(registroVehiculo.getValor());

		return registroParqueoEntity;
	}

}
