package vn.loveBook.DTO;

import vn.loveBook.util.Files;

public class BookDTO extends AbstractDTO<BookDTO> {
	private String name;

	private String author;

	private String content;

	private int publishYear;

	private float vote;

	private long categoryId;

	private Files avatar;

	private Files cover;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public float getVote() {
		return vote;
	}

	public void setVote(float vote) {
		this.vote = vote;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Files getAvatar() {
		return avatar;
	}

	public void setAvatar(Files avatar) {
		this.avatar = avatar;
	}

	public Files getCover() {
		return cover;
	}

	public void setCover(Files cover) {
		this.cover = cover;
	}

}
