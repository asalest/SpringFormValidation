package com.journaldev.spring.form.model; 


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.journaldev.spring.form.model.*;

/**
 * 
 * @author asalest
 *
 */
@Entity
@Table( name = "employee")
public class Employee {  
	
	/**
	 * ID
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * name
	 */
	@Column (name = "name")
    @Size(min=2, max=30) 
    private String name;
	
	/**
	 * role
	 */
	@Column(name = "role")
    @NotNull
    private String role;
	
	/**
	 * comentario
	 */
	@Column(name="comentario")
	@Size(min=1, max=255)     
	private String comentario; 
	
	/**
	 * user
	 */
	@Column(name="user")
	@Size(min=8, max=10)
	private String user;
	
	/**
	 * password
	 */
	@Column(name="password")
	@Size(min=8,max=50)
	private String password;
	
	/**
	 * customer
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Customer customer;
	
	/**
	 * Constructor employee vacio
	 */
	public Employee(){
		/**
		 * Constructor employee vacio
		 */
	}
	
	/**
	 * Constructor employee
	 */
	public Employee( final String comentario, final String name, final String password, final String role, final String user){
		
		this.comentario=comentario;
		this.name=name;
		this.password=password;
		this.role=role;
		this.user=user;
	}
			
	/**
	 * getUser
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * setUser
	 * @param user
	 */
	public void setUser(final String user) {
		this.user = user;
	}

	/**
	 * getPassword
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setPassword
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * getComentario
	 * @return
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * setComentario
	 * @param comentario
	 */
	public void setComentario(final String comentario) {
		this.comentario = comentario;
	}

	/**
	 * getId
	 * @return
	 */
	public int getId() {        
		return id;    
	}   
	
	/**
	 * setId
	 * @param id
	 */
	public void setId(final int id) {        
		this.id = id;    
	}    
	
	/**
	 * getName
	 * @return
	 */
	public String getName() {        
		return name;    
	}    
	
	/**
	 * setName
	 * @param name
	 */
	public void setName(final String name) {        
		this.name = name;    
	}    
	
	/**
	 * getRole
	 * @return
	 */
	public String getRole() {        
		return role;    
	}    
	
	/**
	 * setRole
	 * @param role
	 */
	public void setRole(final String role) {        
		this.role = role;    
	}

	/**
	 * getCustomer
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * setCustomer
	 * @param customer
	 */
	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}     
	
	
}