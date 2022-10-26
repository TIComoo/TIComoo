package g5.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoService {

    @Autowired
   private PlatoRepository platoRepository;

   public Boolean validarNombreNoRepe(Plato plato)throws CustomException{

    if(platoRepository.findBynombre(plato.getNombre()).isPresent()){

        throw new CustomException("Nombre no disponible");

    }

    return true;
   }

   public Boolean categoriaValida(Plato plato) throws CustomException{

    if(!plato.getCategoria().equalsIgnoreCase("primero") && !plato.getCategoria().equalsIgnoreCase("segundo") && !plato.getCategoria().equalsIgnoreCase("postre")
    && !plato.getCategoria().equalsIgnoreCase("entrante")){

        throw new CustomException("La categoria debe de ser: Entrante,primero,segundo o postre");
    }


    return true;
   }

    public void insert(Plato plato)throws CustomException{
       

        if(validarNombreNoRepe(plato) && categoriaValida(plato)){
            plato.setId(SequenceGeneratorService.generateSequence(Plato.SEQUENCE_NAME));
            platoRepository.insert(plato);
        }
         
       
    }
    
    public void update(Plato fromPlato)throws CustomException{
         
        Plato toPlato = this.getPlatorById(fromPlato.getId());

		mapUser(fromPlato, toPlato);

        if(validarNombreNoRepe(toPlato) && categoriaValida(toPlato)){

            platoRepository.save(toPlato);
        }

    }

    public void delete(Long id)throws CustomException{
        
        Plato plato=this.getPlatorById(id);
        platoRepository.delete(plato);
        
    }

   
	public Plato getPlatorById(Long id) throws CustomException {
		return platoRepository.findById(id).orElseThrow(() -> new CustomException("El Id del usuario no existe."));
	}

    protected void mapUser( Plato from,Plato to) {
		to.setNombre(from.getNombre());
		to.setAptoVeganos(from.getAptoVeganos());
		to.setCategoria(from.getCategoria());
		to.setDescripcion(from.getDescripcion());
		to.setImagen(from.getImagen());
        to.setPrecio(from.getPrecio());
        
	}
}
