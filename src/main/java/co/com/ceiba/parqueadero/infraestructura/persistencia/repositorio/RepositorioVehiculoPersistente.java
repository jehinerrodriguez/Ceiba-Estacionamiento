package co.com.ceiba.parqueadero.infraestructura.persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import co.com.ceiba.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.infraestructura.persistencia.entidad.RegistroParqueoEntity;
import co.com.ceiba.parqueadero.infraestructura.persistencia.repositorio.jpa.RegistroParqueoRepositorioJPA;

public class RepositorioVehiculoPersistente implements RepositorioRegistroVehiculo, RegistroParqueoRepositorioJPA{
	
	private static final String CODIGO = "id";
	private static final String PRODUCTO_FIND_BY_ID = "Producto.findById";
	
	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public RegistroParqueoEntity obtenerRegistroParqueoEntityPorId(int id) {
		return null;
	}

	@Override
	public RegistroVehiculo registrarVehiculo(RegistroVehiculo registroVehiculo) {
		return null;
	}

	@Override
	public int calcularVehiculos(String tipoVehiculo) {
		return 0;
	}

	@Override
	public RegistroVehiculo buscarVehiculo(String placa) {
		return null;
	}

	@Override
	public List<RegistroVehiculo> mostrarVehiculos() {
		return null;
	}

}
