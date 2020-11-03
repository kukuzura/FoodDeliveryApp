package yurusova.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date date;

    @ManyToOne
    Employee employee;

    @ManyToMany
    @JoinTable(
            name = "order_menu_option",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "menu_option_id") }
    )
    List<MenuOption> menuOptions;
}
