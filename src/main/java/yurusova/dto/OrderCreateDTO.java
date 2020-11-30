package yurusova.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OrderCreateDTO implements Serializable {

    List<MenuOptionOrderDTO> menuOptions;

    String orderDate;

    public OrderCreateDTO() {
    }

    public OrderCreateDTO(String companyName, List<MenuOptionOrderDTO> menuOptions, String orderDate) {

        this.menuOptions = menuOptions;
        this.orderDate = orderDate;
    }
}
