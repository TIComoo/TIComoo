package g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import g5.app.dao.ClienteRepository;
import g5.app.exception.CustomeFieldValidationException;
import g5.app.model.Cliente;
import g5.app.model.Usuario;

@Service
public class ClienteService {
  @Autowired
  ClienteRepository clienteRepository; // diría de cambiarle el nombre a clienteRepository, o incluso cambiarlo a
                                       // repository o a dao para todas las clases,
                                       // ya que se sobreentiende que es del tipo de usuario que es, y queda más corto
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  // habría que cambiar el nombre de los métodos de Usuario a Cliente
  // CRUD Crear con TDD. Crea o modifica un usuario. Al ser su id el email es
  // inmutable.
  public Cliente guardarCliente(Cliente cliente) throws Exception { // diría de cambiar el nombre del método que usa el save() a
                                                   // guardarCliente, guardarUsuario, guardarRider, etc
	  if (pwdValida(cliente) && emailValido(cliente)) {
			String encodedPassword = bCryptPasswordEncoder.encode(cliente.getPwd());
			cliente.setPwd(encodedPassword);
			cliente = clienteRepository.save(cliente);
		}
    return cliente;
  }

  private boolean emailValido(Cliente cliente) throws Exception {
		Cliente encontrado = leerClientePorEmail(cliente.getEmail());
		if (encontrado != null) {
			throw new CustomeFieldValidationException("Nombre no disponible","username");
		}
		return true;
	}

	private boolean pwdValida(Cliente cliente) throws Exception {
		if (cliente.getConfirmarPwd() == null || cliente.getConfirmarPwd().isEmpty()) {
			throw new CustomeFieldValidationException("Confirmar la contraseña es obligatorio","confirmarPwd");
		}
		
		if ( !cliente.getPwd().equals(cliente.getConfirmarPwd())) {
			throw new CustomeFieldValidationException("Contraseña y Confirmar contraseña no son iguales","pwd");
		}
		return true;
	}
  public List<Cliente> consultarClientes() {
    List<Cliente> clientes = clienteRepository.findAll();

    return clientes;
  }

  public Cliente leerClientePorEmail(String email) {
    Cliente cliente = clienteRepository.findByEmail(email);
    
    return cliente;

  }
  
  
	public Cliente findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return clienteRepository.findByEmail(email);
	}

  public void borrarClientePorEmail(String email) {
    clienteRepository.deleteById(email);
  }

}