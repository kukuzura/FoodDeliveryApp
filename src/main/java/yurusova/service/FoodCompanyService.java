package yurusova.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.entity.Company;
import yurusova.entity.FoodCompany;
import yurusova.entity.User;
import yurusova.repository.FoodCompanyRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodCompanyService
{
	private static final String FOOD_ADMIN = "DELIVERY_ADMIN";

	@Resource
	private FoodCompanyRepository companyRepository;

	@Resource
	private UserService userService;

	@Resource
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void createFoodCompany(CompanyCreateUpdateDTO createCompanyDTO) {
		FoodCompany company = new FoodCompany();
		company.setName(createCompanyDTO.getName());
		User user = userService.createAdmin(createCompanyDTO.getAdminLogin(), createCompanyDTO.getPassword(), FOOD_ADMIN);
		company.setAdmin(user);
		companyRepository.save(company);
	}

	public List<FoodCompany> getAll(){
		return companyRepository.findAll();
	}

	public void removeCompany(Long id){
		companyRepository.deleteById(id);
	}

	public CompanyCreateUpdateDTO getCreateUpdateDTOById(Long id) {
		FoodCompany company = companyRepository.getOne(id);
		CompanyCreateUpdateDTO companyCreateUpdateDTO = new CompanyCreateUpdateDTO();
		BeanUtils.copyProperties(company,companyCreateUpdateDTO);
		companyCreateUpdateDTO.setType("FOOD");
		return companyCreateUpdateDTO;
	}

	public void updateCompany(CompanyCreateUpdateDTO companyCreateUpdateDTO){
		FoodCompany foodCompany = companyRepository.getOne(companyCreateUpdateDTO.getId());
		BeanUtils.copyProperties(companyCreateUpdateDTO,foodCompany);
		User user = foodCompany.getAdmin();
		user.setUsername(companyCreateUpdateDTO.getAdminLogin());
		user.setPassword(bCryptPasswordEncoder.encode(companyCreateUpdateDTO.getPassword()));
		userService.save(user);
		companyRepository.save(foodCompany);
	}
}