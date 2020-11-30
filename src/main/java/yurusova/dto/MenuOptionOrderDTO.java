package yurusova.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuOptionOrderDTO {
    Long id;

    String name;

    String description;

    Double cost;

    int amount;

    String companyName;
}
