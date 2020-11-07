package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.Company;
import yurusova.entity.Role;

@Repository
public interface CustomerCompanyRepository extends JpaRepository<Company,Long> {
}
