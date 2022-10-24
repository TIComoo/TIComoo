package g5.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServicioTests {
    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String direccion = "Calle Falsa 123";
    int telefono = 12345678;
    String email = "johndoe@gmail.com";
    String pwd = "1234";

    Usuario u = new Usuario(email, nombre, apellido, nif, direccion, telefono, pwd);

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_crearUsuario() {
       
        Usuario u = new Usuario(email, nombre, apellido, nif, direccion, telefono, pwd); 
        Mockito.when(usuarioRepository.save(u)).thenReturn(u);
        Usuario u_resultado = servicio.crearUsuario(u);
        assertEquals(u, u_resultado);

    }
    @Test
    public void test_modificarUsuario() {
        Usuario u1 = new Usuario(email, nombre, apellido, nif, direccion, telefono, pwd);
        u1.setNombre("Sergio");
        Mockito.when(usuarioRepository.save(u1)).thenReturn(u);
        assertNotEquals(u1.toString(), servicio.crearUsuario(u1).toString());
    }
}
