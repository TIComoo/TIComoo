package g5.app;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoService {

    @Autowired
   private PlatoRepository platoRepository;

    public void insert(JSONObject json)throws Exception{
       
        String nombre=json.getString("nombre");
        String imagen=json.getString("imagen");
        String descripcion=json.getString("descripcion");
        String precio=json.getString("precio");
        String aptoVeganos=json.getString("aptoVeganos");
        String categoria=json.getString("categoria");

        if(nombre.isEmpty()||imagen.isEmpty()||descripcion.isEmpty()||precio.isEmpty()||aptoVeganos.isEmpty()||categoria.isEmpty()){
            throw new Exception("Rellene todos los campos");
        
        }

        try {
            Double.parseDouble(precio);
            
        } catch (NumberFormatException e){
            throw new Exception("El precio no es un dato numerico");
        }
        
        if(!aptoVeganos.equalsIgnoreCase("si") && !aptoVeganos.equalsIgnoreCase("no")){
            throw new Exception("El valor de apto veganos debe de ser si o no");
        }

        if(!categoria.equalsIgnoreCase("primero") && !categoria.equalsIgnoreCase("segundo") && !categoria.equalsIgnoreCase("postre")){
            throw new Exception("La categoria del plato debe ser valida: Primero,segundo o postre");
        }

        if (platoRepository.findBynombre(nombre).isPresent()){
            throw new Exception("El plato ya existe en el sistema");
        }

                
        Plato plato =new Plato();

        plato.setId(SequenceGeneratorService.generateSequence(Plato.SEQUENCE_NAME));
        plato.setCategoria(categoria);
        plato.setDescripcion(descripcion);
        plato.setNombre(nombre);
        plato.setPrecio(Double.parseDouble(precio));
        plato.setImagen(imagen);

        if(aptoVeganos.equalsIgnoreCase("si")){

            plato.setAptoVeganos(true); 

        }else{
            plato.setAptoVeganos(false); 
        }
            
        platoRepository.insert(plato);
        
        
       
    }
    
    public void update(JSONObject json)throws Exception{
        
        String id=json.getString("id");
        String nombre=json.getString("nombre");
        String imagen=json.getString("imagen");
        String descripcion=json.getString("descripcion");
        String precio=json.getString("precio");
        String aptoVeganos=json.getString("aptoVeganos");
        String categoria=json.getString("categoria");

        if(id.isEmpty()||nombre.isEmpty()||imagen.isEmpty()||descripcion.isEmpty()||precio.isEmpty()||aptoVeganos.isEmpty()||categoria.isEmpty()){
            throw new Exception("Campos vacios");
        
        }

        try {
            Double.parseDouble(precio);
            
        } catch (NumberFormatException e){
            throw new Exception("El precio no es un dato numerico");
        }
        
        if(!aptoVeganos.equalsIgnoreCase("si") && !aptoVeganos.equalsIgnoreCase("no")){
            throw new Exception("El valor de apto veganos debe de ser si o no");
        }

        if(!categoria.equalsIgnoreCase("primero") && !categoria.equalsIgnoreCase("segundo") && !categoria.equalsIgnoreCase("postre")){
            throw new Exception("La categoria del plato debe ser valida: Primero,segundo o postre");
        }

        if (platoRepository.findBynombre(nombre).isPresent()){
            throw new Exception("El plato ya existe en el sistema");
        }
        
        
       
                
        Optional<Plato>platoAux=platoRepository.findById(Integer.parseInt(id));

        platoAux.get().setCategoria(categoria);
        platoAux.get().setDescripcion(descripcion);
        platoAux.get().setNombre(nombre);
        platoAux.get().setPrecio(Double.parseDouble(precio));
        platoAux.get().setImagen(imagen);

        if(aptoVeganos.equalsIgnoreCase("si")){

            platoAux.get().setAptoVeganos(true); 

        }else{
            platoAux.get().setAptoVeganos(false); 
        }
            
        platoRepository.save(platoAux.get());
       
       

    }

    public void delete(JSONObject json)throws Exception{
        
        String id=json.getString("id");
        int Id=Integer.parseInt(id);
        
        platoRepository.delete(platoRepository.findById(Id).get());
            
       
        
    }
}
