package com.journaldev.spring.form.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.form.model.Employee;
/**
 * 
 * @author asalest
 *
 */
@Repository
public class EmployeeDao {
	
	/**
	 * LOGGER
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	 */
	
	/**
	 * SessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor EmployeeDao
	 */
	EmployeeDao(){
		/**
		 * Constructor EmployeeDao
		 */
	}
 
	/**
	 * Listar todos los empleados
	 * @return
	 */
	public List<Employee> getAllEmployeers() {
		final Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Employee e order by id desc");
		List<Employee> employeeList = query.list(); 
	    return employeeList;			
	}
	
	/**
	 * Listar empleados por limite
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesbyLimit(final int first,final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Employee e ")
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	 }

	/**
	 * Listar empleados
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesbyID() {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Employee e")
		.list();
	}
	
	/**
	 * Listar empleados por user	 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesLogin(final String user) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Employee e WHERE user=:user" )
	 	.setString("user",user)
	 	.list();
	}

	/**
	 * Listar empleados mediante idEmployee
	 * @param idEmployee
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesbyIDemployee(final int idEmployee) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Employee e WHERE id=:ID")
		.setInteger("ID", idEmployee)
		.list();
	}
	 
	/**
	 * Añadir empleado
	 * @param employee
	 */
	public void addEmployee(final Employee employee) {
		Session session = sessionFactory.getCurrentSession();	
		session.save(employee);
	}
	
	/**
	 * Crear empleado
	 * @param employee
	 */
	public void createEmployee(final Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
	 
	/**
	 * Modificar empleado
	 * @param employee
	 */
	public void updateEmployee(final Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}
	 
	/**
	 * Eliminar empleado
	 * @param employee
	 */
	public void deleteEmployee(final Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}
	
}
