package yurusova.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yurusova.dto.CompanyCreateUpdateDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCompanyService
{
	private static final String CUSTOMER_COMPANY = "CUSTOMER";
	private static final String FOOD_COMPANY = "FOOD";

	@Resource
	private FoodCompanyService foodCompanyService;

	@Resource
	private CustomerCompanyService customerCompanyService;

	public void createCompany(CompanyCreateUpdateDTO comp){
		if (comp.getType().equals(CUSTOMER_COMPANY))
		{
			customerCompanyService.createCustomerCompany(comp);
		}
		else if (comp.getType().equals(FOOD_COMPANY))
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

	public void removeCompany(String type, long id){
		if (type.equals(CUSTOMER_COMPANY))
		{
			customerCompanyService.removeCompany(id);
		}
		else if (type.equals(FOOD_COMPANY))
		{
			foodCompanyService.removeCompany(id);
		}
	}
}
