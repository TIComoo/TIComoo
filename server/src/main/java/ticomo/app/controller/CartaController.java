package ticomo.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ticomo.app.dao.CartaRepository;
import ticomo.app.exception.CustomException;
import ticomo.app.model.Carta;
import ticomo.app.model.Plato;
import ticomo.app.service.CartaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("carta")
public class CartaController {

    @Autowired
    CartaService cartaService=new CartaService();
	@Autowired
    CartaRepository cartaRepository;

    @GetMapping("/insert")
	public String insertForm(Model model) {
		
		model.addAttribute("cartaForm", new Carta());
		
		return "carpeta/archivo.httml";
	}
	@GetMapping("/todas")
    public List<Carta> getCartas() {
        
        return cartaService.getAllCartas();

    }
	@PostMapping("/enviar")
    public String addEleccion(@RequestBody String content) throws CustomException{

		JSONObject jso = new JSONObject(content);

		Carta aux=new Carta();

		aux.setId(jso.getLong("id"));
		aux.setNombreRestaurante(jso.getString("nombreRestaurante"));
		aux.setCartaElegida(jso.getBoolean("cartaElegida"));

		cartaService.actualizarCarta(aux);

        return "Actualizado";
    }

	@GetMapping("/inicializar")
    public String inicializar() throws CustomException{


		List<Carta> cartas = cartaService.getAllCartas();
		for(int i=0; i<cartas.size();i++){
			cartaService.actualizarCartaI(cartas.get(i));

		}

        return "Actualizado";
    }


    @PostMapping("/eleccion")
    public List<Carta> getEleccion() {
        
		List<Carta> cartas = cartaService.getAllCartas();
        List<Carta> aux = new ArrayList<>();
        for(int i=0;i<cartas.size();i++){
            if(cartas.get(i).getCartaElegida()!=false){
                aux.add(cartas.get(i));
            }
        }
        return aux;

    }

    @PostMapping("/insert")
	public String insert(@Valid @RequestBody @ModelAttribute("cartaForm")Carta carta, BindingResult result, Model model) {

		

		if(result.hasErrors()){
			baseAttributerForPlatoForm(model, new Carta());
			
		}else{

			try {
				
				cartaService.insert(carta);

			} catch (Exception e) {

				throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
				//model.addAttribute("formErrorMessage",e.getMessage());
			}
		}

		return "carpeta/archivo.httml";
	}
	@DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) throws CustomException{
        cartaService.delete(id);
    }
    @GetMapping("/delete/{id}")
	public void delete(Model model, @PathVariable(name="id")Long id) {

		try {
            
			cartaService.delete(id);

		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}
	}

	@GetMapping("/list/{id}")
	public Iterable<Plato> listarPlatosCarta(@PathVariable(name="id")Long id,Model model){	
		
		try {
			return cartaService.listarPlatos(cartaRepository.findById(id).get().getNombreRestaurante());

		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
		}

	}

    private void baseAttributerForPlatoForm(Model model, Carta carta) {

		model.addAttribute("cartaForm", carta);
		//model.addAttribute(activeTab,"active");
	}
    
}
