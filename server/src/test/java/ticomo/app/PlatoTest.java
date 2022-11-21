package ticomo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Plato;

@SpringBootTest

public class PlatoTest {

	Long id = (long) 0 ;
	String nombre = "Hamburguesa";
	String nombreRestaurante = "Dominos";
	String imagen = "url";
	String descripcion = "Hamburguesa";
	double precio = 3.0;
	String aptoVeganos = "si";
    String categoria = "Hamburguesas";


	Plato platoAux = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
	
    @Test
	public void test_CrearObjetoPlato() {

	Long id = (long) 0 ;
	String nombre = "Hamburguesa";
	String nombreRestaurante = "Dominos";
	String imagen = "url";
	String descripcion = "Hamburguesa";
	double precio = 3.0;
	String aptoVeganos = "Si";
    String categoria = "Hamburguesas";

	Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);

		System.out.println(platoAux.toString());
		System.out.println(platoAux1.toString());

	}


	@Test
	public void test_setId() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setId(0);
		assertEquals(0, platoAux1.getId());
	}

	@Test
	public void test_setNombre() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setNombre("Hamburguesa");
		assertEquals("Hamburguesa", platoAux1.getNombre());
	}

	@Test
	public void test_setnombreRestaurante() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setNombreRestaurante("Dominos");
		assertEquals("Dominos", platoAux1.getNombreRestaurante());
	}

    @Test
	public void test_setImagen() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setImagen("url");
		assertEquals("url", platoAux1.getImagen());
	}
	
    @Test
	public void test_setDescripcion() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setDescripcion("Hamburguesa");
		assertEquals("Hamburguesa", platoAux1.getDescripcion());
	}

    @Test
	public void test_setPrecio() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setPrecio(3.0);
		assertEquals(3.0, platoAux1.getPrecio());
	}

    @Test
	public void test_setAptoVeganos() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setAptoVeganos("Si");
		assertEquals("Si", platoAux1.getAptoVeganos());
	}
	
    @Test
	public void test_setCategoria() {
		Plato platoAux1 = new Plato( nombre, nombreRestaurante, categoria,  imagen,  descripcion,  precio,  aptoVeganos);
		platoAux1.setCategoria("Hamburguesas");
		assertEquals("Hamburguesas", platoAux1.getCategoria());
	}
}
