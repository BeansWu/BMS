package org.bms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @Description: 存储借阅记录
 * @author: Andrew 
 * @date:   2017-06-10
 */
@Entity
@Table(name = "t_borrow_record")
@Component
public class BorrowRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "BOOK_ID_FK"))
	private Book book;
	@ManyToOne
	@JoinColumn(name = "reader_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "READER_ID_FK_2"))
	private Reader reader;
	@Column(name = "borrow_date")
	private Timestamp borrowDate;
	@Column(name = "return_date")
	private Timestamp returnDate;
	@Column(name = "has_return")
	private Boolean hasReturn = false;

	public Timestamp getBorrowDate() {
		return this.borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		if (borrowDate == null || borrowDate == "") {
			this.borrowDate = null;
		} else {
			this.borrowDate = Timestamp.valueOf(borrowDate);
		}
	}
	public Timestamp getReturnDate() {
		return this.returnDate;
	}
	public void setReturnDate(String returnDate) {
		if (returnDate == null || returnDate == "") {
			this.returnDate = null;
		} else {
			this.returnDate = Timestamp.valueOf(returnDate);
		}
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public Boolean getHasReturn() {
		return hasReturn;
	}
	public void setHasReturn(Boolean hasReturn) {
		this.hasReturn = hasReturn;
	}
	public BorrowRecord() {
		super();
	}
	public BorrowRecord(Book book, Reader reader, Timestamp borrowDate, Timestamp returnDate) {
		this.book = book;
		this.reader = reader;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	public BorrowRecord(Book book, Reader reader, String borrowDate, String returnDate) {
		this.book = book;
		this.reader = reader;
		setBorrowDate(borrowDate);
		setReturnDate(returnDate);
	}
}
