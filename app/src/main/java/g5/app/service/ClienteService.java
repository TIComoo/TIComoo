package g5.app.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.dao.ClienteRepository;
import g5.app.model.Cliente;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository usuarioRepository;
    

    //CRUD Crear con TDD.
    public Cliente crearUsuario(Cliente cliente) {
        return usuarioRepository.save(cliente);
    }

    //CRUD Modificar con TDD.
    public void modificarUsuario(Cliente cliente) {

    }

    //READ usuarios
    public List<Cliente> consultarUsuarios(){
        List<Cliente> usuarios = new ArrayList<Cliente>();

        usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    
}
