package yurusova.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yurusova.entity.Role;
import yurusova.entity.User;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
	@Resource
	private UserRepository userRepository;

	@Resource
	private RoleService roleService;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User createAdmin(String adminLogin, String adminPassword, String role)
	{
		User user = new User();
		user.setUsername(adminLogin);
		user.setPassword(bCryptPasswordEncoder.encode(adminPassword));
		user.setRoles(getRole(role));
		userRepository.save(user);
		return user;
	}

	private List<Role> getRole(final String roleName){
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.getRoleByName(roleName));
		return roles;
	}

	public User save(User user){
		return userRepository.save(user);
	}


}
