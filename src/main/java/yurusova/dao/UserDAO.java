package yurusova.dao;

import org.springframework.stereotype.Service;
import yurusova.entity.User;

@Service
public interface UserDAO
{
	User getUser(String username);
}
