package yurusova.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yurusova.entity.FoodCompany;
import yurusova.entity.MenuOption;
import yurusova.entity.User;
import yurusova.repository.FoodCompanyRepository;
import yurusova.repository.MenuOptionRepository;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@Service
public class MenuOptionService {

    @Resource
    MenuOptionRepository menuOptionRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    FoodCompanyRepository foodCompanyRepository;

    @Transactional
    public List<MenuOption> getAllMenuOptionsByCompany(Principal principal) {
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(principal.getName());
        return foodCompany.getMenuOptions();
    }

    public void saveMenuOption(Principal principal, MenuOption menuOption) {
        FoodCompany foodCompany = foodCompanyRepository.findFoodCompanyByAdmin_Username(principal.getName());

    }

}
