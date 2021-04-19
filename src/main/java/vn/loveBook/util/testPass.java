package vn.loveBook.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vn.loveBook.DTO.MyUser;

public class testPass {

	public static void main(String[] args) {
		/*
		 * BCryptPasswordEncoder dd = new BCryptPasswordEncoder();
		 * System.out.println(dd.encode("chinhpd")); boolean a = dd.matches("chinhpd",
		 * "$2a$10$ldKd1gdd7nlxrIGAorMjX.cLhmjc0dtzUf///1CIxwXjAMIuzPTZq");
		 * System.out.println(a);
		 */
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(myUser.getFullName());
	}

}
