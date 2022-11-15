package ticomo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ticomo.app.model.Carta;

@SpringBootTest

public class CartaTest {

	Long id = (long) 0 ;
    String nombreRestaurante ="Dominos";

	Carta cartaAux = new Carta( nombreRestaurante);
	
    @Test
	public void test_CrearObjetoCarta() {

	Long id = (long) 0 ;


	Carta cartaAux1 =  new Carta( nombreRestaurante);

		System.out.println(cartaAux.toString());
		System.out.println(cartaAux1.toString());

	}


	@Test
	public void test_setnombreRestaurante() {
        Carta cartaAux1 =  new Carta( nombreRestaurante);
		cartaAux1.setNombreRestaurante("Dominos");
		assertEquals("Dominos", cartaAux.getNombreRestaurante());
	}

    @Test
	public void test_setId() {
        Carta cartaAux1 =  new Carta();
		cartaAux1.setId(0);
		assertEquals(0, cartaAux.getId());
	}
}
