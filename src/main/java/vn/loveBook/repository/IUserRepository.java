package vn.loveBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.loveBook.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findOneByUserNameAndStatus(String username, int status);
	
}
