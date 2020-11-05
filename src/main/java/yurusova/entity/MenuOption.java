package yurusova.entity;

import org.springframework.format.datetime.standard.DateTimeContext;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class MenuOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String description;

    Double cost;

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
