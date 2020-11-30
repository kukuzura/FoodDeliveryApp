package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yurusova.dto.MenuOptionOrderDTO;
import yurusova.dto.OrderCreateDTO;
import yurusova.service.OrderService;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/create_order")
    String getCreateOrderPage(@ModelAttribute("orderDTO") OrderCreateDTO orderCreateDTO,
                              Principal principal,
                              Model model) throws ParseException {
      orderService.createOrder(orderCreateDTO.getMenuOptions(), new SimpleDateFormat("yyyy-MM-dd").parse(orderCreateDTO.getOrderDate()), principal);
        return "create_order_page";
    }
}
