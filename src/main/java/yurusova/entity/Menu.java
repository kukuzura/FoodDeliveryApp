package yurusova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private boolean isChoosed;

    @ManyToMany(mappedBy = "menu")
    List<Company> companies;

    @ManyToMany
    @JoinTable(name="menu_menu_option",
            joinColumns = {@JoinColumn(name="menu_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="menu_option_id", referencedColumnName="id")}
    )
    List<MenuOption> menuOptions;

    @ManyToOne
    @JoinColumn(name="food_company_id")
    FoodCompany foodCompany;

}
