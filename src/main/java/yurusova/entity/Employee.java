package yurusova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
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
