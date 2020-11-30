package yurusova.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yurusova.dto.MenuOptionCreateDTO;
import yurusova.dto.MenuOptionCreateMenuDTO;
import yurusova.dto.MenuOptionOrderDTO;
import yurusova.entity.FoodCompany;
import yurusova.entity.MenuOption;
import yurusova.entity.User;
import yurusova.repository.FoodCompanyRepository;
import yurusova.repository.MenuOptionRepository;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuOptionService {

    @Resource
    MenuOptionRepository menuOptionRepository;

    @Resource
    UserService userService;

    @Resource
    FoodCompanyRepository foodCompanyRepository;

    @Transactional
    public List<MenuOption> getAllMenuOptionsByCompany(Principal principal) {
        User admin = userService.getAdminByUser(principal.getName());
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(admin.getUsername());
        return foodCompany.getMenuOptions();
    }

    @Transactional
    public List<MenuOptionCreateMenuDTO> getAllMenuOptionsToCreateMenu(Principal principal) {
        User admin = userService.getAdminByUser(principal.getName());
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(admin.getUsername());
        List<MenuOption> menuOptions = foodCompany.getMenuOptions();
        List<MenuOptionCreateMenuDTO> menuOptionCreateMenuDTOS = new ArrayList<>();
        for (MenuOption menuOption : menuOptions) {
            MenuOptionCreateMenuDTO menuDTO = new MenuOptionCreateMenuDTO();
            BeanUtils.copyProperties(menuOption, menuDTO);
            menuOptionCreateMenuDTOS.add(menuDTO);
        }
        return menuOptionCreateMenuDTOS;
    }

    public void saveMenuOption(Principal principal, MenuOptionCreateDTO menuOptionCreateDTO) {
        MenuOption menuOption = new MenuOption();
        BeanUtils.copyProperties(menuOptionCreateDTO, menuOption);
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(principal.getName());
        menuOption.setFoodCompany(foodCompany);
        menuOptionRepository.save(menuOption);
    }

    public List<MenuOptionOrderDTO> convertToMenuOptionOrderDTO(List<MenuOption> menuOptionList,String foodCompanyName) {
        List<MenuOptionOrderDTO> menuOptionOrderDTOS = new ArrayList<>();
        for (MenuOption menuOption : menuOptionList) {
            MenuOptionOrderDTO menuOptionOrderDTO = new MenuOptionOrderDTO();
            BeanUtils.copyProperties(menuOption, menuOptionOrderDTO);
            menuOptionOrderDTO.setCompanyName(foodCompanyName);
            menuOptionOrderDTOS.add(menuOptionOrderDTO);
        }
        return menuOptionOrderDTOS;
    }

}
