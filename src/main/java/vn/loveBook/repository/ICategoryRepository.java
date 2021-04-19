package vn.loveBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.loveBook.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
