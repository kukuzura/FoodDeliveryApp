package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.dto.MenuOptionCreateMenuDTO;
import yurusova.service.EmployeeService;
import yurusova.service.MenuOptionService;
import yurusova.service.MenuService;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@Controller
public class DeliveryEmployeeController {

    @Resource
    MenuOptionService menuOptionService;

    @Resource
    MenuService menuService;

    @Resource
    EmployeeService employeeService;

    @GetMapping("/delivery_employee_page")
    String getCreateMenuPage(Model model, Principal principal){
        model.addAttribute("employee",employeeService.getEmployeeByUsername(principal.getName()));
        model.addAttribute("menu_options",menuOptionService.getAllMenuOptionsToCreateMenu(principal));
        return "create_menu";
    }

    @PostMapping("/delivery_employee_page")
    String createUpdateMenu(@ModelAttribute("menu_options")List<MenuOptionCreateMenuDTO> menuOptionCreateMenuDTOS, Principal principal){
        menuService.createMenu(menuOptionCreateMenuDTOS,principal);
        return "create_menu";
    }

}
