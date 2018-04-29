package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserRecord {
	
	@Id
	private int id;
	
	@NotNull
	@Size(min=2, message="First name should have atleast 2 characters")
	private String firstname; 
	
	@NotNull
	@Size(min=2, message="Last name should have atleast 2 characters")
	private String lastname; 
	
	@Digits(fraction = 0, integer = 10)
	private int mobile;
	
	private String email;
    
    public UserRecord(){}  

    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}  
	
		 public String getFirstname() {
				return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public int getMobile() {
			return mobile;
		}


		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
}
