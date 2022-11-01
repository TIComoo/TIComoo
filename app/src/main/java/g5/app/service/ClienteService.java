package g5.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.ClienteRepository;
import g5.app.exception.UsernameNotFound;
import g5.app.model.Cliente;

@Service
public class ClienteService {
	
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public void borrarClientePorEmail(String email) {
        clienteRepository.deleteById(email);
    }

    // READ usuarios
    public List<Cliente> consultarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorEmail(String email) throws UsernameNotFound {
		return clienteRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}