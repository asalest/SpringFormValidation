package com.journaldev.spring.form.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.spring.form.model.Customer;
import com.journaldev.spring.form.validator.HashPassword;
import com.journaldev.spring.form.dao.*;
/**
 * 
 * @author asalest
 *
 */
@Service
@Transactional
public class CustomerService {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	/**
	 * customerDAO
	 */
	@Autowired 
	private CustomerDao customerDAO;
	
	/**
	 * CONSTRUCTOR
	 */
	public CustomerService(){
		
	}
	
	/**
	 * Listar customer por ID employee
	 * @param idEmployee
	 * @return
	 */
	public List<Customer> getCustomersbyID(final int idEmployee) {
		 return customerDAO.getCustomersbyID(idEmployee);
	}
	 
	/**
	 * Listar por limite y id del empleado
	 * @param idEmployee
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersbyLimit(final int idEmployee, final int first, final int last) {
		 return customerDAO.getCustomersbyLimit(idEmployee, first, last);
	}
	
	/**
	 * Listar todos los customers
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersAll(final int first, final int last){
		return customerDAO.getCustomersAll(first, last);
	}
	
	/**
	 * Listar customer por usuario
	 * @param user
	 * @return
	 */
	public List<Customer> getCustomersLogin(final String user) {
		 return customerDAO.getCustomersLogin(user);
	}
	
	
	
	/**
	 * Listar customers en general
	 * @return
	 */
	public List<Customer> getAllCustomer() {		
		return customerDAO.getAllCustomers();		
	}
	
	/**
	 * Crear customer
	 * @param customer
	 */
	public void createCustomer (final Customer customer) {
		customerDAO.createCustomer(customer);
	 }
	
	/**
	 * Listar customers por el id del empleado y el nombre del customer
	 * @param idEmployee
	 * @param byname
	 * @return
	 */
	public List<Customer> getCustomersbyName(final int idEmployee, final String byname) {
		 return customerDAO.getCustomersbyName(idEmployee, byname);
	}
	
	/**
	 * Listar customers por edad
	 * @param idEmployee
	 * @param byagehigh
	 * @param byagelow
	 * @return
	 */
	public List<Customer> getCustomersbyAge(final int idEmployee, final int byagehigh, final int byagelow) {
		 return customerDAO.getCustomersbyAge(idEmployee, byagehigh, byagelow);
	}
	
	/**
	 * Listar customer por idEmployee, el nombre y edad del customer
	 * @param idEmployee
	 * @param byname
	 * @param byagehigh
	 * @param byagelow
	 * @return
	 */
	public List<Customer> getCustomersbyNameAge(final int idEmployee, final String byname, final int byagehigh, final int byagelow) {
		return customerDAO.getCustomersbyNameAge(idEmployee, byname, byagehigh, byagelow);
	}
	
	/**
	 * Listar customers por idEmployee, por el nombre del customer y con limite 
	 * @param idEmployee
	 * @param byname
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersbyNameLimit(final int idEmployee, final String byname, final int first, final int last) {
		 return customerDAO.getCustomersbyNameLimit(idEmployee, byname, first, last);
	}
	
	/**
	 * Listar customers por el idemployee, por el nombre y 
	 * por edad del customer, y con limite
	 * @param idEmployee
	 */
	/**
	 * @param byname
	 * @param byagehigh
	 * @param byagelow
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersbyNameAgeLimit(final int idEmployee, final String byname, final int byagehigh, final int byagelow, final int first, final int last) {
		 return customerDAO.getCustomersbyNameAgeLimit(idEmployee, byname, byagehigh, byagelow, first, last);
	}
	
	/**
	 * Listar customers por idEmployee, edad del customer y con limite
	 */
	/**
	 * @param idEmployee
	 * @param byagehigh
	 * @param byagelow
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersbyAgeLimit(final int idEmployee, final int byagehigh, final int byagelow, final int first, final int last) {
		 return customerDAO.getCustomersbyAgeLimit(idEmployee, byagehigh, byagelow, first, last);
	}
	
	/**
	 * Listar customers por idEmployee, y la fecha de creacion del customer
	 * @param idEmployee
	 * @param bydatehigh
	 * @param bydatelow
	 * @return
	 */
	public List<Customer> getCustomersbyDate(final int idEmployee, final Timestamp bydatehigh, final Timestamp bydatelow) {
		 return customerDAO.getCustomersbyDate(idEmployee, bydatehigh, bydatelow);
	}
	 
	/**
	 * Listar customers por idEmployee, fecha de creacion del customer y con limite
	 */
	/**
	 * @param idEmployee
	 * @param bydatehigh
	 * @param bydatelow
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Customer> getCustomersbyDateLimit(final int idEmployee, final Timestamp bydatehigh, final Timestamp bydatelow, final int first, final int last) {
		 return customerDAO.getCustomersbyDateLimit(idEmployee, bydatehigh, bydatelow, first, last);
	}
	
	/**
	 * Modificar customer
	 * @param customer
	 */
	public void updateCustomer(final Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	
	/**
	 * Modificar customer
	 * @param currentCustomer
	 * @param form
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void updateCustomer(final Customer currentCustomer, final Customer form)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		currentCustomer.setPassword(HashPassword.returnedHash(form.getPassword()));
		currentCustomer.setAge(form.getAge());
		currentCustomer.setBirthday(form.getBirthday());
		currentCustomer.setComentario(form.getComentario());
		currentCustomer.setEmail(form.getEmail());
		currentCustomer.setGender(form.getGender());
		currentCustomer.setName(form.getName());
		currentCustomer.setPhone(form.getPhone());
		currentCustomer.setUser(form.getUser());
		 
		customerDAO.updateCustomer(currentCustomer);
	 }
	 
	/**
	 * Listar customer por su ID
	 * @param idCustomer
	 * @return
	 */
	public List<Customer> getCustomersbyIDcustomer(final int idCustomer) {
		return customerDAO.getCustomersbyIDcustomer(idCustomer);
	}
	
	/**
	 *Eliminar customer 
	 * @param customer
	 */
	public void deleteCustomer(final Customer customer) {
		customerDAO.deleteCustomer(customer);
	}
		
	/**
	 * Añadir customer
	 * @param customer
	 */
    public void addCustomer(final Customer customer){
    		customerDAO.addCustomer(customer);
    }
    
   
	 
	
}
