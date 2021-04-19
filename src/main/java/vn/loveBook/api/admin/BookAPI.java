package vn.loveBook.api.admin;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.service.IBookService;
import vn.loveBook.util.FileUtil;

@RestController
public class BookAPI {

	@Autowired
	private IBookService bookService;

	@DeleteMapping("api/book")
	public void delete(@RequestBody long id) {
		bookService.deleteById(id);
	}

	@PostMapping("api/book")
	public BookDTO create(@RequestBody BookDTO bookDTO) {
		return bookService.save(bookDTO);
	}

	@PutMapping("api/book")
	public BookDTO update(@RequestBody BookDTO bookDTO) {
		String base64avt= bookDTO.getAvatar().getBase64().split(",")[1];
		String base64cv= bookDTO.getCover().getBase64().split(",")[1];
		byte[] decodeBase64avt = Base64.getDecoder().decode(base64avt.getBytes());
		byte[] decodeBase64cv = Base64.getDecoder().decode(base64cv.getBytes());
		FileUtil.save(decodeBase64avt, "avatar\\"+bookDTO.getAvatar().getName());
		FileUtil.save(decodeBase64cv, "cover\\"+bookDTO.getCover().getName());
		return bookService.save(bookDTO);
	}

}
