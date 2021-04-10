package vn.loveBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{

	@ManyToOne()
	@JoinColumn(name = "book_id")
	private BookEntity book;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@Column(name ="content")
	private String content;

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
