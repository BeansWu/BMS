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
 * @Description: ReaderType
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Component
@Entity
@Table(name = "t_reader_type")
public class ReaderType implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 45, nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer canBorrow;
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
	public Integer getCanBorrow() {
		return canBorrow;
	}
	public void setCanBorrow(Integer canBorrow) {
		this.canBorrow = canBorrow;
	}
	public ReaderType() {
		super();
	}
	public ReaderType(String name, Integer canBorrow) {
		this.name = name;
		this.canBorrow = canBorrow;
	}
	@Override
	public String toString() {
		return "ReaderType [id=" + id + ", name=" + name + ", canBorrow=" + canBorrow + "]";
	}
}
