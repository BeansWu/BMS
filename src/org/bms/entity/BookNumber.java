package org.bms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: ISBN
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Entity
@Table(name = "t_isbn")
@Component
public class BookNumber implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="isbn", length = 6, nullable = false)
	private String interSBN;
	@Column(length = 45, nullable = false)
	private String press;
	/** 复本 **/
	@JsonIgnore
	@OneToMany(
			mappedBy = "bookNumber", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.EAGER
			)
	private List<Book> books = new ArrayList<Book>();
	/**
	 * @Title: addBook   
	 * @Description: 添加复本
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void addBook(Book book) {
		books.add(book);
	}
	/**
	 * @Title: removeBook   
	 * @Description: 删除复本
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void removeBook(Book book) {
		books.remove(book);
		book.setBookNumber(null);
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInterSBN() {
		return interSBN;
	}
	public void setInterSBN(String interSBN) {
		this.interSBN = interSBN;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public BookNumber() {
		super();
	}
	public BookNumber(String interSBN, String press) {
		this.interSBN = interSBN;
		this.press = press;
	}
	@Override
	public String toString() {
		return "BookNumber [id=" + id + ", interSBN=" + interSBN + ", press=" + press + ", books=" + books + "]";
	}
}
