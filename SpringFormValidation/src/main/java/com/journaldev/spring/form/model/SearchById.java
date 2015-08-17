package com.journaldev.spring.form.model;
/**
 * 
 * @author asalest
 *
 */
public class SearchById {
	
	/**
	 * customers
	 */
	private String[] customers = new String[100];
	/**
	 * customer
	 */
	private String customer;
	
	/**
	 * employees
	 */
	private String[] employees = new String[100];
	/**
	 * employee
	 */
	private String employee;
	
	/**
	 * providers
	 */
	private String[] providers = new String[100];
	/**
	 * provider
	 */
	private String provider;
	
	
	/**
	 * Constructor SearchById
	 */
	public SearchById(){

		/**
		 * Constructor SearchById
		 */
	}
	
	
	/**
	 * getProviders
	 * @return
	 */
	public String[] getProviders() {
		return providers;
	}

	/**
	 * setProviders
	 * @param providers
	 */
	public void setProviders(final String... providers) {
		this.providers = providers;
	}

	/**
	 * getProvider
	 * @return
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * setProvider
	 * @param provider
	 */
	public void setProvider(final String provider) {
		this.provider = provider;
	}

	/**
	 * getEmployees
	 * @return
	 */
	public String[] getEmployees() {
		return employees;
	}

	/**
	 * setEmployees
	 * @param employees
	 */
	public void setEmployees(final String... employees) {
		this.employees = employees;
	}

	/**
	 * getEmployee
	 * @return
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * setEmployee
	 */
	public void setEmployee(final String employee) {
		this.employee = employee;
	}

	/**
	 * getCustomers
	 * @return
	 */
	public String[] getCustomers() {
		return customers;
	}
	
	/**
	 * setCustomers
	 * @param customers
	 */
	public void setCustomers(final String... customers) {
		this.customers = customers;
	}
	
	/**
	 * getCustomer
	 * @return
	 */
	public String getCustomer() {
		return customer;
	}
	
	/**
	 * setCustomer
	 * @param customer
	 */
	public void setCustomer(final String customer) {
		this.customer = customer;
	}
}
