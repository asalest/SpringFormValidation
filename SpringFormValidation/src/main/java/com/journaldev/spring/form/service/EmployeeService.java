package com.journaldev.spring.form.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.journaldev.spring.form.model.*;
import com.journaldev.spring.form.validator.HashPassword;
import com.journaldev.spring.form.dao.*;

/**
 * 
 * @author asalest
 *
 */
@Service
@Transactional
public class EmployeeService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	/**
	 * EmployeeDao
	 */
	@Autowired 
	private EmployeeDao employeeDAO;

	/**
	 * Contructor EmployeeService
	 */
	public EmployeeService(){
		
	}

	/**
	 * Listar empleado por su user
	 * @param user
	 * @return
	 */
    public List<Employee> getEmployeesLogin(String user) {
		 return employeeDAO.getEmployeesLogin(user);
	}
 
	/**
	 * Listar todos los empleados	
	 * @return
	 */
	public List<Employee> getAllEmployee() {		
		return employeeDAO.getAllEmployeers();
	}
	
	/**
	 * Listar empleados con limite
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Employee> getEmployeesbyLimit(final int first, final int last) {
		 return employeeDAO.getEmployeesbyLimit(first, last);
	}
	
	/**
	 * Listar empleados por ID
	 * @return
	 */
	public List<Employee> getEmployeesbyID() {
		 return employeeDAO.getEmployeesbyID();
	}
	
	/**
	 * Listar empleado por idEmployee
	 * @param idEmployee
	 * @return
	 */
	public List<Employee> getEmployeesbyIDemployee(final int idEmployee) {
		return employeeDAO.getEmployeesbyIDemployee(idEmployee);
	}
	
	/**
     * Añadir empleado
     * @param employee
     */
    public void addEmployee(final Employee employee){
        employeeDAO.addEmployee(employee);
    }
	
	/**
	 * Modificar employee
	 * @param employee
	 */
	public void updateEmployee(final Employee employee) {
		employeeDAO.updateEmployee(employee);
	}
	
	/**
	 * Agregacion del empleado modificado en la BBDD
	 * @param currentEmployee
	 * @param form
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void updateEmployee(final Employee currentEmployee, final Employee form)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		currentEmployee.setPassword(HashPassword.returnedHash(form.getPassword()));
		currentEmployee.setName(form.getName());
		currentEmployee.setRole(form.getRole());
		currentEmployee.setUser(form.getUser());
		currentEmployee.setComentario(form.getComentario());
		 
		employeeDAO.updateEmployee(currentEmployee);
	}
	
	/**
	 * Eliminar empleado
	 * @param employee
	 */
	public void deleteEmployee(final Employee employee) {
		employeeDAO.deleteEmployee(employee);
	}
	 
	/**Buscador para el customer
	 */
	/**
	 * @param sfields
	 * @param currentEmployee
	 * @param nposition
	 * @param custService
	 * @param model
	 */
	public void searchCustomer(final SearchFields sfields, final Employee currentEmployee, final int nposition, final CustomerService custService, final Model model){
		
		if(sfields!=null){
			if(sfields.getByname()!=null && sfields.getByagehigh()==0 && sfields.getByagelow()==0 && sfields.getBydatehigh()==null && sfields.getBydatelow()==null){
				final List<Customer> searching = custService.getCustomersbyName(currentEmployee.getId(), sfields.getByname());
				paginationSearch(model, searching, sfields, nposition, 10, 1, currentEmployee, custService);
			}
			else if(sfields.getByagehigh()!=0 && sfields.getByagelow()!=0 && sfields.getByname()==null && sfields.getBydatehigh()==null && sfields.getBydatelow()==null) {
				final List<Customer> searching = custService.getCustomersbyAge(currentEmployee.getId(), sfields.getByagehigh(), sfields.getByagelow());
				paginationSearch(model, searching, sfields, nposition, 10, 2, currentEmployee, custService);
			}
			else if(sfields.getBydatehigh()!=null && sfields.getBydatelow()!=null && sfields.getByname()==null && sfields.getByagehigh()==0 && sfields.getByagelow()==0){
				final Timestamp timehigh = timestampConverter(sfields.getBydatehigh());
				final Timestamp timelow = timestampConverter(sfields.getBydatelow());
				final List<Customer> searching = custService.getCustomersbyDate(currentEmployee.getId(), timehigh, timelow);
				paginationSearch(model, searching, sfields, nposition, 10, 3, currentEmployee, custService);
			}
			else {
				final List<Customer> searching = custService.getCustomersbyNameAge(currentEmployee.getId(), sfields.getByname(), sfields.getByagehigh(), sfields.getByagelow());
				paginationSearch(model, searching, sfields, nposition, 10, 4, currentEmployee, custService);
			}
		}
	}
	 
	 
	 /**
	  * Convertidor para la fecha
	  * @param date
	  * @return
	  */
	 public Timestamp timestampConverter(final Date date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.MILLISECOND,0);
		 return new Timestamp(cal.getTimeInMillis());
	 }
	 
	 /**
	  * Paginador para el buscador de customers
	  * @param model
	  * @param searching
	  */
	 /**
	  * @param sfields
	  * @param nposition
	  * @param numregist
	  * @param type
	  * @param currentEmployee
	  * @param custService
	  */
	 public void paginationSearch(final Model model, final List<Customer> searching, final SearchFields sfields, final int nposition, final int numregist, final int type, Employee currentEmployee, final CustomerService custService){
		 final int medida = searching.size();
		 final int pages=medida/numregist;
		 final int npages = pages+1;
		 final int ncustomers;
		 if(searching.size()==0){
			 ncustomers=0;
		 }
		 else{
			 ncustomers = searching.size();
		 }
		 model.addAttribute("firstpage", nposition);
		 model.addAttribute("npages", npages);
		 model.addAttribute("ncustomers",ncustomers);
		 			 
		 if(searching.size()!=0){
			 switch(type){
			 case 1: final List<Customer> listing = custService.getCustomersbyNameLimit(currentEmployee.getId(), sfields.getByname(), numregist*(nposition-1), numregist);
			 		 model.addAttribute("listing",listing); break;
			 case 2: final List<Customer> listing2 = custService.getCustomersbyAgeLimit(currentEmployee.getId(), sfields.getByagehigh(), sfields.getByagelow(), numregist*(nposition-1), numregist);
			 		 model.addAttribute("listing",listing2); break;
			 case 3: final Timestamp timehigh = timestampConverter(sfields.getBydatehigh());
			 		 final Timestamp timelow = timestampConverter(sfields.getBydatelow());
			 		 
			 		 final List<Customer> listing3 = custService.getCustomersbyDateLimit(currentEmployee.getId(),timehigh, timelow, numregist*(nposition-1), numregist);
	 		 		 model.addAttribute("listing",listing3); break;
	 		 
			 case 4: final List<Customer> listing4 = custService.getCustomersbyNameAgeLimit(currentEmployee.getId(), sfields.getByname(), sfields.getByagehigh(), sfields.getByagelow(), numregist*(nposition-1), numregist);
			 		 model.addAttribute("listing",listing4); break;	 
			 }
		 }
	 }
	
}
