package yurusova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.entity.Company;
import yurusova.entity.User;
import yurusova.repository.CustomerCompanyRepository;
import java.util.List;

@Service
public class CustomerCompanyService
{
    private static final String CUSTOMER_ADMIN = "CUSTOMER_ADMIN";

    @Autowired
    private CustomerCompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    public void createCustomerCompany(CompanyCreateUpdateDTO createCompanyDTO) {
        Company company = new Company();
        company.setName(createCompanyDTO.getName());
        User user = userService.createAdmin(createCompanyDTO.getAdminLogin(), createCompanyDTO.getPassword(), CUSTOMER_ADMIN);
        company.setAdmin(user);
        companyRepository.save(company);
    }

    public List<Company> getAll(){
        return companyRepository.findAll();
    }
}
