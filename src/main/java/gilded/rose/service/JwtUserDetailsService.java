package gilded.rose.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static  Map<String,String>users=Map.of("admin", "password","andy", "password","randall", "password","dwayne", "password");

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			if (users.containsKey(username)) {
				return new User(username, "$2a$10$hFWbjwJPA4adm0LQ21GZ7Odxti.T25qLeqdFmszwEbDfom1vHoj9i",
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		
		
	}
}
