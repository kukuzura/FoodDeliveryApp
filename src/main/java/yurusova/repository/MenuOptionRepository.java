package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yurusova.entity.FoodCompany;
import yurusova.entity.MenuOption;

import java.util.List;

public interface MenuOptionRepository extends JpaRepository<MenuOption,Long> {

}
