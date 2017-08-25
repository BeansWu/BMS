package org.bms.entity;

import java.io.Serializable;

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
 * @Description: Reader
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Component
@Entity
@Table(name = "t_reader")
public class Reader implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 20, nullable = false)
	private String barCode;
	@ManyToOne
	@JoinColumn(
			name = "reader_type_id", referencedColumnName = "id", 
			foreignKey = @ForeignKey(name = "READER_TYPE_ID_FK")
	)
	private ReaderType readerType;
	@Column(nullable = false)
	private Integer hasBorrow = 0;
	@Column(length = 10, nullable = false)
	private String certType;
	@Column(length = 20, nullable = false)
	private String certNumber;
	@Column(length = 11, nullable = false)
	private String phone;
	@Column(length = 20, nullable = false)
	private String email;
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
	public ReaderType getReaderType() {
		return readerType;
	}
	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}
	public Integer getHasBorrow() {
		return hasBorrow;
	}
	public void setHasBorrow(Integer hasBorrow) {
		this.hasBorrow = hasBorrow;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNumber() {
		return certNumber;
	}
	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Reader() {
		super();
	}
	public Reader(String barCode, String name, ReaderType readerType, String certType, String certNumber, String phone, String email) {
		this.barCode = barCode;
		this.name = name;
		this.readerType = readerType;
		this.certType = certType;
		this.certNumber = certNumber;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", barCode=" + barCode + ", readerType=" + readerType
				+ ", hasBorrow=" + hasBorrow + ", certType=" + certType + ", certNumber=" + certNumber + ", phone="
				+ phone + ", email=" + email + "]";
	}
}
