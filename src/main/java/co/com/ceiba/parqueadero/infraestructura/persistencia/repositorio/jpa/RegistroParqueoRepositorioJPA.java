package co.com.ceiba.parqueadero.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.parqueadero.infraestructura.persistencia.entidad.RegistroParqueoEntity;

public interface RegistroParqueoRepositorioJPA {
	RegistroParqueoEntity obtenerRegistroParqueoEntityPorId(int id);
}
