package vn.loveBook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.loveBook.DTO.UserDTO;
import vn.loveBook.constant.SystemConstant;
import vn.loveBook.converter.UserConverter;
import vn.loveBook.repository.IUserRepository;
import vn.loveBook.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	@Transactional
	public boolean save(UserDTO userDTO) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		userDTO.setPassword(bCrypt.encode(userDTO.getPassword()));
		userDTO.setStatus(SystemConstant.ACTIVE_STATUS);
//chua xu li trung userName
		return userRepo.save(UserConverter.toEntity(userDTO))!=null;
	}

}
