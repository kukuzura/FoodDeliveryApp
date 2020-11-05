package yurusova.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    String name;

    String address;

    @ManyToOne
    Company company;

    @OneToMany
    List<Employee> employee;

}
