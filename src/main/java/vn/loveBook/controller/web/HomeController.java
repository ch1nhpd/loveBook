package vn.loveBook.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.loveBook.service.IBookService;
import vn.loveBook.service.ICategoryService;
import vn.loveBook.util.MessageUtil;

@Controller(value = "controllerOfWeb")
public class HomeController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired 
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/trang-chu" , method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("listTrending", bookService.getTrending());
		mav.addObject("listHero", bookService.getHero());
		mav.addObject("listNewBook", bookService.getNewBook());
		mav.addObject("listRandom", bookService.getBookRandom());
		mav.addObject("listCategory", categoryService.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap" , method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/dang-ki" , method = RequestMethod.GET)
	public ModelAndView signUpPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("signUp");
		if(request.getParameter("message")!=null) {
			mav.addObject("message", MessageUtil.getMessage(request.getParameter("message")));
		}
		return mav;
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
}
