package com.journaldev.spring.form.controllers;
 

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

import com.journaldev.spring.form.model.*;
import com.journaldev.spring.form.service.CustomerService;
import com.journaldev.spring.form.validator.HashPassword;
 
/**
  * 
  * @author asalest
  *
  */
@Controller
public class CustomerController {
 
	/**
	 * LOGGER
	 */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomerController.class);
     
    /**
     * CustomerService
     */
	@Autowired
	protected CustomerService custService;
   
    /**
     * Constructor CustomerController
     */
    CustomerController(){
    	/**
    	 * Constructor CustomerController
    	 */
    }
   
    /**
     * Session del customer
     * @param session
     * @return
     */
	 private Customer getCurrentUser(HttpSession session) {
		 return (Customer)session.getAttribute("currentUser");
	 }
    
    /**
     * Login customer
     * @param model
     * @return
     */
    @RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginCustormer(final Model model){
    	LOGGER.info("Return login.jsp page");
		 
		model.addAttribute("login", new Login());
		 
		return "login";
	 }
	 
    /**
     * Comprobar login
     */
    /**
     * @param login
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String comprobarLoginCustomer(@ModelAttribute("login") final Login login, final Model model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final List<Customer> customerLog = custService.getCustomersLogin(login.getUser());
					
		if(customerLog.size()==0){				
			return "login";
		}
		final Customer referedCust = customerLog.get(0);
		final String savedfailpass = login.getPassword();
		login.setPassword(HashPassword.returnedHash(login.getPassword()));
					
		if(login.getPassword().equals(referedCust.getPassword())){
			session.setAttribute("currentUser", referedCust);
			return "redirect:customer";
		}
				
		else {
			login.setPassword(savedfailpass);{
				return "login";
			}
		}
	}
	 
	 
	/**
	 * Pagina pricipal del customer
	 * @param model
	 * @return
	 */
	 @RequestMapping(value="/customer")
	 public String getEmployeeInfo(final Model model, HttpSession session) {
		 model.addAttribute("stateH","active");
		 model.addAttribute("currentCustomer",getCurrentUser(session));
		 return "customer";
	 }

	    
	/**
	 * Modificar customer
	 *     
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "customer-editinfo")
	public String addInfoGetCustomer(final Model model, HttpSession session) {
		model.addAttribute("stateH","active");
		model.addAttribute("currentCustomer", getCurrentUser(session));
		return "customer-editinfo";
	}
	 
	/**
	 * Entrada de datos del customer para su modificacion
	*/
	/**
	 * @param Customer
	 * @param bindingresult
	 * @param model
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "customer-editinfo", method = RequestMethod.POST)
	public String addInfoPostCustomer(@ModelAttribute("currentCustomer") @Valid final Customer Customer, final BindingResult bindingresult, final Model model, HttpSession session)throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(bindingresult.hasErrors()){;
			return "customer-editinfo";
		}
	    	 
		custService.updateCustomer(getCurrentUser(session), Customer);
			return "redirect:customer";
		}
	 }