package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.converter.BookConverter;
import vn.loveBook.entity.BookEntity;
import vn.loveBook.entity.CategoryEntity;
import vn.loveBook.repository.IBookRepository;
import vn.loveBook.repository.ICategoryRepository;
import vn.loveBook.service.IBookService;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired ICategoryRepository categoryRepo;

	@Override
	public List<BookDTO> findAll() {
		List<BookDTO> results = new ArrayList<>();
		for (BookEntity bookEntity : bookRepo.findAll()) {
			results.add(BookConverter.toDTO(bookEntity));
		}
		return results;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		bookRepo.delete(id);
	}

	@Override
	@Transactional
	public BookDTO save(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		CategoryEntity category = categoryRepo.findOne(bookDTO.getCategoryId());
		
		if(bookDTO.getId()!=0l) {
			bookEntity = bookRepo.findOne(bookDTO.getId()); 
			bookEntity = BookConverter.toEntity(bookEntity, bookDTO);
		}else {
			bookEntity = BookConverter.toEntity(bookDTO);
		}
		
		bookEntity.setCategory(category);
		return BookConverter.toDTO(bookRepo.save(bookEntity));
	}

	@Override
	public BookDTO findById(long id) {
		return BookConverter.toDTO(bookRepo.findOne(id));
	}

	@Override
	public List<BookDTO> getTrending() {
		List<BookDTO> listTrending = new ArrayList<>();
		for(long i = 8 ;i<14;++i) {
			BookEntity book = bookRepo.findOne(i);
			if(book!=null) {
				listTrending.add(BookConverter.toDTO( book));
			}
		}
		return listTrending;
	}

	@Override
	public List<BookDTO> getHero() {
		List<BookDTO> listHero = new ArrayList<>();
		for(long i = 8;i<11;++i) {
			BookEntity book = bookRepo.findOne(i);
			if(book!=null) {
				listHero.add(BookConverter.toDTO( book));
			}
		}
		return listHero;
	}

	@Override
	public List<BookDTO> getNewBook() {
		List<BookDTO> results = new ArrayList<BookDTO>();
		for (BookEntity bookEntity : bookRepo.findAll()) {
			if(bookEntity.getPublishYear()>2019) {
				results.add(BookConverter.toDTO(bookEntity));
			}
		}
		return results;
	}

	@Override
	public List<BookDTO> getBookRandom() {
		List<BookDTO> listHero = new ArrayList<>();
		for(long i = 1;i<8;++i) {
			BookEntity book = bookRepo.findOne(i);
			if(book!=null) {
				listHero.add(BookConverter.toDTO( book));
			}
		}
		return listHero;
	}


}
