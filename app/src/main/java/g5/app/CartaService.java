package g5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

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
    
}
