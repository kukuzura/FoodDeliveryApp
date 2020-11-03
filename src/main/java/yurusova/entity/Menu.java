package yurusova.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private boolean isChoosed;

    @ManyToMany
    List<Company> companies;

    @ManyToMany(mappedBy = "menus")
    List<MenuOption> menuOptions;

    @ManyToOne
    FoodCompany foodCompany;

}
