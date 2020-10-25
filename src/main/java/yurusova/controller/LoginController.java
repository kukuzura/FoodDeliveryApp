package yurusova.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController
{
/*	@RequestMapping(value = {"/login","","/"},  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@ModelAttribute("value") String string, HttpServletRequest request){
		if (isAuthenticated()){
			return new ModelAndView("index");
		}
		ModelAndView mnv = new ModelAndView("login");
		String isError = request.getParameter("error");
		if ("true".equals(isError)) {
			mnv.addObject("errorMessage", "Wrong credentials");
		}
		return mnv;
	}*/
/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}*/
	@RequestMapping(value = "/login",  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@ModelAttribute("value") String string, HttpServletRequest request){
		ModelAndView mnv = new ModelAndView("login");
		String isError = request.getParameter("error");
		if ("true".equals(isError)) {
			mnv.addObject("errorMessage", "Wrong credentials");
		}
		return mnv;
	}

	private boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || AnonymousAuthenticationToken.class.
				isAssignableFrom(authentication.getClass())) {
			return false;
		}
		return authentication.isAuthenticated();
	}
}
