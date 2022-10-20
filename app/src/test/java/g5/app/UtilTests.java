package g5.app;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
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

  /*   private String codificarStringMD5(String string_a_codificar) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes_del_mensaje = string_a_codificar.getBytes("UTF-8");
        System.out.println(bytes_del_mensaje.toString());
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(bytes_del_mensaje);
        String mensaje_codificado = md5.toString();

 */
}

