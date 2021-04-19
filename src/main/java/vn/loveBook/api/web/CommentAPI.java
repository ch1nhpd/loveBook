package vn.loveBook.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.loveBook.DTO.CommentDTO;
import vn.loveBook.service.ICommentService;

@RestController("CommentAPIofWeb")
public class CommentAPI {
	
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("api/comment")
	public boolean create(@RequestBody CommentDTO commentDTO) {
		return commentService.save(commentDTO);
	}

}
