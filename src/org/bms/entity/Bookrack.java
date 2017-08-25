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
 * @Description: 书架
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Entity
@Table(name = "t_bookrack")
@Component
public class Bookrack implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** 书架编号 **/
	@Column(length = 45, nullable = false)
	private String pressmark;
	/** 书架中的书 **/
	@JsonIgnore
	@OneToMany(
			mappedBy = "bookrack", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			fetch = FetchType.EAGER
			)
	private List<Book> books = new ArrayList<Book>();
	/**
	 * @Title: addBook   
	 * @Description: 添加书籍到书架
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void addBook(Book book) {
		books.add(book);
	}
	/**
	 * @Title: removeBook   
	 * @Description: 从书架删除书籍
	 * @param: @param book      
	 * @return: void      
	 * @throws
	 */
	public void removeBook(Book book) {
		books.remove(book);
		book.setBookrack(null);
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
	public String getPressmark() {
		return pressmark;
	}
	public void setPressmark(String pressmark) {
		this.pressmark = pressmark;
	}
	public Bookrack() {
		super();
	}
	public Bookrack(String pressmark) {
		this.pressmark = pressmark;
	}
	@Override
	public String toString() {
		return "Bookrack [id=" + id + ", pressmark=" + pressmark + ", books=" + books + "]";
	}
}
