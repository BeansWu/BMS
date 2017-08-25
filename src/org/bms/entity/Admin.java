package org.bms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @Description: 管理员
 * @author: Andrew 
 * @date:   2017-06-03
 */
@Component
@Entity
@Table(name = "t_admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 45, nullable = false)
	private String name;
	@Column(length = 45)
	private String password;
	@Column(name = "admin_level")
	private AdminLevel adminLevel = AdminLevel.COMMON;
	@Column
	private Boolean sysSet = false;
	@Column
	private Boolean bookMgt = false;
	@Column
	private Boolean readerMgt = false;
	@Column
	private Boolean bookBorrowAndReturn = false;
	@Column
	private Boolean sysSearch = false;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AdminLevel getAdminLevel() {
		return adminLevel;
	}
	public void setAdminLevel(AdminLevel adminLevel) {
		this.adminLevel = adminLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getSysSet() {
		return sysSet;
	}
	public void setSysSet(Boolean sysSet) {
		this.sysSet = sysSet;
	}
	public Boolean getBookMgt() {
		return bookMgt;
	}
	public void setBookMgt(Boolean bookMgt) {
		this.bookMgt = bookMgt;
	}
	public Boolean getReaderMgt() {
		return readerMgt;
	}
	public void setReaderMgt(Boolean readerMgt) {
		this.readerMgt = readerMgt;
	}
	public Boolean getBookBorrowAndReturn() {
		return bookBorrowAndReturn;
	}
	public void setBookBorrowAndReturn(Boolean bookBorrowAndReturn) {
		this.bookBorrowAndReturn = bookBorrowAndReturn;
	}
	public Boolean getSysSearch() {
		return sysSearch;
	}
	public void setSysSearch(Boolean sysSearch) {
		this.sysSearch = sysSearch;
	}
	public Admin() {
		super();
	}
	public Admin(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public Admin(Integer id, String name, String password, Boolean sysSet, Boolean bookMgt, Boolean readerMgt,
			Boolean bookBorrowAndReturn, Boolean sysSearch) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sysSet = sysSet;
		this.bookMgt = bookMgt;
		this.readerMgt = readerMgt;
		this.bookBorrowAndReturn = bookBorrowAndReturn;
		this.sysSearch = sysSearch;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", sysSet=" + sysSet + ", bookMgt="
				+ bookMgt + ", readerMgt=" + readerMgt + ", bookBorrowAndReturn=" + bookBorrowAndReturn + ", sysSearch="
				+ sysSearch + "]";
	}
}
