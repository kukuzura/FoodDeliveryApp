package yurusova.dao.impl;

import org.springframework.stereotype.Service;
import yurusova.dao.UserDAO;
import yurusova.entity.User;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;

@Service
public class DefaultUserDAO implements UserDAO
{
	@Resource
	private UserRepository userRepository;

	@Override
	public User getUser(String username)
	{
		return userRepository.findByUsername(username);
	}
}
