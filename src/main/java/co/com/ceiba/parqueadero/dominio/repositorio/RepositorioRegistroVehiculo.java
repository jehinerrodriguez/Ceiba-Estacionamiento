package co.com.ceiba.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.RegistroVehiculo;

public interface RepositorioRegistroVehiculo {
	
	public RegistroVehiculo registrarVehiculo(RegistroVehiculo registroVehiculo);

	public int calcularVehiculos(String tipoVehiculo);
	
	public RegistroVehiculo buscarVehiculo(String placa);
	
	public List<RegistroVehiculo> mostrarVehiculos();

}
