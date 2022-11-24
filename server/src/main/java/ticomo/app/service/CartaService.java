package ticomo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticomo.app.SequenceGeneratorServiceCarta;
import ticomo.app.dao.CartaRepository;
import ticomo.app.dao.PlatoRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Carta;
import ticomo.app.model.Plato;

@Service
public class CartaService {

	@Autowired
	CartaRepository cartaRepository;
	@Autowired
	PlatoRepository platoRepository;

	public void insert(Carta carta) {

		carta.setId(SequenceGeneratorServiceCarta.generateSequence(Carta.SEQUENCE_NAME));
		cartaRepository.insert(carta);

	}

	public void delete(Long id) throws CustomException {

		Carta carta = this.getCartaById(id);
		cartaRepository.delete(carta);
		;

	}

	public Carta getCartaById(Long id) throws CustomException {

		return cartaRepository.findById(id).orElseThrow(() -> new CustomException("El Id de la carta no existe."));

	}

	public void actualizarCarta(Carta carta_O) throws CustomException {

		Carta carta_D = getCartaById(carta_O.getId());
		cambio(carta_O, carta_D);
	
		this.cartaRepository.save(carta_D);
	
		}

		protected void cambio(Carta origen, Carta destino) {
	
			destino.setCartaElegida(true);
			destino.setNombreRestaurante(origen.getNombreRestaurante());

	
		}
		public void actualizarCartaI(Carta carta_O) throws CustomException {

			Carta carta_D = getCartaById(carta_O.getId());
			cambioI(carta_O, carta_D);
		
			this.cartaRepository.save(carta_D);
		
			}
	
			protected void cambioI(Carta origen, Carta destino) {
		
				destino.setCartaElegida(false);
				destino.setNombreRestaurante(origen.getNombreRestaurante());
	
		
			}

	public List<Plato> listarPlatos(String nombreRestaurante) throws CustomException {

		return platoRepository.findByNombreRestaurante(nombreRestaurante);
	}
	public Carta leerCartaPorRestaurante(String cartaR) {
        Carta carta= cartaRepository.findBynombreRestaurante(cartaR);

        return carta;

    }

	public List<Carta> getAllCartas() {
        
        return cartaRepository.findAll();
    }
}
