package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.dto.MenuOptionCreateDTO;
import yurusova.service.FoodCompanyService;
import yurusova.service.MenuOptionService;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class MenuOptionController {

    @Resource
    private MenuOptionService menuOptionService;

    @Resource
    private FoodCompanyService foodCompanyService;

    @RequestMapping("/menu_options")
    public String getAllOptionsOfCompany(Model model, Principal principal) {
        model.addAttribute("menu_options", menuOptionService.getAllMenuOptionsByCompany(principal));
        model.addAttribute("company_name", foodCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "menu_option_list";
    }

    @GetMapping("/menu_options/add")
    public String getCreateMenuOptionPage(Model model, Principal principal) {
        model.addAttribute("menu_option", new MenuOptionCreateDTO());
        model.addAttribute("company_name", foodCompanyService.getCompanyNameByAdminUsername(principal.getName()));
        return "create_menu_option";
    }

    @PostMapping("/menu_options/add")
    public String createMenuOption(@ModelAttribute("menu_option") MenuOptionCreateDTO menuOptionCreateDTO, Principal principal) {
        menuOptionService.saveMenuOption(principal, menuOptionCreateDTO);
        return "redirect:/menu_option_list";
    }

}
