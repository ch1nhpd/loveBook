package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.loveBook.DTO.UserDTO;
import vn.loveBook.constant.SystemConstant;
import vn.loveBook.converter.UserConverter;
import vn.loveBook.entity.RoleEntity;
import vn.loveBook.entity.UserEntity;
import vn.loveBook.repository.IRoleRepository;
import vn.loveBook.repository.IUserRepository;
import vn.loveBook.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IRoleRepository roleRepo;

	@Override
	@Transactional
	public boolean save(UserDTO userDTO) throws Exception {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		userDTO.setPassword(bCrypt.encode(userDTO.getPassword()));
		userDTO.setStatus(SystemConstant.ACTIVE_STATUS);
		// xu li trung userName
		for (UserEntity user : userRepo.findAll()) {
			if(userDTO.getUserName().equals(user.getUserName())) {
				throw new Exception("Username không hợp lệ!");
			}
		}
		UserEntity userEntity = UserConverter.toEntity(userDTO);
		//mặc định đăng kí có role là USER
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		RoleEntity role = roleRepo.findOne((long) 1);
		roles.add(role);
		userEntity.setRoles(roles);
		return userRepo.save(userEntity)!=null;
	}

}
