package com.journaldev.spring.form.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author asalest
 *
 */

@Controller
public class HomeController {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory
	           .getLogger(CustomerController.class);
	
	/**
	 * Constructor HomeController
	 */
	HomeController(){
		/**
		 * Constructor HomeController
		 */
	}
	
	/**
	 * Pagina inicial de la APP
	 * @param model
	 * @return
	 */
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String loginPage(final Model model) {
		 LOGGER.info("Returning home.jsp page");
	               
	     return "home";
	 }
	 
	
	 
	 
}
