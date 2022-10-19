package g5.app;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlatoService {

    @Autowired
   private PlatoRepository platoRepository;

    public void insertPlato(JSONObject json)throws Exception{

        String id=json.getString("id");
        String nombre=json.getString("nombre");
        String imagen=json.getString("imagen");
        String descripcion=json.getString("descripcion");
        String precio=json.getString("precio");
        String aptoVeganos=json.getString("aptoVeganos");
        String categoria=json.getString("categoria");

        if(id.isEmpty()||nombre.isEmpty()||imagen.isEmpty()||descripcion.isEmpty()||precio.isEmpty()||aptoVeganos.isEmpty()||categoria.isEmpty()){
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

        try{
            if (platoRepository.findById(Integer.parseInt(id)).isPresent()){
                throw new Exception("El plato ya existe en el sistema");
            }
            
        }catch(NumberFormatException e){
            throw new Exception("El id no es un dato numerico");
        }
                
        Plato plato =new Plato();

        plato.setId(Integer.parseInt(id));
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
    
    public void updatePlato(JSONObject json)throws Exception{
        
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

        try{
            if (platoRepository.findById(Integer.parseInt(id)).isPresent()){
                throw new Exception("El plato ya existe en el sistema");
            }
            
        }catch(NumberFormatException e){
            throw new Exception("El id no es un dato numerico");
        }
                
        Plato plato =new Plato();

        plato.setId(Integer.parseInt(id));
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
            
        platoRepository.save(plato);
       
       

    }

    public void deletePlato(JSONObject json)throws Exception{
        
        String id=json.getString("id");
        int Id=Integer.parseInt(id);
        
        platoRepository.delete(platoRepository.findById(Id).get());
            
       
        
    }
}
