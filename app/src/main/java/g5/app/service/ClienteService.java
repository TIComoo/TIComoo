package g5.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.ClienteRepository;
import g5.app.model.Cliente;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository; // diría de cambiarle el nombre a clienteRepository, o incluso cambiarlo a repository o a dao para todas las clases,
                                         // ya que se sobreentiende que es del tipo de usuario que es, y queda más corto
    
    // habría que cambiar el nombre de los métodos de Usuario a Cliente
    //CRUD Crear con TDD.
    public Cliente crearUsuario(Cliente cliente) { // diría de cambiar el nombre del método que usa el save() a guardarCliente, guardarUsuario, guardarRider, etc
        return clienteRepository.save(cliente);
    }

    //CRUD Modificar con TDD.
    public void modificarUsuario(Cliente cliente) {

    }


    public List<Cliente> consultarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        
        return clientes;
    }
     
  public Cliente leerClientePorEmail(String email) {
    Optional<Cliente> ClienteOptional = clienteRepository.findById(email);

    Cliente Cliente = ClienteOptional.get();

    return Cliente;

  }
    
}
