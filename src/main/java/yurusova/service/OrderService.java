package yurusova.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import yurusova.dto.MenuOptionOrderDTO;
import yurusova.dto.OrderCreateDTO;
import yurusova.entity.*;
import yurusova.repository.OrderMenuOptionRepository;
import yurusova.repository.OrderRepository;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Resource
    CustomerCompanyService customerCompanyService;

    @Resource
    FoodCompanyService foodCompanyService;

    @Resource
    UserService userService;

    @Resource
    MenuOptionService menuOptionService;

    @Resource
    EmployeeService employeeService;

    @Resource
    OrderMenuOptionRepository orderMenuOptionRepository;

    @Resource
    OrderRepository orderRepository;


    public OrderCreateDTO getInfoForOrderCreationByUsername(Principal principal) {
        User admin = userService.getAdminByUser(principal.getName());
        Company company = customerCompanyService.getCompanyByAdminUsername(admin.getUsername());
        List<FoodCompany> foodCompanies = company.getFoodCompanies();
        OrderCreateDTO orderCreateDTO = new OrderCreateDTO();
        List<MenuOptionOrderDTO> menuOptionOrderDTOS = new ArrayList<>();
        orderCreateDTO.setMenuOptions(new ArrayList<>());
        HashMap<String, List<MenuOptionOrderDTO>> companyNameOptionsMap = new HashMap<>();
        for (FoodCompany foodCompany : foodCompanies) {
            menuOptionOrderDTOS = menuOptionService.convertToMenuOptionOrderDTO(foodCompany.getMenu().get(0).getMenuOptions(), foodCompany.getName());
            orderCreateDTO.getMenuOptions().addAll(menuOptionOrderDTOS);
        }
        return orderCreateDTO;
    }

    public void createOrder(List<MenuOptionOrderDTO> companyNameMenuOptions, Date orderDate, Principal principal) {
        User admin = userService.getAdminByUser(principal.getName());
        Company company = customerCompanyService.getCompanyByAdminUsername(admin.getUsername());
        List<FoodCompany> foodCompanies = company.getFoodCompanies();
        Employee employee = employeeService.getEmployeeByUsername(principal.getName());
        Order order = new Order();
        java.sql.Date sqlDate = new java.sql.Date(orderDate.getTime());
        order.setDate(sqlDate);
        order.setEmployee(employee);
        order = orderRepository.save(order);
        companyNameMenuOptions = companyNameMenuOptions.stream().filter(menuOptionOrderDTO -> menuOptionOrderDTO.getAmount() > 0).collect(Collectors.toList());
        for (MenuOptionOrderDTO menuOptionOrderDTO : companyNameMenuOptions) {
            MenuOption menuOption = new MenuOption();
            BeanUtils.copyProperties(menuOptionOrderDTO, menuOption);
            FoodCompany foodCompany = foodCompanyService.getFoodCompanyByName(menuOptionOrderDTO.getCompanyName());
            OrderMenuOption orderMenuOption = new OrderMenuOption();
            menuOption.setFoodCompany(foodCompany);
            orderMenuOption.setOrder(order);
            orderMenuOption.setMenuOption(menuOption);
            orderMenuOption.setAmount(menuOptionOrderDTO.getAmount());
            orderMenuOptionRepository.save(orderMenuOption);
        }

    }
}
