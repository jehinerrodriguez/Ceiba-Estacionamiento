package co.com.ceiba.parqueadero.infraestructura.persistencia.sistema;

import javax.persistence.EntityManager;

import co.com.ceiba.parqueadero.infraestructura.persistencia.conexion.ConexionJPA;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}
	
	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
