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

    @OneToMany(mappedBy="foodCompany")
    private List<Menu> menu;

    @OneToMany(mappedBy = "foodCompany")
    private List<MenuOption> menuOptions;

    @ManyToMany
    @JoinTable(name="food_company_company",
            joinColumns = {@JoinColumn(name="food_company_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="company_id", referencedColumnName="id")}
    )
    private List<Company> clients;

    public FoodCompany()
    {
    }
}
