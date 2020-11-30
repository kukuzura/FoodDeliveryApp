package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.dto.EmployeeCreateUpdateDTO;
import yurusova.service.CustomerCompanyService;
import yurusova.service.EmployeeService;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class CustomerController
{

    @Resource
    private CustomerCompanyService customerCompanyService;

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/customer_admin")
    public String getDeliveryAdminPage(Model model,Principal principal){
        model.addAttribute("employees",employeeService.getAllByAdmin(principal.getName()));
        model.addAttribute("company_name",customerCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "customer_admin_page";
    }


    @GetMapping("/create_customer_employee")
    public String getCreateUserPage(Model model, Principal principal){
        model.addAttribute("employee",new EmployeeCreateUpdateDTO());
        model.addAttribute("company_name",customerCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "create_employee";
    }

    @PostMapping("/create_customer_employee")
    public String createUser(@ModelAttribute("employee") EmployeeCreateUpdateDTO employee
            ,Principal principal){
        employeeService.saveEmployee(employee, principal,"FOOD");
        return "redirect:/customer_admin";
    }

}
