package vn.loveBook.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.loveBook.DTO.UserDTO;
import vn.loveBook.service.IUserService;

@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;

	@PostMapping("api/user")
	public boolean create(@RequestBody UserDTO userDTO) throws Exception {
		return userService.save(userDTO);
	}
}
