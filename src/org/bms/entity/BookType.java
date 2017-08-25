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
 * @Description: 书籍类型
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Entity
@Table(name = "t_book_type")
@Component
public class BookType implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45, nullable = false)
	private String name;
	@Column(name = "day_can_borrow", nullable = false)
	private Integer dayCanBorrow = 30;
	/** 该类型的书籍 **/
	@JsonIgnore
	@OneToMany(
			mappedBy = "bookType", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.EAGER
			)
	private List<Book> books = new ArrayList<Book>();
	/**
	 * @Title: addBook   
	 * @Description: 添加书籍到该类型
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void addBook (Book book) {
		books.add(book);
	}
	/**
	 * @Title: removeBook   
	 * @Description: 从该类型中移除书籍
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void removeBook (Book book) {
		books.remove(book);
		book.setBookType(null);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDayCanBorrow() {
		return dayCanBorrow;
	}
	public void setDayCanBorrow(Integer dayCanBorrow) {
		this.dayCanBorrow = dayCanBorrow;
	}
	public BookType() {
		super();
	}
	public BookType(String name, Integer dayCanBorrow) {
		this.name = name;
		this.dayCanBorrow = dayCanBorrow;
	}
}
