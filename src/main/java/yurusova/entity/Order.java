package yurusova.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
