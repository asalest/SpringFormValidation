package com.journaldev.spring.form.pruebas;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.form.controllers.EmployeeController;
import com.journaldev.spring.form.model.Customer;
import com.journaldev.spring.form.model.Employee;
import com.journaldev.spring.form.model.Login;
import com.journaldev.spring.form.model.Provider;
import com.journaldev.spring.form.model.SearchFields;
import com.journaldev.spring.form.service.CustomerService;
import com.journaldev.spring.form.service.EmployeeService;
import com.journaldev.spring.form.service.ProviderService;
import com.journaldev.spring.form.service.PruebasService;


import com.journaldev.spring.form.model.SearchById;

/**
 * 
 * @author asalest
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/dataSource-context.xml",
		"classpath:/META-INF/spring.xml"
})
public class TestJunitValidation {

	/**
	 * LOGGER
	 */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    /**
     * EmployeeService
     */
	@Autowired
	protected EmployeeService empService; 
	
	/**
	 * CustomerService
	 */
	@Autowired
	protected CustomerService custService;
	
	/**
	 * ProviderService
	 */
	@Autowired 
	protected ProviderService provService;
	
	/**
	 * PruebasService
	 */
	@Autowired
	protected PruebasService pruebas; 
	
	/**
	 * Creacion del empleado
	 */
	private final Employee employee = new Employee("comentario","probando","probando","CEO","probando");
	
	/**
	 * Creacion del customer
	 */
	private final Customer customer = new Customer(21, new Date(1988-04-04), "customer", "a@a.es", Customer.Gender.MALE, "customer", "customer", "6656656659", "probando");
	
	/**
	 * Creacion del provider
	 */
	private final Provider provider = new Provider("comentario","p@p.es", "provider", "provider", "6686656655", Provider.Place.BARCELONA, "provider");

	/**
     * Constructor TestJunitValidation
     */
    public TestJunitValidation(){
    	/**
    	 * Constructor TestJunitValidation
    	 */
    }
	
	/***************EMPLOYEES***************/
	
	/**
	 * La creación de un nuevo employee funciona correctamente
	 * La recuperación de un employee existente funciona
	 * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testCrearyRecuperarEmployee() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LOGGER.info("Empezando testCrearyRecuperarEmployee");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		assertNotNull(pruebas.getEmployeebyUser(test.getUser()));
	}
	
	/**
	 * La recuperación de un employee inexistente falla
	 * Devuelvo FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarEmployeeInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testRecuperarEmployeeInexistente");
		final Login test = new Login("fail", "0000");
		pruebas.addEmployee(employee);
		assertNotNull("Recuperar inexistente", pruebas.getEmployeebyUser(test.getUser()));
	}

	/**
	 * La modificacion de un employee existete funciona
	 * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testModificarEmployeeExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testModificarEmployeeExistente");
		final Login test = new Login("probando", "probando");
		pruebas.addEmployee(employee);
		employee.setName("modifyTest");
		final Employee current = pruebas.getEmployeebyUser(test.getUser()).get(0);
		pruebas.updateEmployeeTest(employee, current);
		assertTrue(pruebas.getEmployeebyUser(test.getUser()).get(0).getName().equals(employee.getName()));
	}
	
	/**
     * La modificacion de un employee inexistente falla
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testModificarEmployeeInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testModificarEmployeeInexistente");
		final Login test = new Login("fail", "0000");
		pruebas.addEmployee(employee);
		employee.setName("modifyTest");
		assertNotNull("Modificar inexistente", pruebas.getEmployeebyUser(test.getUser()));
		final Employee current = pruebas.getEmployeebyUser(test.getUser()).get(0);
		pruebas.updateEmployeeTest(employee, current);

	}
	
	 /**
     * Ver si el login que entramos existe
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginExistente");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		pruebas.getEmployeeLogin(test);
		LOGGER.info("Login test: "+pruebas.isLogin());
		assertTrue(pruebas.isLogin());
	}
	
	/**
     * Comprueba si el login que entramos es inexistente
     * Devuelve FAIL, porque no existe
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginInexistente");
		pruebas.addEmployee(employee);
		final Login test = new Login("fail", "0000");
		pruebas.getEmployeeLogin(test);
		assertTrue(pruebas.isLogin());
	}
	
	 /**
     * Entrar en login con contraseña incorrecta
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginContraseñaIncorrecta() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginContraseñaIncorrecta");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "fail");
		pruebas.getEmployeeLogin(test);
		assertTrue("Login contraseña incorrecta", pruebas.isLogin());
	}
	
	
	
	/***************CUSTOMERS******************/
	
	 /**
     * Creacion y recuperacion de un customer asoaciado a un empleado
     * Devuevle OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCrearyRecuperarCustomerAsociado() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LOGGER.info("Empezando testCrearyRecuperarCustomerAsociado");
		final SearchById sfields = new SearchById();
		sfields.setCustomer(String.valueOf(customer.getId()));
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		pruebas.getEmployeeLogin(test);
		pruebas.createCustomer(customer);
		final Object[] array = pruebas.getCustomersbyID(1);
		final List<Customer> customerDB = (List<Customer>) array[1];
		final Customer asociado = customerDB.get(0);
		LOGGER.info("Asociado: "+asociado.getName());
		assertNotNull("Customers asociados"+asociado.getName(), asociado);
	}
	
	/**
     * Recuperar customer asociacio a un empleado inexistente    
     * Entramos con un usuario empleado no correcto, entonces ya no nos crea el customer
     */
	/**
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarCustomerAsociadoEmployeeInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LOGGER.info("Empezando testRecuperarCustomerAsociadoEmployeeInexistente");
		final SearchById sfields = new SearchById();
		sfields.setCustomer(String.valueOf(customer.getId()));
		pruebas.addEmployee(employee);
		final Login test = new Login("fail", "0000");
		final Employee current = pruebas.getEmployeeLogin(test);
		assertNotNull("Customer asociado a Employee inexistente", current);
		/*facade.createCustomer(customer);
		final Object[] Array = facade.getCustomersbyID(1);
		final List<Customer> CustomerDB = (List<Customer>) Array[1];
		final Customer asociado = CustomerDB.get(0);*/
	}
	
	/**
     * Recupera un customer existente
     * Devuelve OK
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarCustomerExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testRecuperarCustomerExistente");
		pruebas.addEmployee(employee); //for After
		pruebas.addCustomer(customer);
		assertNotNull("Recuperar Customer Existente", pruebas.getCustomerbyUser(customer.getUser()));
	}
	
	
	 /**
     * Recuperar customer inexistente
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarCustomerInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testRecuperarCustomerInexistente");
		final SearchById sfields = new SearchById();
		sfields.setCustomer(String.valueOf(100));
		pruebas.addEmployee(employee); // for After
		pruebas.addCustomer(customer);
		assertNotNull("Recuperar Customer inexistente", pruebas.getCustomerbyUser("fail"));
	}
	
	 /**
     * Ver si el login que entramos existe
     * Devuelve OK
     * <p>
     */
	@Test
	public void testLoginCustomerExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginCustomerExistente");
		pruebas.addCustomer(customer);
		final Login test = new Login("customer", "customer");
		pruebas.getCustomerLogin(test);
		LOGGER.info("Login test: "+pruebas.isLogin());
		assertTrue(pruebas.isLogin());
	}
	
	/**
     * Comprueba si el login que entramos es inexistente
     * Devuelve FAIL, porque no existe
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginCustomerInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginCustomerInexistente");
		pruebas.addCustomer(customer);
		final Login test = new Login("fail", "0000");
		pruebas.getCustomerLogin(test);
		assertTrue(pruebas.isLogin());
	}
	
	 /**
     * Entrar en login con contraseña incorrecta
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginCustomerContraseñaIncorrecta() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginCustomerContraseñaIncorrecta");
		pruebas.addCustomer(customer);
		final Login test = new Login("customer", "fail");
		pruebas.getCustomerLogin(test);
		assertTrue("Login customer contraseña incorrecta", pruebas.isLogin());
	}
	
	/**
     * Test para la busqueda de customer via el nombre de este
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testValidarBusquedaNombre() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		LOGGER.info("Empezando testValidarBusqueda por nombre");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		
		final Employee currentEmployee = pruebas.getEmployeeLogin(test);
		assertNotNull(currentEmployee);
		pruebas.createCustomer(customer);
		final SearchFields sfields = new SearchFields();
		sfields.setByname("customer");
		final List<Customer> searching = custService.getCustomersbyName(pruebas.getCurrentEmployee().getId(), sfields.getByname());
		final Customer customer = searching.get(0);
		LOGGER.info("Customer Recuperado "+customer.getName());
		assertNotNull(customer);
	}
	
	/**
     * Test para la busqueda de customer via la edad de este
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testValidarBusquedaEdad() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		LOGGER.info("Empezando testValidarBusqueda por edad");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		final Employee currentEmployee = pruebas.getEmployeeLogin(test);
		assertNotNull(currentEmployee);
		pruebas.createCustomer(customer);
		final SearchFields sfields = new SearchFields();
		sfields.setByagelow(20);
		sfields.setByagehigh(22);
		final List<Customer> searching = custService.getCustomersbyAge(pruebas.getCurrentEmployee().getId(), sfields.getByagehigh(), sfields.getByagelow());
		final Customer customer = searching.get(0);
		LOGGER.info("Customer Recuperado "+customer.getAge());
		assertNotNull(customer);
	}
	
	/**
     * Test para la busqueda de customer via la edad de este
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testValidarBusquedaFechaRegistro() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		LOGGER.info("Empezando testValidarBusqueda por fecha de registro");
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		Employee currentEmployee = pruebas.getEmployeeLogin(test);
		assertNotNull(currentEmployee);
		pruebas.createCustomer(customer);				
		final List<Customer> searching = custService.getCustomersbyDate(pruebas.getCurrentEmployee().getId(), pruebas.currentDateHigh(), pruebas.currentDateLow());
		final Customer customer = searching.get(0);
		LOGGER.info("Customer Recuperado "+customer.getAge());
		assertNotNull(customer);
	}
	
	
	/************PROVIDERS**************/
	
	/**
	 * Crear provider asociado a un empleado
	 * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCrearyRecuperarProviderAsociado() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LOGGER.info("Empezando testCrearyRecuperarCustomerAsociado");
		final SearchById sfields = new SearchById();
		sfields.setProvider(String.valueOf(provider.getId()));
		pruebas.addEmployee(employee);
		final Login test = new Login("probando", "probando");
		pruebas.getEmployeeLogin(test);
		pruebas.createProvider(provider);
		final Object[] array = pruebas.getProvidersbyID(1);
		final List<Provider> providerDB = (List<Provider>) array[1];
		final Provider asociado = providerDB.get(0);
		LOGGER.info("Asociado: "+asociado.getName());
		assertNotNull("Customers asociados"+asociado.getName(), asociado);
	}
	
	/**
     * Recuperar Provider asociacio a un empleado inexistente     
     * Entramos con un usuario empleado no correcto, entonces ya no nos crea el customer
     */
	/**
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarProviderAsociadoEmployeeInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LOGGER.info("Empezando testRecuperarProviderAsociadoEmployeeInexistente");
		final SearchById sfields = new SearchById();
		sfields.setProvider(String.valueOf(provider.getId()));
		pruebas.addEmployee(employee);
		final Login test = new Login("fail", "0000");
		final Employee current = pruebas.getEmployeeLogin(test);
		assertNotNull("Provider asociado a Employee inexistente", current);
		/*facade.createCustomer(customer);
		final Object[] Array = facade.getCustomersbyID(1);
		final List<Customer> CustomerDB = (List<Customer>) Array[1];
		final Customer asociado = CustomerDB.get(0);*/
	}
	
	/**
     * Recupera un Provider existente
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarProviderExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testRecuperarCustomerExistente");
		pruebas.addEmployee(employee); //for After
		pruebas.addProvider(provider);
		assertNotNull("Recuperar Provider Existente", pruebas.getProviderbyUser(provider.getUser()));
	}
	
	
	 /**
     * Recuperar Provider inexistente
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testRecuperarProviderInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testRecuperarProviderInexistente");
		final SearchById sfields = new SearchById();
		sfields.setCustomer(String.valueOf(100));
		pruebas.addEmployee(employee); // for After
		pruebas.addProvider(provider);
		assertNotNull("Recuperar Provider inexistente", pruebas.getProviderbyUser("fail"));
	}
	
	 /**
     * Ver si el login que entramos existe
     * Devuelve OK
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginProviderExistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginProviderExistente");
		pruebas.addProvider(provider);
		
		final Login test = new Login("provider", "provider");
		pruebas.getProviderLogin(test);
		LOGGER.info("Login test: "+pruebas.isLogin());
		assertTrue(pruebas.isLogin());
	}
	
	/**
     * Comprueba si el login que entramos es inexistente
     * Devuelve FAIL, porque no existe
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginProviderInexistente() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginProviderInexistente");
		pruebas.addProvider(provider);
		final Login test = new Login("fail", "0000");
		pruebas.getProviderLogin(test);
		assertTrue(pruebas.isLogin());
	}
	
	 /**
     * Entrar en login con contraseña incorrecta
     * Devuelve FAIL
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testLoginProviderContraseñaIncorrecta() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LOGGER.info("Empezando testLoginProviderContraseñaIncorrecta");
		pruebas.addProvider(provider);
		final Login test = new Login("provider", "fail");
		pruebas.getCustomerLogin(test);
		assertTrue("Login Provider contraseña incorrecta", pruebas.isLogin());
	}
	
	
	/***LIMPIAR BBDD****/
	
	 /**
	  * Limpiar BBDD
	  */
	@After
	public void paraEjecutarDespues(){
		final SearchById sfields = new SearchById();
		String[] customers = new String[1];
		String[] providers = new String[1];
		customers[0] = String.valueOf(customer.getId());
		providers[0] = String.valueOf(provider.getId());
		sfields.setCustomers(customers);
		sfields.setProviders(providers);
		pruebas.deleteEmployee(employee);
		pruebas.deleteCustomers(sfields);
		pruebas.deleteProviders(sfields);
	}


	
}
