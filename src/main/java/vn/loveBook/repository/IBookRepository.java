package vn.loveBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.loveBook.entity.BookEntity;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long>{
	
}
