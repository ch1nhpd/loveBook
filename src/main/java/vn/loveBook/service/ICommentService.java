package vn.loveBook.service;

import java.util.List;

import vn.loveBook.DTO.CommentDTO;

public interface ICommentService {
	boolean save(CommentDTO comment);
	List<CommentDTO> findAll();

}
