package vn.loveBook.converter;

import vn.loveBook.DTO.BookDTO;
import vn.loveBook.entity.BookEntity;
import vn.loveBook.util.Files;

public class BookConverter {

	public static BookDTO toDTO(BookEntity bookEntity) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(bookEntity.getId());
		bookDTO.setName(bookEntity.getName());
		bookDTO.setAuthor(bookEntity.getAuthor());
		bookDTO.setContent(bookEntity.getContent());
		bookDTO.setModifiedDate(bookEntity.getModifiedDate());
		bookDTO.setCategoryId(bookEntity.getCategory().getId());
		bookDTO.setCover(new Files(bookEntity.getCover(), " "));
		bookDTO.setAvatar(new Files(bookEntity.getAvatar(), " "));
		bookDTO.setVote(bookEntity.getVote());
		return bookDTO;
	}
	
	public static BookEntity toEntity(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(bookDTO.getName());
		bookEntity.setAuthor(bookDTO.getAuthor());
		bookEntity.setContent(bookDTO.getContent());
		bookEntity.setCover(bookDTO.getCover().getName());
		bookEntity.setPublishYear(bookDTO.getPublishYear());
		bookEntity.setAvatar(bookDTO.getAvatar().getName());
		return bookEntity;
	}
	
	public static BookEntity toEntity(BookEntity oldBook,BookDTO bookDTO) {
		oldBook.setName(bookDTO.getName());
		oldBook.setAuthor(bookDTO.getAuthor());
		oldBook.setContent(bookDTO.getContent());
		oldBook.setPublishYear(bookDTO.getPublishYear());
		oldBook.setAvatar(bookDTO.getAvatar().getName());
		oldBook.setCover(bookDTO.getCover().getBase64());;
		return oldBook;
	}

}
