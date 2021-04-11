package vn.loveBook.converter;

import vn.loveBook.DTO.UserDTO;
import vn.loveBook.entity.UserEntity;

public class UserConverter {
	public static UserDTO toDTO(UserEntity userEntity) {
		UserDTO result = new UserDTO();
		
		return result;
	}
	
	public static UserEntity toEntity(UserDTO userDTO) {
		UserEntity result = new UserEntity();
		result.setEmail(userDTO.getEmail());
		result.setUserName(userDTO.getUserName());
		result.setPassword(userDTO.getPassword());
		result.setStatus(userDTO.getStatus());
		return result;
	}
}
