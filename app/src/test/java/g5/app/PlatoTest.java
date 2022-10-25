package g5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlatoTest {

	Plato plato;

	@BeforeEach
	void inicializar(){
		 plato=new Plato("cocido","primero", "imagen", "Cocido madrileño para dos", 20.0, false);
	}

	

	@Test
	void getNombreTest(){
		assertEquals("cocido", plato.getNombre());
	}

	@Test
	void getCategoriaTest(){
		assertEquals("primero", plato.getCategoria());
	}
	@Test
	void getImagenTest(){
		assertEquals("imagen", plato.getImagen());
	}
	@Test
	void getDescripcionTest(){
		assertEquals("Cocido madrileño para dos", plato.getDescripcion());
	}
	@Test
	void getPrecioTest(){
		assertEquals(20.0, plato.getPrecio());
	}
	@Test
	void getAptoVeganosTest(){
		assertFalse(plato.getAptoVeganos());
	}

	@Test
	void setAptoVeganosTest(){
		plato.setAptoVeganos(true);
		assertTrue(plato.getAptoVeganos());
	}
	
	@Test
	void setNombreTest(){
		plato.setNombre("lentejas");
		assertEquals("lentejas", plato.getNombre());
	}
	@Test
	void setCategoriaTest(){
		plato.setCategoria("segundo");
		assertEquals("segundo", plato.getCategoria());
	}
	@Test
	void setImagenTest(){
		plato.setImagen("imagenn");
		assertEquals("imagenn", plato.getImagen());
	}
	@Test
	void setDescripcionTest(){
		plato.setDescripcion("lentejas de la abuela");;
		assertEquals("lentejas de la abuela", plato.getDescripcion());
	}
	@Test
	void setIPrecioTest(){
		plato.setPrecio(19.2);
		assertEquals(19.2, plato.getPrecio());
	}
}	

