package vn.loveBook.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.service.IBookService;
import vn.loveBook.service.ICategoryService;

@Controller("CategoryControllerOfWeb")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IBookService bookService;

	@RequestMapping(value = "/the-loai", method = RequestMethod.GET)
	public ModelAndView bookOfCategory(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("web/category");
		mav.addObject("books", categoryService.bookOfCategory(id));
		mav.addObject("nameCategory", categoryService.findById(id).getName());
		mav.addObject("listCategory", categoryService.findAll());
		mav.addObject("listTrending", bookService.getTrending());
		mav.addObject("listHero", bookService.getHero());
		mav.addObject("listNewBook", bookService.getNewBook());
		mav.addObject("listRandom", bookService.getBookRandom());
		return mav;
	}
}
