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

import g5.app.exception.UsernameNotFound;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioService service;
	
	/*
	 * Habría que ver qué hacer con este método: si mirar en las 3 tablas o hacer una tabla Login que tenga el
	 * email, pwd y rol del usuario
	 * */

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		g5.app.model.Usuario appUser = null;

		try {
			appUser = service.buscarPorEmail(email);
		} catch (UsernameNotFound e) {
			e.printStackTrace();
		}

		Set<GrantedAuthority> grantList = new HashSet<>();
		grantList.add(new SimpleGrantedAuthority(appUser.getClass().getSimpleName()));

//        for (Role role : appUser.getRoles()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
//            grantList.add(grantedAuthority);
//        }

		return new User(email, appUser.getPwd(), grantList);
	}

}
