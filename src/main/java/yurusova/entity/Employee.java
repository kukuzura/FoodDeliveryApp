package yurusova.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    private String post;

    @OneToOne
    private User user;

    @OneToMany
    private List<Order> orders;

    @ManyToOne
    private Office office;

}
