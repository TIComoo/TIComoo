package g5.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import g5.app.dao.ClienteRepository;
import g5.app.model.Cliente;

import g5.app.service.ClienteService;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTests {
    
    
    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String direccion = "Calle Falsa 123";
    String telefono = "12345678";
    String email = "johndoe@gmail.com";
    String pwd = "1234";

    Cliente u = new Cliente(email, nombre, apellido, nif, direccion, telefono, pwd);

    @Mock
    ClienteRepository usuarioRepository;

    @InjectMocks
    ClienteService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_crearUsuario() {
       
        Cliente u = new Cliente(email, nombre, apellido, nif, direccion, telefono, pwd); 
        Mockito.when(usuarioRepository.save(u)).thenReturn(u);
        Cliente u_resultado = servicio.crearUsuario(u);
        assertEquals(u, u_resultado);

    }
  /*   @Test
    public void test_modificarUsuario() {
        Usuario u1 = new Usuario(email, nombre, apellido, nif, direccion, telefono, pwd);
        u1.setNombre("Sergio");
        Mockito.when(usuarioRepository.save(u1)).thenReturn(u);
        assertNotEquals(u1.toString(), servicio.crearUsuario(u1).toString());
    }

    @Test
    public void test_consultarUsuarios(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = servicio.consultarUsuarios();

        for(Usuario u : usuarios){
            System.out.println(u.toString());
        }
    } */
}
