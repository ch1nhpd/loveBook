package vn.loveBook.service;

import vn.loveBook.DTO.UserDTO;

public interface IUserService {
	boolean save(UserDTO userDTO) throws Exception;
}
