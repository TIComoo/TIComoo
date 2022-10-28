package g5.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import g5.app.model.Cliente;

import g5.app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/guardarCliente")
    public void guardarUsuario(@RequestBody @ModelAttribute("Cliente") Cliente cliente) {
        this.clienteService.guardarCliente(cliente);
    }


    @GetMapping(value = "/leerClientes", produces = "application/json")
    @ResponseBody
    public List<Cliente> leerClientes() {
        List<Cliente> clientes = this.clienteService.consultarClientes();
        return clientes;
    }

    @GetMapping(value = "/leerClientePorEmail", produces = "application/json")
    @ResponseBody
    public Cliente leerClientePorEmail(@RequestHeader String email) {
        Cliente cliente = this.clienteService.leerClientePorEmail(email);
        return cliente;

    }

}
