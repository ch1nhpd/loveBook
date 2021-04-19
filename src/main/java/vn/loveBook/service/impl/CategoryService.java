package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.DTO.CategoryDTO;
import vn.loveBook.converter.BookConverter;
import vn.loveBook.converter.CategoryConverter;
import vn.loveBook.entity.BookEntity;
import vn.loveBook.entity.CategoryEntity;
import vn.loveBook.repository.ICategoryRepository;
import vn.loveBook.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryRepository categoryRepo;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		for (CategoryEntity categoryEntity : categoryRepo.findAll()) {
			results.add(CategoryConverter.toDTO(categoryEntity));
		}
		return results;
	}

	@Override
	public CategoryDTO findById(long id) {
		return CategoryConverter.toDTO(categoryRepo.findOne(id));
	}

	@Override
	public List<BookDTO> bookOfCategory(long id) {
		List<BookDTO> listBook = new ArrayList<>();
		for (BookEntity book : categoryRepo.findOne(id).getBooks()) {
			listBook.add(BookConverter.toDTO(book));
		}
		return listBook;
	}

}
