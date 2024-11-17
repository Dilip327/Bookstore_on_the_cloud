package com.user.model;

public class User {
	
	private int id;
	private int ISBN;
	private String title;
	private String Author;
	private int pub_year;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, int iSBN, String title, String author, int pub_year) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.title = title;
		Author = author;
		this.pub_year = pub_year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPub_year() {
		return pub_year;
	}

	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", Author=" + Author + ", pub_year="
				+ pub_year + "]";
	}
	
	
	
	

}
