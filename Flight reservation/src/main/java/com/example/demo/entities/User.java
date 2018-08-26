package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Field can not be empty")
	private String firstname;
	@NotEmpty(message = "Field can not be empty")
	private String lastname;
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}", message="Wrong format")
	private String email;
	@Size(min=5, message="Password must contain at least 5 characters")
	private String password;
	

	public void setId(int id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public User() {
		
	}
	
}
