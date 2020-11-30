package yurusova.service;


import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yurusova.dto.EmployeeCreateUpdateDTO;
import yurusova.entity.Employee;
import yurusova.entity.User;
import yurusova.repository.EmployeeRepository;
import yurusova.repository.UserRepository;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleService roleService;

    public List<Employee> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public List<Employee> getAllByAdmin(String adminUsername){
        return employeeRepository.findAllByUser_Admin_Username(adminUsername);
    }

    @Transactional
    public void saveEmployee(EmployeeCreateUpdateDTO employeeCreateUpdateDTO, Principal principal,String type){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeCreateUpdateDTO,employee);
        User admin = userRepository.findByUsername(principal.getName());
        User user = new User();
        user.setUsername(employeeCreateUpdateDTO.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(employeeCreateUpdateDTO.getPassword()));
        if(type.equals("FOOD")) {
            user.setRoles(Collections.singletonList(roleService.getRoleByName("DELIVERY_USER")));
        }
        else if(type.equals("CUSTOMER")){
            user.setRoles(Collections.singletonList(roleService.getRoleByName("CUSTOMER_USER")));
        }
        user.setAdmin(admin);
        user = userRepository.save(user);
        employee.setUser(user);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByUsername(String username){
        return employeeRepository.findByUser_Username(username);
    }

}
