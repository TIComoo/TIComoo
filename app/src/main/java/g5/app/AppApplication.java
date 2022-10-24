package g5.app;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		/* 
		String st = "1234";
		String codificado = Util.codificarStringMD5(st);
	 */
		SpringApplication.run(AppApplication.class, args);
	
	}
	
}
