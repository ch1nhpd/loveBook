package vn.loveBook.service;

import java.util.List;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.DTO.CommentDTO;

public interface IBookService {
	List<BookDTO> findAll();
	List<CommentDTO> getCommentByBookId(long id);
	BookDTO findById(long id);
	void deleteById(long id);
	BookDTO save(BookDTO bookDTO);
	List<BookDTO> getTrending();
	List<BookDTO> getHero();
	List<BookDTO> getNewBook();
	List<BookDTO> getBookRandom();
}
