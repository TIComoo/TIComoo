package g5.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g5.app.model.Cliente;

import g5.app.service.ClienteService;
    
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/crearCliente")
    public void crearUsuario(@RequestBody @ModelAttribute("Cliente") Cliente cliente) {
        this.clienteService.crearUsuario(cliente);
    }

    @PostMapping(value = "modificarCliente")
    public void modificarUsuario(@RequestBody @ModelAttribute("Cliente") Cliente cliente) {
        this.clienteService.modificarUsuario(cliente);
    }

    
}
