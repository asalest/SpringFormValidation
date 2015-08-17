package com.journaldev.spring.form.controllers;
 
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
 

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
 


import com.journaldev.spring.form.model.Customer;
import com.journaldev.spring.form.model.Login;
import com.journaldev.spring.form.model.Provider;
import com.journaldev.spring.form.service.ProviderService;
import com.journaldev.spring.form.validator.HashPassword;

 /**
  * 
  * @author asalest
  *
  */
@Controller
public class ProviderController {
 
	/**
	 * LOGGER
	 */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProviderController.class);
   
    /**
     * provService
     */
    @Autowired
	protected ProviderService provService;
   
    /**
     * Constructor ProviderController
     */
    ProviderController(){
    	/**
    	 * Constructor ProviderController
    	 */
    }
    
    /**
     * Session del provider
     * @param session
     * @return
     */
    private Provider getCurrentUser(HttpSession session) {
		 return (Provider)session.getAttribute("currentUser");
	 }
    
    /**
     * Login provider
     * @param model
     * @return
     */
    @RequestMapping(value="/loginP", method=RequestMethod.GET)
	public String loginProviders(final Model model){
    	 LOGGER.info("Return loginE.jsp page");
		 
		 model.addAttribute("loginP", new Login());
		 
		 return "loginP";
	 }
	 
    /**
     * Comporbacion del login
     * @param loginP
     * @param model
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
	@RequestMapping(value = "/loginP", method = RequestMethod.POST)
	public String comprobarLoginProviders(@ModelAttribute("loginP") final Login loginP, final Model model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		final List<Provider> providerLog = provService.getProvidersLogin(loginP.getUser());
		
		if(providerLog.size()==0){				
			return "login";
		}
		final Provider referedProv = providerLog.get(0);
		final String savedfailpass = loginP.getPassword();
		loginP.setPassword(HashPassword.returnedHash(loginP.getPassword()));
		
		if(loginP.getPassword().equals(referedProv.getPassword())){
			session.setAttribute("currentUser", referedProv);
			return "redirect:provider";
		}
		else {
			loginP.setPassword(savedfailpass);{
				return "loginP";
			}
		}
	}
   
	 
	 /**
	  * Pagina inicial del provider
	  * @param model
	  * @return
	  */
	 @RequestMapping(value="/provider")
	 public String getEmployeeInfo(final Model model, HttpSession session) {
		 model.addAttribute("stateH","active");
		 model.addAttribute("currentProvider",getCurrentUser(session));
		 return "provider";
	 }

	/**
	 * Modificar provider
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "provider-editinfo")
	public String addInfoGetCustomer(final Model model, HttpSession session) {
		 model.addAttribute("stateH","active");
		 model.addAttribute("currentProvider", getCurrentUser(session));
		 return "provider-editinfo";
	}
	
	/**
	 * Comprobacion y añadir las modificaciones del provider en la BBDD
	 */
	/**
	 * @param Provider
	 * @param bindingresult
	 * @param model
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "provider-editinfo", method = RequestMethod.POST)
	public String addInfoPostProvider(@ModelAttribute("currentProvider") @Valid final Provider Provider, final BindingResult bindingresult, final Model model, HttpSession session)throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    if(bindingresult.hasErrors()){;
	    	return "provider-editinfo";
		}
	    	 	    	 
		provService.updateProvider(getCurrentUser(session), Provider);	 
		return "redirect:provider";
	}
	  
}