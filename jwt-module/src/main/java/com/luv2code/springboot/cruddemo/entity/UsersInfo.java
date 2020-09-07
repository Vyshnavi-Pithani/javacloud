package com.luv2code.springboot.cruddemo.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "users")
public class UsersInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userID;

	@Email(message = "Please enter a valid email")
	@Column(name = "email")
	private String email;

	@Column(name = "user_name")
	@NotNull(message = "Required")
	@Size(min = 2, message = "minimum of two letters required")
	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	private String userName;

	@Column(name = "role")
	@NotNull(message = "Required")
	private String role;

	@NotNull(message = "Required")
	@Column(name = "password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	
	
	
	
	
	@Column(name="mobile")
	private String mobileNumber;

	@OneToMany(mappedBy = "userbean", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<RequestForm> requestInfoBeanList1;

	@OneToMany(mappedBy = "userbean", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Assets> assetBeanList;

	public UsersInfo() {

	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<RequestForm> getRequestInfoBeanList1() {
		return requestInfoBeanList1;
	}

	public void setRequestInfoBeanList1(List<RequestForm> requestInfoBeanList1) {
		this.requestInfoBeanList1 = requestInfoBeanList1;
	}

	public List<Assets> getAssetBeanList() {
		return assetBeanList;
	}

	public void setAssetBeanList(List<Assets> assetBeanList) {
		this.assetBeanList = assetBeanList;
	}

	@Override
	public String toString() {
		return "UsersInfo [userID=" + userID + ", email=" + email + ", userName=" + userName + ", role=" + role
				+ ", password=" + password + ", gender=" + gender + ", mobileNumber=" + mobileNumber
				+ ", requestInfoBeanList1=" + requestInfoBeanList1 + ", assetBeanList=" + assetBeanList + "]";
	}

	
}
