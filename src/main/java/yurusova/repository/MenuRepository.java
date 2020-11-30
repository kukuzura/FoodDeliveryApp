package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yurusova.entity.FoodCompany;
import yurusova.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    //Menu findByFoodCompanyAdmin_Username(String adminUsername);
}
