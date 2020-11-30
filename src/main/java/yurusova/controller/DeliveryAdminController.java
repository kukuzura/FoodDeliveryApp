package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yurusova.dto.EmployeeCreateUpdateDTO;
import yurusova.service.EmployeeService;
import yurusova.service.FoodCompanyService;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class DeliveryAdminController {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private FoodCompanyService foodCompanyService;

    @RequestMapping("/delivery_admin")
    public String getDeliveryAdminPage(Model model,Principal principal){
        model.addAttribute("employees",employeeService.getAllByAdmin(principal.getName()));
        model.addAttribute("company_name",foodCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "delivery_admin_page";
    }

    @GetMapping("/create_delivery_employee")
    public String getCreateUserPage(Model model,Principal principal){
        model.addAttribute("employee",new EmployeeCreateUpdateDTO());
        model.addAttribute("company_name",foodCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "create_employee";
    }

    @PostMapping("/create_delivery_employee")
    public String createUser(@ModelAttribute("employee") EmployeeCreateUpdateDTO employee
            ,Principal principal){
        employeeService.saveEmployee(employee, principal,"FOOD");
        return "redirect:/delivery_admin";
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/delivery_admin";
    }

}
