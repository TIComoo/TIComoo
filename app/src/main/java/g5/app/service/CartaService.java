package g5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.CustomException;
import g5.app.SequenceGeneratorServiceCarta;
import g5.app.dao.CartaRepository;
import g5.app.dao.PlatoRepository;
import g5.app.model.Carta;
import g5.app.model.Plato;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;
    @Autowired
    PlatoRepository platoRepository;

    public void insert(Carta carta){
       
        carta.setId(SequenceGeneratorServiceCarta.generateSequence(Carta.SEQUENCE_NAME));
        cartaRepository.insert(carta);
       
    }

    public void delete(Long id)throws CustomException{
        
        Carta carta=this.getCartaById(id);
        cartaRepository.delete(carta);;
        
    }

    public Carta getCartaById(Long id) throws CustomException {

		return cartaRepository.findById(id).orElseThrow(() -> new CustomException("El Id de la carta no existe."));

	}

    public List<Plato>listarPlatos(String nombreRestaurante)throws CustomException{
        
        
        return platoRepository.findBynombreRestaurante(nombreRestaurante);
    }
    
}
