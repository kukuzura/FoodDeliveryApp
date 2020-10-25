package yurusova.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yurusova.dao.UserDAO;
import yurusova.entity.User;

import javax.annotation.Resource;
import java.util.HashSet;

@Service
public class AuthorizationService implements UserDetailsService
{
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

	@Resource
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
	{
		// с помощью нашего сервиса UserService получаем User
		User user = userDAO.getUser(login);
		// указываем роли для этого пользователя
		HashSet<SimpleGrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(user.getRole().getName()));

		// на основании полученных данных формируем объект UserDetails
		// который позволит проверить введенный пользователем логин и пароль
		// и уже потом аутентифицировать пользователя

		System.out.println("---------" + user.getPassword());
		logger.info("User " + user.getUsername() + "has been authorize.");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
	}
}

