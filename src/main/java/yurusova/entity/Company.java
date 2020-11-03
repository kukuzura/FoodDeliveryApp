package yurusova.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Office> office;

    @ManyToMany(mappedBy = "companies")
    private List<Menu> menu;

}
