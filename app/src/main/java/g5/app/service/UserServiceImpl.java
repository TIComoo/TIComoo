package g5.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g5.app.exception.UsernameOrIdNotFound;
import g5.app.model.User;
import g5.app.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User findByEmail(String email) throws UsernameOrIdNotFound {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameOrIdNotFound("El email del usuario no existe."));
    }
    
}
