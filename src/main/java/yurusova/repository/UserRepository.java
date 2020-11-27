package yurusova.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>
{
	User findByUsername(String username);

}
