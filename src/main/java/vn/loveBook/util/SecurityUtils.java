package vn.loveBook.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import vn.loveBook.DTO.MyUser;

public class SecurityUtils {

	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			results.add(grantedAuthority.getAuthority());
		}
		return results;
	}

	public static MyUser getPrincipal() {
		try {
			MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return myUser;
		} catch (Exception e) {
			return null;
		}
		
	}

}
