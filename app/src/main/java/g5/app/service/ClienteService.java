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
    ClienteRepository repository;
    
    public Cliente guardarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    // READ usuarios
    public List<Cliente> consultarClientes() {
        return repository.findAll();
    }

    public Cliente buscarPorEmail(String email) throws UsernameNotFound {
		return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFound("El email del usuario no existe."));
	}

}