package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Repository;
import yurusova.entity.FoodCompany;

@Repository
public interface FoodCompanyRepository extends JpaRepository<FoodCompany,Long>
{

    FoodCompany findFoodCompanyByAdmin_Username(String username);

    FoodCompany findByName(String companyName);

}
