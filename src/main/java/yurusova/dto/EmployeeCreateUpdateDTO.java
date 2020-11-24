package yurusova.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateUpdateDTO {

    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    private String username;

    private String password;

    private String post;
}
