package com.journaldev.spring.form.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.form.model.Provider;
/**
 * 
 * @author asalest
 *
 */
@Repository
public class ProviderDao {
	
	/**
	 * LOGGER
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderDao.class);
	*/
	
	/**
	 * SessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor ProviderDao
	 */
	ProviderDao(){
		/**
		 * Constructor ProviderDao
		 */
	}
	 
	/**
	 * Listar providers
	 * @return
	 */
	public List<Provider> getAllProviders() {
		final Session session = sessionFactory.getCurrentSession();		
		final Query query = session.createQuery("from Provider c order by id desc");
		List<Provider> providerList = query.list(); 
	    return providerList;			
	}

	/**
	 * Listar providers por user		
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> getProvidersLogin(final String user) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Provider p WHERE user=:user" )
		.setString("user",user)
		.list();
	}
		
	/**
	 * Listar providers por id
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> getProvidersName(final int idParameter) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Provider p WHERE id=:ID" )
		.setInteger("ID",idParameter)
		.list();
	}
		
	/**
	 * Listar providers mediante el idEmployee
	 * @param idEmployee
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> getProvidersbyID(final int idEmployee) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Provider p WHERE idemployee=:ID")
		.setInteger("ID", idEmployee)
		.list();
	}
	
	/**
	 * Listar providers mediante el idEmployee, y dos numeros de limites
	 * @param idEmployee
	 * @param first
	 * @param last
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> getProvidersbyLimit(final int idEmployee, final int first, final int last) {
		return sessionFactory.getCurrentSession()
		.createQuery("FROM Provider p WHERE idemployee=:ID")
		.setInteger("ID", idEmployee)
		.setFirstResult(first)
		.setMaxResults(last)
		.list();
	}
		
	/**
	 * Listar providers por idProvider
	 * @param idProvider
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> getProvidersbyIDprovider(final int idProvider) {
		return sessionFactory.getCurrentSession()
	    .createQuery("FROM Provider p WHERE id=:ID")
		.setInteger("ID", idProvider)
		.list();
	}
		
	/**
	 * Crear providers
	 * @param provider
	 */
	public void createProvider(final Provider provider) {
		sessionFactory.getCurrentSession().save(provider);
	}
		
	/**
	 * Modificar provider
	 * @param provider
	 */
	public void updateProvider(final Provider provider) {
		sessionFactory.getCurrentSession().saveOrUpdate(provider);
	}
	
	/**
	 * Eliminar provider
	 * @param provider
	 */
	public void deleteProvider(final Provider provider) {
		 sessionFactory.getCurrentSession().delete(provider);
	}
	
	/**
	 * Añadir customer
	 * @param customer
	 */
	public void addProvider(final Provider provider) {
		final Session session = sessionFactory.getCurrentSession();	
		session.save(provider);
	}
		
			 
}
