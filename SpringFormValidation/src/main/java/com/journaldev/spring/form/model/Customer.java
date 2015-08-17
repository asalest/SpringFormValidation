package com.journaldev.spring.form.model; 

import java.sql.Timestamp;
import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size; 

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat; 

import com.journaldev.spring.form.validator.Phone; 
/**
 * 
 * @author asalest
 *
 */
@Entity
@Table (name="customer")
public class Customer {     
	
	/**
	 * id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	/**
	 * idemployee
	 */
	@Column(name="idemployee")
	private int idemployee;
	
	/**
	 * name
	 */
	@Column (name = "name")
    @Size(min=2, max=30) 
    private String name;
	
	/**
	 * email
	 */
	@Column( name = "email")
    @NotEmpty @Email
    private String email;
      
	/**
	 * age
	 */
	@Column (name = "age")
    @NotNull @Min(18) @Max(100)
    private Integer age;
      
	/**
	 * gender
	 */
	@Column(name = "gender")
    @NotNull
    private Gender gender;
    
	/**
	 * birthday
	 */
	@Column(name = "birthday")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private Date birthday;
     
	/**
	 * phone
	 */
	@Column( name = "phone")
    @Phone
    private String phone;
	
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
	 * currentdate
	 */
	@Column(name="currentdate")
	private Timestamp currentdate;
	
	
	/**
	 * Constructor Customer
	 */
	public Customer(){
		/**
		 * Constructor Customer
		 */
	}
	
	public Customer(final  int age,final  Date birthday,final  String comentario,final  String email, Gender gender, final String name,final String password,final String phone,final String user){
		this.age=age;
		this.birthday=birthday;
		this.comentario=comentario;
		this.email=email;
		this.gender=gender;
		this.name=name;
		this.password=password;
		this.phone=phone;
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
	 * getCurrentdate
	 * @return
	 */
	public Timestamp getCurrentdate() {
		return currentdate;
	}

	/**
	 * setCurrentdate
	 * @param currentdate
	 */
	public void setCurrentdate(final Timestamp currentdate) {
		this.currentdate = currentdate;
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
		this.password=password;
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
	 * Gender
	 * @author asalest
	 *
	 */
	public enum Gender {        
		MALE, FEMALE    
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
	 * getAge
	 * @return
	 */
	public Integer getAge() {        
		return age;    
	}     
	
	/**
	 * setAge
	 * @param age
	 */
	public void setAge(final Integer age) {        
		this.age = age;    
	}     
	
	/**
	 * getGender
	 * @return
	 */
	public Gender getGender() {        
		return gender;    
	}     
	
	/**
	 * setGender
	 * @param gender
	 */
	public void setGender(final Gender gender) {        
		this.gender = gender;    
	}     
	
	/**
	 * getBirthday
	 * @return
	 */
	public Date getBirthday() {        
		return birthday;    
	}     
	
	/**
	 * setBirthday
	 * @param birthday
	 */
	public void setBirthday(final Date birthday) {        
		this.birthday = birthday;    
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
	
	
}