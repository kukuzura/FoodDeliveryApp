package yurusova.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuOptionCreateMenuDTO extends MenuOptionCreateDTO {
    Long id;

    Boolean isChoose;

}
