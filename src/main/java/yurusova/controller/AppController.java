package yurusova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yurusova.entity.Role;
import yurusova.entity.User;
import yurusova.repository.RoleRepository;
import yurusova.repository.UserRepository;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/index")
    public String index() {


        Role role1 = new Role();
        role1.setName("second role");
        roleRepository.save(role1);
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            System.out.println(role.getName());
        }
        return "index.jsp";
    }
}
