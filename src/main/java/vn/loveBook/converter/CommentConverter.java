package vn.loveBook.converter;

import vn.loveBook.DTO.CommentDTO;
import vn.loveBook.entity.CommentEntity;


public class CommentConverter {

	public static CommentEntity toEntity(CommentDTO commentDTO) {
		CommentEntity comment = new CommentEntity();
		comment.setContent(commentDTO.getContent());
		return comment;
	}
	
	public static CommentDTO toDTO(CommentEntity commentEntity) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentBy(commentEntity.getUser().getUserName());
		commentDTO.setContent(commentEntity.getContent());
		return commentDTO;
	}
}
