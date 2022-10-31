package g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.ClienteRepository;
import g5.app.model.Cliente;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository clienteRepository; // le he añadido private
  
  // CRUD Crear con TDD. Crea o modifica un usuario. Al ser su id el email es
  // inmutable.
  public Cliente guardarCliente(Cliente cliente) { 
    return clienteRepository.save(cliente);
  }

  public List<Cliente> consultarClientes() {
    List<Cliente> clientes = clienteRepository.findAll();

    return clientes;
  }

  public Cliente leerClientePorEmail(String email) {
    Optional<Cliente> clienteOptional = clienteRepository.findById(email); // he puesto en minúscula la primera c de la variable

    Cliente cliente = clienteOptional.get(); // he puesto en minúscula la primera c de la variable

    return cliente;

  }

  public void borrarClientePorEmail(String email) {
    clienteRepository.deleteById(email);
  }

}
