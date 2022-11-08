<<<<<<< HEAD:app/src/test/java/g5/app/RestauranteTest.java
package g5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import g5.app.model.Restaurante;
=======
package ticomo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Restaurante;
>>>>>>> main:server/src/test/java/ticomo/app/RestauranteTest.java

@SpringBootTest

public class RestauranteTest {
<<<<<<< HEAD:app/src/test/java/g5/app/RestauranteTest.java
   
    
    String nombre="Domino's ";
    String razon="Pizzerias Ciudad Real";
    String cif="1234567CJS";
    String direccion="C/Alegria";
    String tlf="67676767";
    String categoria="Pizzeria";
    String email="dominos@domino.com";

    Restaurante restauranteAux=new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);


    @Test
    public void test_CrearObjetoRestaurante() {
 
       String nombre="Domino's ";
       String razon="Pizzerias Ciudad Real";
       String cif="1234567CJS";
       String direccion="C/Alegria";
       String tlf="67676767";
       String categoria="Pizzeria";
       String email="dominos@domino.com";
       
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
 
       System.out.println(restauranteAux.toString());
       System.out.println(restauranteAux1.toString());
 
    }


    @Test
    public void test_setNombre() {
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
       restauranteAux1.setNombre("nombre");
       assertEquals("nombre", restauranteAux1.getNombre());
    }
    
    @Test
    public void test_setRazon() {
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
       restauranteAux1.setRazon("razon");
       assertEquals("razon", restauranteAux1.getRazon());
    }

    @Test
    public void test_setCIF() {
       Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
       restauranteAux1.setCif("CIF");
       assertEquals("CIF", restauranteAux1.getCif());
    }

    @Test
    public void test_setDireccion() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setDireccion("direccion");
       assertEquals("direccion", restauranteAux1.getDireccion());
    }

    @Test
    public void test_setTlf() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setTlf("12345");
       assertEquals("12345", restauranteAux1.getTlf());
    }

    @Test
    public void test_setCategoria() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setCategoria("categoria");
       assertEquals("categoria", restauranteAux1.getCategoria());
    }

    @Test
    public void test_setEmail() {
      Restaurante restauranteAux1 = new Restaurante(nombre,razon,cif,direccion,tlf,categoria,email);
      restauranteAux1.setEmail("email");
       assertEquals("email", restauranteAux1.getEmail());
    }
=======

	String nombre = "Domino's ";
	String razon = "Pizzerias Ciudad Real";
	String cif = "1234567CJS";
	String direccion = "C/Alegria";
	String tlf = "67676767";
	String categoria = "Pizzeria";
	String email = "dominos@domino.com";

	Restaurante restauranteAux = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);

	@Test
	public void test_CrearObjetoRestaurante() {

		String nombre = "Domino's ";
		String razon = "Pizzerias Ciudad Real";
		String cif = "1234567CJS";
		String direccion = "C/Alegria";
		String tlf = "67676767";
		String categoria = "Pizzeria";
		String email = "dominos@domino.com";

		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);

		System.out.println(restauranteAux.toString());
		System.out.println(restauranteAux1.toString());

	}

	@Test
	public void test_setNombre() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setNombre("nombre");
		assertEquals("nombre", restauranteAux1.getNombre());
	}

	@Test
	public void test_setRazon() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setRazon("razon");
		assertEquals("razon", restauranteAux1.getRazon());
	}
	@Test
	public void test_setCif() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setCIF("123");
		assertEquals("123", restauranteAux1.getCIF());
	}
	@Test
	public void test_setDireccion() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setDireccion("direccion");
		assertEquals("direccion", restauranteAux1.getDireccion());
	}

	@Test
	public void test_setTlf() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setTlf("12345");
		assertEquals("12345", restauranteAux1.getTlf());
	}

	@Test
	public void test_setCategoria() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setCategoria("categoria");
		assertEquals("categoria", restauranteAux1.getCategoria());
	}

	@Test
	public void test_setEmail() {
		Restaurante restauranteAux1 = new Restaurante(nombre, razon, cif, direccion, tlf, categoria, email);
		restauranteAux1.setEmail("email");
		assertEquals("email", restauranteAux1.getEmail());
	}
>>>>>>> main:server/src/test/java/ticomo/app/RestauranteTest.java
}
