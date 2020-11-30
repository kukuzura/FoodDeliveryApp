package yurusova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yurusova.entity.Menu;
import yurusova.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
