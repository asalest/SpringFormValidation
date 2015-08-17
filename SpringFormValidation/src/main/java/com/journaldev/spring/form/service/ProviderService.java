package com.journaldev.spring.form.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.form.dao.ProviderDao;
import com.journaldev.spring.form.model.Provider;
import com.journaldev.spring.form.validator.HashPassword;
/**
 * 
 * @author asalest
 *
 */
@Service
@Transactional
public class ProviderService {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderService.class);
	
	/**
	 * ProviderDao
	 */
	@Autowired 
	private ProviderDao providerDAO;
	
	/**
	 * Constructor ProviderService
	 */
	public ProviderService(){
		
	}
	
    
    /**
     * Listar providers por usuario
     * @param user
     * @return
     */
    public List<Provider> getProvidersLogin(final String user) {
		 return providerDAO.getProvidersLogin(user);
	}
	
    
	/**
	 * Listar todos los providers
	 * @return
	 */
	public List<Provider> getAllProvider() {		
		return providerDAO.getAllProviders();		
	}
	
	/**
	 * Listar providers por el idEmployee
	 * @param idEmployee
	 * @return
	 */
	public List<Provider> getProvidersbyID(final int idEmployee) {
		 return providerDAO.getProvidersbyID(idEmployee);
	}
	
	/**
	 * Listar proveedores por idEmployee, con limites
	 * @param idEmployee
	 * @param first
	 * @param last
	 * @return
	 */
	public List<Provider> getProvidersbyLimit(final int idEmployee, final int first, final int last) {
		 return providerDAO.getProvidersbyLimit(idEmployee, first, last);
	}
	
	/**
	 * Crear provider
	 * @param provider
	 */
	public void createProvider (final Provider provider) {
		providerDAO.createProvider(provider);
	 }
	
	/**
	 * Modifica provider
	 * @param provider
	 */
	public void updateProvider(final Provider provider) {
		providerDAO.updateProvider(provider);
	}
	
	/**
	 * Comprobar y guardar datos de la modificacion en la BBDD
	 * @param currentProvider
	 * @param form
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public void updateProvider(final Provider currentProvider, final Provider form)throws NoSuchAlgorithmException, UnsupportedEncodingException{

		currentProvider.setName(form.getName());
		currentProvider.setPlace(form.getPlace());
		currentProvider.setUser(form.getUser());
		currentProvider.setPassword(HashPassword.returnedHash(form.getPassword()));
		currentProvider.setComentario(form.getComentario());
		currentProvider.setEmail(form.getEmail());
		currentProvider.setPhone(form.getPhone());
				
		providerDAO.updateProvider(currentProvider);
	}
	
	/**
	 * Listar providers por su id
	 * @param idProvider
	 * @return
	 */
	public List<Provider> getProvidersbyIDprovider(final int idProvider) {
		return providerDAO.getProvidersbyIDprovider(idProvider);
	}
	
	/**
	 * Eliminar providers
	 * @param provider
	 */
	public void deleteProvider(final Provider provider) {
		providerDAO.deleteProvider(provider);
	}
	 
	/**
	 * Añadir customer
	 * @param customer
	 */
    public void addProvider(final Provider provider){
    		providerDAO.addProvider(provider);
    }
	 
	 
	 
}
