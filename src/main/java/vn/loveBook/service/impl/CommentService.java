package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.loveBook.DTO.CommentDTO;
import vn.loveBook.converter.CommentConverter;
import vn.loveBook.entity.CommentEntity;
import vn.loveBook.repository.ICommentRepository;
import vn.loveBook.service.ICommentService;

@Service
public class CommentService implements ICommentService{

	@Autowired
	private ICommentRepository commentRepo;
	
	@Override
	public boolean save(CommentDTO comment) {
		try {
			commentRepo.save(CommentConverter.toEntity(comment));
		} catch (Exception e) {
			return false;
		}
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
