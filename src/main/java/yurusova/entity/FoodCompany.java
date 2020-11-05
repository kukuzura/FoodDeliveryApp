package yurusova.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
public class FoodCompany {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Time timeRestriction;

    @OneToMany
    private List<Menu> menu;


}
