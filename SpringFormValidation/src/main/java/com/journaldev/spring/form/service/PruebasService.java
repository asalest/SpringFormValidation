package com.journaldev.spring.form.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









import com.journaldev.spring.form.model.Customer;
import com.journaldev.spring.form.model.Employee;
import com.journaldev.spring.form.model.Login;
import com.journaldev.spring.form.model.Provider;
import com.journaldev.spring.form.model.SearchById;
import com.journaldev.spring.form.validator.HashPassword;
/**
 * 
 * @author asalest
 *
 */
@Service
public class PruebasService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PruebasService.class);
	 
	/**
	 * login
	 */
	private boolean login;
	/**
	 * Employee
	 */
	private Employee currentEmployee;
	/**
	 * Customer
	 */
	private Customer currentCustomer;
	/**
	 * Provider
	 */
	private Provider currentProvider;
	/**
	 * EmployeeService
	 */
	@Autowired
	private EmployeeService empService;
	/**
	 * CustomerService
	 */
	@Autowired 
	private CustomerService custService;
	/**
	 * ProviderService
	 */
	@Autowired
	private ProviderService provService;
	
	 /**
	  * isLogin
	  * @return
	  */
    public boolean isLogin() {
		return login;
	}
    
    /**
     * getCurrentEmployee
     * @return
     */
    public Employee getCurrentEmployee() {
		return currentEmployee;
	}
    
	/**
	 * Añadir empleado
	 * @param employee
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void addEmployee(final Employee employee) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final Login log = new Login();          
	    final String password = employee.getPassword();
	    employee.setPassword(log.returnedHash(password)); 
	    empService.addEmployee(employee);
	}
	
	/**
	 * Listar empleado por usuario
	 * @param user
	 * @return
	 */
	public List<Employee> getEmployeebyUser(final String user){
		final List<Employee> employee = empService.getEmployeesLogin(user);
		if(employee.isEmpty()){
			return null;
		}else{
			return employee;
		}
	}
	
	 /**
	  * Eliminar empleado de la BBDD
	  * @param employee
	  */
	public void deleteEmployee(final Employee employee){
		empService.deleteEmployee(employee);
	}
	
	/**
	 * Eliminar el customer selecionado
	 * @param sfields
	 */
	public void deleteCustomers(final SearchById sfields){
		final String[] selectedCustomers = sfields.getCustomers();
		for(int j=0;j<selectedCustomers.length;j++) {
		   	final List<Customer> customersl = custService.getCustomersbyIDcustomer(Integer.parseInt(selectedCustomers[j]));
		   	LOGGER.info("Customer with ID "+Integer.parseInt(selectedCustomers[j])+" selected");
			if(customersl.isEmpty()) {
				LOGGER.info("ERROR. Impossible search of customer's ID \n");		
		   	}else{
		   		custService.deleteCustomer(customersl.get(0));		
		   	}
	   	}
	}
	
	 /**
	  * Modificar el empleado creado en la bbdd
	  * @param form
	  * @param currentEmployee
	  * @throws NoSuchAlgorithmException
	  * @throws UnsupportedEncodingException
	  */
	public void updateEmployeeTest(final Employee form, final Employee currentEmployee)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Form: "+form);
		LOGGER.info("Current: "+currentEmployee);
		
		currentEmployee.setPassword(HashPassword.returnedHash(form.getPassword()));
		currentEmployee.setName(form.getName());
		currentEmployee.setRole(form.getRole());
		currentEmployee.setUser(form.getUser());
		currentEmployee.setComentario(form.getComentario());
		
		empService.updateEmployee(currentEmployee);
	}
	
	/**
	 * Comprobacion del login de los empleados
	 * @param clogin
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Employee getEmployeeLogin(final Login clogin) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException{
		List<Employee> employeeLog = empService.getEmployeesLogin(clogin.getUser());
		LOGGER.info(employeeLog.toString());
	   	if(employeeLog.isEmpty()){
	   		LOGGER.info("Fallo al hacer login");
	   		login=false;
	   		return null;
	   	}else{
	   		currentEmployee=employeeLog.get(0);
	   	}
	   	final String savedfailpass = clogin.getPassword();
	   	clogin.setPassword(clogin.returnedHash(clogin.getPassword()));
	   	if(clogin.getPassword().equals(currentEmployee.getPassword())){ 
	   		login = true;
	   		LOGGER.info("Login True");
	   		return currentEmployee;
	   	} else {
	   		clogin.setPassword(savedfailpass);
	   		login = false;
	   		LOGGER.info("Login False");
	   		return null;
	   	}
	   		//return currentEmployee;
	}
	
	 /**
	  * Crear customer
	  * @param customer
	  * @throws NoSuchAlgorithmException
	  * @throws UnsupportedEncodingException
	  */
	public void createCustomer(final Customer customer) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final Login log = new Login();
        customer.setPassword(log.returnedHash("customer"));
        customer.setCurrentdate(currentDate());
        customer.setIdemployee(currentEmployee.getId());
        custService.createCustomer(customer);
	}
	

	
	/**
	 * Pagina del customer con el ID del employee
	 * @param start
	 * @return
	 */
	public Object[] getCustomersbyID(final int start){
		int maxElements = 2;
		int pages;
		LOGGER.info("Current Employee: "+currentEmployee.getName());	
		final List<Customer> customersById = custService.getCustomersbyID(currentEmployee.getId());
    	final int num = customersById.size();
    	final int offset = (start-1)*maxElements;
    	if(num%maxElements == 0){
    		pages= num/maxElements;
    	}else{
    		pages=num/maxElements+1;
    	}
    	final List<Customer> customerDB = custService.getCustomersbyLimit(currentEmployee.getId(), offset, maxElements);
    	
    	Object[] array = new Object[2];
    	array[0] = pages;
    	array[1] = customerDB;
    	
    	return  array;
	}
	
	/**
	 * Añadir nuevo customer
	 * @param customer
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void addCustomer(final Customer customer) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final Login log = new Login();
			customer.setCurrentdate(currentDate());
			final String password = customer.getPassword();
			customer.setPassword(log.returnedHash(password));
			custService.addCustomer(customer);
	}
	
	/**
	 * Retornar o listar un customer
	 * @param user
	 * @return
	 */
	public List<Customer> getCustomerbyUser(final String user){
		final List<Customer> customer = custService.getCustomersLogin(user);
		if(customer.isEmpty()){
			return null;
		}else{
			return customer;
		}
	}
	
	/**
	 * Comporbar login del customer
	 * @param clogin
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Customer getCustomerLogin(final Login clogin) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		List<Customer> customerLog = custService.getCustomersLogin(clogin.getUser());
		LOGGER.info(customerLog.toString());
	   	if(customerLog.isEmpty()){
	   		LOGGER.info("Fallo al hacer login");
	   		login=false;
	   		return null;
	   	}else{
	   		currentCustomer=customerLog.get(0);
	   	}
	   	final String savedfailpass = clogin.getPassword();
	   	clogin.setPassword(clogin.returnedHash(clogin.getPassword()));
	   	if(clogin.getPassword().equals(currentCustomer.getPassword())){ 
	   		login = true;
	   		LOGGER.info("Login True");
	   		return currentCustomer;
	   	} else {
	   		clogin.setPassword(savedfailpass);
	   		login = false;
	   		LOGGER.info("Login False");
	   		return null;
	   	}
	   		//return currentEmployee;
	}
	
	/**********PROVIDER************/
	
	/**
	 * Crear provider
	 * @param provider
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void createProvider(final Provider provider) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final Login log = new Login();
		provider.setPassword(log.returnedHash("customer"));
		provider.setIdemployee(currentEmployee.getId());
        provService.createProvider(provider);
	}
	
	/**
	 * 
	 * @param start
	 * @return
	 */
	public Object[] getProvidersbyID(final int start){
		int maxElements = 2;
		int pages;
		LOGGER.info("Current Employee: "+currentEmployee.getName());	
		final List<Provider> providersById = provService.getProvidersbyID(currentEmployee.getId());
    	final int num = providersById.size();
    	final int offset = (start-1)*maxElements;
    	if(num%maxElements == 0){
    		pages= num/maxElements;
    	}else{
    		pages=num/maxElements+1;
    	}
    	final List<Provider> providerDB = provService.getProvidersbyLimit(currentEmployee.getId(), offset, maxElements);
    	
    	Object[] array = new Object[2];
    	array[0] = pages;
    	array[1] = providerDB;
    	
    	return  array;
	}
	
	/**
	 * Provider por usuario
	 * @param user
	 * @return
	 */
	public List<Provider> getProviderbyUser(final String user){
		final List<Provider> provider = provService.getProvidersLogin(user);
		if(provider.isEmpty()){
			return null;
		}else{
			return provider;
		}
	}
	
	/**
	 * Añadir customer
	 * @param provider
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void addProvider(final Provider provider) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final Login log = new Login();
			final String password = provider.getPassword();
			provider.setPassword(log.returnedHash(password));
			provService.addProvider(provider);
	}
	
	/**
	 * Comprobacion del login en el customer
	 * @param clogin
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Provider getProviderLogin(final Login clogin) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		List<Provider> providerLog = provService.getProvidersLogin(clogin.getUser());
		
		LOGGER.info(providerLog.toString());
	   	if(providerLog.isEmpty()){
	   		LOGGER.info("Fallo al hacer login");
	   		login=false;
	   		return null;
	   	}else{
	   		currentProvider=providerLog.get(0);
	   	}
	   	final String savedfailpass = clogin.getPassword();
	   	clogin.setPassword(clogin.returnedHash(clogin.getPassword()));
	   	if(clogin.getPassword().equals(currentProvider.getPassword())){ 
	   		login = true;
	   		LOGGER.info("Login True");
	   		return currentProvider;
	   	} else {
	   		clogin.setPassword(savedfailpass);
	   		login = false;
	   		LOGGER.info("Login False");
	   		return null;
	   	}
	   		//return currentEmployee;
	}
	
	/**
	 * Eliminar el provider seleccionado
	 * @param sfields
	 */
	public void deleteProviders(final SearchById sfields){
		final String[] selectedProviders = sfields.getProviders();
		for(int j=0;j<selectedProviders.length;j++) {
		   	final List<Provider> providersl = provService.getProvidersbyIDprovider(Integer.parseInt(selectedProviders[j]));
		   	LOGGER.info("Provider with ID "+Integer.parseInt(selectedProviders[j])+" selected");
			if(providersl.isEmpty()) {
				LOGGER.info("ERROR. Impossible search of provider's ID \n");		
		   	}else{
		   		provService.deleteProvider(providersl.get(0));		
		   	}
	   	}
	}
	
	
	
	/********TIMESTAMP**********/
	
	/**
	 * Fecha actual
	 * @return
	 */
	public Timestamp currentDate() {
	  	 final Date today = new Date();
	  	 return new Timestamp(today.getTime());
	   }

	/**
	 * Fecha del sistema + un dia
	 * @return
	 */
	public Timestamp currentDateLow() {
		 final Date today = new Date();
		 return new Timestamp(today.getTime()-86399999);		 
	 }
	
	/**
	 * Fecha del sistema - un dia
	 * @return
	 */
	public Timestamp currentDateHigh() {
		 final Date today = new Date();
		 return new Timestamp(today.getTime()+86399999);
	 }
	
	
}
