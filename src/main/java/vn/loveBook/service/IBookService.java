package vn.loveBook.service;

import java.util.List;

import vn.loveBook.DTO.BookDTO;

public interface IBookService {
	List<BookDTO> findAll();
	BookDTO findById(long id);
	void deleteById(long id);
	BookDTO save(BookDTO bookDTO);
	List<BookDTO> getTrending();
	List<BookDTO> getHero();
	List<BookDTO> getNewBook();
	List<BookDTO> getBookRandom();
}
