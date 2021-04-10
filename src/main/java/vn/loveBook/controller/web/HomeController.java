package vn.loveBook.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfWeb")
public class HomeController {
	
	@RequestMapping(value = "/trang-chu" , method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "/the-loai" , method = RequestMethod.GET)
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView("web/category");
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap" , method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/dang-ki" , method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView mav = new ModelAndView("signUp");
		return mav;
	}
	
	@RequestMapping(value = "/bai-viet" , method = RequestMethod.GET)
	public ModelAndView detailPage() {
		ModelAndView mav = new ModelAndView("web/detail");
		return mav;
	}
}
