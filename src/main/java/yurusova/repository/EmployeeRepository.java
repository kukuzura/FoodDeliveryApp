package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByUser_Admin_Username(String adminUsername);

    Employee findByUser_Username(String username);
}
