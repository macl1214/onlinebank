package com.cubas.onlinebank.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cubas.onlinebank.entity.Address;
import com.cubas.onlinebank.validation.PasswordMatches;
import com.cubas.onlinebank.validation.ValidEmail;

@PasswordMatches
public class UserDto {
	
	@NotNull
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	@NotEmpty
	private String username;
	
	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;
	
	private Address address;

	public UserDto() {
	}


	public UserDto(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
			@NotNull @NotEmpty String username, @NotNull @NotEmpty String email, @NotNull @NotEmpty String password,
			String matchingPassword, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.address = address;
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

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", matchingPassword=" + matchingPassword + ", address=" + address + "]";
	}
}
