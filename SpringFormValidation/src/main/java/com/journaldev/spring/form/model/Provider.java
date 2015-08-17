package com.journaldev.spring.form.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size; 

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.journaldev.spring.form.validator.Phone; 
/**
 * 
 * @author asalest
 *
 */
@Entity
@Table (name ="provider")
public class Provider {     
	
	/**
	 * ID
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * idemployees
	 */
	@Column
	private int idemployee;
	
	/**
	 * name
	 */
	@Column(name="mane")
	@Size(min=2, max=30)     
	private String name;     

	/**
	 * email
	 * @return
	 */
	@Column (name="email")
	@NotEmpty @Email    
	private String email;     
	
	/**
	 * place
	 */
	@Column(name="place")
	private Place place;      
	
	/**
	 * phone
	 */
	@Column(name="phone")
	@Phone    
	private String phone;
	
	/**
	 * comentario
	 */
	@Column (name="comentario")
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
	 * Constructor provider vacio
	 */
	public Provider(){
		/**
		 * Constructor provider vacio
		 */
	}
	
	/**
	 * Constructor
	 * @param comentario
	 * @param email
	 * @param name
	 * @param password
	 * @param phone
	 * @param place
	 * @param user
	 */
	public Provider(final String comentario, final String email, final String name, final String password, final String phone, final Place place, final String user){
		this.comentario=comentario;
		this.email=email;
		this.name=name;
		this.password=password;
		this.phone=phone;
		this.place=place;
		this.user=user;
	}
	
	
	/**
	 * getId
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * getIdemployee
	 * @return
	 */
	public int getIdemployee() {
		return idemployee;
	}
	
	/**
	 * setIdemployee
	 * @param idemployee
	 */
	public void setIdemployee(final int idemployee) {
		this.idemployee = idemployee;
	}

	/**
	 * setId
	 * @param id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * getPlace
	 * @return
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * setPlace
	 * @param place
	 */
	public void setPlace(final Place place) {
		this.place = place;
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
	 * Place
	 * @author asalest
	 *
	 */
	public enum Place {        
		BARCELONA, LLEIDA    
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
	 * getEmail
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail
	 * @param email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * getplace
	 * @return
	 */
	public Place getplace() {
		return place;
	}

	/**
	 * setplace
	 * @param place
	 */
	public void setplace(final Place place) {
		this.place = place;
	}

	/**
	 * getPhone
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * setPhone
	 * @param phone
	 */
	public void setPhone(final String phone) {
		this.phone = phone;
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
	
	
	
}