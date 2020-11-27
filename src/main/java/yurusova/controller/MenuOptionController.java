package yurusova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.service.MenuOptionService;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class MenuOptionController {

    @Resource
    private MenuOptionService menuOptionService;

    @RequestMapping("/menu_options")
    public String getAllOptionsOfCompany(Model model,Principal principal){
        model.addAttribute("menu_options",menuOptionService.getAllMenuOptionsByCompany(principal));
        return "menu_option_list";
    }

}
