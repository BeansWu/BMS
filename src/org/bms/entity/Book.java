package org.bms.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: 书籍
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Entity
@Table(name = "t_book")
@Component
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** 所在书架 **/
	@ManyToOne
	@JoinColumn(
			name = "bookrack_id", referencedColumnName = "id", 
			foreignKey = @ForeignKey(name = "BOOKRACK_ID_FK")
			)
	private Bookrack bookrack;
	/** 书籍类型 **/
	@ManyToOne
	@JoinColumn(
			name = "book_type_id", referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "BOOK_TYPE_ID_FK")
			)
	private BookType bookType;
	/** ISBN **/
	@ManyToOne
	@JoinColumn(
			name = "isbn_id", referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "ISBN_ID_FK")
			)
	private BookNumber bookNumber;
	/** 书名 **/
	@Column(length = 45, nullable = false)
	private String name;
	/** 作者 **/
	@Column(length = 45, nullable = false)
	private String author;
	@Column(name = "bar_code", length = 45, nullable = false)
	private String barCode;
	@Column
	private Integer page;
	/** 译者 **/
	@Column(length = 45, nullable = false)
	private String translator;
	@Column
	private Integer price;
	/** 借阅人，若未借出则为空 **/
	@ManyToOne
	@JoinColumn(
			name = "reader_id", referencedColumnName = "id", 
			foreignKey = @ForeignKey(name = "READER_ID_FK")
			)
	private Reader reader;
	@Column(name = "borrow_date")
	private Timestamp borrowDate;
	@Column(name = "return_date")
	private Timestamp returnDate;
	
	@Transient
	@JsonIgnore
	private static SimpleDateFormat sdf;
	@JsonIgnore
	public SimpleDateFormat getSDF() {
		if (sdf == null) {
			sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		}
		return sdf;
	}
	
	public void setBorrowDate(String borrowDate) {
		if (borrowDate == null || borrowDate == "") {
			this.borrowDate = null;
		} else {
			this.borrowDate = Timestamp.valueOf(borrowDate);
		}
	}
	public void setReturnDate(String returnDate) {
		if (returnDate == null || returnDate == "") {
			this.returnDate = null;
		} else {
			this.returnDate = Timestamp.valueOf(returnDate);
		}
	}
	public Timestamp getBorrowDate() {
		return this.borrowDate;
	}
	public Timestamp getReturnDate() {
		return this.returnDate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Bookrack getBookrack() {
		return bookrack;
	}
	public void setBookrack(Bookrack booktrack) {
		this.bookrack = booktrack;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public BookNumber getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(BookNumber bookNumber) {
		this.bookNumber = bookNumber;
	}
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
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Book() {
		super();
	}
	public Book(Bookrack bookrack, BookType bookType, BookNumber bookNumber, String name, String author, String barCode,
			Integer page, String translator, Integer price) {
		this.bookrack = bookrack;
		this.bookType = bookType;
		this.bookNumber = bookNumber;
		this.name = name;
		this.author = author;
		this.barCode = barCode;
		this.page = page;
		this.translator = translator;
		this.price = price;
	}
}
