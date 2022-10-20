package g5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioTests {
   /*
    * TDD 3 PASOS PRINCIPALES
    * - ESCRIBIR LOS TESTS Y PASARLOS CORRECTAMENTE
    * - IMPLEMENTAR EN SRC
    * - REFACTORIZAR SI ES NECESARIO
    */
   String nombre = "John";
   String apellido = "Doe";
   String nif = "12345678k";
   String direccion = "Calle Falsa 123";
   int telefono = 12345678;
   String email = "johndoe@gmail.com";
   String pwd = "1234";
   String rol = "Usuario";

   Usuario u = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);

   @Test
   public void test_CrearObjetoUsuario() {
      // constructor vacio
      Usuario usuario = new Usuario();

      // constructor con atributos
      String nombre = "John";
      String apellido = "Doe";
      String nif = "12345678k";
      String direccion = "Calle Falsa 123";
      int telefono = 12345678;
      String email = "johndoe@gmail.com";
      String pwd = "1234";
      String rol = "Usuario";
      Usuario usuario2 = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);

      System.out.println(usuario.toString());
      System.out.println(usuario2.toString());

   }

   @Test
   public void test_getNombre() {
      String nombre = u.getNombre();
      System.out.println(nombre);
   }

   @Test
   public void test_setNombre() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setNombre("Jose");
   }

   @Test
   public void test_getApellido() {
      String apellido = u.getApellido();
      assertEquals(apellido, "Doe");

   }

   @Test
   public void test_setApellido() {
      u.setApellido("Rambo");
      System.out.println();
   }

   @Test
   public void test_getNif() {
      String nif = u.getNif();
      assertEquals(nif, "12345678k");

   }

   @Test
   public void test_setNif() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setNif("12234567");
      assertEquals("12234567", usuario.getNif());

   }

   @Test
   public void test_getDireccion() {
      String d = u.getDireccion();
      assertEquals(d, "Calle Falsa 123");
   }

   @Test
   public void test_setDireccion() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setDireccion("Calle Falsa 321");
      assertEquals(usuario.getDireccion(), "Calle Falsa 321");

   }

   @Test
   public void test_getTelefono() {
      int telefono = u.getTelefono();
      assertEquals(telefono, 12345678);
   }

   @Test
   public void test_setTelefono() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setTelefono(87654321);
      assertEquals(87654321, usuario.getTelefono());
   }

   @Test
   public void test_getEmail() {
      String e = u.getEmail();
      assertEquals("johndoe@gmail.com", e);
   }

   @Test
   public void test_setEmail() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setEmail("johndoe24@gmail.com");
      assertEquals("johndoe24@gmail.com", usuario.getEmail());

   }

   @Test
   public void test_getPwd() {
      String p = u.getPwd();
      assertEquals("1234", p);

   }

   @Test
   public void test_setPwd() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setPwd("4321");
      assertEquals("4321", usuario.getPwd());
   }

   @Test
   public void test_getRol() {
      String p = u.getRol();
      assertEquals("Usuario", p);
   }
   @Test
   public void test_setRol() {
      Usuario usuario = new Usuario(nombre, apellido, nif, direccion, telefono, email, pwd, rol);
      usuario.setRol("usuario");
      assertEquals("usuario", usuario.getRol());
   }
}
