package yurusova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.service.CustomerCompanyService;
import yurusova.service.DefaultCompanyService;

@Controller
public class AdminController
{
    @Autowired
    DefaultCompanyService companyService;

    @Autowired
    DefaultCompanyService defaultCompanyService;

    @RequestMapping(value = "/company_list", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("customerCompanies",companyService.getCustomerCompanies());
        model.addAttribute("foodCompanies",companyService.getFoodCompanies());
        return "company_list";
    }

    @RequestMapping(value = "/create_company", method = RequestMethod.GET)
    public String getCreatePage(Model model) {
        model.addAttribute("company",new CompanyCreateUpdateDTO());
        return "create_company";
    }

    @RequestMapping(value = "/create_company", method = RequestMethod.POST)
    public String createCompany(@ModelAttribute("company") CompanyCreateUpdateDTO company) {
        companyService.createCompany(company);
        return "redirect:/company_list";
    }

}
