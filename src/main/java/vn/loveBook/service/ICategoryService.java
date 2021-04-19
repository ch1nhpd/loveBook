package vn.loveBook.service;

import java.util.List;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.DTO.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	CategoryDTO findById(long id);
	List<BookDTO> bookOfCategory(long id);
	
}
