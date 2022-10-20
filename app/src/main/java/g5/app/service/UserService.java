package g5.app.service;

import g5.app.exception.UsernameOrIdNotFound;
import g5.app.model.User;

public interface UserService {

    User findByEmail(String email) throws UsernameOrIdNotFound;

}
