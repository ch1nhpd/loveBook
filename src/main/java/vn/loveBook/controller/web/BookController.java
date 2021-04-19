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
import vn.loveBook.service.ICommentService;

@Controller(value = "BookControllerOfWeb")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ICommentService commentService;

	@RequestMapping(value = "/sach",method = RequestMethod.GET)
	public ModelAndView detailPage(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("web/detail");
		BookDTO bookDTO = new BookDTO();
		bookDTO = bookService.findById(id);
		mav.addObject("listComment", bookService.getCommentByBookId(id));
		mav.addObject("book", bookDTO);
		mav.addObject("listCategory", categoryService.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/tat-ca-sach",method = RequestMethod.GET)
	public ModelAndView allBook() {
		ModelAndView mav = new ModelAndView("web/list");
		mav.addObject("listHero", bookService.getHero());
		mav.addObject("allBook", bookService.findAll());
		mav.addObject("listTrending", bookService.getTrending());
		mav.addObject("listNewBook", bookService.getNewBook());
		mav.addObject("listRandom", bookService.getBookRandom());
		mav.addObject("listCategory", categoryService.findAll());
		return mav;
	}
}
