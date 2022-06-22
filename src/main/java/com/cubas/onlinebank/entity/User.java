package com.cubas.onlinebank.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	@Email(message="Please provide a valid Email")
	@NotEmpty(message="Please provide an email")
	private String email;
	
	@Column(name="password")
	private String password;
	
//	private Address address;
	
	@Column(name="active")
	private Boolean active;
	
	@ManyToMany(fetch = FetchType.EAGER,
				cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

//	private String address;
//	private String city;
//	private String state;
//	private Long zipcode;
	
	public User() {
		
	}

	public User(Long id, String firstName, String lastName, String username,
		@Email(message = "Please provide a valid Email") @NotEmpty(message = "Please provide an email") String email,
		String password, Boolean active, Set<Role> roles) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.email = email;
	this.password = password;
	this.active = active;
	this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}

}
