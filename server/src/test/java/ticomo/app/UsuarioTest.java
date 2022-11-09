package ticomo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Usuario;

@SpringBootTest

public class UsuarioTest {

     String email="prueba@gmail.com";
     String nombre="Victoria";
     String apellido="Alcazar";
     String pwd="123";
     String rol="Usuario";

	Usuario UsuarioAux = new Usuario( email,nombre,apellido,pwd,rol );
	
    @Test
	public void test_CrearObjetoCarta() {

        String email="prueba@gmail.com";
        String nombre="Victoria";
        String apellido="Alcazar";
        String pwd="123";
        String rol="Usuario";

	Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );

		System.out.println(UsuarioAux.toString());
		System.out.println(UsuarioAux1.toString());

	}


	@Test
	public void test_setEmail() {
        Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );
		UsuarioAux1.setEmail("prueba@gmail.com");
		assertEquals("prueba@gmail.com", UsuarioAux1.getEmail());
	}

	@Test
	public void test_setNombre() {
        Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );
		UsuarioAux1.setNombre("Victoria");
		assertEquals("Victoria", UsuarioAux1.getNombre());
	}

    @Test
	public void test_setApellido() {
        Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );
		UsuarioAux1.setApellido("Alcazar");
		assertEquals("Alcazar", UsuarioAux1.getApellido());
	}

    @Test
	public void test_setPwd() {
        Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );
		UsuarioAux1.setPwd("123");
		assertEquals("123", UsuarioAux1.getPwd());
	}

    @Test
	public void test_setRol() {
        Usuario UsuarioAux1 = new Usuario( email,nombre,apellido,pwd,rol );
		UsuarioAux1.setRol("Usuario");
		assertEquals("Usuario", UsuarioAux1.getRol());
	}
}
