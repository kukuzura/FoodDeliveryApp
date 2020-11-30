package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.Menu;
import yurusova.entity.OrderMenuOption;

@Repository
public interface OrderMenuOptionRepository extends JpaRepository<OrderMenuOption,Long> {
}
