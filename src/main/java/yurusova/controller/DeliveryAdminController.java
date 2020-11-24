package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yurusova.dto.EmployeeCreateUpdateDTO;
import yurusova.service.EmployeeService;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class DeliveryAdminController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/delivery_admin")
    public String getDeliveryAdminPage(Model model){
        model.addAttribute("employees",employeeService.getAll());
        return "delivery_admin_page";
    }

    @GetMapping("/create_employee")
    public String getCreateUserPage(Model model){
        model.addAttribute("employee",new EmployeeCreateUpdateDTO());
        return "create_employee";
    }

    @PostMapping("/create_employee")
    public String createUser(@ModelAttribute("employee") EmployeeCreateUpdateDTO employee
            ,Principal principal){
        employeeService.saveEmployee(employee, principal);
        return "redirect:/delivery_admin";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/delivery_admin";
    }

}
