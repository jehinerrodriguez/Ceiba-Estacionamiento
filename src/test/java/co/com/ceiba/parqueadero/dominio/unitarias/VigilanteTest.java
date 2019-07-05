package co.com.ceiba.parqueadero.dominio.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.validation.constraints.Pattern.Flag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.parqueadero.dominio.modelo.IngresoVehiculo;
import co.com.ceiba.parqueadero.dominio.modelo.Vigilante;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest {

	public static final String TIPO_CARRO = "C";
	public static final String TIPO_MOTO = "M";
	
	public static final String PLACA_ABC123 = "ABC123";
	
	public static final int PRECIO_6500 = 6500;
	public static final int PRECIO_8000 = 8000;
	public static final int PRECIO_44000 = 44000;
	public static final int CILINDRAJE_125 = 125;
	public static final int CILINDRAJE_650 = 650;

	@Mock
	RepositorioRegistroVehiculo registroVehiculo;
	@InjectMocks
	Vigilante vigilante;	

	@Test
	public void calcularPrecioCarroTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 00, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 2, 9, 0);

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_CARRO, 0);

		// Assert
		assertEquals(PRECIO_8000, precio, 0);
	}

	@Test
	public void calcularPrecioMotoBajaTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 10, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 13, 4, 00);

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_MOTO, CILINDRAJE_125);

		// Assert
		assertTrue(PRECIO_44000 == precio);
	}

	@Test
	public void calcularPrecioMotoAltaTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 2, 00, 00);
		Calendar fechaSalida = new GregorianCalendar(2019, Calendar.JULY, 2, 8, 59);

		// Act
		double precio = vigilante.calcularPrecio(fechaIngreso, fechaSalida, TIPO_MOTO, CILINDRAJE_650);

		// Assert
		assertEquals(PRECIO_6500, precio, 0);
	}
	
	@Test
	public void validarDiaDomingoTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JUNE, 30, 00, 00);
		IngresoVehiculo ingresoVehiculo = new IngresoVehiculo(fechaIngreso, TIPO_CARRO, PLACA_ABC123);

		// Act
		vigilante.validarDia(ingresoVehiculo);
	}

	@Test
	public void validarDiaLunesTest() {
		// Arrange
		Calendar fechaIngreso = new GregorianCalendar(2019, Calendar.JULY, 1, 00, 00);
		IngresoVehiculo ingresoVehiculo = new IngresoVehiculo(fechaIngreso, TIPO_CARRO, PLACA_ABC123);

		// Act
		vigilante.validarDia(ingresoVehiculo);
	}

	@Test
	public void validarDiaNoHabilTest() {
		// Arrange
		Calendar fechaIngresoNoHabil = new GregorianCalendar(2019, Calendar.JULY, 3);
		IngresoVehiculo ingresoVehiculoNoHabil = new IngresoVehiculo(fechaIngresoNoHabil, TIPO_CARRO, PLACA_ABC123);

		try {
			// Act
			vigilante.validarDia(ingresoVehiculoNoHabil);
			fail();
			
		} catch (Exception e) {
			// Assert
			assertEquals(Vigilante.MENSAJE_NO_HABIL, e.getMessage());
		}

	}
}
