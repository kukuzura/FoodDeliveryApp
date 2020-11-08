package yurusova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;
import yurusova.entity.FoodCompany;
import yurusova.entity.User;
import yurusova.repository.FoodCompanyRepository;

import java.util.List;

@Service
public class FoodCompanyService
{
	private static final String FOOD_ADMIN = "DELIVERY_ADMIN";

	@Autowired
	private FoodCompanyRepository companyRepository;

	@Autowired
	private UserService userService;

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

	public void removeCompany(long id){
		companyRepository.deleteById(id);
	}
}
