package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.loveBook.DTO.CommentDTO;
import vn.loveBook.converter.CommentConverter;
import vn.loveBook.entity.CommentEntity;
import vn.loveBook.repository.IBookRepository;
import vn.loveBook.repository.ICommentRepository;
import vn.loveBook.repository.IUserRepository;
import vn.loveBook.service.ICommentService;

@Service
public class CommentService implements ICommentService{

	@Autowired
	private ICommentRepository commentRepo;
	
	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired IUserRepository userRepo;
	
	@Override
	public boolean save(CommentDTO comment) {
		CommentEntity commentEntity = CommentConverter.toEntity(comment);
		commentEntity.setBook(bookRepo.findOne(comment.getBookId()));
		commentEntity.setUser(userRepo.findOne(comment.getUserId()));
		commentRepo.save(commentEntity);
		return true;
	}

	@Override
	public List<CommentDTO> findAll() {
		List<CommentDTO> listResults = new ArrayList<>();
		for (CommentEntity commentEntity : commentRepo.findAll()) {
			listResults.add(CommentConverter.toDTO(commentEntity));
		}
		return listResults;
	}

}
