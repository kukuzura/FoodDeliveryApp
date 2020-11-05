package yurusova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.entity.Company;
import yurusova.entity.User;
import yurusova.repository.CompanyRepository;
import yurusova.repository.UserRepository;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void createCompany(CompanyCreateUpdateDTO createCompanyDTO) {
        Company company = new Company();
        User user = new User();
        company.setName(createCompanyDTO.getName());
        user.setUsername(createCompanyDTO.getAdminLogin());
        user.setPassword(bCryptPasswordEncoder.encode(createCompanyDTO.getPassword()));
        user = userRepository.save(user);
        company.setAdmin(user);
        companyRepository.save(company);
    }

    public List<Company> getAll(){
        return companyRepository.findAll();
    }
}
