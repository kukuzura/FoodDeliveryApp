package yurusova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
public class FoodCompany {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Time timeRestriction;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Menu> menu;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "foodCompany")
    private List<MenuOption> menuOptions;

    public FoodCompany()
    {
    }
}
