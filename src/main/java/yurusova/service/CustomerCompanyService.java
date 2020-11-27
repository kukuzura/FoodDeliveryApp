package yurusova.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.entity.Company;
import yurusova.entity.FoodCompany;
import yurusova.entity.User;
import yurusova.repository.CustomerCompanyRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerCompanyService
{
    private static final String CUSTOMER_ADMIN = "CUSTOMER_ADMIN";

    @Resource
    private CustomerCompanyRepository companyRepository;

    @Resource
    private UserService userService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createCustomerCompany(CompanyCreateUpdateDTO createCompanyDTO) {
        Company company = new Company();
        company.setName(createCompanyDTO.getName());
        User user = userService.createAdmin(createCompanyDTO.getAdminLogin(), createCompanyDTO.getPassword(), CUSTOMER_ADMIN);
        company.setAdmin(user);
        companyRepository.save(company);
    }

    public void removeCompany(long id){
        companyRepository.deleteById(id);
    }


    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public CompanyCreateUpdateDTO getCreateUpdateDTOById(Long id) {
        Company company = companyRepository.getOne(id);
        CompanyCreateUpdateDTO companyCreateUpdateDTO = new CompanyCreateUpdateDTO();
        BeanUtils.copyProperties(company,companyCreateUpdateDTO);
        companyCreateUpdateDTO.setType("CUSTOMER");
        return companyCreateUpdateDTO;
    }

    public void updateCompany(CompanyCreateUpdateDTO companyCreateUpdateDTO){
        Company company = companyRepository.getOne(companyCreateUpdateDTO.getId());
        BeanUtils.copyProperties(companyCreateUpdateDTO,company);
        User user = company.getAdmin();
        user.setUsername(companyCreateUpdateDTO.getAdminLogin());
        user.setPassword(bCryptPasswordEncoder.encode(companyCreateUpdateDTO.getPassword()));
        userService.save(user);
        companyRepository.save(company);
    }
}
