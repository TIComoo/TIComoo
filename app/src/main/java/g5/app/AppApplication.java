package g5.app;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import g5.app.dao.RoleRepository;
import g5.app.dao.UserRepository;
import g5.app.model.Role;
import g5.app.model.User;

@SpringBootApplication
public class AppApplication {

//  @Autowired
//  private UserRepository userDao;
//  
//  @Autowired
//  private RoleRepository roleDao;

  public static void main(String[] args) { // implements CommandLineRunner
      SpringApplication.run(AppApplication.class, args);
  }

//  @Override
//  public void run(String... args) throws Exception {
//      Role rol = new Role(1, "admin", "Es el administrador");
//      roleDao.save(rol);
//      
//      Set<Role> roles = Set.of(rol);
//
//      User usr1 = new User(1, "barchi2001@gmail.com",
//              "$2a$04$aobqwaxQZdrKpfU/q1HRS.siskpmy0CETGrF1u4RAOVQ5nFi/0dzK", roles);
//      userDao.save(usr1);
//  }

}
