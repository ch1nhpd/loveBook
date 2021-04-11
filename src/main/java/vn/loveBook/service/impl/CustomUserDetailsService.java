package vn.loveBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.loveBook.DTO.MyUser;
import vn.loveBook.constant.SystemConstant;
import vn.loveBook.entity.RoleEntity;
import vn.loveBook.entity.UserEntity;
import vn.loveBook.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepo.findOneByUserNameAndStatus( username,  SystemConstant.ACTIVE_STATUS);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException("Use not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
		}
		
		MyUser user = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		user.setFullName(userEntity.getUserName());
		return user;
	}

}
