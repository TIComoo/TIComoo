package g5.app;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    

    public static String codificarStringMD5(String string_a_codificar) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes_del_mensaje = string_a_codificar.getBytes("UTF-8");
        System.out.println(bytes_del_mensaje.toString());
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(bytes_del_mensaje);
        String mensaje_codificado = md5.toString();

        return mensaje_codificado;
    }
}
