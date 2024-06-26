package cl.miguelbaillon.integradoraM6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.miguelbaillon.integradoraM6.model.Usuario;



@SpringBootTest
public class UsuarioTest {
	Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario();
		
		usuario.setId(1);
		usuario.setUsername("joseperez");
		usuario.setPassword("12345");
		usuario.setNombre("Jose");
		usuario.setApellido("Perez");
		usuario.setEmail("joseperez@gmail.com");
		usuario.setSaldo(1000);
	}
	
	@Test
	@DisplayName("Prueba mostrar id de usuario")
	void testMuestraId() {
		int resultado = usuario.getId();
		assertEquals(1, resultado);
	}
	
	@Test
	@DisplayName("Prueba mostrar nombre de usuario")
	void testMuestraUsername() {
		String resultado = usuario.getUsername();
		assertEquals("joseperez", resultado);
	}

	@Test
	@DisplayName("Prueba mostrar contraseña")
	void testMuestraPassword() {
		String resultado = usuario.getPassword();
		assertEquals("12345", resultado);
	}

	@Test
	@DisplayName("Prueba mostrar primer nombre")
	void testMuestraNombre() {
		String resultado = usuario.getNombre();
		assertEquals("Jose", resultado);
	}
	
	@Test
	@DisplayName("Prueba mostrar apellido paterno")
	void testMuestraApellido() {
		String resultado = usuario.getApellido();
		assertEquals("Perez", resultado);
	}
	
	@Test
	@DisplayName("Prueba mostrar correo electrónico")
	void testMuestraEmail() {
		String resultado = usuario.getEmail();
		assertEquals("joseperez@gmail.com", resultado);
	}
	
	@Test
	@DisplayName("Prueba mostrar saldo del usuario")
	void testMuestraSaldo() {
		int resultado = usuario.getSaldo();
		assertEquals(1000, resultado);
	}
}
