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
	private UsuarioService usrService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		g5.app.model.Usuario appUser = null;

		try {
			appUser = usrService.buscarPorEmail(email);
		} catch (UsernameNotFound e) {
			e.printStackTrace();
		}

		Set<GrantedAuthority> grantList = new HashSet<>();
		grantList.add(new SimpleGrantedAuthority(appUser.getRol()));

		return new User(email, appUser.getPwd(), grantList);
	}

}
