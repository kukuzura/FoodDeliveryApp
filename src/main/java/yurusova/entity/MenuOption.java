package yurusova.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.datetime.standard.DateTimeContext;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String description;

    Double cost;

    @ManyToOne
    FoodCompany foodCompany;

    @ManyToMany
    @JoinTable(
            name = "menu_menu_option",
            joinColumns = { @JoinColumn(name = "menu_id") },
            inverseJoinColumns = { @JoinColumn(name = "menu_option_id") }
    )
    List<Menu> menus;

    @ManyToMany
    List<Order> order;

}
