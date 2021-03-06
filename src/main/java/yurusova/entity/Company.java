package yurusova.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<Office> office;

    @ManyToMany
    @JoinTable(name="company_menu",
            joinColumns = {@JoinColumn(name="company_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="menu_id", referencedColumnName="id")}
    )
    private List<Menu> menu;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;

    @ManyToMany
    @JoinTable(name="food_company_company",
            joinColumns = {@JoinColumn(name="company_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="food_company_id", referencedColumnName="id")}
    )
    private List<FoodCompany> foodCompanies;

    public Company() {
    }
}

