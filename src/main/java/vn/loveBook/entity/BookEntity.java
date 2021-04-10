package vn.loveBook.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@OneToMany(mappedBy = "book")
	List<CommentEntity> comments = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<UserEntity> users = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "avatar")

	@Lob
	private Blob avatar;

	@Column(name = "cover")

	@Lob
	private Blob cover;

	@Column(name = "author")
	private String author;

	@Column(name = "publishYear")
	private int publishYear;

	@Column(name = "content")
	private String content;

	@Column(name = "vote")
	private float vote;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getVote() {
		return vote;
	}

	public void setVote(float vote) {
		this.vote = vote;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public Blob getCover() {
		return cover;
	}

	public void setCover(Blob cover) {
		this.cover = cover;
	}

}
