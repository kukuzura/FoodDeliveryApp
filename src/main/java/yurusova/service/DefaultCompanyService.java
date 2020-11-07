package yurusova.service;

import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCompanyService
{
	@Resource
	private FoodCompanyService foodCompanyService;

	@Resource
	private CustomerCompanyService customerCompanyService;

	public void createCompany(CompanyCreateUpdateDTO comp){
		if (comp.getType().equals("CUSTOMER"))
		{
			customerCompanyService.createCustomerCompany(comp);
		}
		else if (comp.getType().equals("FOOD"))
		{
			foodCompanyService.createFoodCompany(comp);
		}
	}

	public List getCompanies(){
		ArrayList comps = new ArrayList();
		comps.addAll(getCustomerCompanies());
		comps.addAll(getFoodCompanies());
		return comps;
	}

	public List getCustomerCompanies(){
		return customerCompanyService.getAll();
	}

	public List getFoodCompanies(){
		return foodCompanyService.getAll();
	}
}
