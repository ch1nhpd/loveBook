package vn.loveBook.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.DTO.CategoryDTO;
import vn.loveBook.service.IBookService;
import vn.loveBook.service.ICategoryService;
import vn.loveBook.util.MessageUtil;

@Controller(value = "bookControllerOfAdmin")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "quan-tri/sach/danh-sach" , method = RequestMethod.GET)
	public ModelAndView listPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list");
		BookDTO bookDTO = new BookDTO();
		bookDTO.setListResult(bookService.findAll());
		mav.addObject("model", bookDTO);

		if(request.getParameter("message")!=null) {
			mav.addObject("message", MessageUtil.getMessage(request.getParameter("message")));
		}
		
		return mav;
	}
	
	@RequestMapping(value = "quan-tri/sach/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/edit");
		BookDTO model = new BookDTO(); 
		if(id!=null) {
			model = bookService.findById(id);
		}
		List<CategoryDTO> categories = categoryService.findAll();
		
		mav.addObject("categories", categories);
		mav.addObject("model",model);
		return mav;
	}
}
