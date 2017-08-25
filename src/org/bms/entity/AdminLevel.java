package org.bms.entity;
/**
 * @Description: 管理员等级
 * @author: Andrew 
 * @date:   2017-06-01
 */
public enum AdminLevel {
	/** 普通管理员 **/
	COMMON(2),
	/** 超级管理员 **/
	SUPER(3);
	
	private Byte val;
	
	private AdminLevel (Integer val) {
		this.val = val.byteValue();
	}

	public Byte getVal () {
		return val;
	}

	public int compare (AdminLevel adminLevel) {
		return compare (adminLevel);
	}
	
	public int compare (Byte adminLevel) {
		return this.val.compareTo(adminLevel);
	}
}
