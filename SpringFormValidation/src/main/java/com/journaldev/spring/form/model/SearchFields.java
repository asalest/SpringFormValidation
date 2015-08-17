package com.journaldev.spring.form.model;

import java.util.Date;
/**
 * 
 * @author asalest
 *
 */
public class SearchFields {
	
	/**
	 * byname
	 */
	private String byname;
	
	/**
	 * byagehigh
	 */
	private int byagehigh;
	
	/**
	 * byagelow
	 */
	private int byagelow;
	
	/**
	 * bydatelow
	 */
	private Date bydatelow;
	
	/**
	 * bydatehigh
	 */
	private Date bydatehigh;
	
	
	/**
	 * Constructor SearchFields
	 */
	public SearchFields(){
		/**
		 * Constructor SearchFields
		 */
	}
	
	/**
	 * getByname
	 * @return
	 */
	public String getByname() {
		return byname;
	}
	
	/**
	 * setByname
	 * @param byname
	 */
	public void setByname(final String byname) {
		this.byname = byname;
	}
	
	/**
	 * getByagehigh
	 * @return
	 */
	public int getByagehigh() {
		return byagehigh;
	}
	
	/**
	 * setByagehigh
	 * @param byagehigh
	 */
	public void setByagehigh(final int byagehigh) {
		this.byagehigh = byagehigh;
	}
	
	/**
	 * getByagelow
	 * @return
	 */
	public int getByagelow() {
		return byagelow;
	}
	
	/**
	 * setByagelow
	 * @param byagelow
	 */
	public void setByagelow(final int byagelow) {
		this.byagelow = byagelow;
	}
	
	/**
	 * getBydatelow
	 * @return
	 */
	public Date getBydatelow() {
		return bydatelow;
	}
	
	/**
	 * setBydatelow
	 * @param bydatelow
	 */
	public void setBydatelow(final Date bydatelow) {
		this.bydatelow = bydatelow;
	}
	
	/**
	 * getBydatehigh
	 * @return
	 */
	public Date getBydatehigh() {
		return bydatehigh;
	}
	
	/**
	 * setBydatehigh
	 * @param bydatehigh
	 */
	public void setBydatehigh(final Date bydatehigh) {
		this.bydatehigh = bydatehigh;
	}

}