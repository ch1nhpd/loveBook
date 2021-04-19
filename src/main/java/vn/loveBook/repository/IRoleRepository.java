package vn.loveBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.loveBook.entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{

}
