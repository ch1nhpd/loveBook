package vn.loveBook.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.loveBook.DTO.CommentDTO;
import vn.loveBook.entity.CommentEntity;
import vn.loveBook.repository.IBookRepository;
import vn.loveBook.repository.IUserRepository;

@Component
public class CommentConverter {
	@Autowired
	private static IBookRepository bookRepo;

	@Autowired
	private static IUserRepository userRepo;

	public static CommentEntity toEntity(CommentDTO commentDTO) {
		CommentEntity comment = new CommentEntity();
		comment.setBook(bookRepo.findOne(commentDTO.getBookId()));
		comment.setUser(userRepo.findOne(commentDTO.getUserId()));
		return comment;
	}
	
	public static CommentDTO toDTO(CommentEntity commentEntity) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentBy(commentEntity.getUser().getUserName());
		commentDTO.setContent(commentEntity.getContent());
		return commentDTO;
	}
}
