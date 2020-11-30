package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.dto.OrderCreateDTO;
import yurusova.service.OrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Date;

@Controller
public class CustomerEmployeeController {

    @Resource
    OrderService orderService;

    @GetMapping("/create_order")
    String getCreateOrderPage(Principal principal, Model model, HttpSession httpSession){
        OrderCreateDTO orderCreateDTO = orderService.getInfoForOrderCreationByUsername(principal);
        orderCreateDTO.setOrderDate(new Date().toString());
//        model.addAttribute("companyNameMenuOptionsMap",orderService.getInfoForOrderCreationByUsername(principal));
//        model.addAttribute("orderDate",new Date());
        model.addAttribute("orderDTO",orderCreateDTO);
       // httpSession.setAttribute("orderDTO",orderCreateDTO);
        return "create_order_page";
    }


}
