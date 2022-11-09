package g5.app;

import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class UtilTests {



    @Test
    public void test_codificarStringMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException{

        String string_a_codificar = "12345";
        Util.codificarStringMD5(string_a_codificar);

        //comprobar que se codifica correctamente (assertTrue)

    }

}

