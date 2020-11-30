package yurusova.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>
{
	User findByUsername(String username);

//	@Query("SELECT admin FROM User admin" +
//			" WHERE admin.id = (SELECT user.admin.id from User user where user.username like ?1)")
@Query("SELECT user.admin FROM User user where user.username like ?1")
	User getAdminByUser_Username(String username);

}
