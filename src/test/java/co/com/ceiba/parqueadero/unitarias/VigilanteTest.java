package co.com.ceiba.parqueadero.unitarias;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.parqueadero.dominio.modelo.IngresoVehiculo;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest {

	@Mock
	RepositorioRegistroVehiculo registroVehiculo;

	public static final String TIPO_CARRO = "C";
	public static final String TIPO_MOTO = "M";

	public Vigilante vigilante = new Vigilante();

	@Test
	public void calcularPrecioCarroTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 00, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 2, 9, 0);

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_CARRO, 0);

		// Assert
		assertEquals(8000, precio, 0);
	}

	@Test
	public void calcularPrecioMotoBajaTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 10, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 13, 4, 00);
		int cilindraje = 125;

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_MOTO, cilindraje);

		// Assert
		assertTrue(44000 == precio);
	}

	@Test
	public void calcularPrecioMotoAltaTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 00, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 2, 2, 00);
		int cilindraje = 650;

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_MOTO, cilindraje);

		// Assert
		assertEquals(3000, precio, 0);
		//assertTrue(3000 == precio);
	}

	@Test
	public void validarDiaTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 1, 00, 00);
		IngresoVehiculo ingresoVehiculo = new IngresoVehiculo(fechaIngreso, TIPO_CARRO, "ABC123");

		// Act
		vigilante.validarDia(ingresoVehiculo);

		// Assert
	}

	@Test
	public void validarDiaNoHabilTest() {
		// Arrange
		Calendar fechaIngresoNoHabil = new GregorianCalendar(2019, Calendar.JULY, 3);
		IngresoVehiculo ingresoVehiculoNoHabil = new IngresoVehiculo(fechaIngresoNoHabil, TIPO_CARRO, "BC123");

		// Act
		vigilante.validarDia(ingresoVehiculoNoHabil);

		// Assert
	}
}
