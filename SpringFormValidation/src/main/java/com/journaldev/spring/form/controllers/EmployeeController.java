package com.journaldev.spring.form.controllers;
 
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.journaldev.spring.form.model.*;
import com.journaldev.spring.form.service.*;
import com.journaldev.spring.form.validator.HashPassword;
 /**
  * 
  * @author asalest
  *
  */
@Controller
public class EmployeeController {
 
	/**
	 * LOGGER
	 */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeController.class);
    
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
     * Constructor EmployeeController
     */
    EmployeeController(){
    	/**
    	 * Constructor EmployeeController
    	 */
    }
    
    /**
     * Session del employee
     * @param session
     * @return
     */
	 private Employee getCurrentUser(HttpSession session) {
		 return (Employee)session.getAttribute("currentUser");
	 }

    /**
     * Login employee
     * @param model
     * @return
     */
    @RequestMapping(value="/loginE", method=RequestMethod.GET)
	 public String loginEmployees(final Model model){
    	LOGGER.info("Return loginE.jsp page");
		 
		 model.addAttribute("loginE", new Login());
		 
		 return "loginE";
	 }
	 
    /**
     * Comprobacion del login
     */
    /**
     * @param loginE
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
	 @RequestMapping(value = "/loginE", method = RequestMethod.POST)
	 public String comprobarLoginEmployees(@ModelAttribute("loginE") final Login loginE, final Model model,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			final List<Employee> employeerLog = empService.getEmployeesLogin(loginE.getUser());
			
			if(employeerLog.size()==0){				
				return "loginE";
			}
			final Employee referedEmp = employeerLog.get(0);
			final String savedfailpass = loginE.getPassword();
			loginE.setPassword(HashPassword.returnedHash(loginE.getPassword()));
						
			if(loginE.getPassword().equals(referedEmp.getPassword())){
				session.setAttribute("currentUser", referedEmp);
				return "redirect:employee";
			}
			else {
				loginE.setPassword(savedfailpass);{
					return "loginE";
				}
			}
		 }
	 
	
	 /**
	  * PAGINA INICIAL EMPLOYEE
	  * @param model
	  * @return
	  */
	 @RequestMapping(value="/employee")
	 public String getEmployeeInfo(final Model model,HttpSession session) {
		 if (null == getCurrentUser(session)) {
			 return "loginE";
		 }
		 model.addAttribute("stateH","active");
		 model.addAttribute("currentEmployee",getCurrentUser(session));
		 return "employee";
	 }
    
	/**
	 * Crear employee
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/emp/save", method = RequestMethod.GET)
    public String saveEmployeePage(final Model model) {
    	LOGGER.info("Returning empSave.jsp page");
        model.addAttribute("employee", new Employee());
        return "empSave";
    }
 
    /**
     * Crear y guardar empleado
     */
    /**
     * @param employee
     * @param bindingResult
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/emp/save.do", method = RequestMethod.POST)
    public String saveEmployeeAction( @Valid final Employee employee, final BindingResult bindingResult, final Model model,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if (bindingResult.hasErrors()) {
        	LOGGER.info("Returning empSave.jsp page");
            return "empSave";
        }
        LOGGER.info("Returning empSaveSuccess.jsp page");
       
        
        employee.setPassword(HashPassword.returnedHash(employee.getPassword()));
        
        empService.addEmployee(employee);
       
        return "empSaveSuccess";
    }
    
   /**
    * Modificar employee    
    * @param model
    * @return
    */
    @RequestMapping(value = "employee-editinfo")
	 public String addInfoGet(final Model model, HttpSession session) {
		 model.addAttribute("stateH","active");
		 model.addAttribute("currentEmployee", getCurrentUser(session));
		 return "employee-editinfo";
	 }
    
    /**
     * Comprobacion de la modificacion del empleado
     */
    /**
     * @param Employee
     * @param bindingresult
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "employee-editinfo", method = RequestMethod.POST)
	 public String addInfoPost(@ModelAttribute("currentEmployee") @Valid final Employee Employee, final BindingResult bindingresult, final Model model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	 if(bindingresult.hasErrors()){;
			 return "employee-editinfo";
		 }
    	 		 
		 empService.updateEmployee(getCurrentUser(session), Employee);
		 
		 return "redirect:employee";
	 }
    
   /**
    * Listar empleados
    * @param nposition
    * @param model
    * @return
    */
    @RequestMapping(value = "/emp/empList", method = RequestMethod.GET)
	 public String getEmployee(@RequestParam(value="page") final int nposition, final Model model, HttpSession session) {
		 model.addAttribute("stateC","active");
		 model.addAttribute("currentEmployee", getCurrentUser(session));
		 model.addAttribute("ArrayID", new SearchById());
		 
		 final List<Employee> employeeDB = empService.getAllEmployee();
	    
		 paginationEmployees(model, employeeDB, nposition, 2);
		 return "empList";
	 }

    /**
     * Eliminar empleado
     * @param searchById
     * @param model
     * @return
    */
    @RequestMapping(value = "/emp/delete", method = RequestMethod.POST)
    public String deletePostEmployees(@ModelAttribute("ArrayID") final SearchById searchById, final Model model) {
    	int pagelist=1;
    	final String[] selectedEmployees = searchById.getEmployees();
	   	for(int j=0;j<selectedEmployees.length;j++) {
		   	final List<Employee> employees = empService.getEmployeesbyIDemployee(Integer.parseInt(selectedEmployees[j]));
		   
		   	if(employees.size()!=0) {
		   		empService.deleteEmployee(employees.get(0));
		   	}
		   	else{
		   		LOGGER.info("ERROR. Impossible search of customer's ID \n");
		   	}
		}
	   	return "redirect:empList?page="+pagelist;
    }
    
    
    /**
     * Crear customer
     * @param model
     * @return
     */
    @RequestMapping(value = "/cust/save", method = RequestMethod.GET)
    public String saveCustomerPage(final Model model) {
    	 model.addAttribute("stateAC","active");
    	 model.addAttribute("customer", new Customer());
        return "custSave";
    }
    
   /**
    * Creacion y almacenamiento del customer en la BBDD
    */
    /**
    * @param customer
    * @param bindingresult
    * @param model
    * @return
    * @throws NoSuchAlgorithmException
    * @throws UnsupportedEncodingException
    */
    @RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
     public String saveCustomerAction(@ModelAttribute("customer") @Valid final Customer customer, final BindingResult bindingresult, final Model model, HttpSession session)throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	 if(bindingresult.hasErrors()){    		 
			 return "custSave";
		 }
    	 
    	 customer.setCurrentdate(currentDate());
    	 customer.setPassword(HashPassword.returnedHash(customer.getPassword()));
    	 
		 customer.setIdemployee(getCurrentUser(session).getId());
		 custService.createCustomer(customer);
		 	 	       
         return "custSaveSuccess";
     }    
    
	/**
	 * Listar customer
	 * @param nposition
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/cust/custList", method = RequestMethod.GET)
	 public String getCustomers(@RequestParam(value="page") final int nposition, final Model model, HttpSession session) {
    	 model.addAttribute("stateC","active");
    	 model.addAttribute("currentEmployee", getCurrentUser(session));
    	 model.addAttribute("ArrayID", new SearchById());

		 final List<Customer> customerDB = custService.getCustomersbyID(getCurrentUser(session).getId());
	    
		 paginationCustomers(model, customerDB, nposition, 2, session);
		 return "custList";
    }
    
    /**
     * Eliminar customer
     * @param searchById
     * @param model
     * @return
     */
    @RequestMapping(value = "/cust/delete", method = RequestMethod.POST)
    public String deletePostCustomer(@ModelAttribute("ArrayID") final SearchById searchById, final Model model) {
    	int pagelist=1;
    	final String[] selectedCustomers = searchById.getCustomers();
	   	for(int j=0;j<selectedCustomers.length;j++) {
		   	final List<Customer> customers = custService.getCustomersbyIDcustomer(Integer.parseInt(selectedCustomers[j]));
		   	if(customers.size()!=0) {
		   		custService.deleteCustomer(customers.get(0));
		   	}
		   	else{
		   		LOGGER.info("ERROR. Impossible search of customer's ID \n");
		   	}
	   	}
	   	return "redirect:custList?page="+pagelist;
    }
    
    /**
     * Crear provider
     * @param model
     * @return
     */
    @RequestMapping(value = "/prov/save", method = RequestMethod.GET)
    public String saveProviderPage(final Model model) {
    	model.addAttribute("stateAC","active");
        model.addAttribute("provider", new Provider());
        return "provSave";
    }
 
    /**
     * Comporbacion de la creacion del customer en BBDD
     */
    /**
     * @param provider
     * @param bindingResult
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/prov/save.do", method = RequestMethod.POST)
    public String saveProviderAction( @ModelAttribute("provider") @Valid final Provider provider, final BindingResult bindingResult, final Model model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if (bindingResult.hasErrors()) {
             return "provSave";
         }         
         provider.setPassword(HashPassword.returnedHash(provider.getPassword()));
         
         provider.setIdemployee(getCurrentUser(session).getId());
         
         provService.createProvider(provider);
                         
         return "provSaveSuccess";
             
     }
   
	/**
	 * Listar providores
	 * @param nposition
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/prov/provList", method = RequestMethod.GET)
	 public String getProviders(@RequestParam(value="page") final int nposition, final Model model, HttpSession session) {
    	 model.addAttribute("stateC","active");
    	 model.addAttribute("currentEmployee", getCurrentUser(session));
    	 model.addAttribute("ArrayID", new SearchById());

		 final List<Provider> providerDB = provService.getProvidersbyID(getCurrentUser(session).getId());
	    
		 paginationProviders(model, providerDB, nposition, 2, session);
		 return "provList";
    }
    
    /**
     * Eliminar provider
     * @param searchById
     * @param model
     * @return
     */
    @RequestMapping(value = "/prov/delete", method = RequestMethod.POST)
    public String deletePostProvider(@ModelAttribute("ArrayID") final SearchById searchById, final Model model) {
    	int pagelist=1;
    	final String[] selectedProviders = searchById.getProviders();
	   	for(int j=0;j<selectedProviders.length;j++) {
		   	final List<Provider> providers = provService.getProvidersbyIDprovider(Integer.parseInt(selectedProviders[j]));
		   	
		   	if(providers.size()!=0) {
		   		provService.deleteProvider(providers.get(0));
		   	}
		   	else{
		   		LOGGER.info("ERROR. Impossible search of customer's ID \n");
		   	}
	   	}
	   	return "redirect:provList?page="+pagelist;
	   		   	
    }
    
    /**
     * Buscador
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
	 public String getSearch(final Model model, HttpSession session) {
		 model.addAttribute("stateS","active");
		 model.addAttribute("currentemployee", getCurrentUser(session));
		 model.addAttribute("Searchfields", new SearchFields());
		 
		 return "search";
	 }
	 
    /**
     * Buscador por parametros
     * @param nposition
     * @param sfields
     * @param model
     * @return
    */
    @RequestMapping(value = "search", method = RequestMethod.POST)
	 public String doSearch(@RequestParam(value="page") final int nposition, @ModelAttribute("Searchfields") final SearchFields sfields, final Model model, HttpSession session) {
		 model.addAttribute("stateS","active");
		 model.addAttribute("currentemployee", getCurrentUser(session));
		 
		 empService.searchCustomer(sfields, getCurrentUser(session), nposition, custService, model);
		 
		 return "search";
	 }
    
    /**
     * Paginacion de los customers
     * @param model
     * @param customers
     * @param nposition
     * @param numregist
     */
	public void paginationCustomers(final Model model, final List<Customer> customers, final int nposition, final int numregist, HttpSession session){
		 final int medida = customers.size();
		 int npages;
		 int ncustomers;
		 if(customers.size()==0){
			 ncustomers=0;
		 }
		 else{
			 ncustomers = customers.size();
		 }
		 if(medida%numregist==0){
			 npages = medida/numregist;
		 }
		 else{
			 npages = medida/numregist+1;
		 }
		 model.addAttribute("firstpage", nposition);
		 model.addAttribute("npages", npages);
		 model.addAttribute("ncustomers",ncustomers);
		 if(customers.size()!=0){
			 final List<Customer> listingC = custService.getCustomersbyLimit(getCurrentUser(session).getId(), numregist*(nposition-1), numregist);
			 model.addAttribute("listingC",listingC);
		 }
	 }
	
	/**
	 * Paginacion proveedores
	 * @param model
	 * @param providers
	 * @param nposition
	 * @param numregist
	 */
	public void paginationProviders(final Model model, final List<Provider> providers, final int nposition, final int numregist, HttpSession session){
		 final int medida = providers.size();
		 int npages;
		 int nproviders;
		 if(providers.size()==0){
			 nproviders=0;
		 }
		 else{
			 nproviders = providers.size();
		 }
		 if(medida%numregist==0){
			 npages = medida/numregist;
		 }
		 else{
			 npages = medida/numregist+1;
		 }
		 model.addAttribute("firstpage", nposition);
		 model.addAttribute("npages", npages);
		 model.addAttribute("nproviders",nproviders);
		 if(providers.size()!=0){
			 final List<Provider> listingP = provService.getProvidersbyLimit(getCurrentUser(session).getId(), numregist*(nposition-1), numregist);
			 model.addAttribute("listingP",listingP);
		 }
	 }
	 
	/**
	 * Paginacion empleados
	 * @param model
	 * @param employees
	 * @param nposition
	 * @param numregist
	 */
	public void paginationEmployees(final Model model, final List<Employee> employees, final int nposition,final int numregist){
		 final int medida = employees.size();
		 int npages;
		 int nemployees;
		 if(employees.size()==0){
			 nemployees=0;
		 }
		 else{
			 nemployees = employees.size();
		 }
		 
		 if(medida%numregist==0){
			 npages = medida/numregist;
		 }
		 else{
			 npages = medida/numregist+1;
		 }
		 model.addAttribute("firstpage", nposition);
		 model.addAttribute("npages", npages);
		 model.addAttribute("nemployees",nemployees);
		 
		 if(employees.size()!=0){
			 final List<Employee> listingE = empService.getEmployeesbyLimit(numregist*(nposition-1), numregist);
			 model.addAttribute("listingE",listingE);
		 }
	 }
	
	/**
	 * Fecha del sistema
	 * @return
	 */
	public Timestamp currentDate() {
		 final Date today = new Date();
		 return new Timestamp(today.getTime());
	 }
	 
	
	 
	
}