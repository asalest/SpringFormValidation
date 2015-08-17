package com.journaldev.spring.form.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.form.model.*;
/**
 * 
 * @author asalest
 *
 */
@Repository
public class CustomerDao {
		
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDao.class);
		 
	/**
	 * sessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	 
	/**
	 * Constructor CustomerDao
	 */
	CustomerDao(){
		/**
		 * Constructor CustomerDao
		 */
	}
	
	/**
	 * Listar todos los customers
	 * @return
	 */
	public List<Customer> getAllCustomers() {
		final Session session = sessionFactory.getCurrentSession();		
		final Query query = session.createQuery("from Customer c order by id desc");
		List<Customer> customerList = query.list(); 
		return customerList;			
	}
	
	/**
	 * Listar customer por idEmployee
	 * @param idEmployee
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyID(final int idEmployee) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID")
		.setInteger("ID", idEmployee)
		.list();
	}
		
	/**
	 * Listar customers mediante limites
	 * @param idEmployee
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyLimit(final int idEmployee, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID")
		.setInteger("ID", idEmployee)
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		
	/**
	 * Listar customers
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersAll(final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c")
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		
	/**
	 * Listar customers					 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c")
		.list();
	}
		 
	/**
	 * Listar customers por su usuario
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersLogin(final String user) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE user=:user" )
		 .setString("user",user)
		.list();
	}
		 
	/**
	 * listar customers via su ID
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersName(final int idParameter) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE id=:ID" )
		.setInteger("ID",idParameter)
		.list();
	}
	
	
	/**
	 * Listar customers por idEmployee y el nombre del customer 
	 * @param idEmployee
	 * @param byname
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyName(final int idEmployee, final String byname) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID AND name LIKE :N")
		.setInteger("ID", idEmployee)
		.setString("N", "%"+byname+"%")
		.list();
	}
	
	/**
	 * Listar por id del employee, y entre dos edades que le pasamos
	 * @param idEmployee
	 * @param byagehigh
	 * @param byagelow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyAge(final int idEmployee, final int byagehigh, final int byagelow) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:id AND age BETWEEN :L AND :H")
		.setParameter("id", idEmployee)
		.setParameter("L", byagelow)
		.setParameter("H", byagehigh)
		.list();
	}
	
	/**
	 * Listar por id del employee, dos edades que entramos y el nombre
	 * @param idEmployee
	 * @param byname
	 * @param byagehigh
	 * @param byagelow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyNameAge(final int idEmployee, final String byname, final int byagehigh, final int byagelow) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID AND age BETWEEN :L AND :H AND name LIKE :N")
		.setInteger("ID", idEmployee)
		.setInteger("H", byagehigh)
		.setInteger("L", byagelow)
		.setString("N", "%"+byname+"%")
		.list();
	}
		 
	/**
	 * Listar por el id del employee, el nombre del customer y dos limites
	 * @param idEmployee
	 * @param byname
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyNameLimit(final int idEmployee, final String byname, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID AND name LIKE :N")
		.setInteger("ID", idEmployee)
		.setString("N", "%"+byname+"%")
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		 
	/**
	 * Listar customer por el idEmployee, nombre, edad y limites
	 * 
	 * @param idEmployee
	 * @param byname
	 */
	/**
	 * @param byagehigh
	 * @param byagelow
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyNameAgeLimit(final int idEmployee, final String byname, final int byagehigh, final int byagelow, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:ID AND age BETWEEN :L AND :H AND name LIKE :N")
		.setInteger("ID", idEmployee)
		.setInteger("H", byagehigh)
		.setInteger("L", byagelow)
		.setString("N", "%"+byname+"%")
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		 
	/**
	 * Listar customer por el idEmloyee, edad y limites
	 */
	/**
	 * @param idEmployee
	 * @param byagehigh
	 * @param byagelow
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyAgeLimit(final int idEmployee, final int byagehigh, final int byagelow, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:id AND age BETWEEN :L AND :H")
		.setParameter("id", idEmployee)
		.setParameter("L", byagelow)
		.setParameter("H", byagehigh)
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		 
	/**
	 * Listar customer por idEmployee, y dos fechas de creacion del customer	 
	 * @param idEmployee
	 * @param bydatehigh
	 * @param bydatelow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyDate(final int idEmployee, final Timestamp bydatehigh, final Timestamp bydatelow) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:id AND currentdate BETWEEN :L AND :H")
		.setParameter("id", idEmployee)
		.setParameter("L", bydatelow)
		.setParameter("H", bydatehigh)
		.list();
	}
	
	/**
	 * Listar customer por idEmployee, fechas de creacion y limites
	 */
	/**
	 * @param idEmployee
	 * @param bydatehigh
	 * @param bydatelow
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyDateLimit(final int idEmployee, final Timestamp bydatehigh, final Timestamp bydatelow, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE idemployee=:id AND currentdate BETWEEN :L AND :H")
		.setParameter("id", idEmployee)
		.setParameter("L", bydatelow)
		.setParameter("H", bydatehigh)
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		 
	/**
	 * Listar customer por idCustomer
	 * @param idCustomer
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersbyIDcustomer(final int idCustomer) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Customer c WHERE id=:ID")
		.setInteger("ID", idCustomer)
		.list();
	}
	
	
	/**
	 * Creacion customer
	 * @param customer
	 */
	public void createCustomer(final Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}
	
	/**
	 * Modificar customer
	 * @param customer
	 */
	public void updateCustomer(final Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}
	
	/**
	 * Eliminar customer
	 * @param customer
	 */
	public void deleteCustomer(final Customer customer) {
		 sessionFactory.getCurrentSession().delete(customer);
	}
	
	/**
	 * Añadir customer
	 * @param customer
	 */
	public void addCustomer(final Customer customer) {
		final Session session = sessionFactory.getCurrentSession();	
		session.save(customer);
	}
		
	
}
