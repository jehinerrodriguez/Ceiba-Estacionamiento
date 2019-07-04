package co.com.ceiba.parqueadero.infraestructura.persistencia.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
	private static final String PARQUEADERO = "parqueadero";
	private static EntityManagerFactory entityManagerFactory;

	public ConexionJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PARQUEADERO);
	}
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
