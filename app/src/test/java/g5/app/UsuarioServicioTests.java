package g5.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServicioTests {

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    public void test_crearUsuario() {

    }

    public void test_modificarUsuario() {

    }

    public void test_borrarUsuario() {

    }

    public void test_consultarUsuario() {

    }
}
