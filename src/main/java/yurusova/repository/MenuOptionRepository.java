package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yurusova.entity.FoodCompany;
import yurusova.entity.MenuOption;

public interface MenuOptionRepository extends JpaRepository<MenuOption,Long> {
}
