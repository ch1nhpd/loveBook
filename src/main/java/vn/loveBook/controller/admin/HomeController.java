package vn.loveBook.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.loveBook.DTO.BookDTO;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@RequestMapping(value = "quan-tri/trang-chu")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
	

}
