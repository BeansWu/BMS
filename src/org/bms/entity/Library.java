package org.bms.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @Description: Library 
 * @author: Andrew 
 * @date:   2017-06-01
 */
@Entity
@Table(name = "t_library")
public class Library implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 45, nullable = false)
	private String name;
	@Column(length = 100, nullable = false)
	private String address;
	@Column(name = "build_time", nullable = false)
	private Date buildTime;
	@Column(nullable = false)
	private String principal = "Andrew";
	@Column(length = 11, nullable = false)
	private String phone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(buildTime);
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public Library() {
		super();
	}
	public Library(String name, String address, Date buildTime, String principal, String phone) {
		this.name = name;
		this.address = address;
		this.buildTime = buildTime;
		this.principal = principal;
		this.phone = phone;
	}
	public Library(Integer id, String name, String address, Date buildTime, String principal, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.buildTime = buildTime;
		this.principal = principal;
		this.phone = phone;
	}
}
