package yurusova.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import yurusova.dto.MenuOptionCreateMenuDTO;
import yurusova.dto.MenuOptionOrderDTO;
import yurusova.entity.*;
import yurusova.repository.CustomerCompanyRepository;
import yurusova.repository.FoodCompanyRepository;
import yurusova.repository.MenuRepository;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private FoodCompanyRepository foodCompanyRepository;

    @Resource
    private CustomerCompanyRepository companyRepository;

    public void createMenu(List<MenuOptionCreateMenuDTO> menuDTOS, Principal principal) {
        User admin = userRepository.getAdminByUser_Username(principal.getName());
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(admin.getUsername());
        Menu menu = foodCompany.getMenu().get(0);
        if (menu == null) {
            menu = new Menu();
        }
        List<MenuOption> menuOptions = new ArrayList<>();
        for (MenuOptionCreateMenuDTO menuDTO : menuDTOS) {
            if (menuDTO.getIsChoose()) {
                MenuOption menuOption = new MenuOption();
                BeanUtils.copyProperties(menuDTO, menuOption);
                menuOptions.add(menuOption);
            }
        }
        menu.setMenuOptions(menuOptions);
        menuRepository.save(menu);
    }


}
