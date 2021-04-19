package vn.loveBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.loveBook.entity.CommentEntity;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long>{

}
