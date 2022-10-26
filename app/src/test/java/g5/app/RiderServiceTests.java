package g5.app;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import g5.app.dao.RiderRepository;
import g5.app.model.Rider;
import g5.app.service.RiderService;

@RunWith(MockitoJUnitRunner.class)
public class RiderServiceTests {

    String nombre = "John";
    String apellido = "Doe";
    String nif = "12345678k";
    String email = "johndoe@gmail.com";
    String pwd = "1234";
    String matricula= "1";
    String carnet = "1111";
    String tipo_vehiculo = "Motocicleta";

    Rider r = new Rider(nombre, apellido, nif, email, pwd, tipo_vehiculo, matricula, carnet);

    @Mock
    RiderRepository riderRepository;
    @InjectMocks
    RiderService servicio;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void test_crearRider(){
        Mockito.when(riderRepository.save(r)).thenReturn(r);
        servicio.crearRider(r);
        assertNotNull(riderRepository.save(r));
    }
    @Test 
    public void test_modificarRider(){ //
        Rider r_nuevo = new Rider(nombre, apellido, nif, email, pwd, tipo_vehiculo, matricula, carnet);
        r_nuevo.setTipo_vehiculo("Bicicleta");
        Mockito.when(riderRepository.save(r_nuevo)).thenReturn(r_nuevo);
        servicio.crearRider(r_nuevo);
        assertNotNull(r_nuevo.toString(), r.toString());


    }


}
