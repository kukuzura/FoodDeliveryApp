package yurusova.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCreateUpdateDTO {

    private Long id;

    private String name;

    private String adminLogin;

    private String password;

    private String type;
}
