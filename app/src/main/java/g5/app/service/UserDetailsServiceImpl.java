package g5.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import g5.app.model.Role;
import g5.app.dao.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	g5.app.model.User appUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

        Set<GrantedAuthority> grantList = new HashSet<>();

        for (Role role : appUser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
            grantList.add(grantedAuthority);
        }

        return new User(username, appUser.getPwd(), grantList);
    }

}
